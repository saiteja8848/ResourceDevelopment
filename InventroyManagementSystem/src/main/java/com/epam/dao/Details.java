package com.epam.dao;

import com.epam.model.*;
import java.util.ArrayList;

public class Details 
{
	  private  ArrayList<Category> categorys_list = new ArrayList<Category>();
      private  ArrayList<SubCategory> subcategorys_list = new ArrayList<SubCategory>();
	  private  ArrayList<Product> products_list = new ArrayList<Product>();
      private  ArrayList<Cart> cartitems_list =  new ArrayList<Cart>();
	  
	 public void setCategorys(){
	   Category	electronics = new Category(1,"Electronics");
	   Category	fashion = new Category(2,"Fashion");
	   categorys_list.add(electronics);
	   categorys_list.add(fashion);
	 }
    public void setsubCategories(){
    	 SubCategory s1 = new SubCategory(1,1,"Mobile");
    	 SubCategory s2 = new SubCategory(1,2,"Televisions");
    	 SubCategory s3 = new SubCategory(1,3,"Laptops");
    	 SubCategory s4 = new SubCategory(2,1,"Mens");
    	 SubCategory s5 = new SubCategory(2,2,"Womens");
    	 SubCategory s6 = new SubCategory(2,3,"Kids");
    	 subcategorys_list.add(s1);
    	 subcategorys_list.add(s2);
    	 subcategorys_list.add(s3);
    	 subcategorys_list.add(s4);
    	 subcategorys_list.add(s5);
    	 subcategorys_list.add(s6);
    } 
    public void setProducts(){
    	Product p1 = new Product(1,1,1,"Samsung",10000,4);	
    	Product p2 = new Product(1,1,2,"Iphone",50000,5);	    	
    	Product p3 = new Product(1,2,1,"LG_television",20000,6);
    	Product p4 = new Product(1,2,2,"BPL_television",60000,5);
    	Product p5 = new Product(2,1,1,"Black-Tshirts",500,10);
    	Product p6 = new Product(2,2,1,"Womens-clothes",800,4);
    	Product p7 = new Product(2,3,1,"Kids-wear",300,3);
    	products_list.add(p1);
    	products_list.add(p2);
    	products_list.add(p3);
    	products_list.add(p4);	
    	products_list.add(p5);	
    	products_list.add(p6);	
    	products_list.add(p7);	    	
    }
    
    public ArrayList<Category> getCategorys(){
    	return categorys_list;
    	}
    public ArrayList<SubCategory> findsubCategories(int id){	
		return subcategorys_list;
	}
    
    public ArrayList<Product> getProducts(int id){
    	return products_list;
    }  
    
    
    
    void add(Product product,int quantity)throws CloneNotSupportedException 
    {
    	Product x;
	    Cart temp = new Cart();
    	 x =(Product)product.clone();
		    x.setQuantity(quantity);
		    temp.setCart_products(x);
		    cartitems_list.add(temp);

    }
	public void addtoCart(Product product,int quantity)throws CloneNotSupportedException 
	{
		
		if(cartitems_list.size()==0)  
			add(product,quantity);
		else	{
			int flag=1;
			for(int i=0;i<cartitems_list.size();i++)
			{
			  	if(cartitems_list.get(i).getCart_products().getName()==product.getName())
			  	{
			          int value =cartitems_list.get(i).getCart_products().getQuantity();
			          value =value+quantity;
			          cartitems_list.get(i).getCart_products().setQuantity(value);
			          flag=1;
			          break;
			  	}
			  	else
			  		flag=0;
			}
			if(flag==0)
		     add(product,quantity);	
		}
		System.out.println("Selected product added to cart successfully");
	}
	
	
    public void printcartItems()
    {
    	if(cartitems_list.size()==0)
    		System.out.println("No Items are added to cart");
    	else
    	for(int i=0;i<cartitems_list.size();i++){
    		System.out.println("Name="+cartitems_list.get(i).getCart_products().getName());
     	     System.out.println("Price="+cartitems_list.get(i).getCart_products().getPrice());
     	     System.out.println("Quantity="+cartitems_list.get(i).getCart_products().getQuantity());
    		}
    }
    
    public void getBilling()
    {
    	if(cartitems_list.size()==0)
    		System.out.println("No Items for billing");
    	else
    	for(int i=0;i<cartitems_list.size();i++){
    		System.out.println("name="+cartitems_list.get(i).getCart_products().getName());
    	    System.out.println("Price="+cartitems_list.get(i).getCart_products().getPrice());
    	   Cart q =cartitems_list.get(i);
    	   Product p = q.getCart_products();
    	   int k = p.getQuantity()-1;
    	   p.setQuantity(k);
    	}
    	cartitems_list.clear();
    }
    
    
    
}
