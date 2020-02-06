package com.epam.model;

import java.util.List;
import com.epam.Services.*;

public class Category implements ecommerce
{
   int categoryId;
   String categoryName;
   List<Subcategory> subcategorys;
   
public Category(int categoryId, String categoryName, List<Subcategory> subcategorys) {
	this.categoryId = categoryId;
	this.categoryName = categoryName;
	this.subcategorys = subcategorys;
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
   System.out.println(categoryId+"."+categoryName);	
}


}
