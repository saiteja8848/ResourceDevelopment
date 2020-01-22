package com.epam.services;

import com.epam.model.*;
import java.util.ArrayList;

public interface  ServicesInterface {
	
	public ArrayList<Category>  getAllCategories();
	public ArrayList<SubCategory> getsubCategories(int id);
	public ArrayList<Product> getProducts(int id);
    public void addtocart(Product p);
    public void getcartItems();
    public void setAll();
    public void billing();
}
