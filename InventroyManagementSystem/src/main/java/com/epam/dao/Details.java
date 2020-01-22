package com.epam.dao;

import com.epam.model.*;
import java.util.ArrayList;

public class Details {
	 
	  private  ArrayList<Category> c = new ArrayList<Category>();
      private  ArrayList<SubCategory> sc = new ArrayList<SubCategory>();
	  private  ArrayList<Product> p = new ArrayList<Product>();
      private  ArrayList<Cart> cart_items =  new ArrayList<Cart>();
	  
	 public void setCategorys()
	 {
	    Category	electronics = new Category();
		 electronics.setCategoryId(1);
		 electronics.setCategoryName("Electronics");
		 c.add(electronics);
		 Category	fashion = new Category();
		 fashion.setCategoryId(2);
		 fashion.setCategoryName("Fashion");
		 c.add(fashion);
		
	 }
    public ArrayList<Category> getCategorys()
    {        	return c; }
	
    
    public void setsubCategories()
    {
       
    	 SubCategory s1 = new SubCategory();
    	 s1.setMaincategory_id(1);
    	 s1.setSubcategory_id(1);
    	 s1.setSubcategory_name("Mobile");
    	 sc.add(s1);
    	 SubCategory s2 = new SubCategory();
    	 s2.setMaincategory_id(1);
    	 s2.setSubcategory_id(2);
    	 s2.setSubcategory_name("Televisions");
    	 sc.add(s2);
    	 SubCategory s3 = new SubCategory();
    	 s3.setMaincategory_id(1);
    	 s3.setSubcategory_id(3);
    	 s3.setSubcategory_name("Laptops");
    	 sc.add(s3);
    	 SubCategory s4 = new SubCategory();
    	 s4.setMaincategory_id(2);
    	 s4.setSubcategory_id(1);
    	 s4.setSubcategory_name("Mens");
    	 sc.add(s4);
    	 SubCategory s5 = new SubCategory();
    	 s5.setMaincategory_id(2);
    	 s5.setSubcategory_id(2);
    	 s5.setSubcategory_name("Womens");
    	 sc.add(s5);
    	 SubCategory s6 = new SubCategory();
    	 s6.setMaincategory_id(2);
    	 s6.setSubcategory_id(3);
    	 s6.setSubcategory_name("Kids");
    	 sc.add(s6);
    }
	public ArrayList<SubCategory> findsubCategories(int id)
	{	
		return sc;
	}
	
	
    public void setProducts()
    {
    	Product p1 = new Product();
    	p1.setMaincategory_id(1);
    	p1.setSubcategory_id(1);
    	p1.setName("Samsung");
    	p1.setPrice(1000);
    	p1.setQuantity(4);
    	p1.setProduct_id(1);
    	p.add(p1);
    	Product p2 = new Product();
    	p2.setMaincategory_id(1);
    	p2.setSubcategory_id(1);
    	p2.setName("Iphone");
    	p2.setPrice(2000);
    	p2.setQuantity(4);
    	p2.setProduct_id(2);
    	p.add(p2);
    	Product p3 = new Product();
    	p3.setMaincategory_id(1);
    	p3.setSubcategory_id(2);
    	p3.setName("LG_television");
    	p3.setPrice(1000);
    	p3.setQuantity(4);
    	p3.setProduct_id(1);
    	p.add(p3);
    	Product p4 = new Product();
    	p4.setMaincategory_id(1);
    	p4.setSubcategory_id(2);
    	p4.setName("BPL_television");
    	p4.setPrice(1000);
    	p4.setQuantity(4);
    	p4.setProduct_id(2);
    	p.add(p4);	
    	
    	Product p5 = new Product();
    	p5.setMaincategory_id(2);
    	p5.setSubcategory_id(1);
    	p5.setName("Black Tshirts");
    	p5.setPrice(1000);
    	p5.setQuantity(4);
    	p5.setProduct_id(1);
    	p.add(p5);	
    	
    	Product p6 = new Product();
    	p6.setMaincategory_id(2);
    	p6.setSubcategory_id(2);
    	p6.setName("Womens clothes");
    	p6.setPrice(1000);
    	p6.setQuantity(4);
    	p6.setProduct_id(1);
    	p.add(p6);	
    	
    	Product p7 = new Product();
    	p7.setMaincategory_id(2);
    	p7.setSubcategory_id(3);
    	p7.setName("Kids wear");
    	p7.setPrice(1000);
    	p7.setQuantity(4);
    	p7.setProduct_id(1);
    	p.add(p7);	
    	
    }
    public ArrayList<Product> getProducts(int id)
    {
    	return p;
    }
	public void addtoCart(Product item)
	{
		
		Cart temp = new Cart();
		temp.setCart_products(item);
		cart_items.add(temp);
		//System.out.println(item.getName());
		System.out.println("Selected product added to cart successfully");
	}
    public ArrayList<Cart> getCartProducts()
    {
    	return cart_items;
    }
    public void printcartItems()
    {
    	if(cart_items.size()==0)
    		System.out.println("No Items are added to cart");
    	else
    	for(int i=0;i<cart_items.size();i++)
    		{System.out.println("Name="+cart_items.get(i).getCart_products().getName());
     	     System.out.println("Price="+cart_items.get(i).getCart_products().getPrice());
     	     System.out.println("Quantity="+cart_items.get(i).getCart_products().getQuantity());
    		}
    }
    public void getCartItems()
    {
    	//int sum=0;
    	if(cart_items.size()==0)
    		System.out.println("No Items for billing");
    	else
    	for(int i=0;i<cart_items.size();i++)
    	{
    		System.out.println("name="+cart_items.get(i).getCart_products().getName());
    	    System.out.println("Price="+cart_items.get(i).getCart_products().getPrice());
    	   Cart q =cart_items.get(i);
    	   Product p = q.getCart_products();
    	   int k = p.getQuantity()-1;
    	   p.setQuantity(k);
    	}
    	cart_items.clear();
    }
	

}
