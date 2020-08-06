package dev.edwin.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="EXPENSE_CATEGORY")
public class ExpenseCategory {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cid")
	private int cid;
	
	@Column(name="title")
	private String title;
	
	@Column(name="image_url")
	private String image_url;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "expenseCategory", cascade = CascadeType.ALL)
	private List<Reimbursement> reimbursements = new ArrayList<Reimbursement>();
	
	
	public ExpenseCategory() {
		super();
	}



	public ExpenseCategory(int cid, String title, String image_url) {
		super();
		this.cid = cid;
		this.title = title;
		this.image_url = image_url;
	}



	public int getCid() {
		return cid;
	}



	public void setCid(int cid) {
		this.cid = cid;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public String getImage_url() {
		return image_url;
	}



	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}



	@Override
	public String toString() {
		return "ExpenseCategory [cid=" + cid + ", title=" + title + ", image_url=" + image_url + "]";
	}
	
	

}
