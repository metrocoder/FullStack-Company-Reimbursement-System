package dev.edwin.entities;



public class Employee {

	private int eid;
	private String email;
	private String password;
	private String name;
	private String image_url;
	private int mgid;
	
	
	public Employee() {
		super();
	}
	
	


	public Employee(int eid, String email, String password, String name, String image_url, int mgid) {
		super();
		this.eid = eid;
		this.email = email;
		this.password = password;
		this.name = name;
		this.image_url = image_url;
		this.mgid = mgid;
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


	public int getMgid()
	{
		return mgid;
	}

	public void setMgid(int mgid)
	{
		this.mgid = mgid;
	}


	@Override
	public String toString()
	{

		return "Employee{" +
				"eid=" + eid +
				", email='" + email + '\'' +
				", password='" + password + '\'' +
				", name='" + name + '\'' +
				", image_url='" + image_url + '\'' +
				", manager=" + mgid +
				'}';
	}
}
