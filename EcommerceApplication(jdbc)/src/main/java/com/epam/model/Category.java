package com.epam.model;

import java.util.List;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epam.services.*;

public class Category implements Ecommerce
{
	private static Logger logger = LogManager.getLogger(Category.class);
   int categoryId;
   String categoryName;
    List<Subcategory> subcategorys = new ArrayList<>();
   public Category() {}
    
public Category(int categoryId, String categoryName) {
	this.categoryId = categoryId;
	this.categoryName = categoryName;
}
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
public List<Subcategory> getSubcategorys() {
	return subcategorys;
}
public void setSubcategorys(List<Subcategory> subcategorys) {
	this.subcategorys = subcategorys;
}

public void showDetails() {
   logger.info("{}{}.{}","\n",categoryId,categoryName);	
}


}
