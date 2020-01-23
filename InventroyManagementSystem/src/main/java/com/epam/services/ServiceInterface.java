package com.epam.services;


public interface  ServiceInterface {
	
	public void  printAllcategories();
	public void  printAllsubCategoriesById(int category_option);
	public void printAllProductsById(int category_option,int subcategory_option);
    public void addProductToCart(int category_option,int subcategory_option,int product_option,int quantity);
    public void getProductsInCart();
    public void setAll();
    public void billing();
}
