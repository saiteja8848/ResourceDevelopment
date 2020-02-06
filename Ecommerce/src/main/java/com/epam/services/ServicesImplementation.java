package com.epam.services;


import java.util.function.Consumer;
import com.epam.dao.*;
import com.epam.model.*;
import java.util.List;


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
			List<Category> listofCategory = data.getCategorys();
			Consumer<List<Category>> consumer = category -> { for(int index=0;index<category.size();index++) System.out.println(category.get(index).getCategoryId() + "." + category.get(index).getCategoryName());};
			consumer.accept(listofCategory);			
	}

	
 	public void  printAllsubCategoriesById(int categoryOption){	
 		 List<SubCategory> listofSubcategorys =data.findsubCategories();
 		 List<Category> listofCategorys = data.getCategorys();
 		 
 		 if(categoryOption<=listofCategorys.size())
 		 {
 	      System.out.println("\nSubCategories\n-------------");
          listofSubcategorys.stream().filter(subcategory->subcategory.getmaincategoryId()==categoryOption).
          forEach(subcategory->System.out.println(subcategory.getsubcategoryId()+"."+subcategory.getsubcategoryName()));
 		 }
 		 else
 			 System.out.println("---------WRONG INPUT---------");
 	}
 	
 	public void  printAllProductsById(int categoryOption,int subcategoryOption){
 		    List<Product> listofProducts = data.getProducts();
 		    
 		   if(subcategoryOption<=3) {
 			   System.out.println("\nProducts\n--------\npid  product_name   unitprice   quantity\n--   ------------   ---------   --------");
	           listofProducts.stream().filter(product->product.getsubcategoryId()==subcategoryOption&&product.getmaincategoryId()==categoryOption).
	           forEach(product-> System.out.println(product.getproductId() + "\t"  + product.getName()+"\t    "+ product.getPrice()+"\t "+product.getQuantity()));
 		   }
 		   else
 			   System.out.println("----------WRONG INPUT--------------");
 	}
 	
 	
 	
 	  public void addProductToCart(int categoryOption,int subcategoryOption,int productOption,int quantity) {
 		 List<Product> product = data.getProducts();
 		 try {
 		     Product selectedproduct=null; 
 		     for(int index=0;index<product.size();index++)
 		    { 
 		      if(product.get(index).getproductId()==productOption&&product.get(index).getsubcategoryId()==subcategoryOption&&product.get(index).getmaincategoryId()==categoryOption)
			   {selectedproduct=product.get(index);}
 		    }  	
 		    if(selectedproduct==null)
 		         {System.out.println("Nothing");}
 		    else if(selectedproduct.getQuantity()==0)
 				 {System.out.println("--------------OUT OF STOCK---------------");}
 		    else if(quantity<=selectedproduct.getQuantity()) 
 		          addtoCart(selectedproduct,quantity);
 			else
 				System.out.println("stock limit exceeded");
 		 }
 		 catch(Exception exception) {
 		     System.out.println(exception);
 		 }		 
 	  } 	  
 	  
 	  
 	  
 	 public void getProductsInCart(){
 		List<Cart> cartitemsList = data.getCartProducts();
 		if(cartitemsList.isEmpty())
    		System.out.println("Your Cart is Empty");
    	else {
    	     for(int index=0;index<cartitemsList .size();index++){
    		 System.out.print("ProductName="+cartitemsList .get(index).getcartProducts().getName()+"  UnitPrice="+cartitemsList .get(index).getcartProducts().getPrice());
     	     System.out.print("  Quantity="+cartitemsList .get(index).getcartProducts().getQuantity()+"\n");
    		 }
    	   }
    	   
 	  }
 	
 	 
 	 
 	 
 	 public void billing(){
 		  List<Cart> cartitemsList = data.getCartProducts();
          List<Cart> cartitemlistUpdate =data.getCartUpdate();
     	if(cartitemsList.isEmpty())
     		System.out.println("No Items for billing");
     	else 
     	{ 
     		 int totalamount=0;
        	 for(int index=0;index<cartitemsList .size();index++){
     		 int  price =cartitemsList .get(index).getcartProducts().getPrice();
     		 int quantity =cartitemsList .get(index).getcartProducts().getQuantity();
     		 int  subtotalamount=price * quantity; 		
     		 totalamount =totalamount + subtotalamount;
     		 System.out.println("Productname = "+cartitemsList .get(index).getcartProducts().getName() + "  UnitPrice ="+price +"  quantity="+quantity+ "  subtotal amount="+subtotalamount);
     	     int updatedquantity = cartitemlistUpdate.get(index).getcartProducts().getQuantity()-cartitemsList .get(index).getcartProducts().getQuantity();
     	     cartitemlistUpdate.get(index).getcartProducts().setQuantity(updatedquantity);
     	}
     	System.out.println("Total amount ="+ totalamount);
     	cartitemsList .clear(); 
     	} 
     	
 	  }	
 	 	
 	 
 	void add(Product product, int quantity)  {
		Cart temporary_cart = new Cart();
		Product addingproductToCart = new Product(product);
		
		temporary_cart.setoriginalQuantity(product.getQuantity());
		addingproductToCart.setQuantity(quantity);
		
		temporary_cart.setcartProducts(addingproductToCart);
		data.getCartProducts().add(temporary_cart);
		
	
		Cart update = new Cart();
		update.setcartProducts(product);
		
		data.getCartUpdate().add(update);
		System.out.println("\nSelected product added to cart successfully");
	}

	public void addtoCart(Product product, int quantity) {
		int flag = 1;
		if (data.getCartProducts().isEmpty())
			add(product, quantity);
		else {
			for (int index = 0; index < data.getCartProducts().size(); index++) {
				if (data.getCartProducts().get(index).getcartProducts().getName().equals (product.getName()))
				 {
					int value = data.getCartProducts().get(index).getcartProducts().getQuantity();
					value = value + quantity;
					if (value < data.getCartProducts().get(index).getoriginalQuantity())
						data.getCartProducts().get(index).getcartProducts().setQuantity(value);
					else
						System.out.println("Out of stock");
					break;
				}
				else
					{flag = 0;}
			}
			if (flag == 0)
				add(product, quantity);
		}
	}
 	 
 	 
 	 
 	 
 	 
 	 
 	 
 	 
 	 
 	 
 	 
 	 
 	 
 	 
 	 
 	 
 	 
 	 
 	 
 	 
 	 
 	 
 	 
 	 
}
