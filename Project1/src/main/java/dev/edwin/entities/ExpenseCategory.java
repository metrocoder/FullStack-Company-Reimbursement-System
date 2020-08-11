package dev.edwin.entities;



public class ExpenseCategory {

	private int cid;

	private String title;

	private String image_url;

	
	
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
	public String toString()
	{

		return "ExpenseCategory{" +
				"cid=" + cid +
				", title='" + title + '\'' +
				", image_url='" + image_url + '\'' +
				'}';
	}
}
