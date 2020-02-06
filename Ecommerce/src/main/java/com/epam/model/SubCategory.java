package com.epam.model;

public class SubCategory {
   private int maincategoryId;
   private int subcategoryId;
   private String subcategoryName;
   
   public SubCategory(int maincategoryId, int subcategoryId, String subcategoryName) {
	this.maincategoryId = maincategoryId;
	this.subcategoryId = subcategoryId;
	this.subcategoryName = subcategoryName;
}
   
   
   
public int getmaincategoryId() {
	return maincategoryId;
}
public void setmaincategoryId(int maincategoryId) {
	this.maincategoryId = maincategoryId;
}

public int getsubcategoryId() {
	return subcategoryId;
}
public void setsubcategoryId(int subcategoryId) {
	this.subcategoryId = subcategoryId;
}
public String getsubcategoryName() {
	return subcategoryName;
}
public void setsubcategoryName(String subcategoryName) {
	this.subcategoryName = subcategoryName;
}
		
}
