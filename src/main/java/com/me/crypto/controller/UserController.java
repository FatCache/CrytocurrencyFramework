package com.me.crypto.controller;

import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.me.crypto.dao.UserDAO;
import com.me.crypto.exception.UserException;
import com.me.crypto.pojo.User;
import com.me.crypto.pojo.UserBankDetails;
import com.me.crypto.validator.UserValidator;

import antlr.ParserSharedInputState;

@Controller
@RequestMapping("/user/*")
public class UserController {
	
	@Autowired
	@Qualifier("userDao")
	UserDAO userDao;
	
	@RequestMapping(value="/user/login", method = RequestMethod.GET)
	public String userLoginForm(ModelMap model) {
		model.addAttribute("user", new User());
		return "user-form";
	}
	
	
	@RequestMapping(value="user/login",method = RequestMethod.POST) // Takes to the transaction history Page
	public String authenticateUser(HttpServletRequest request, ModelMap map, @ModelAttribute("user") User command, UserDAO userDao) {
		HttpSession httpSession = request.getSession(true);
		User user = userDao.authenticate(command);
		if(user != null) {
			if(user.getUsername().equals("admin")){
				httpSession.setAttribute("userRole","admin");
				return "dashboard";
			}else {				
				httpSession.setAttribute("userRole","user");
				httpSession.setAttribute("personid", user.getPersonid());
				
				map.addAttribute("user",user);
				return "dashboard";	
			}
		}
		else {
			map.addAttribute("errorMessage","Invalid Username / Password!");
			return "error-page";
			}
		}

	
	@RequestMapping(value="/user/register", method = RequestMethod.GET)
	public String userRegister(ModelMap model) {
		model.addAttribute("user", new User());
		return "register-user";
	}
		
	@RequestMapping(value = "/user/register", method = RequestMethod.POST)
	public String userRegisterNew(HttpServletRequest request, UserDAO userDao, ModelMap map, @ModelAttribute("user") User command, BindingResult result) throws UserException {				
			User u = userDao.register(command);

			long userid = u.getPersonid();
			
			HttpSession httpSession = request.getSession(true);
			httpSession.setAttribute("userid", userid);

			map.addAttribute("userbankdetails", new UserBankDetails());
						
			return "user-form-bank";
	}
	
	@RequestMapping(value = "/user/registerbank", method = RequestMethod.POST)
	public String bankregister(HttpServletRequest request, UserDAO userDao, ModelMap map,  @ModelAttribute("userbankdetails") UserBankDetails command, BindingResult result) throws NumberFormatException, UserException {
		int userid = Integer.parseInt(request.getParameter(("passedByUserId")));
		User user = userDao.get(userid);		
		userDao.registerbankdetails(command, user);
		map.addAttribute("user",user);
		return "error-page";		
	}
	
}