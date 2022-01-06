package com.test.hibernate60;

import java.util.List;

import com.test.hibernate60.dao.DepartmentDao;
import com.test.hibernate60.dao.EmailDao;
import com.test.hibernate60.dao.PersonDao;
import com.test.hibernate60.domain.Department;
import com.test.hibernate60.domain.Email;
import com.test.hibernate60.domain.Person;

public class App {
	
	static PersonDao personDao = new PersonDao();
	static DepartmentDao departmentDao = new DepartmentDao();
	static EmailDao emailDao = new EmailDao();

	
	public static void main(String[] args) {
		
		createPersonWithDepartmentAndEmail();
		
		retrievePerson();
		
	}

	private static void createPersonWithDepartmentAndEmail() {
		Person person1 = new Person(null, "Rahamath", "S");
		personDao.savePerson(person1);
		departmentDao.saveDepartment(new Department(null, "Energy", "LOC1", person1));
		departmentDao.saveDepartment(new Department(null, "Solar", "LOC2", person1));
		emailDao.saveEmail(new Email(null, "rahamath18@yahoo.com", person1));
		emailDao.saveEmail(new Email(null, "rahamath1805@gmail.com", person1));
		emailDao.saveEmail(new Email(null, "rahamath1805@info.com", person1));
		
		Person person2 = new Person(null, "John Kumar", "D");
		personDao.savePerson(person2);
		departmentDao.saveDepartment(new Department(null, "Energy", "LOC1", person2));
		departmentDao.saveDepartment(new Department(null, "Solar", "LOC2", person2));
		emailDao.saveEmail(new Email(null, "john.kumar@gmail.com", person2));
		emailDao.saveEmail(new Email(null, "john.kumar@info.com", person2));
		
	}

	private static void retrievePerson() {
		List<Person> persons = personDao.getPersons();
		persons.forEach(person -> 
			{
				System.out.println(person); 
				System.out.println(person.getDepartment()); 
				System.out.println(person.getEmail()); 
			}
		);
	}

}