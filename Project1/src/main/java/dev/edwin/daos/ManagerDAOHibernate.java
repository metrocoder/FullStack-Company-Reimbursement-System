package dev.edwin.daos;

import java.util.List;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import dev.edwin.entities.Manager;
import dev.edwin.utils.HibernateUtil;
import org.hibernate.criterion.Restrictions;

public class ManagerDAOHibernate implements ManagerDAO {
	private static ManagerDAO mdao;

	private static SessionFactory sf = HibernateUtil.getSessionFactory();
	
	private ManagerDAOHibernate() {super();}
	
	public static ManagerDAO getMdao()
	{
		if (mdao == null)
			mdao = new ManagerDAOHibernate();
		
		return mdao;
	}

	@Override
	public Manager createManager(Manager manager) {
		Session s = sf.openSession();
		s.beginTransaction();
		
		s.save(manager);
		
		s.getTransaction().commit();
		s.close();
		
		return manager;
	}

	@Override
	public Manager getManagerById(int mgid) {
		Session s = sf.openSession();

		Manager result = s.get(Manager.class, mgid);
		s.close();

		return result;
	}


	@Override
	public List<Manager> getAllManagers() {
		Session s = sf.openSession();
		
		CriteriaBuilder cb = s.getCriteriaBuilder();
	    CriteriaQuery<Manager> cq = cb.createQuery(Manager.class);
	    Root<Manager> rootEntry = cq.from(Manager.class);
	    CriteriaQuery<Manager> all = cq.select(rootEntry);
	 
	    TypedQuery<Manager> allQuery = s.createQuery(all);
	    return allQuery.getResultList();
	}

	@Override
	public Manager updateManager(Manager manager) {
		Session s = sf.openSession();
		s.beginTransaction();
		
		s.update(manager);
		
		s.getTransaction().commit();
		s.close();
		
		return manager;
	}

	@Override
	public boolean deleteManager(Manager manager) {
		
		try {
			
			Session s = sf.openSession();
			s.beginTransaction();
			
			s.delete(manager);
			
			s.getTransaction().commit();
			s.close();
			
			return true;
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		
		return false;
	}

}
