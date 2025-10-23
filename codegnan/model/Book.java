package com.codegnan.model;

public class Book {
	private int Bid;
	private String Bname;
	private String Aname;
	private double price;
	@Override
	public String toString() {
		return "Book [Bid=" + Bid + ", Bname=" + Bname + ", Aname=" + Aname + ", price=" + price + "]";
	}
	public int getBid() {
		return Bid;
	}
	public void setBid(int bid) {
		Bid = bid;
	}
	public String getBname() {
		return Bname;
	}
	public void setBname(String bname) {
		Bname = bname;
	}
	public String getAname() {
		return Aname;
	}
	public void setAname(String aname) {
		Aname = aname;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Book(int bid, String bname, String aname, double price) {
		super();
		Bid = bid;
		Bname = bname;
		Aname = aname;
		this.price = price;
	}
	public Book() {
		super();
	}
	
	

}
