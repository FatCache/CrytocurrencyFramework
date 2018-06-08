package com.me.crypto.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.me.crypto.dao.NewsDAO;
import com.me.crypto.dao.UserDAO;
import com.me.crypto.exception.CoinException;
import com.me.crypto.exception.NewsException;
import com.me.crypto.pojo.Coin;
import com.me.crypto.pojo.News;
import com.me.crypto.pojo.Transaction;



@Controller
@RequestMapping("/news/*")
public class NewsController {
	
	@Autowired
	@Qualifier("newsDao")
	NewsDAO newsDao;
	
	@Autowired
	@Qualifier("coinDao")
	CoinDAO coinDao;
	
	@RequestMapping(value = "/news/createnews", method = RequestMethod.GET)
	public String createnews(HttpServletRequest request, ModelMap model) throws NewsException, CoinException {
		model.addAttribute("news", new News());
		
		List<Coin> coinlist = coinDao.list();
		Map<String, String> coinmap = new HashMap<String, String>();
		for (Coin c : coinlist) {
			coinmap.put(c.getName(),c.getName());
		}
		
		model.addAttribute("coinlist", coinmap);
		return "news-create";
	}
	
	@RequestMapping(value = "/news/createnews", method = RequestMethod.POST)
	public String creatednews(HttpServletRequest request, ModelMap model,
			@ModelAttribute("news") News command) throws NewsException, CoinException {
		
		News news = newsDao.create(command);
		System.out.println("Inside the CREATED NEW METHOD");
		model.addAttribute("news", news);
		return "error-page";
	}
	
	@RequestMapping(value = "/news/view", method = RequestMethod.GET)
	public String viewNews(HttpServletRequest request, ModelMap model) throws NewsException, CoinException {
		HttpSession httpSession = request.getSession(true);
		
		httpSession.setAttribute("newsflag", "display");
		model.addAttribute("newsflag", "display");
		
		List<Coin> coinlist = coinDao.list();
		Map<String, String> coinmap = new HashMap<String, String>();
		for (Coin c : coinlist) {
			coinmap.put(c.getName(),c.getName());
		}
		
		model.addAttribute("coinmap", coinmap);
		return "news-select";
	}
	
	@RequestMapping(value = "/news/view", method = RequestMethod.POST)
	public String viewNewsSelected(HttpServletRequest request, ModelMap model) throws NewsException, CoinException {
		String coinConcern = request.getParameter("coin");
		List<News> newslist = newsDao.getNews(coinConcern);
		
		model.addAttribute("newslist", newslist);
		
		return "news-view";
	}


}
