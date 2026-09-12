package com.example.demo.pojo;

public class IPO {

	String name;
	Integer price;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public IPO(String name, Integer price) {
		super();
		this.name = name;
		this.price = price;
	}
	
	
	
}
