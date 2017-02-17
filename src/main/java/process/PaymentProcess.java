package process;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import common.UnexpectedException;

import dao.HibernateUtil;
import dao.PaymentInfo;

public class PaymentProcess {

	static final Logger log = Logger.getLogger(PaymentProcess.class);

	/**
	 * Save the payment information in the DB
	 * 
	 * @param pizzaData
	 * @throws UnexpectedException
	 */
	public boolean savePaymentInfo(PaymentInfo paymentInfo)
			throws UnexpectedException {
		Session session = null;
		Transaction tx = null;
		boolean txSuccess = false;
		try {
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			session.saveOrUpdate(paymentInfo);
			session.flush();
			tx.commit();
			txSuccess = true;
		} catch (HibernateException e) {
			log.error("A Hibernate exception thrown :" + e.getMessage(),e);
			throw new UnexpectedException("An internal error has occured",e);
		} finally {
			if (tx != null && !txSuccess) {
				tx.rollback();
			}
		}
		return txSuccess;
	}
}
