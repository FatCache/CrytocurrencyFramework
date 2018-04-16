package com.me.crypto.dao;

import java.util.List;
import java.util.Set;

import javax.transaction.TransactionalException;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.me.crypto.exception.NewsException;
import com.me.crypto.pojo.News;
import com.me.crypto.pojo.Transaction;
import com.me.crypto.pojo.User;

public class NewsDAO extends DAO{
	
	public List<News> get(String coinConcern) throws NewsException {
        try {
            begin();
            Query q=getSession().createQuery("from News where coinConcern= :coinConcern");
            q.setString("coinType",coinConcern);
            List<News> newsList = q.list();
            commit();
            return newsList;
        } catch (HibernateException e) {
            rollback();
            throw new NewsException("Could not obtain the list of News for coinConcern: " + coinConcern+ " " + e.getMessage(), e);
        }
    }
    
    // A set of transaction for a particular user using reference personID 

    public News create(News news) throws NewsException {
        try {
            begin();
            getSession().save(news);
            commit();
            return news;
        } catch (HibernateException e) {
            rollback();
            throw new NewsException("Exception while creating News: " + e.getMessage(),e);
        }
    }

    public void update(News news) throws NewsException {
        try {
            begin();
            getSession().update(news);
            commit();
        } catch (HibernateException e) {
            rollback();
            throw new NewsException("Exception while updating News: " + e.getMessage(),e);
        }
    }

    public void delete(News news) throws NewsException {
        try {
            begin();
            getSession().delete(news);
            commit();
        } catch (HibernateException e) {
            rollback();
            throw new NewsException("Exception while deleting News: " + e.getMessage(),e);
        }
    }

}
