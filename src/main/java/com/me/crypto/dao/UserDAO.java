package com.me.crypto.dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.me.crypto.exception.UserException;
import com.me.crypto.pojo.User;
import com.me.crypto.pojo.UserBankDetails;


public class UserDAO extends DAO {
	
	public UserDAO() {
	}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               

	public User get(String username, String password) throws UserException {
		try {
			begin();
			Query q = getSession().createQuery("from User where username = :username and password = :password");
			q.setString("username", username);
			q.setString("password", password);			
			User user = (User) q.uniqueResult();
			commit();
			return user;
		} catch (HibernateException e) {
			rollback();
			throw new UserException("Could not get user " + username, e);
		}
	}
	
	public User get(int userId) throws UserException {
		try {
			begin();
			Query q = getSession().createQuery("from User where personID= :personID");
			q.setInteger("personID", userId);		
			User user = (User) q.uniqueResult();
			commit();
			return user;
		} catch (HibernateException e) {
			rollback();
			throw new UserException("Could not get user " + userId, e);
		}
	}

	public User register(User u)
			throws UserException {
		try {
			begin();
			System.out.println("inside UserDAO-Register");
			
			UserBankDetails userBankDetails = new UserBankDetails();
			userBankDetails.setBankName(u.getUserBankDetail().getBankName());
			userBankDetails.setBalance(u.getUserBankDetail().getBalance());
			userBankDetails.setCreditCardNumber(u.getUserBankDetail().getCreditCardNumber());
			userBankDetails.setCsv(u.getUserBankDetail().getCsv());
			userBankDetails.setCreditCardNumber(u.getUserBankDetail().getCreditCardNumber());			
			
			User user = new User(u.getUsername(), u.getPassword());
			user.setFirstname(u.getFirstname());
			user.setLastName(u.getLastName());	
			
			user.setUserBankDetail(userBankDetails);
			
			getSession().save(user);
			commit();
			return user;

		} catch (HibernateException e) {
			rollback();
			throw new UserException("Exception while creating user: " + e.getMessage());
		}
	}

	public void delete(User user) throws UserException {
		try {
			begin();
			getSession().delete(user);
			commit();
		} catch (HibernateException e) {
			rollback();
			throw new UserException("Could not delete user " + user.getUsername(), e);
		}
	}

}
