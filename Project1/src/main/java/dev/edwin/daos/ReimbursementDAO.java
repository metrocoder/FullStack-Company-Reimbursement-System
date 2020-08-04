package dev.edwin.daos;

import java.util.List;

import dev.edwin.entities.Reimbursement;

public interface ReimbursementDAO {
	
//	CRUD
	Reimbursement createReimbursement(Reimbursement reimbursement);
	
//	Read
	Reimbursement getReimbursementById(int rid);
	Reimbursement getReimbursementByEmployee(int eid);
	Reimbursement getReimbursementByCategory(int cid);
	Reimbursement getReimbursementByStatus(int status);
	List<Reimbursement> getAllReimbursement();
	
//	Update
	Reimbursement updateReimbursement(Reimbursement reimbursement);
	
//	Delete
	boolean deleteReimbursement(Reimbursement reimbursement);

}
