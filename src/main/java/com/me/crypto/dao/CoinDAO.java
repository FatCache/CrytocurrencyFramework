package com.me.crypto.dao;

import java.util.List;
import java.util.Set;

import javax.transaction.TransactionalException;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.me.crypto.exception.CoinException;
import com.me.crypto.pojo.Coin;
import com.me.crypto.pojo.Transaction;
import com.me.crypto.pojo.User;

public class CoinDAO extends DAO {
	
    public Coin get(String coinId) throws CoinException {
        try {
            begin();
            Query q=getSession().createQuery("from Coin where coinId= :coinId");
            q.setString("coinId",coinId);
            Coin coin=(Coin)q.uniqueResult();
            commit();
            close();
            return coin;
        } catch (HibernateException e) {
            rollback();
            throw new CoinException("Could not obtain the coin with id " + coinId + " " + e.getMessage(), e);
        }
    }
    
    // A set of single type coin to retrieve a historical data for that particular coin 
    public List<Coin> list(String coinType) throws CoinException {
        try {
            begin();
    		Query q = getSession().createQuery("from Coin where coinType= :coinType");
    		q.setParameter("coinType", coinType);
    		List<Coin> coinList = q.list();
            commit();
            close();
            return coinList;
        } catch (HibernateException e) {
            rollback();
            throw new CoinException("Could not obtain the list for Cointype " + coinType + " " + e.getMessage(), e);
        }
    }
    
    // Simple coin list retrieval from database
    public List<Coin> list() throws CoinException {
        try {
            begin();
    		Query q = getSession().createQuery("from Coin");
    		List<Coin> coinList = q.list();
            commit();
            close();
            return coinList;
        } catch (HibernateException e) {
            rollback();
            throw new CoinException("Could not obtain the list of " + e.getMessage(), e);
        }
    }

    public Coin create(Coin coin) throws CoinException {
        try {
            begin();
            Coin c = new Coin();
            c.setName(coin.getName());
            c.setCoinType(coin.getCoinType());
            c.setWorth(coin.getWorth());
            
            getSession().save(c);
            commit();
            close();
            return c;
        } catch (HibernateException e) {
            rollback();
            //throw new AdException("Could not create the category", e);
            throw new CoinException("Exception while creating Coin: " + e.getMessage(),e);
        }
    }

    public void update(Coin coin) throws CoinException {
        try {
            begin();
            getSession().update(coin);
            
            commit();
            close();
        } catch (HibernateException e) {
            rollback();
            throw new CoinException("Exception while updating Coin: " + e.getMessage(),e);
        }
    }

    public void delete(Coin coin) throws CoinException {
        try {
            begin();
            getSession().delete(coin);
            commit();
            close();
        } catch (HibernateException e) {
            rollback();
            throw new CoinException("Exception while deleting Coin: " + e.getMessage(),e);
        }
    }

}
