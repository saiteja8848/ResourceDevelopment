package com.epam.InventroyManagementSystem;

import java.util.Scanner;
import com.epam.services.*;
import com.epam.model.*;
import java.util.ArrayList;

public class UserInteraction {
	public static void main(String[] args) {
       
		try {
		Scanner input = new Scanner(System.in);
		int  choice =-1, category_option, subcategory_option, product_option;
		ServicesInterface servicesinterface = new ServicesImplementation();
		
		servicesinterface.setAll();
		while(choice !=4) {
			System.out.println();
		System.out.println("-----------------------");
		System.out.println("Welcome to Epam's store");
		System.out.println("-----------------------");
		System.out.println("Activities");
		System.out.println("----------");
		System.out.println("1.shopping");
		System.out.println("2.cart");
		System.out.println("3.billing");
		System.out.println("4.exit");
		System.out.print("Please enter your choice:");
		choice = input.nextInt();
		System.out.println();
		
		switch (choice) 
		{
		    case 1:
			System.out.println("Categories");
			System.out.println("----------");
			ArrayList<Category> c = servicesinterface.getAllCategories();
			
			for (int i = 0; i < c.size(); i++)
			System.out.println(c.get(i).getCategoryId() + "." + c.get(i).getCategoryName());
			System.out.print("Please enter your choice:");
			
			category_option = input.nextInt();
			System.out.println();
			System.out.println("SubCategories");
			System.out.println("-------------");
			ArrayList<SubCategory> sc = servicesinterface.getsubCategories(category_option);
			for (int i = 0; i < sc.size(); i++) {
				if (sc.get(i).getMaincategory_id() == category_option)
					System.out.println(sc.get(i).getSubcategory_id() + "." + sc.get(i).getSubcategory_name());
			}
			System.out.print("Please enter your choice:");
			subcategory_option = input.nextInt();
			System.out.println();
			System.out.println("Products");
			System.out.println("--------");
			ArrayList<Product> p = servicesinterface.getProducts(subcategory_option);
			for (int i = 0; i < p.size(); i++) 
			{
				if (p.get(i).getSubcategory_id() == subcategory_option&& p.get(i).getMaincategory_id() == category_option)
					System.out.println(p.get(i).getProduct_id() + "." + "name=" + p.get(i).getName() + " price="+ p.get(i).getPrice()+ " Quantity="+p.get(i).getQuantity());
			}
			
			System.out.print("Please enter your choice:");
			product_option = input.nextInt();
			System.out.println();
			    for(int i=0;i<p.size();i++)
				if(p.get(i).getProduct_id()==product_option&&p.get(i).getSubcategory_id()==subcategory_option&&p.get(i).getMaincategory_id()==category_option)
					servicesinterface.addtocart(p.get(i));	
			break;
		    case 2:
			System.out.println();
			System.out.println("Products In Cart");
			System.out.println("----------------");
			servicesinterface.getcartItems();
			break;
	    	case 3:
			System.out.println("Billing");
			servicesinterface.billing();
			break;
		    case 4:
			System.out.println("Thanks for visting the store");
			System.exit(0);
			break;
		    default:
			System.out.println("Invalid Choice");
		 }
		
		}
		
		input.close();
		System.out.println();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		
		
		
		
	}
}
