package com.epam.InventroyManagementSystem;

import java.util.Scanner;
import com.epam.services.ServiceInterface;
import com.epam.services.ServicesImplementation;

public class UserInteraction {
    
	  public static int enteredvalue,choice =-1, category_option, subcategory_option, product_option,quantity;
	  public static Scanner input = new Scanner(System.in);
	  static int readInput()
	  {
		  System.out.print("Please enter your choice(enter -1 to return main menu):");
	      enteredvalue = input.nextInt();
	      if(enteredvalue==-1)
	    	UserInteraction.main(null);
	    	  return enteredvalue;
	  }
	public static void main(String[] args) {
		try {
		Scanner input = new Scanner(System.in);
		ServiceInterface serviceInterface = new ServicesImplementation();
		serviceInterface.setAll();
		while(choice !=4) 
		{
		System.out.println("\n-----------------------\nWelcome to Epam's store\n-----------------------");
		System.out.print("Activities\n----------\n1.shopping\n2.cart\n3.billing\n4.exit\nPlease enter your choice:");
		choice = input.nextInt();
		switch (choice) 
		{
		    case 1:
			      serviceInterface.printAllcategories();
			      category_option = readInput();
			      serviceInterface.printAllsubCategoriesById(category_option);
			      subcategory_option = readInput();
		          serviceInterface.printAllProductsById(category_option,subcategory_option);
	              product_option = readInput();
	              if(product_option>=4)
	               System.out.println("Wrong Input");
	              else
	              {System.out.print("Enter no of quantities:");
		          quantity = input.nextInt();
		          serviceInterface.addProductToCart(category_option,subcategory_option,product_option,quantity);}
			break;		
		    case 2:
		     	 System.out.println("\nProducts In Cart\n----------------");
			     serviceInterface.getProductsInCart();
			break;
	    	case 3:
			     System.out.println("\nBilling\n-------");
			     serviceInterface.billing();
			break;
		    case 4:
			     System.out.println("\nThank you for visting the store");
			     System.exit(0);
			break;
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
