package com.epam.services;

import java.util.ArrayList;
import com.epam.dao.*;
import com.epam.model.*;


public class ServicesImplementation implements ServiceInterface
{
	private Details d = new Details();
	
	public void setAll(){
 		d.setCategorys();
 		d.setsubCategories();
 		d.setProducts();
 	}
	public void printAllcategories()	{
			ArrayList<Category> c = d.getCategorys();
			for (int i = 0; i < c.size(); i++) 
		        System.out.println(c.get(i).getCategoryId() + "." + c.get(i).getCategoryName());
			
			
	}
 	public void  printAllsubCategoriesById(int category_option){
 		 ArrayList<SubCategory> sc =d.findsubCategories(category_option);
         for (int i = 0; i < sc.size(); i++)  
		      if (sc.get(i).getMaincategory_id() == category_option)
		       System.out.println(sc.get(i).getSubcategory_id() + "." + sc.get(i).getSubcategory_name());
 		
 		
 	}
 	public void  printAllProductsById(int category_option,int subcategory_option){
 		   ArrayList<Product> p = d.getProducts(subcategory_option);
	      for (int i = 0; i < p.size(); i++) 
		      if (p.get(i).getSubcategory_id() == subcategory_option&& p.get(i).getMaincategory_id() == category_option)
	     	  System.out.println(p.get(i).getProduct_id() + "." + "name=" + p.get(i).getName() + " price="+ p.get(i).getPrice()+ " Quantity="+p.get(i).getQuantity());
        		
 	}
 	
 	
 	  public void addProductToCart(int category_option,int subcategory_option,int product_option,int quantity) 
 	  {
 		 ArrayList<Product> p = d.getProducts(subcategory_option);
 		 Product value=null;
 		 for(int i=0;i<p.size();i++)
 		 {  if(p.get(i).getProduct_id()==product_option&&p.get(i).getSubcategory_id()==subcategory_option&&p.get(i).getMaincategory_id()==category_option)
			   value=p.get(i);
 		 }  		  
 		 try {
 		 d.addtoCart(value,quantity);
 		 }
 		 catch(Exception e) {System.out.println(e);}
 	  } 	  
 	  
 	  
 	  
 	  
 	 public void getProductsInCart(){
 		d.printcartItems();
 	}
 	
 	 	public void billing(){
 		d.getBilling();
 	}
 	
}
