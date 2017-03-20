package com.niit.shopping.model;

import java.io.Serializable;
import java.lang.annotation.Inherited;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class Product implements Serializable {

	@Id
	@GeneratedValue
	private int productId;
	private String productName;
	private double productPrice;
	private String productImage;
	@ManyToOne
	@JoinColumn(name="subcategoryId")
	private SubCategory productSubCategory;
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	public String getProductImage() {
		return productImage;
	}
	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}
	public SubCategory getProductSubCategory() {
		return productSubCategory;
	}
	public void setProductSubCategory(SubCategory productSubCategory) {
		this.productSubCategory = productSubCategory;
	}
	
		
}
