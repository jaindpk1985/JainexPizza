package process;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import common.UnexpectedException;

import dao.HibernateUtil;
import dao.LoginData;

public class LoginProcess {

	static final Logger log = Logger.getLogger(LoginProcess.class);

	/**
	 * Authenticate the user
	 * 
	 * @param loginData
	 * @return LoginData
	 * @throws UnexpectedException
	 */
	public LoginData authenticateUser(LoginData loginData)
			throws UnexpectedException {

		Session session = null;
		LoginData loginDataResult=null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Criteria crit = session.createCriteria(LoginData.class);
			crit.add(Restrictions.eq("pwd_text", loginData.getPwd_text()));
			crit.add(Restrictions.eq("userName", loginData.getUserName()));
			loginDataResult = (LoginData) crit.uniqueResult();
		} catch (HibernateException e) {
			log.error("A Hibernate exception thrown :" + e.getMessage(), e);
			throw new UnexpectedException("An internal error has occured",e);
		} finally {
			if (session != null){
				session.close();
			}
		}
		return loginDataResult;
	}

	/**
	 * Create the user by saving the login info into DB
	 * 
	 * @param loginData
	 * @throws UnexpectedException
	 */
	public boolean createUser(LoginData loginData) throws UnexpectedException {
		Session session = null;
		Transaction tx = null;
		boolean txSuccess = false;
		try {
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			session.saveOrUpdate(loginData);
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
	 * Get the login info using userid
	 * 
	 * @param userId
	 *            to get login info by user id
	 * @return LoginData
	 * @throws UnexpectedException
	 */
	public LoginData getLoginInfoByUserId(Long userId)
			throws UnexpectedException {
		Session session = null;
		LoginData loginData = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Criteria crit = session.createCriteria(LoginData.class);
			crit.add(Restrictions.eq("userId", userId));
			loginData = (LoginData) crit.uniqueResult();
		} catch (HibernateException e) {
			log.error("A Hibernate exception thrown :" + e.getMessage(), e);
			throw new UnexpectedException("An internal error has occured",e);
		}
		return loginData;
	}

	/**
	 * Retrieve the login info by the user name
	 * 
	 * @param userName
	 * @return LoginData
	 * @throws UnexpectedException
	 */
	public LoginData getLoginInfoByUserName(String userName)
			throws UnexpectedException {
		Session session = null;
		LoginData loginData = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Criteria crit = session.createCriteria(LoginData.class);
			crit.add(Restrictions.eq("userName", userName));
			loginData = (LoginData) crit.uniqueResult();
		} catch (HibernateException e) {
			log.error("A Hibernate exception thrown :" + e.getMessage(), e);
			throw new UnexpectedException("An internal error has occured",e);
		}
		return loginData;
	}
}
