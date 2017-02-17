package process;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import common.UnexpectedException;

import dao.HibernateUtil;
import dao.OffersInfo;

public class SchemeOffersProcess {
	
	static final Logger log = Logger.getLogger(SchemeOffersProcess.class);

	/** Save the Scheme/offers information into the DB
	 * @param offersInfo
	 * @return
	 * @throws UnexpectedException
	 */
	public boolean saveUpdateSchemeOffers(OffersInfo offersInfo)throws UnexpectedException{
		Session session = null;
		Transaction tx = null;
		boolean txSuccess = false;
		try {
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			session.saveOrUpdate(offersInfo);
			session.flush();
			tx.commit();
			txSuccess = true;
		} catch (HibernateException e) {
			log.error("An exception thrown :" + e.getMessage(),e);
			throw new UnexpectedException("An internal error has occured",e);
		} finally {
			if (tx != null && !txSuccess) {
				tx.rollback();
			}
		}
		return txSuccess;
	}
	
}
