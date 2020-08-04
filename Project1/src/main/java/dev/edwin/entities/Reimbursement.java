package dev.edwin.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="REIMBURSEMENT")
public class Reimbursement {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="rid")
	private int rid;
	
	@Column(name="amount")
	private float amount;
	
	@Temporal(TemporalType.DATE)
	@Column(name="submit_date")
	private Date submit_date;
	
	@Column(name="status")
	private boolean status;
	
	@Temporal(TemporalType.DATE)
	@Column(name="status_date")
	private Date status_date;
	
	@Column(name="employee_note")
	private String employee_note;
	
	@Column(name="manager_note")
	private String manager_note;
	
	@ManyToOne
    @JoinColumn(name = "cid")
	private ExpenseCategory expenseCategory;
	
	@ManyToOne
    @JoinColumn(name = "eid")
	private Employee employee;
	
	
	
	public Reimbursement() {
		super();
	}



	public Reimbursement(int rid, float amount, Date submit_date, boolean status, Date status_date,
			String employee_note, String manager_note, ExpenseCategory expenseCategory, Employee employee) {
		super();
		this.rid = rid;
		this.amount = amount;
		this.submit_date = submit_date;
		this.status = status;
		this.status_date = status_date;
		this.employee_note = employee_note;
		this.manager_note = manager_note;
		this.expenseCategory = expenseCategory;
		this.employee = employee;
	}



	public int getRid() {
		return rid;
	}



	public void setRid(int rid) {
		this.rid = rid;
	}



	public float getAmount() {
		return amount;
	}



	public void setAmount(float amount) {
		this.amount = amount;
	}



	public Date getSubmit_date() {
		return submit_date;
	}



	public void setSubmit_date(Date submit_date) {
		this.submit_date = submit_date;
	}



	public boolean isStatus() {
		return status;
	}



	public void setStatus(boolean status) {
		this.status = status;
	}



	public Date getStatus_date() {
		return status_date;
	}



	public void setStatus_date(Date status_date) {
		this.status_date = status_date;
	}



	public String getEmployee_note() {
		return employee_note;
	}



	public void setEmployee_note(String employee_note) {
		this.employee_note = employee_note;
	}



	public String getManager_note() {
		return manager_note;
	}



	public void setManager_note(String manager_note) {
		this.manager_note = manager_note;
	}



	public ExpenseCategory getExpenseCategory() {
		return expenseCategory;
	}



	public void setExpenseCategory(ExpenseCategory expenseCategory) {
		this.expenseCategory = expenseCategory;
	}



	public Employee getEmployee() {
		return employee;
	}



	public void setEmployee(Employee employee) {
		this.employee = employee;
	}



	@Override
	public String toString() {
		return "Reimbursement [rid=" + rid + ", amount=" + amount + ", submit_date=" + submit_date + ", status="
				+ status + ", status_date=" + status_date + ", employee_note=" + employee_note + ", manager_note="
				+ manager_note + ", expenseCategory=" + expenseCategory + ", employee=" + employee + "]";
	}

	
	
}
