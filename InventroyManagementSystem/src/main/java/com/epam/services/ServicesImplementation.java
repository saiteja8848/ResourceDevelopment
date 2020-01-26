package com.epam.services;

import java.util.ArrayList;
import java.util.function.Consumer;
import com.epam.dao.*;
import com.epam.model.*;


public class ServicesImplementation implements ServiceInterface
{
	private Details data = new Details();
	
	public void setAll(){
 		data.setCategorys();
 		data.setsubCategories();
 		data.setProducts();
 	}
	
	
	public void printAllcategories()	{
		    System.out.println("\nCategories\n----------");
			ArrayList<Category> c = data.getCategorys();
			Consumer<ArrayList<Category>> consumer = (k) -> { for(int i=0;i<k.size();i++) System.out.println(k.get(i).getCategoryId() + "." + k.get(i).getCategoryName());};
			consumer.accept(c);			
	}

	
 	public void  printAllsubCategoriesById(int category_option){	
 		 ArrayList<SubCategory> sc =data.findsubCategories();
 		 ArrayList<Category> f = data.getCategorys();
 		 if(category_option<=f.size())
 		 {
 	     System.out.println("\nSubCategories\n-------------");
       sc.stream().filter(subcategory->subcategory.getMaincategory_id()==category_option).
       forEach(subcategory->System.out.println(subcategory.getSubcategory_id()+"."+subcategory.getSubcategory_name()));
 		 }
 		 else
 			 System.out.println("---------WRONG INPUT---------");
 	}
 	
 	public void  printAllProductsById(int category_option,int subcategory_option){
 		   ArrayList<Product> p = data.getProducts(subcategory_option);
 		   if(subcategory_option<=3) {
 			   System.out.println("\nProducts\n--------\npid  product_name   unitprice   quantity\n--   ------------   ---------   --------");
	      p.stream().filter(p1->p1.getSubcategory_id()==subcategory_option&&p1.getMaincategory_id()==category_option).
	      forEach(p1-> System.out.println(p1.getProduct_id() + "\t"  + p1.getName()+"\t    "+ p1.getPrice()+"\t "+p1.getQuantity()));
 		   }
 		   else
 			   System.out.println("----------WRONG INPUT--------------");
 	}
 	
 	
 	
 	  public void addProductToCart(int category_option,int subcategory_option,int product_option,int quantity)   {
 		 ArrayList<Product> product = data.getProducts(subcategory_option);
 		 Product selectedproduct=null; 
 		 for(int i=0;i<product.size();i++)
 		 {  if(product.get(i).getProduct_id()==product_option&&product.get(i).getSubcategory_id()==subcategory_option&&product.get(i).getMaincategory_id()==category_option)
			   selectedproduct=product.get(i);
 		 }  		  
 		 try {
 			 if(selectedproduct.getQuantity()==0)
 				 System.out.println("--------------OUT OF STOCK---------------");
 		 else if(quantity<=selectedproduct.getQuantity()) 
 		   data.addtoCart(selectedproduct,quantity);
 			else
 				System.out.println("stock limit exceeded");
 		 }
 		 catch(Exception e) {System.out.println(e);}		 
 	  } 	  
 	  
 	  
 	  
 	 public void getProductsInCart(){
 		ArrayList<Cart> cartitems_list = data.getCartProducts();
 		if(cartitems_list.size()==0)
    		System.out.println("Your Cart is Empty");
    	else
    	for(int i=0;i<cartitems_list.size();i++){
    		System.out.print("ProductName="+cartitems_list.get(i).getCart_products().getName()+"  UnitPrice="+cartitems_list.get(i).getCart_products().getPrice());
     	     System.out.print("  Quantity="+cartitems_list.get(i).getCart_products().getQuantity()+"\n");
    		}
 	}
 	
 	 
 	 
 	 
 	 public void billing(){
 		  ArrayList<Cart> cartitems_list = data.getCartProducts();
          ArrayList<Cart> cartitemlist_update =data.getCartUpdate();
     	int totalamount =0,price,quantity,subtotalamount;
     	if(cartitems_list.size()==0)
     		System.out.println("No Items for billing");
     	else 
     	{ 
     	for(int i=0;i<cartitems_list.size();i++){
     		 price =cartitems_list.get(i).getCart_products().getPrice();
     		 quantity =cartitems_list.get(i).getCart_products().getQuantity();
     		 subtotalamount=price * quantity; 		
     		 totalamount =totalamount + subtotalamount;
     		System.out.println("Productname = "+cartitems_list.get(i).getCart_products().getName() + "  UnitPrice ="+price +"  quantity="+quantity+ "  subtotal amount="+subtotalamount);
     	     int updatedquantity = cartitemlist_update.get(i).getCart_products().getQuantity()-cartitems_list.get(i).getCart_products().getQuantity();
     	     cartitemlist_update.get(i).getCart_products().setQuantity(updatedquantity);
     	}
     	System.out.println("Total amount ="+ totalamount);
     	cartitems_list.clear(); 
     	} 
 	  }	
 	 	
}
