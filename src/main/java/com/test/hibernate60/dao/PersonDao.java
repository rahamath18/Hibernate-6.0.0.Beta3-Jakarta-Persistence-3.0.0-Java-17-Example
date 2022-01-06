package com.test.hibernate60.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.test.hibernate60.HibernateUtil;
import com.test.hibernate60.domain.Person;

public class PersonDao {
	
	public void savePerson(Person person) {
		
		Transaction transaction = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			transaction = session.beginTransaction();
			session.save(person);
			transaction.commit();

		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	public List<Person> getPersons() {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return session.createQuery("from person", Person.class).list();
		}
	}
}