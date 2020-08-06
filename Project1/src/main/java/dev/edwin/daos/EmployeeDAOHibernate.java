package dev.edwin.daos;


import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import dev.edwin.entities.Employee;
import dev.edwin.utils.HibernateUtil;



public class EmployeeDAOHibernate implements EmployeeDAO 
{
	private static EmployeeDAO edao;
	private static SessionFactory sf = HibernateUtil.getSessionFactory();
	
	private EmployeeDAOHibernate() {super();}
	
	public static EmployeeDAO getEdao() {
		
		if (edao == null)
			edao = new EmployeeDAOHibernate();
		
		return edao;
	}

	@Override
	public Employee createEmployee(Employee employee) {
		Session s = sf.openSession(); // open a session
		s.beginTransaction(); // begin a transaction
		
		
		s.save(employee); // this will save our director object	
		
		s.getTransaction().commit(); // commit the transaction
		s.close(); // close a session
		
		return employee;
	}

	@Override
	public Employee getEmployeeById(int eid) {
		Session s = sf.openSession(); 
		
		Employee employee = s.get(Employee.class, eid);
		s.close(); 
		return employee;
	}
	
	@Override
	public Employee getEmployeeByEmail(String email) {
		Session s = sf.openSession(); 
		
		Employee employee = s.get(Employee.class, email);
		s.close(); 
		return employee;
	}

	@Override
	public Employee getEmployeeByName(String name) {
		Session s = sf.openSession(); 
		
		Employee employee = s.get(Employee.class, name);
		s.close(); 
		return employee;
	} 

	@Override
	public List<Employee> getAllEmployees() {
		Session s = sf.openSession(); 
		CriteriaBuilder cb = s.getCriteriaBuilder();
	    CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);
	    Root<Employee> rootEntry = cq.from(Employee.class);
	    CriteriaQuery<Employee> all = cq.select(rootEntry);
	 
	    TypedQuery<Employee> allQuery = s.createQuery(all);
	    return allQuery.getResultList();
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		Session s = sf.openSession(); // open a session
		s.beginTransaction(); // begin a transaction
		
		
		s.update(employee); // this will save our director object	
		
		s.getTransaction().commit(); // commit the transaction
		s.close(); // close a session
		
		return employee;
	}

	@Override
	public boolean deleteEmployee(Employee employee) {
		Session s = sf.openSession(); // open a session
		s.beginTransaction(); // begin a transaction
		
		try {
			

			s.delete(employee); // this will save our director object	
			
			s.getTransaction().commit(); // commit the transaction
			s.close(); // close a session
			
			return true;
			
		}
		catch(Exception e) 
		{
			
			e.printStackTrace();
			return false;
		}
		
	}





}
