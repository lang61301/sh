package me.paddingdun.dao.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import me.paddingdun.dao.ICommonDao;
import me.paddingdun.dao.generic.hibernate.impl.HibernateGenericDaoImpl;

/**
 * 
 * @author paddingdun
 *
 * 2015年10月28日
 */
@Repository
public class CommonDao extends HibernateGenericDaoImpl implements ICommonDao {

	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
