package com.epam.Services;

import com.epam.dao.*;
import com.epam.view.*;
import java.util.ArrayList;
import java.util.List;
import com.epam.model.*;

public class Serviceprovider {
	int flag = -1;
	private Data data = new Data();
	private List<Cart> cartProducts = new ArrayList<Cart>();

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
		data.printProductsData(categoryOption, subcategoryOption);
	}

	public void addproductToCart(int categoryOption, int subcategoryOption, int productOption, int quantity) {
		Category category = data.get(categoryOption);
		Product product = category.getSubcategorys().get(subcategoryOption).getProducts().get(productOption);
		int length = product.getQuantity();
		if (quantity > length)
			System.out.println("please Enter valid Stock Number");
		else {
			// check for existence of the product in the cartlist, if not exists just add to
			// cart list
			// if exists,take the index in the list then just update the quantity
			// Only,quantity should be in limit and valid.
			if (checkforExistence(product)) // true
			{
				int q = cartProducts.get(flag).getQuantity();
				int k=q+quantity;
				if(k<cartProducts.get(flag).getProduct().getQuantity())
				cartProducts.get(flag).setQuantity(k);
				else
					System.out.println("\nStock limit exceeded");
			} else // false
			{
				Product p = new Product(product);
				Cart c = new Cart(categoryOption, subcategoryOption);
				c.setQuantity(quantity);
				c.setOriginalProduct(product);
				c.setProduct(p);
				cartProducts.add(c);
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
		if (cartProducts.size() == 0)
			System.out.println("No products added to cart");
		else
			for (Cart cp : cartProducts)
				System.out.println(cp.getProduct().getProductName() + " " + cp.getQuantity());
	}
	
	public void billing()
	{
		if(cartProducts.size()==0)
			System.out.println("no products in the cart for billing");
		else{
			for (Cart cp : cartProducts)
			{System.out.println(cp.getProduct().getProductName() + " " + cp.getQuantity()+" "+cp.getProduct().getUnitPrice());
			 int p=cp.getOriginalProduct().getQuantity() - cp.getQuantity();
			 cp.getOriginalProduct().setQuantity(p);
			}
			cartProducts.clear();
		}
			
	}
	

}
