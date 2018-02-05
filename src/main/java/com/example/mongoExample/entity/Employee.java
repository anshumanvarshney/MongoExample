package com.example.mongoExample.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document (collection = Employee.COLLECTION_NAME)
public class Employee {
	public static final String COLLECTION_NAME = "employee";

	@Id
	private String productId;
	private String pName;
	private double pPrice;
	private String pBrand;
	private String pCategory;
	private String pimage;
	private int pUnit;

	public static String getCollectionName() {
		return COLLECTION_NAME;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public double getpPrice() {
		return pPrice;
	}

	public void setpPrice(double pPrice) {
		this.pPrice = pPrice;
	}

	public String getpBrand() {
		return pBrand;
	}

	public void setpBrand(String pBrand) {
		this.pBrand = pBrand;
	}

	public String getpCategory() {
		return pCategory;
	}

	public void setpCategory(String pCategory) {
		this.pCategory = pCategory;
	}

	public String getPimage() {
		return pimage;
	}

	public void setPimage(String pimage) {
		this.pimage = pimage;
	}

	public int getpUnit() {
		return pUnit;
	}

	public void setpUnit(int pUnit) {
		this.pUnit = pUnit;
	}
}
