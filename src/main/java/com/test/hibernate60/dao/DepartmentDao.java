package com.test.hibernate60.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.test.hibernate60.HibernateUtil;
import com.test.hibernate60.domain.Department;

public class DepartmentDao {
	
	public void saveDepartment(Department department) {
		
		Transaction transaction = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			transaction = session.beginTransaction();
			session.save(department);
			transaction.commit();

		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	public List<Department> getDepartments() {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return session.createQuery("from department", Department.class).list();
		}
	}
}