RD-Jan-2020-Java-Project(E-commerce application)

As part of Java learning we are going to build an E-commerce application.
In initial stages this application is going to be a console based application, later after each advanced topic being discussed we would be including them in this project. 

Components:

Below is the list of components which are discussed in the class.

1. Categories      
As discussed this application should contain only two categories (Electronics and Fashion) for easier implementation. Each category can contain more than one subcategory.
sub-Categories:
Electronics <br>
&nbsp;&nbsp;&nbsp;|—Mobiles ----- products(iPhone,Samsung,realme, etc)<br>
&nbsp;&nbsp;&nbsp;|—Computers/Laptops<br>
&nbsp;&nbsp;&nbsp;|—Home Appliances<br>
Fashion<br>
&nbsp;&nbsp;&nbsp;|—Men <br>
&nbsp;&nbsp;&nbsp;|—Women <br>
Categories need to be dynamically displayed i.e., Whenever a new Category added in the back-end( either in Database or in collection) it should reflect in the front end.
Ex: Our application has two categories (Electronics and Fashion) and I want to introduce new category (say Food ), I will be inserting it in either Database or in collection(list of categories) and this new category(Food ) has to get reflected in the front end (console or UI) without any code changes.

2. Products           
In each sub-category each product should contain price, quantity and "ADD-TO-CART" values along with the product details. Here the product details(price and other values) should be generated from Database or collection.

3. CART   
After selecting the "ADD-TO-CART" of product, that product should be added to CART and it should support multiple products to be added to cart.
CART should display the following details:
•	product 
•	Quantity
•	Price
•	Grand Total
•	CHECK-OUT
After selecting/clicking CHECK-OUT option/button, a message "Inventory Database/collection has Updated" need to be displayed on the console.
