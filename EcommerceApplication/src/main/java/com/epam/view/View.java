package com.epam.view;

import com.epam.Services.*;
import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class View {
	private static Scanner input = new Scanner(System.in);
	private static Logger logger = LogManager.getLogger(View.class);

	static int readInput() {
		int enteredchoice;
		System.out.print("please enter your choice (press -1 to return to main menu):");
		enteredchoice = input.nextInt();
		if (enteredchoice == -1)
			View.main(null);
		return enteredchoice;
	}

	public static void main(String[] args) {
		logger.info("info");
        logger.debug("debug");
        logger.fatal("fatal");
        logger.warn("warn");
		
		int choice = -1;
		String[] useroptions = { "Categories", "Cart", "Billing", "Exit" };
		int categoryOption;
		int subcategoryOption;
		int productOption;
		int quantity;
		Serviceprovider serviceprovider = new Serviceprovider();

		try {
Scanner input = new Scanner(System.in);
			while(choice!=4) 
			{
				System.out.println("\n-----------------------\nWelcome to Epam's Store\n-----------------------");
				System.out.print("Activites\n---------\n1.Categories\n2.Cart\n3.Billing\n4.Exit\nPlease enter your Choice:");
				choice = input.nextInt();
				switch (useroptions[choice - 1]) {
				case "Categories":
					System.out.println("\nCategories\n----------");
					serviceprovider.showCategories();
					categoryOption = readInput();
					System.out.println("\nSubcategories\n-------------");
					serviceprovider.showSubCategorysById(categoryOption - 1);
					subcategoryOption = readInput();
					System.out.println("\nProducts\n---------");
					serviceprovider.showProductsById(categoryOption - 1, subcategoryOption - 1);
					productOption = readInput();
					if (productOption > 2)
						System.out.println("Invalid Input");
					else {
						System.out.print("Please enter quantity:");
						quantity = input.nextInt();
						serviceprovider.addproductToCart(categoryOption - 1, subcategoryOption - 1, productOption - 1,quantity);
					}
					break;
				case "Cart":
					System.out.println("\nProductsInCart\n---------------");
					serviceprovider.showcartProducts();
					break;
				case "Billing":
					System.out.println("\nBilling\n--------");
					serviceprovider.billing();
					break;
				case "Exit":
					System.out.println("\nThank you for visting the Store");
					System.exit(0);
				}
			} 
			input.close();
			
		}
		catch(Exception e)
		{
			System.out.println("\nINPUT MISMATCH");
			View.main(null);
		}
			
			
			
			
		}		
	}

