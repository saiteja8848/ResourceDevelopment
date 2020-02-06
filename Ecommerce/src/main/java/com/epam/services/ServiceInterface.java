package com.epam.services;


public interface  ServiceInterface {
	
	public void  printAllcategories();
	public void  printAllsubCategoriesById(int categoryOption);
	public void printAllProductsById(int categoryOption,int subcategoryOption);
    public void addProductToCart(int categoryOption,int subcategoryOption,int productOption,int quantity);
    public void getProductsInCart();
    public void setAll();
    public void billing();
}
