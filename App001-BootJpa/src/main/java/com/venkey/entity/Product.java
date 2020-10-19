package com.venkey.entity;



import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


@Document(collection = "prod_details")
public class Product {
	@Id
	private Integer prodID;
	private String prodName;
	@Field(name = "price")
	private Double cost;
	private String color;
	
	public void setColor(String color) {
		this.color = color;
	}

	public Integer getProdID() {
		return prodID;
	}

	public void setProdID(Integer prodID) {
		this.prodID = prodID;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	public String getColor() {
		return color;
	}

}
