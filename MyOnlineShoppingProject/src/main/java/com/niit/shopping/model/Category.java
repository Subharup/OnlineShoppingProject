package com.niit.shopping.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Category implements Serializable{
	@Id
	@GeneratedValue
	private int categoryId;
	private String categoryName;
	@OneToMany(mappedBy="catagory",fetch=FetchType.EAGER)
	List<SubCategory> subCatagory;
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public List<SubCategory> getSubCatagory() {
		return subCatagory;
	}
	public void setSubCatagory(List<SubCategory> subCatagory) {
		this.subCatagory = subCatagory;
	}
	
}
