package com.epam.services;

import java.util.ArrayList;
import com.epam.dao.*;
import com.epam.model.*;


public class ServicesImplementation implements ServicesInterface
{
	private Details d = new Details();
	
	public ArrayList<Category> getAllCategories()
	{
			return d.getCategorys();
	}
 	public ArrayList<SubCategory> getsubCategories(int id)
 	{
 	   return d.findsubCategories(id);	
 	}
 	public ArrayList<Product> getProducts(int id)
 	{
 			return d.getProducts(id);
 	}
 	  public void addtocart(Product p)
 	  {
 		  d.addtoCart(p);
 	  }
 	public void getcartItems()
 	{
 		d.printcartItems();
 	}
 	public void setAll()
 	{
 		d.setCategorys();
 		d.setsubCategories();
 		d.setProducts();

 	}
 	public void billing()
 	{
 		d.getCartItems();
 	}
 	
}
