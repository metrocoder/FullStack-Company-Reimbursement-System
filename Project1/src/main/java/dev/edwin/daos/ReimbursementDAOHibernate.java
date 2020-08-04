package dev.edwin.daos;


import dev.edwin.entities.Reimbursement;
import dev.edwin.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class ReimbursementDAOHibernate implements ReimbursementDAO {
    private static SessionFactory sf = HibernateUtil.getSessionFactory();

    private static ReimbursementDAO rdao = null;

    private ReimbursementDAOHibernate()
    {super();}

    public static ReimbursementDAO getRdao(){
        if (rdao == null)
            rdao = new ReimbursementDAOHibernate();

        return rdao;
    }

    @Override
    public Reimbursement createReimbursement(Reimbursement reimbursement) {
        Session s = sf.openSession();
        s.beginTransaction();

        s.save(reimbursement);

        s.getTransaction().commit();
        s.close();

        return reimbursement;
    }

    @Override
    public Reimbursement getReimbursementById(int rid) {
        Session s = sf.openSession();

        Reimbursement result = s.get(Reimbursement.class, rid);
        s.close();

        return result;
    }


    @Override
    public List<Reimbursement> getAllReimbursement() {
        Session s = sf.openSession();

        CriteriaBuilder cb = s.getCriteriaBuilder();
        CriteriaQuery<Reimbursement> cq = cb.createQuery(Reimbursement.class);
        Root<Reimbursement> rootEntry = cq.from(Reimbursement.class);
        CriteriaQuery<Reimbursement> all = cq.select(rootEntry);

        TypedQuery<Reimbursement> allQuery = s.createQuery(all);
        return allQuery.getResultList();
    }

    @Override
    public Reimbursement updateReimbursement(Reimbursement reimbursement) {
        Session s = sf.openSession();
        s.beginTransaction();

        s.update(reimbursement);

        s.getTransaction().commit();
        s.close();

        return reimbursement;
    }

    @Override
    public boolean deleteReimbursement(Reimbursement reimbursement) {
        try {

            Session s = sf.openSession();
            s.beginTransaction();

            s.update(reimbursement);

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
