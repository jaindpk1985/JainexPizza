package process;

import common.UnexpectedException;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import dao.AddressInfo;
import dao.HibernateUtil;
import dao.LoginData;
import dao.UserProfileInfo;

public class UserProfileProcess {

	static final Logger log = Logger.getLogger(UserProfileProcess.class);

	/**
	 * Save user profile information in the DB
	 * 
	 * @param userProfileInfo
	 * @throws UnexpectedException
	 *         
	 */
	public boolean createUserProfile(UserProfileInfo userProfileInfo)
			throws UnexpectedException {
		Transaction tx = null;
		Session session = null;
		boolean txSuccess = false;
		try {
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			session.saveOrUpdate(userProfileInfo);
			session.flush();
			tx.commit();
			txSuccess = true;
		} catch (HibernateException e) {
			log.error("An exception thrown :" , e);
			throw new UnexpectedException("An internal error has occured",e);
		} finally {
			if (tx != null && !txSuccess) {
				tx.rollback();
			}
		}
		return txSuccess;
	}

	/**
	 * findUserInformation by login data
	 * 
	 * @param loginData
	 * @throws Exception
	 * 
	 */
	public UserProfileInfo findUserInfoByLoginData(LoginData loginData)
			throws UnexpectedException {
		Session session = null;
		UserProfileInfo userProfileInfo = null;
		try {
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			Criteria crit = session.createCriteria(UserProfileInfo.class);
			crit.add(Restrictions.eq("loginData", loginData));
			userProfileInfo = (UserProfileInfo) crit.uniqueResult();
		} catch (Exception e) {
			log.error("A exception thrown :" + e.getMessage(), e);
			throw new UnexpectedException("An internal error has occured",e);
		} finally {
			session.getTransaction().commit();
		}
		return userProfileInfo;
	}

	/**
	 * save user address info in the DB
	 * 
	 * @param addressInfo
	 * @throws UnexpectedException
	 * 
	 */
	public boolean createAddressInfo(AddressInfo addressInfo)
			throws UnexpectedException {
		Transaction tx = null;
		Session session = null;
		boolean txSuccess = false;
		try {
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			session.saveOrUpdate(addressInfo);
			session.flush();
			tx.commit();
			txSuccess = true;
		} catch (HibernateException e) {
			log.error("A exception thrown :" + e.getMessage(), e);
			throw new UnexpectedException("An internal error has occured",e);
		} finally {
			if (tx != null && !txSuccess) {
				tx.rollback();
			}
		}
		return txSuccess;
	}

	/**
	 * find user AddressInfo By loginData
	 * 
	 * @param loginData
	 * @throws UnexpectedException
	 * 
	 */
	public AddressInfo findAddressInfoByLoginData(LoginData loginData)
			throws UnexpectedException {
		AddressInfo addressInfo = null;
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			Criteria crit = session.createCriteria(AddressInfo.class);
			crit.add(Restrictions.eq("loginData", loginData));
			addressInfo = (AddressInfo) crit.uniqueResult();
		} catch (HibernateException e) {
			log.error("A exception thrown :" + e.getMessage(), e);
			throw new UnexpectedException("An internal error has occured",e);
		} finally {
			session.getTransaction().commit();

		}
		return addressInfo;
	}
	
	/**
	 * find user AddressInfo By addressId
	 * 
	 * @param addressId
	 * @throws UnexpectedException
	 * 
	 */
	public AddressInfo findAddressInfoByAddressId(Long addressId)
			throws UnexpectedException {
		AddressInfo addressInfo = null;
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			Criteria crit = session.createCriteria(AddressInfo.class);
			crit.add(Restrictions.eq("addressId", addressId));
			addressInfo = (AddressInfo) crit.uniqueResult();
		} catch (HibernateException e) {
			log.error("A exception thrown :" + e.getMessage(), e);
			throw new UnexpectedException("An internal error has occured",e);
		} finally {
			session.getTransaction().commit();

		}
		return addressInfo;
	}

}
