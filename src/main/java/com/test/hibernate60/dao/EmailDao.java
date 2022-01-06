package com.test.hibernate60.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.test.hibernate60.HibernateUtil;
import com.test.hibernate60.domain.Email;

public class EmailDao {
	
	public void saveEmail(Email email) {
		
		Transaction transaction = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			transaction = session.beginTransaction();
			session.save(email);
			transaction.commit();

		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	public List<Email> getEmails() {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return session.createQuery("from email", Email.class).list();
		}
	}
}