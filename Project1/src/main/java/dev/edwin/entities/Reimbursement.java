package dev.edwin.entities;


public class Reimbursement {

	private int rid;

	private float amount;

	private String submit_date;

	private int status;

	private String status_date;

	private String employee_note;

	private String manager_note;

	private int cid;

	private int eid;
	
	
	
	public Reimbursement() {
		super();
	}

	public Reimbursement(int rid, float amount, String submit_date, int status, String status_date, String employee_note, String manager_note, int cid, int eid)
	{
		this.rid = rid;
		this.amount = amount;
		this.submit_date = submit_date;
		this.status = status;
		this.status_date = status_date;
		this.employee_note = employee_note;
		this.manager_note = manager_note;
		this.cid = cid;
		this.eid = eid;
	}

	public int getRid()
	{
		return rid;
	}

	public void setRid(int rid)
	{
		this.rid = rid;
	}

	public float getAmount()
	{
		return amount;
	}

	public void setAmount(float amount)
	{
		this.amount = amount;
	}

	public String getSubmit_date()
	{
		return submit_date;
	}

	public void setSubmit_date(String submit_date)
	{
		this.submit_date = submit_date;
	}

	public int getStatus()
	{
		return status;
	}

	public void setStatus(int status)
	{
		this.status = status;
	}

	public String getStatus_date()
	{
		return status_date;
	}

	public void setStatus_date(String status_date)
	{
		this.status_date = status_date;
	}

	public String getEmployee_note()
	{
		return employee_note;
	}

	public void setEmployee_note(String employee_note)
	{
		this.employee_note = employee_note;
	}

	public String getManager_note()
	{
		return manager_note;
	}

	public void setManager_note(String manager_note)
	{
		this.manager_note = manager_note;
	}

	public int getCid()
	{
		return cid;
	}

	public void setCid(int cid)
	{
		this.cid = cid;
	}

	public int getEid()
	{
		return eid;
	}

	public void setEid(int eid)
	{
		this.eid = eid;
	}

	@Override
	public String toString()
	{
		return "Reimbursement{" +
				"rid=" + rid +
				", amount=" + amount +
				", submit_date=" + submit_date +
				", status=" + status +
				", status_date=" + status_date +
				", employee_note='" + employee_note + '\'' +
				", manager_note='" + manager_note + '\'' +
				", cid=" + cid +
				", eid=" + eid +
				'}';
	}
}
