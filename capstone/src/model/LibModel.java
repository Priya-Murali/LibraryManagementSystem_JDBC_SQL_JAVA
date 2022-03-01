package model;

public class LibModel {
	private int bid;
	private String bname;
	private String aname;
	private int rackno;
	private double yearpub;
	public LibModel(int bid, String  bname, String aname, int rackno,
			double yearpub) {
		super();
		this.setbid(bid);
		this. bname =  bname;
		this.aname = aname;
		this.rackno = rackno;
		this.yearpub=yearpub;
	}
	public LibModel() {
		super();
	}
	public String getbname() {
		return  bname;
	}
	public void setbname(String  bname) {
		this. bname =  bname;
	}
	public String getaname() {
		return aname;
	}
	public void setaname(String aname) {
		this. aname = aname;
	}
	public int getrackno() {
		return rackno;
	}
	public void setrackno(int rackno) {
		this.rackno = rackno;
	}
	public double getyearpub() {
		return yearpub;
	}
	public void setyearpub(double yearpub) {
		this.yearpub = yearpub;
	}
	public int getbid() {
		return bid;
	}
	public void setbid(int bid) {
		this.bid = bid;
	}
	
	
}