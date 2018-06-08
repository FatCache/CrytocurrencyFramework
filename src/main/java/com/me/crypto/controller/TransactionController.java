package com.me.crypto.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.me.crypto.dao.CoinDAO;
import com.me.crypto.dao.TransactionDAO;
import com.me.crypto.dao.UserDAO;
import com.me.crypto.exception.CoinException;
import com.me.crypto.exception.UserException;
import com.me.crypto.pojo.Coin;
import com.me.crypto.pojo.Transaction;
import com.me.crypto.pojo.User;

import antlr.ParserSharedInputState;

@Controller
@RequestMapping("/transaction/*")
public class TransactionController {

	@Autowired
	@Qualifier("userDao")
	UserDAO userDao;

	@Autowired
	@Qualifier("coinDao")
	CoinDAO coinDao;

	@Autowired
	@Qualifier("transactionDao")
	TransactionDAO transactionDao;

	@RequestMapping(value = "/transaction/fireupajax", method = RequestMethod.POST)
	@ResponseBody
	public String calculateValue(HttpServletRequest request) throws CoinException {
		String coinAid = request.getParameter("coinA");
		String coinBid = request.getParameter("coinB");
		
		Coin coinA = coinDao.get(coinAid);
		Coin coinB = coinDao.get(coinBid);
		
		double conversion = (coinA.getWorth()/coinB.getWorth())*1.00;
		
		return Double.toString(conversion);
		

	}

	@RequestMapping(value = "/transaction/create", method = RequestMethod.GET)
	public String coincreate(HttpServletRequest request, ModelMap model) throws CoinException, NumberFormatException, UserException {
		model.addAttribute("transaction", new Transaction());
		List<Coin> coinlist = coinDao.list(); // TODO should retrieve the latest entry for EACH coinType only
		Map<String, String> coinmap = new HashMap<String, String>();
		for (Coin c : coinlist) {
			coinmap.put(Integer.toString(c.getCoinId()), c.getName());
		}
		model.addAttribute("coinlist", coinmap);

		String personid = request.getParameter("personid");
		User user = userDao.get(Integer.parseInt(personid));
		
		double balance = user.getUserBankDetail().getBalance();
		
		HttpSession httpSession = request.getSession(true);
		httpSession.setAttribute("personid", personid);
		httpSession.setAttribute("balance", balance);
		

		return "transaction-create";
	}

	// For Admin
	@RequestMapping(value = "/transaction/manageadmin", method = RequestMethod.GET)
	public String trannsactionManager(ModelMap model) throws CoinException {

		ArrayList<Transaction> transactionList = transactionDao.listAll();
		model.addAttribute("transactionList", transactionList);

		return "transaction-history";
	}

	@RequestMapping(value = "/transaction/viewtransaction", method = RequestMethod.GET)
	public String transactionuserview(HttpServletRequest request, ModelMap model) throws CoinException {
		int personid = Integer.parseInt(request.getParameter("personid"));

		ArrayList<Transaction> transactionList = transactionDao.listAllUser(personid);

		model.addAttribute("transactionList", transactionList);

		return "transaction-history";
	}

	@RequestMapping(value = "/transaction/create", method = RequestMethod.POST)
	public String coincreated(HttpServletRequest request, ModelMap map,
			@ModelAttribute("transaction") Transaction command, UserDAO userDAO) throws CoinException, UserException {
		int personid = Integer.parseInt(request.getParameter(("passedByPersonId"))); // Renaming userid TO personid
		User user = userDao.get(personid);
		
		double transactionAmount = command.getAmount();
		double newBalance = user.getUserBankDetail().getBalance() - transactionAmount;
		
		user.getUserBankDetail().setBalance(newBalance);
		
		Coin coinA = coinDao.get(command.getCoinA());
		Coin coinB = coinDao.get(command.getCoinB());

		System.out.println("FIRST COIN ->  " + coinA.getName());
		System.out.println("SECOND COIN -> " + coinB.getName());

		command.getCoins().add(coinA);
		command.getCoins().add(coinB);
		command.setUser(user);

		Transaction transaction = transactionDao.create(command);

		Set<Transaction> transactions = user.getTransactions();
		transactions.add(transaction);

		userDAO.update(user);

		return "error-page";

	}
}

