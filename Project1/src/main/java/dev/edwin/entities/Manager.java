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
@Table(name="MANAGER")
public class Manager {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="mgid")
	private int mgid;
	
	@Column(name="email")
	private String email;
	
	@Column(name="password")
	private String password;
	
	@Column(name="name")
	private String name;
	
	@Column(name="image_url")
	private String image_url;
	
	@OneToMany(mappedBy = "MANAGER", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Employee> employees = new ArrayList<Employee>();
	

	public Manager() {
		super();
	}


	public Manager(int mgid, String email, String password, String name, String image_url) {
		super();
		this.mgid = mgid;
		this.email = email;
		this.password = password;
		this.name = name;
		this.image_url = image_url;
	}


	public int getMgid() {
		return mgid;
	}


	public void setMgid(int mgid) {
		this.mgid = mgid;
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


	public List<Employee> getEmployees() {
		return employees;
	}


	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}


	@Override
	public String toString() {
		return "Manager [mgid=" + mgid + ", email=" + email + ", password=" + password + ", name=" + name
				+ ", image_url=" + image_url + "]";
	}


	
	
	
	
}
