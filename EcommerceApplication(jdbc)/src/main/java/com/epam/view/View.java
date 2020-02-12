package com.epam.view;

import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.epam.services.*;

public class View {
	private static Scanner input = new Scanner(System.in);
	private static Logger logger = LogManager.getLogger(View.class);

	static int readInput() {
		int enteredchoice;
		logger.info("{}please enter your choice (press -1 to return to main menu):", "\n");
		enteredchoice = input.nextInt();
		if (enteredchoice == -1)
			View.main(null);
		return enteredchoice;
	}

	public static void main(String[] args) {

		int choice = -1;
		int categoryOption;
		int subcategoryOption;
		int productOption;
		int quantity;
		String[] useroptions = { "Categories", "Cart", "Billing", "Exit" };
		Service serviceprovider = new Serviceprovider();
		try {
			Scanner input = new Scanner(System.in);
			while (choice != 4) {

				logger.info("{}-----------------------{}Welcome to Epam's Store{}-----------------------", "\n", "\n",
						"\n");
				logger.info(
						"{}Activites{}---------{}1.Categories{}2.Cart{}3.Billing{}4.Exit{}Please enter your Choice:",
						"\n", "\n", "\n", "\n", "\n", "\n", "\n");
				choice = input.nextInt();
				switch (useroptions[choice - 1]) {
				case "Categories":
					logger.info("{}Categories{}----------", "\n", "\n");
					serviceprovider.showCategories();
					categoryOption = readInput();
					logger.info("{}Subcategories{}-------------", "\n", "\n");
					serviceprovider.showSubCategorysById(categoryOption - 1);
					subcategoryOption = readInput();
					logger.info("{}Products{}---------", "\n", "\n");
					serviceprovider.showProductsById(categoryOption - 1, subcategoryOption - 1);
					productOption = readInput();
					if (productOption > 2)
						logger.info("{}Invalid Input", "\n");
					else {
						logger.info("Please enter quantity:");
						quantity = input.nextInt();
						serviceprovider.addproductToCart(categoryOption - 1, subcategoryOption - 1, productOption - 1,
								quantity);
					}
					break;
				case "Cart":
					logger.info("{}{}Products In Cart{}---------------", "\n", "\n", "\n");
					serviceprovider.showcartProducts();
					break;
				case "Billing":
					logger.info("{}Billing{}--------", "\n", "\n");
					serviceprovider.billing();
					break;
				case "Exit":
					logger.info("{}Thank you for visting the Store{}", "\n", "\n");
					System.exit(0);
					break;
				default:
					logger.info("Invalid Option");
				}

			}
			input.close();

		} catch (Exception e) {
			logger.info("{}INPUT MISMATCH{}", "\n", "\n");
			View.main(null);
		}
	}
}
