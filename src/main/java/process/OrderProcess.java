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
import dao.OrderPizzaToppingsInfo;
import dao.OrderPizzasInfo;
import dao.PizzaOrderInfo;

public class OrderProcess {

	static final Logger log = Logger.getLogger(OrderProcess.class);

	/**
	 * Save the ordered info by the user
	 * 
	 * @param pizzaOrderInfo
	 * @throws UnexpectedException
	 */
	public boolean saveUpdatePizzaOrder(PizzaOrderInfo pizzaOrderInfo)
			throws UnexpectedException {
		Session session = null;
		Transaction tx = null;
		boolean txSuccess = false;
		try {
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			session.saveOrUpdate(pizzaOrderInfo);
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
	 * Save the selected pizza in the DB
	 * 
	 * @param orderPizzasInfo
	 * @throws UnexpectedException
	 */
	public boolean saveUpdateOrderPizza(OrderPizzasInfo orderPizzasInfo)
			throws UnexpectedException {
		Session session = null;
		Transaction tx = null;
		boolean txSuccess = false;
		try {
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			session.saveOrUpdate(orderPizzasInfo);
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
	 * Get the customer orders information
	 * 
	 * @return customer order list throws UnexpectedException
	 */
	public List<PizzaOrderInfo> getCustomerOrders() throws UnexpectedException {
		Session session = null;
		List<PizzaOrderInfo> pizzaOrderDatas = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Criteria crit = session.createCriteria(PizzaOrderInfo.class);
			pizzaOrderDatas = (List<PizzaOrderInfo>) crit.list();
		} catch (HibernateException e) {
			log.error("A Hibernate exception thrown :" + e.getMessage(), e);
			throw new UnexpectedException("An internal error has occured",e);
		}
		return pizzaOrderDatas;
	}

	/**
	 * Get the customer orders information
	 * 
	 * @return customer order list
	 * @throws UnexpectedException
	 */
	public List<PizzaOrderInfo> getCustomerOrdersByUserId(Long userId)
			throws UnexpectedException {
		Session session = null;
		List<PizzaOrderInfo> pizzaOrderDatas = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Criteria crit = session.createCriteria(PizzaOrderInfo.class);
			crit.add(Restrictions.eq("userId", userId));
			pizzaOrderDatas = (List<PizzaOrderInfo>) crit.list();
		} catch (HibernateException e) {
			log.error("A Hibernate exception thrown :" + e.getMessage(), e);
			throw new UnexpectedException("An internal error has occured",e);
		}
		return pizzaOrderDatas;
	}

	/**
	 * get the order information from the DB by order Id
	 * 
	 * @param orderId
	 * @return throws
	 * @UnexpectedException
	 */
	public PizzaOrderInfo getOrderInfoByOrderId(Long orderId)
			throws UnexpectedException {
		Session session = null;
		PizzaOrderInfo orderInfo = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Criteria crit = session.createCriteria(PizzaOrderInfo.class);
			crit.add(Restrictions.eq("orderId", orderId));
			orderInfo = (PizzaOrderInfo) crit.uniqueResult();
		} catch (HibernateException e) {
			log.error("A Hibernate exception thrown :" + e.getMessage(), e);
			throw new UnexpectedException("An internal error has occured",e);
		}
		return orderInfo;
	}

	/**
	 * get the all pizza information consist in order by order Id
	 * 
	 * @param orderId
	 * @return throws
	 * @UnexpectedException
	 */
	public List<OrderPizzasInfo> getOrderPizzasInfoByOrderId(Long orderId)
			throws UnexpectedException {
		Session session = null;
		List<OrderPizzasInfo> orderPizzasInfo = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Criteria crit = session.createCriteria(OrderPizzasInfo.class);
			crit.add(Restrictions.eq("orderId", orderId));
			orderPizzasInfo = (List<OrderPizzasInfo>) crit.list();
		} catch (HibernateException e) {
			log.error("A Hibernate exception thrown :" + e.getMessage(), e);
			throw new UnexpectedException("An internal error has occured",e);
		}
		return orderPizzasInfo;
	}

	/**
	 * Save the selected topping for a pizza in the DB
	 * 
	 * @param orderPizzaToppingsInfo
	 * @throws UnexpectedException
	 */
	public boolean saveUpdateOrderPizzaToppingsInfo(
			OrderPizzaToppingsInfo orderPizzaToppingsInfo)
			throws UnexpectedException {
		Session session = null;
		Transaction tx = null;
		boolean txSuccess = false;
		try {
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			session.saveOrUpdate(orderPizzaToppingsInfo);
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
	 * get the all pizza information consist in order by order Id
	 * 
	 * @param orderId
	 * @return throws
	 * @UnexpectedException
	 */
	public List<OrderPizzaToppingsInfo> getOrderPizzaToppingsInfoByOrdPizzaInfo(OrderPizzasInfo orderPizzasInfo)
			throws UnexpectedException {
		Session session = null;
		List<OrderPizzaToppingsInfo> orderPizzasInfoList = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Criteria crit = session.createCriteria(OrderPizzaToppingsInfo.class);
			crit.add(Restrictions.eq("orderPizzasInfo", orderPizzasInfo));
			orderPizzasInfoList = (List<OrderPizzaToppingsInfo>) crit.list();
		} catch (HibernateException e) {
			log.error("A Hibernate exception thrown :" + e.getMessage(), e);
			throw new UnexpectedException("An internal error has occured",e);
		}
		return orderPizzasInfoList;
	}

}
