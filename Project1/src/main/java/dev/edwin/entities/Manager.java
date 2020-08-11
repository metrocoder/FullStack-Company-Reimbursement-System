package dev.edwin.entities;




public class Manager {

	private int mgid;
	
	private String email;
	
	private String password;
	
	private String name;
	
	private String image_url;


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



	@Override
	public String toString()
	{
		return "Manager{" +
				"mgid=" + mgid +
				", email='" + email + '\'' +
				", password='" + password + '\'' +
				", name='" + name + '\'' +
				", image_url='" + image_url + '\'' +
				'}';
	}
}
