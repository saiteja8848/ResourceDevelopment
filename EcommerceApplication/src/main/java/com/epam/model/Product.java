package com.epam.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epam.services.*;


public class Product implements Ecommerce {
	
	private static Logger logger = LogManager.getLogger(Product.class);
	int productId;
	String productName;
	int quantity;
	int unitPrice;
	
	public Product() {}
	public Product(Product p){
		productId = p.getProductId();
		productName = p.getProductName();
		quantity = p.getQuantity();
		unitPrice = p.getUnitPrice();
	}

	public int getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}



	public Product(int productId, String productName, int quantity, int unitPrice) {
		this.productId = productId;
		this.productName = productName;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public void showDetails() {
	logger.info("{}{}   {}\t {}\t\t{}","\n",productId,productName,unitPrice,quantity);
	}
}
