package com.epam.services;

import com.epam.dao.Data;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.epam.model.*;



public class Serviceprovider implements Service{
	private static Logger logger = LogManager.getLogger(Serviceprovider.class);
	int flag = -1;
	private Data data = new Data();
	private List<Cart> cartProducts = new ArrayList<>();

	public Serviceprovider() {
		data.setData();
	}

	public void showCategories() {
		data.printCategorysData();
	}

	public void showSubCategorysById(int categoryOption) {
		data.printSubCategorysData(categoryOption);
	}

	public void showProductsById(int categoryOption, int subcategoryOption) {
		logger.info("{}id  productname  unitPrice Quantity {}","\n","\n");
		logger.info("--  -----------   ---------- ------ ");
		data.printProductsData(categoryOption, subcategoryOption);
	}

	public void addproductToCart(int categoryOption, int subcategoryOption, int productOption, int quantity) {
		Category category = data.get(categoryOption);
		Product product = category.getSubcategorys().get(subcategoryOption).getProducts().get(productOption);
		int length = product.getQuantity();
		if (quantity > length)
			logger.info("{}please Enter valid Stock Number","\n");
		else {
			
			if (checkforExistence(product)) 
			{
				int existingQuantity = cartProducts.get(flag).getQuantity();
				int addedQuantity = existingQuantity + quantity;
				if (addedQuantity < cartProducts.get(flag).getProduct().getQuantity())
					cartProducts.get(flag).setQuantity(addedQuantity);
				else
					logger.info("{}Stock limit exceeded{}","\n","\n");
			} else 
			{
				Product p = new Product(product);
				Cart cart = new Cart(categoryOption, subcategoryOption);
				cart.setQuantity(quantity);
				cart.setOriginalProduct(product);
				cart.setProduct(p);
				cartProducts.add(cart);
				logger.info("{} Product added to cart successfully","\n");
			}

		}

	}

	boolean checkforExistence(Product product) {
		boolean existing = false;
		for (int index = 0; index < cartProducts.size(); index++) {
			if (cartProducts.get(index).getProduct().getProductName().equals(product.getProductName())) {
				existing = true;
				flag = index;
				break;
			}
		}
		return existing;
	}

	public void showcartProducts() {
		if (cartProducts.isEmpty())
			logger.info("{}No products added to cart{}","\n","\n");
		else {
			logger.info("{}productname unitPrice Quantity {}","\n","\n");
		    logger.info("----------  ---------  -------");
			for (Cart cartproduct : cartProducts)
				logger.info("{}{}   {}   {}{}","\n",cartproduct.getProduct().getProductName(),cartproduct.getProduct().getUnitPrice(),cartproduct.getQuantity(),"\n");
	     }
	}

	
	public void billing() {
		if (cartProducts.isEmpty())
			logger.info("{}no products in the cart for billing{}","\n","\n");
		else {
			for (Cart cartproduct : cartProducts) {
				int quantity =cartproduct.getQuantity() ;
				int unitPrice = cartproduct.getProduct().getUnitPrice();
				int grandTotal = quantity * unitPrice;
				logger.info("{}productname unitPrice Quantity GrandTotal{}","\n","\n");
			    logger.info("----------  ---------  ------- ---------");
				logger.info("{}{}\t{}\t{}\t{} {}","\n",cartproduct.getProduct().getProductName(),quantity,unitPrice,grandTotal,"\n");
				int updatedQuantity = cartproduct.getOriginalProduct().getQuantity() - cartproduct.getQuantity();
				cartproduct.getOriginalProduct().setQuantity(updatedQuantity);
			}
			cartProducts.clear();
		}

	}
	

}
