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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="EMPLOYEE")
public class Employee {


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="eid")
	private int eid;
	@Column(name="email")
	private String email;
	@Column(name="password")
	private String password;
	@Column(name="name")
	private String name;
	@Column(name="image_url")
	private String image_url;

	@ManyToOne
	@JoinColumn(name = "mgid")
	private Manager manager;
	
	@OneToMany(mappedBy = "employee", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Reimbursement> reimbursements = new ArrayList<Reimbursement>();
	
	
	public Employee() {
		super();
	}
	
	


	public Employee(int eid, String email, String password, String name, String image_url) {
		super();
		this.eid = eid;
		this.email = email;
		this.password = password;
		this.name = name;
		this.image_url = image_url;
//		this.mgid = mgid;
	}




	public int getEid() {
		return eid;
	}




	public void setEid(int eid) {
		this.eid = eid;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public String getPassword() {
		return password;
	}




	public void setPassword(String password) {
		this.password = password;
	}




	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	public String getImage_url() {
		return image_url;
	}




	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}


	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	public List<Reimbursement> getReimbursements() {
		return reimbursements;
	}




	public void setReimbursements(List<Reimbursement> reimbursements) {
		this.reimbursements = reimbursements;
	}




	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", email=" + email + ", password=" + password + ", name=" + name
				+ ", image_url=" + image_url + "]";
	}

	
	

}
