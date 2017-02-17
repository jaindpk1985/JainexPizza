package process;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import common.UnexpectedException;

import dao.HibernateUtil;
import dao.PizzaData;
import dao.ToppingInfo;

public class PizzaProcess {

	static final Logger log = Logger.getLogger(PizzaProcess.class);

	/**
	 * Get the all pizza info by category
	 * 
	 * @param isVeg
	 * @return pizza list
	 * @throws UnexpectedException
	 */
	public List<PizzaData> getPizzaByCategory(Boolean isVeg)
			throws UnexpectedException {
		Session session = null;
		List<PizzaData> pizzaDatas = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Criteria crit = session.createCriteria(PizzaData.class);
			crit.add(Restrictions.eq("isVeg", isVeg));
			crit.add(Restrictions.eq("status", "Active"));
			pizzaDatas = (List<PizzaData>) crit.list();
		} catch (HibernateException e) {
			log.error("A Hibernate exception thrown :" + e.getMessage(), e);
			throw new UnexpectedException("An internal error has occured",e);
		}
		return pizzaDatas;
	}

	/**
	 * Get all topppings info by category
	 * 
	 * @param isVeg
	 * @return Toppings List
	 * @throws UnexpectedException
	 */
	public List<ToppingInfo> getToppingsByCategory(Boolean isVeg)
			throws UnexpectedException {
		Session session = null;
		List<ToppingInfo> toppingDatas = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Criteria crit = session.createCriteria(ToppingInfo.class);
			crit.add(Restrictions.eq("isVeg", isVeg));
			toppingDatas = (List<ToppingInfo>) crit.list();
		} catch (HibernateException e) {
			log.error("A Hibernate exception thrown :" + e.getMessage(), e);
			throw new UnexpectedException("An internal error has occured",e);
		}
		return toppingDatas;
	}

	/**
	 * Get pizza information by pizza Id
	 * 
	 * @param pizzaId
	 * @return Pizza Info
	 * @throws UnexpectedException
	 */
	public PizzaData getPizzaById(Long pizzaId) throws UnexpectedException {
		Session session = null;
		PizzaData pizzaData = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Criteria crit = session.createCriteria(PizzaData.class);
			crit.add(Restrictions.eq("pizzaId", pizzaId));
			pizzaData = (PizzaData) crit.uniqueResult();
		} catch (HibernateException e) {
			log.error("A Hibernate exception thrown :" + e.getMessage(), e);
			throw new UnexpectedException("An internal error has occured",e);
		}
		return pizzaData;
	}

	/**
	 * Get Toppings Info by Id
	 * 
	 * @param toppingId
	 * @return Topping Info
	 * @throws UnexpectedException
	 */
	public ToppingInfo getToppingById(Long toppingId)
			throws UnexpectedException {
		Session session = null;
		ToppingInfo toppingData = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Criteria crit = session.createCriteria(ToppingInfo.class);
			crit.add(Restrictions.eq("toppingId", toppingId));
			toppingData = (ToppingInfo) crit.uniqueResult();
		} catch (HibernateException e) {
			log.error("A Hibernate exception thrown :" + e.getMessage(), e);
			throw new UnexpectedException("An internal error has occured",e);
		}
		return toppingData;
	}

	/**
	 * Save the new pizza Info in the DB
	 * 
	 * @param pizzaData
	 * @throws UnexpectedException
	 */
	public boolean saveUpdatePizzaData(PizzaData pizzaData)
			throws UnexpectedException {
		Session session = null;
		Transaction tx = null;
		boolean txSuccess = false;
		try {
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			session.saveOrUpdate(pizzaData);
			session.flush();
			tx.commit();
			txSuccess = true;
		} catch (HibernateException e) {
			log.error("A Hibernate exception thrown :" + e.getMessage(), e);
			throw new UnexpectedException("An internal error has occured",e);
		} finally {
			if (tx != null && !txSuccess) {
				tx.rollback();
			}
		}
		return txSuccess;
	}
	
	/**
	 * Get the all pizza info by category and Name
	 * 
	 * @param isVeg
	 * @return pizza list
	 * @throws UnexpectedException
	 */
	public List<PizzaData> getPizzaByCategoryAndName(Boolean isVeg, String pizzaName)
			throws UnexpectedException {
		Session session = null;
		List<PizzaData> pizzaDatas = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Criteria crit = session.createCriteria(PizzaData.class);
			crit.add(Restrictions.eq("isVeg", isVeg));
			crit.add(Restrictions.eq("status", "Active"));
			crit.add(Restrictions.like("pizzaName", "%"+pizzaName+"%"));
			pizzaDatas = (List<PizzaData>) crit.list();
		} catch (HibernateException e) {
			log.error("A Hibernate exception thrown :" + e.getMessage(), e);
			throw new UnexpectedException("An internal error has occured",e);
		}
		return pizzaDatas;
	}
	/**
	 * Get the all pizza info by category and Content
	 * 
	 * @param isVeg
	 * @return pizza list
	 * @throws UnexpectedException
	 */
	public List<PizzaData> getPizzaByCategoryAndContent(Boolean isVeg, String contentName)
			throws UnexpectedException {
		Session session = null;
		List<PizzaData> pizzaDatas = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Criteria crit = session.createCriteria(PizzaData.class);
			crit.add(Restrictions.eq("isVeg", isVeg));
			crit.add(Restrictions.eq("status", "Active"));
			crit.add(Restrictions.like("description", "%"+contentName+"%"));
			pizzaDatas = (List<PizzaData>) crit.list();
		} catch (HibernateException e) {
			log.error("A Hibernate exception thrown :" + e.getMessage(), e);
			throw new UnexpectedException("An internal error has occured",e);
		}
		return pizzaDatas;
	}

}
