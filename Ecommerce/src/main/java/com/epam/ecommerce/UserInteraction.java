package com.epam.ecommerce;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epam.services.ServiceInterface;
import com.epam.services.ServicesImplementation;
import org.apache.logging.log4j.Logger;

public class UserInteraction {
    
	private static Logger logger =LogManager.getLogger(UserInteraction.class) ;
	
	  private static Scanner input = new Scanner(System.in);
	  static int readInput()
	  {
		  System.out.print("Please enter your choice(enter -1 to return main menu):");
	      int enteredvalue = input.nextInt();
	      if(enteredvalue==-1)
	    	{UserInteraction.main(null);}
	    	  return enteredvalue;
	  }
	public static void main(String[] args) {
		int choice=-1;
		int categoryOption;
		int subcategoryOption;
		int productOption;
		int quantity;
		logger.info("info");
		logger.error("error");
		
		
		try {
		Scanner input = new Scanner(System.in);
		String cases[] = {"NOTHING","CATEGORIES","CART","BILLING","EXIT"};
		ServiceInterface serviceInterface = new ServicesImplementation();
		serviceInterface.setAll();
		while(choice !=4) 
		{
		System.out.println("\n-----------------------\nWelcome to Epam's store\n-----------------------");
		System.out.print("Activities\n----------\n1.shopping\n2.cart\n3.billing\n4.exit\nPlease enter your choice:");
		choice = input.nextInt();
		
		switch (cases[choice]) 
		{
		    case "CATEGORIES":
			      serviceInterface.printAllcategories();
			      categoryOption = readInput();
			      serviceInterface.printAllsubCategoriesById(categoryOption);
			      subcategoryOption = readInput();
		          serviceInterface.printAllProductsById(categoryOption,subcategoryOption);
	              productOption = readInput();
	              if(productOption>=4)
	               System.out.println("Wrong Input");
	              else
	              {System.out.print("Enter no of quantities:");
		          quantity = input.nextInt();
		          serviceInterface.addProductToCart(categoryOption,subcategoryOption,productOption,quantity);}
			break;		
		    case "CART":
		     	 System.out.println("\nProducts In Cart\n----------------");
			     serviceInterface.getProductsInCart();
			break;
	    	case "BILLING":
			     System.out.println("\nBilling\n-------");
			     serviceInterface.billing();
			break;
		    case "EXIT":
			     System.out.println("\nThank you for visting the store");
			     return;
		    default:
			     System.out.println("\n------------INVALID OPTION--------------");
			     UserInteraction.main(null);
		 }
		}
		input.close();
		System.out.println();
		}
		catch(Exception e)
		{		
			System.out.println("\n--------------INPUT MISMATCH--------------");
			UserInteraction.main(null);
		}
		
		
	}
}
