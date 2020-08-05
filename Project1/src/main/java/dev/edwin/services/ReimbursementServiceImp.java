package dev.edwin.services;

import dev.edwin.daos.ReimbursementDAO;
import dev.edwin.entities.Reimbursement;

import javax.inject.Inject;
import java.util.List;

public class ReimbursementServiceImp implements ReimbursementService {

    @Inject
    private  ReimbursementDAO rdao;


    private static ReimbursementService rserv = null;

    private ReimbursementServiceImp() {
    }

    public static ReimbursementService getRserv() {
        if (rserv == null)
            rserv = new ReimbursementServiceImp();
        return rserv;
    }

    @Override
    public Reimbursement createReimbursement(Reimbursement reimbursement) {
        return rdao.createReimbursement(reimbursement);
    }

    @Override
    public Reimbursement getReimbursementById(int rid) {
        return rdao.getReimbursementById(rid);
    }

    @Override
    public List<Reimbursement> getAllReimbursement() {
        return rdao.getAllReimbursement();
    }

    @Override
    public Reimbursement updateReimbursement(Reimbursement reimbursement) {
        return rdao.updateReimbursement(reimbursement);
    }

    @Override
    public boolean deleteReimbursement(Reimbursement reimbursement) {
        return rdao.deleteReimbursement(reimbursement);
    }
}
