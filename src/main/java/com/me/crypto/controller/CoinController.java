package com.me.crypto.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.me.crypto.dao.CoinDAO;
import com.me.crypto.dao.UserDAO;
import com.me.crypto.exception.CoinException;
import com.me.crypto.pojo.Coin;
import com.me.crypto.pojo.User;

@Controller
@RequestMapping("/coin/*")
public class CoinController {
	
	@Autowired
	@Qualifier("userDao")
	UserDAO userDao;
	
	@Autowired
	@Qualifier("coinDao")
	CoinDAO coinDao;
	
	@RequestMapping(value="/coin/manage", method = RequestMethod.GET)
	public String coincreate(ModelMap model) {
		model.addAttribute("coin", new Coin());
		return "coin-create";
	}
	
	@RequestMapping(value="/coin/createcoin",method = RequestMethod.POST) // Takes to the transaction history Page
	public String coincreated(HttpServletRequest request, ModelMap map, @ModelAttribute("coin") Coin command, CoinDAO coinDao) throws CoinException {
		Coin c = coinDao.create(command);
		map.addAttribute("coin", c);
		return "error-page";
		
	}
}
