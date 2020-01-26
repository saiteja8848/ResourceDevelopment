package com.epam.dao;

import com.epam.model.*;
import java.util.ArrayList;

public class Details 
{
	  private  ArrayList<Category> categorys_list = new ArrayList<Category>();
      private  ArrayList<SubCategory> subcategorys_list = new ArrayList<SubCategory>();
	  private  ArrayList<Product> products_list = new ArrayList<Product>();
      private  ArrayList<Cart> cartitems_list =  new ArrayList<Cart>();
	  private  ArrayList<Cart> cartitemlist_update = new ArrayList<Cart>();
      
	 public void setCategorys(){
	   Category	electronics = new Category(1,"Electronics");
	   Category	fashion = new Category(2,"Fashion");
	   categorys_list.add(electronics);
	   categorys_list.add(fashion);
	 }
	  public ArrayList<Category> getCategorys(){
	    	return categorys_list;
	    	}
    public void setsubCategories(){
    	 subcategorys_list.add(new SubCategory(1,1,"Mobile"));
    	 subcategorys_list.add(new SubCategory(1,2,"Televisions"));
    	 subcategorys_list.add( new SubCategory(1,3,"Laptops"));
    	 subcategorys_list.add(new SubCategory(2,1,"Mens"));
    	 subcategorys_list.add(new SubCategory(2,2,"Womens"));
    	 subcategorys_list.add(new SubCategory(2,3,"Kids"));
    }
    public ArrayList<SubCategory> findsubCategories(){	
		return subcategorys_list;
	}
    public void setProducts(){
    	products_list.add(new Product(1,1,1,"Samsung",21000,4));
    	products_list.add(new Product(1,1,2,"Iphone",50000,5));
    	products_list.add(new Product(1,1,3,"realme",12000,3));
    	products_list.add(new Product(1,2,1,"ONIDA",20000,6));
    	products_list.add(new Product(1,2,2,"SONY",60000,5));
    	products_list.add(new Product(1,2,3,"SAMSUNG",75000,6));
    	products_list.add(new Product(1,3,1,"Apple",20000,6));
    	products_list.add(new Product(1,3,2,"Dell",60000,5));
    	products_list.add(new Product(1,3,3,"Hp",75000,6));
    	products_list.add(new Product(2,1,1,"levis",5000,10));
    	products_list.add(new Product(2,1,2,"denim",1500,10));
    	products_list.add(new Product(2,1,3,"raymond",2500,10));
    	products_list.add(new Product(2,2,1,"Sarees",1800,14));
    	products_list.add(new Product(2,2,2,"causal",1800,4));
    	products_list.add(new Product(2,2,3,"formal",2800,4));
    	products_list.add(new Product(2,3,1,"Kids-1",1300,3));	
    	products_list.add(new Product(2,3,2,"kids-2",1800,4));
    	products_list.add(new Product(2,3,3,"kids-3",1000,4));
    }
    public ArrayList<Product> getProducts(int id){
    	return products_list;
    }  
    
    
    
    void add(Product product,int quantity)throws CloneNotSupportedException 
    {
    	 Product x;
	     Cart temp = new Cart();
         	 x =(Product)product.clone();
    	    temp.setOriginal_quantity(product.getQuantity());
		    x.setQuantity(quantity);
		    temp.setCart_products(x);
		    cartitems_list.add(temp);
		    System.out.println("\nSelected product added to cart successfully");
		    Cart update = new Cart();
	        update.setCart_products(product);
	        cartitemlist_update.add(update);
    }
    
	public void addtoCart(Product product,int quantity)throws CloneNotSupportedException 
	{
		int flag=1;
		if(cartitems_list.size()==0)  
			add(product,quantity);
		else
		{
			for(int i=0;i<cartitems_list.size();i++)
			{
			  	if(cartitems_list.get(i).getCart_products().getName()==product.getName())
			  	{
			          int value =cartitems_list.get(i).getCart_products().getQuantity();
			          value =value+quantity;
			         if(value<cartitems_list.get(i).getOriginal_quantity())
			          cartitems_list.get(i).getCart_products().setQuantity(value);
			         else
			        	 System.out.println("Out of stock");
			          break;
			  	}
			  	else
			  		flag=0;
			}
			if(flag==0)
		     add(product,quantity);	
		}	
	}
		  
    public ArrayList<Cart> getCartProducts()
    {
    	return cartitems_list;
    }
	
    public ArrayList<Cart> getCartUpdate()
    {
    	return cartitemlist_update;
    }  
    
}
