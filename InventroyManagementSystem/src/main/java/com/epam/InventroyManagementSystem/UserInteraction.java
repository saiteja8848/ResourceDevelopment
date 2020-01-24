package com.epam.InventroyManagementSystem;

import java.util.Scanner;
import com.epam.services.ServiceInterface;
import com.epam.services.ServicesImplementation;

public class UserInteraction {
	public static void main(String[] args) {
		try {
		Scanner input = new Scanner(System.in);
		int  choice =-1, category_option, subcategory_option, product_option,quantity;
		ServiceInterface serviceInterface = new ServicesImplementation();
		serviceInterface.setAll();
		while(choice !=4) 
		{
		System.out.println("\n-----------------------\nWelcome to Epam's store\n-----------------------");
		System.out.println("Activities\n----------\n1.shopping\n2.cart\n3.billing\n4.exit");
		System.out.print("Please enter your choice:");
		choice = input.nextInt();
		switch (choice) 
		{
		    case 1:
			      System.out.println("\nCategories\n----------");
			      serviceInterface.printAllcategories();
			      System.out.print("Please enter your choice(enter -1 to return main menu):");
			      category_option = input.nextInt();
			      if(category_option==-1)
			    	UserInteraction.main(null);
			       System.out.println();  
			      serviceInterface.printAllsubCategoriesById(category_option);
			      System.out.print("Please enter your choice(enter -1 to return main menu):");
			      subcategory_option = input.nextInt();
			      if(subcategory_option==-1)
				  UserInteraction.main(null);
			      System.out.println();
		          serviceInterface.printAllProductsById(category_option,subcategory_option);
		          System.out.print("Please enter your choice(enter -1 to return main menu):");
	              product_option = input.nextInt();
	              if(product_option==-1)
				   UserInteraction.main(null);
	              else if(product_option>=4)
	              { System.out.println("Wrong Input");}
	              else
		          System.out.print("Enter no of quantities:");
		          quantity = input.nextInt();
		          serviceInterface.addProductToCart(category_option,subcategory_option,product_option,quantity);
			break;		
		    case 2:
		     	 System.out.println("\nProducts In Cart\n----------------");
			     serviceInterface.getProductsInCart();
			break;
	    	case 3:
			     System.out.println("Billing\n-------");
			     serviceInterface.billing();
			break;
		    case 4:
			     System.out.println("Thanks for visting the store");
			     System.exit(0);
			break;
		    default:
			     System.out.println("------------Invalid Choice--------------");
			     UserInteraction.main(null);
			     //System.exit(0);
		 }
		}
		input.close();
		System.out.println();
		}
		catch(Exception e)
		{
			System.out.println("--------------MISMATCH--------------");
			UserInteraction.main(null);
		}
				
	}
}
