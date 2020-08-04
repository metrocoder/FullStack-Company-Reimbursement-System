package dev.edwin.services;

import dev.edwin.entities.Reimbursement;

import java.util.List;

public interface ReimbursementService {

//    CRUD
    Reimbursement createReimbursement(Reimbursement reimbursement);

//    READ
    Reimbursement getReimbursementById(int rid);
    List<Reimbursement> getAllReimbursement();

//    Update
    Reimbursement updateReimbursement(Reimbursement reimbursement);

//    Delete
    boolean deleteReimbursement(Reimbursement reimbursement);
}
