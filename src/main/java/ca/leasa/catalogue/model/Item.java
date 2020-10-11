package ca.leasa.catalogue.model;

import java.math.BigDecimal;

public class Item {

	String category;
	String subCategory;
	String title;
	String description;
	BigDecimal dailyPrice;
	String imageID;
	String sku;
	
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getSubCategory() {
		return subCategory;
	}
	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getDailyPrice() {
		return dailyPrice;
	}
	public void setDailyPrice(BigDecimal dailyPrice) {
		this.dailyPrice = dailyPrice;
	}
	public String getImageID() {
		return imageID;
	}
	public void setImageID(String imageID) {
		this.imageID = imageID;
	}
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	
	
}
