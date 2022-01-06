package com.test.hibernate60;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.test.hibernate60.HibernateUtil;

public class Test {

	public static void main(String[] args) {

		System.out.println("@@@@@@@@@@@@@@@@@");
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		
		//Session session = HibernateUtil.getSessionFactory().openSession();
		
	}

}
