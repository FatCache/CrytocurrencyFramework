package com.me.crypto.dao;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

import com.me.crypto.exception.UserException;
import com.me.crypto.pojo.User;
import com.me.crypto.pojo.UserBankDetails;



public class UserDAO extends DAO {
	
	public UserDAO() {
	}       
	
	public User authenticate(User user) {
		
		Criteria c = getSession().createCriteria(User.class);
		c.add(Example.create(user));		
		User u = (User) c.uniqueResult();		
		return u;
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
			Query q = getSession().createQuery("from User where personid= :personid");
			q.setInteger("personid", userId);		
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

			User user = new User();
			user.setFirstname(u.getFirstname());
			user.setLastname(u.getLastname());
			user.setPassword(u.getPassword());
			user.setUsername(u.getUsername());
			
			getSession().save(user);
			commit();
			return user;

		} catch (HibernateException e) {
			rollback();
			throw new UserException("Exception while creating user: " + e.getMessage());
		}
	}
	
	public void registerbankdetails(UserBankDetails u, User user) throws UserException {
		try {
			begin();
		UserBankDetails userBankDetails = new UserBankDetails();
		userBankDetails.setBankName(u.getBankName());
		userBankDetails.setBalance(u.getBalance());
		userBankDetails.setCreditCardNumber(u.getCreditCardNumber());
		userBankDetails.setCsv(u.getCsv());
		userBankDetails.setCreditCardNumber(u.getCreditCardNumber());
		
		user.setUserBankDetail(userBankDetails);
		
		getSession().update(user);
		commit();
		
		
		}
		catch (HibernateException e) {
			rollback();
			throw new UserException("Exception while registering user details & updateing: " + e.getMessage());
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
	
	
    public void update(User user) throws UserException {
        try {
            begin();
            getSession().update(user);
            commit();
        } catch (HibernateException e) {
            rollback();
            throw new UserException("Could not update user ", e);
        }
    }
}
