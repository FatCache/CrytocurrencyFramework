package com.me.crypto.dao;

import java.util.List;
import java.util.Set;

import javax.transaction.TransactionalException;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.me.crypto.pojo.Transaction;
import com.me.crypto.pojo.User;

public class TransactionDAO extends DAO {
	
	public TransactionDAO() {}
	
    public Transaction get(String transactionid) throws TransactionalException {
        try {
            begin();
            Query q=getSession().createQuery("from Transaction where transactionid= :transactionid");
            q.setString("transactionid",transactionid);
            Transaction transaction=(Transaction)q.uniqueResult();
            commit();
            return transaction;
        } catch (HibernateException e) {
            rollback();
            throw new TransactionalException("Could not obtain the Transaction with id " + transactionid + " " + e.getMessage(), e);
        }
    }
    
    // A set of transaction for a particular user using reference personID 
    public Set<Transaction> list(String personID) throws TransactionalException {
        try {
            begin();
    		Query q = getSession().createQuery("from User where personID= :personID");
    		q.setParameter("personID", personID);
    		User user = (User) q.uniqueResult();
    		Set<Transaction> transactionList = user.getTransactions(); //?
            commit();
            return transactionList;
        } catch (HibernateException e) {
            rollback();
            throw new TransactionalException("Could not obtain the list for PersonId " + personID + " " + e.getMessage(), e);
        }
    }

    public Transaction create(Transaction transaction) throws TransactionalException {
        try {
            begin();
            getSession().save(transaction);
            commit();
            return transaction;
        } catch (HibernateException e) {
            rollback();
            //throw new AdException("Could not create the category", e);
            throw new TransactionalException("Exception while creating Transaction: " + e.getMessage(),e);
        }
    }

    public void update(Transaction transaction) throws TransactionalException {
        try {
            begin();
            getSession().update(transaction);
            commit();
        } catch (HibernateException e) {
            rollback();
            throw new TransactionalException("Exception while updating Transaction: " + e.getMessage(),e);
        }
    }

    public void delete(Transaction transaction) throws TransactionalException {
        try {
            begin();
            getSession().delete(transaction);
            commit();
        } catch (HibernateException e) {
            rollback();
            throw new TransactionalException("Exception while deleting Transaction: " + e.getMessage(),e);
        }
    }
	
	
	
}
