package com.epam.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epam.model.*;
import com.epam.services.*;

class Composite implements Ecommerce {
	private List<Ecommerce> ecommerceData = new ArrayList<>();

	public void showDetails() {
		for (Ecommerce ecommerceList : ecommerceData)
			ecommerceList.showDetails();
	}

	public void addDetails(Ecommerce anyImplementationclass) {
		ecommerceData.add(anyImplementationclass);
	}

	public Category getDetails(int categoryOption) {
		return (Category) ecommerceData.get(categoryOption);
	}

}

public class Data {
	private Composite composite = new Composite();
	JavaDatabaseConnection databaseConnection = new JavaDatabaseConnection();

	public void setData() {
		List<Category> c = databaseConnection.getData();
		composite.addDetails(c.get(0));
		composite.addDetails(c.get(1));
	}

	public void printCategorysData() {
		composite.showDetails();
	}

	public void printSubCategorysData(int categoryOption) {
		Category category = composite.getDetails(categoryOption);
		List<Subcategory> subcategoryList = category.getSubcategorys();
		for (Subcategory subcategory : subcategoryList)
			subcategory.showDetails();
	}

	public void printProductsData(int categoryOption, int subcategoryOption) {
		Category category = composite.getDetails(categoryOption);
		List<Product> productList = category.getSubcategorys().get(subcategoryOption).getProducts();
		for (Product product : productList)
			product.showDetails();
	}

	public Category get(int categoryOption) {
		return composite.getDetails(categoryOption);
	}

}

class JavaDatabaseConnection {
	private List<Category> categorys = new ArrayList<>();
    private static Logger logger = LogManager.getLogger(JavaDatabaseConnection.class);
	
	public void connection() 
	{
		try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce", "root",String.valueOf("Epam1234$"));Statement statementforCategorys = connection.createStatement();Statement statementforSubcategorys = connection.createStatement();
				Statement statementforProducts = connection.createStatement();) 
		{
				
				try(ResultSet resultSet = statementforCategorys.executeQuery("select categoryId,categoryName from categorys");){
				while (resultSet.next()) {
					Category category = new Category();
					List<Subcategory> subcategorys = new ArrayList<>();
					category.setCategoryId(resultSet.getInt("categoryId"));
					category.setCategoryName(resultSet.getString("categoryName"));
					
					try(ResultSet subcategorysResult = statementforSubcategorys.executeQuery("select * from subCategorys where categoryId="+ resultSet.getInt("categoryId") + " order by subcategoryId");){
					while (subcategorysResult.next()) {
						Subcategory subcategory = new Subcategory();
						List<Product> productsList = new ArrayList<>();
						subcategory.setSubcategoryId(subcategorysResult.getInt("subcategoryId"));
						subcategory.setSubcategoryName(subcategorysResult.getString("subcategoryName"));
						try(ResultSet productsResult = statementforProducts.executeQuery("select * from products where subcategoryName= '"+ subcategorysResult.getString("subcategoryName") + "'  order by productId;");){
						while (productsResult.next()) {
							Product product = new Product();
							product.setProductId(productsResult.getInt("productId"));
							product.setProductName(productsResult.getString("productName"));
							product.setQuantity(productsResult.getInt("Quantity"));
							product.setUnitPrice(productsResult.getInt("price"));
							productsList.add(product);
						}}
						subcategory.setProducts(productsList);
						subcategorys.add(subcategory);
					}}
					
					
					category.setSubcategorys(subcategorys);
					categorys.add(category);
			    	}
				}
			
		}catch(Exception e) {logger.info("");}
		
		

	}

	public List<Category> getData() {
		
		connection();
		
		return categorys;
	}
}
