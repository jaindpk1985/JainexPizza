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
import dao.UserPreferencesInfo;

public class UserPreferencesProcess {

	static final Logger log = Logger.getLogger(UserPreferencesProcess.class);

	/**
	 * Save the user selected pizza preference in the DB
	 * 
	 * @param userPreferencesInfo
	 * @throws UnexpectedException
	 */
	public boolean saveUpdateUserPreferences(
			UserPreferencesInfo userPreferencesInfo) throws UnexpectedException {
		Session session = null;
		Transaction tx = null;
		boolean txSuccess = false;
		try {
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			session.saveOrUpdate(userPreferencesInfo);
			session.flush();
			tx.commit();
			txSuccess = true;
		} catch (HibernateException e) {
			log.error("An exception thrown :" + e.getMessage(), e);
			throw new UnexpectedException("An internal error has occured",e);
		} finally {
			if (tx != null && !txSuccess) {
				tx.rollback();
			}
		}
		return txSuccess;
	}

	/**
	 * Get teh user preferences list by the user id
	 * 
	 * @param userId
	 * @return User preferences List
	 * @throws UnexpectedException
	 */
	public List<UserPreferencesInfo> getUserPreferencesByUserId(Long userId)
			throws UnexpectedException {
		Session session = null;
		List<UserPreferencesInfo> userPreferencesInfos = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Criteria crit = session.createCriteria(UserPreferencesInfo.class);
			crit.add(Restrictions.eq("userId", userId));
			userPreferencesInfos = (List<UserPreferencesInfo>) crit.list();
		} catch (HibernateException e) {
			log.error("An exception thrown :" + e.getMessage(), e);
			throw new UnexpectedException("An internal error has occured",e);
		}
		return userPreferencesInfos;
	}

	/**
	 * @param userId
	 * @param pizzaId
	 * @return User preferences Info
	 * @throws UnexpectedException
	 */
	public UserPreferencesInfo getUserPreferencesByUserIdandPizzaId(
			Long userId, Long pizzaId) throws UnexpectedException {
		Session session = null;
		UserPreferencesInfo userPreferencesInfo = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Criteria crit = session.createCriteria(UserPreferencesInfo.class);
			crit.add(Restrictions.eq("userId", userId));
			crit.add(Restrictions.eq("pizzaId", pizzaId));
			userPreferencesInfo = (UserPreferencesInfo) crit.uniqueResult();
		} catch (HibernateException e) {
			log.error("An exception thrown :" + e.getMessage(), e);
			throw new UnexpectedException("An internal error has occured",e);
		}
		return userPreferencesInfo;
	}

	/**
	 * @param userPreferencesInfo
	 * @throws UnexpectedException
	 */
	public boolean deleteUserPreference(UserPreferencesInfo userPreferencesInfo)
			throws UnexpectedException {
		Session session = null;
		boolean txSuccess = false;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.delete(userPreferencesInfo);
			txSuccess = true;
		} catch (HibernateException e) {
			log.error("An exception thrown :" + e.getMessage(), e);
			throw new UnexpectedException("An internal error has occured",e);
		} finally {
			session.flush();
			session.close();
		}

		return txSuccess;
	}

}
