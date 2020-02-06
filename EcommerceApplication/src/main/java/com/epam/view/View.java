package com.epam.view;

import com.epam.Services.*;
import java.util.Scanner;

public class View {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Serviceprovider serviceprovider = new Serviceprovider();
		System.out.println("-----------------------");
		System.out.println("Welcome to Epam's Store");
		System.out.println("-----------------------");
		System.out.println("Activites");
		System.out.println("---------");
		System.out.println("1.Categories\n2.Cart\n3.Billing\n4.Exit");
		System.out.print("Please enter your Choice:");
		int choice = input.nextInt();
		switch (choice) {
		case 1:
			System.out.println("\nCategories");
			System.out.println("----------");
			serviceprovider.loadData();
			System.out.print("please enter your choice:");
			int categoryOption = input.nextInt();
			System.out.println("\nSubCategories");
			System.out.println("-------------");
			serviceprovider.printSubCategorysById(categoryOption);
			System.out.print("please enter your choice:");
			int subcategoryOption = input.nextInt();
			System.out.println("\nProducts");
			System.out.println("--------");
			serviceprovider.printProductsById(categoryOption, subcategoryOption);
			System.out.print("please enter your choice:");
			break;
		case 2:
			System.out.println("Cart");
			break;
		case 3:
			System.out.println("Billing");
			break;
		case 4:
			System.out.println("Thank you for visting the Store");
			System.exit(0);
		}
		input.close();
	}
}
