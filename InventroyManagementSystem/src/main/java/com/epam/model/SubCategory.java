package com.epam.model;

public class SubCategory {
   private int maincategory_id;
   private int subcategory_id;
   private String subcategory_name;
   
   public int getMaincategory_id() {
	return maincategory_id;
}
public void setMaincategory_id(int maincategory_id) {
	this.maincategory_id = maincategory_id;
}

public int getSubcategory_id() {
	return subcategory_id;
}
public void setSubcategory_id(int subcategory_id) {
	this.subcategory_id = subcategory_id;
}
public String getSubcategory_name() {
	return subcategory_name;
}
public void setSubcategory_name(String subcategory_name) {
	this.subcategory_name = subcategory_name;
}
		
}
