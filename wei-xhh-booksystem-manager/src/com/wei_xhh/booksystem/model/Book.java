package com.wei_xhh.booksystem.model;

public class Book {
	
	private String id;  //���
	private String name; //����
	private double price; //�۸�
	private int bnum; //����
	private String category; //���
	
	
	public Book() {
		super();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getBnum() {
		return bnum;
	}
	public void setBnum(int bnum) {
		this.bnum = bnum;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	//��дtoString����
	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", price=" + price + ", bnum=" + bnum + ", category=" + category
				+ "]";
	}
	
	
}
