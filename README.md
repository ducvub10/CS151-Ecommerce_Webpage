# CS151-Ecommerce_Webpage_Proposal
**Team #** 9.\
**Team members:** Frank Lo, Kiet Quan, Le Nguyen, Naiwei Guan.\
**Team member working on the proposal:**
- Kiet: Assumptions, Problem/Issues Resolve.
- Le: Operation.
- Frank: High-level Description. 
- Naiwei: Functionality.

**Team member working on the project presentation:**
- Kiet: Class Diagram and User's Controllers, Model, and View.
- Le: Sign in and Sign Up, Admin, Sequence Diagram.
- Frank: Use Case diagram, Seller.
- Naiwei: State Diagram.

**Team member working on the project:**
- Kiet: Made the Users's MVC. Worked on Store, User, Product classes. Worked on storing customer, seller information, maintaining a singleton session. 
- Le: Worked on the Admin class. Made the Admin UIs and the controller for Admin. Also, worked to handle the Sign up and Sign in feature.
- Frank: Worked on Store class. Made the Seller UIs. Made controllers for the Seller side of the code.
- Naiwei:

## Problem/Issues to resolve
Our application aims to refine the e-commerce pipeline by providing useful tools for managing product prices, availability, and user transactions. Our program will provide a flexible interface for the admin to manage the sellers’ and customers’ transactions and information, the seller to manage the product information and offer discounts, and the user to purchase through access to a cart. Furthermore, proper authentication is in place to ensure confidentiality and security of the customer’s data. In all, our program strives to deliver effective and seamless operations for customers, sellers, and admin in an online environment.

## Previous works
Vzenun’s E-Commerce_Application-JAVA-.\
Adithkrishnan98’s ECommerce-Java.
## Assumptions
The end user must be an e-commerce business seeking to ensure maximum customer satisfaction and ease of operation for the faculty/staff.  The admin, which requires special authentication, manages user’s accounts. The seller manages the product pricing and inventory. The user can view and purchase products.
## Operating environments
Our program will be built primarily using Java, using JavaFX to design the interface, CSS for stylization. The program will use Java-based controllers and backend.
## Intended usage:
The program will be used to benefit an e-commerce business by providing useful tools to manage customers and transactions, manage product information, offer product discounts for customers and staff, and provide an interface for viewing/buying products. The program provides an authentication process for all users (including admin, customer, seller).
 
## Diagrams:
- [Class Diagram](https://github.com/ducvub10/CS151-Ecommerce_Webpage/blob/main/diagrams/ClassDiagram.drawio.png).
- [State Diagram](https://github.com/ducvub10/CS151-Ecommerce_Webpage/blob/main/diagrams/StateDiagram.drawio.png).
- [Sequence Diagram](https://github.com/ducvub10/CS151-Ecommerce_Webpage/blob/main/diagrams/SequenceDiagram.drawio.png)
- [Use Case Diagram](https://github.com/ducvub10/CS151-Ecommerce_Webpage/blob/main/diagrams/UseCaseDiagram.drawio.png)

## Functionality
- User login and authentication: Verify the user's identity and allow them to log into their account.
- Product search and browsing: Enables customers to search and browse products for sale and add them to the shopping cart.
- Payment processing: Once the customer completes the payment choice, the products are listed as purchased.
- Order viewing and return system: Customers can choose to return purchased items and receive a refund.
- Review and rating system: Customers can rate the products they have purchased.
- Product list page that sellers can view, edit, or delete their products: to adjust inventory.
- Option to provide special discounts: offer discounts to customers.

## Operations
The e-commerce has 3 main users: admin, seller, and customer.
- Admin:
  + Manage the user's accounts (sellers and customers).
- Seller:
  + Add/ remove the products they want to sell (id, name, price).
  + Manage the inventory.
  + Handle returns and refunds.
  + Customer Support.
  + Give customer a special discount.
- Customer:
  + Search the product.
  + Select or remove the product they want to buy.
  + Payment.
  + Returns and refunds.
  + Reviews.

## High-level description
Plan of approach in the program is to tackle each part of the e-commerce one at a time. We plan to tackle the seller’s section first as they will be the ones putting their product up and be the ones having the product that is being sold. On the side of the sellers we will be making it as easy as possible for them to put a product up, label, and price them in a simple way. From there they will be able to add any discounts or anything that they want to do with the product. Then we will approach the customer side and see how we can make it as easy as possible for them to find what they are looking for. Having things like discounted items show and a filter system that makes it easy to search. Then we will go to the admin side last because it is the place where all the data is being held. On the admin side we plan on having it be able to pull data out and be able to send data back as well when it is asked. The admin side will hold the customer information and the seller information. The admin side will be the side with a lot of data as that will be the place where everything goes in and out through. If anyone wants to edit, delete, or add information that they have this is where that can be granted access to do that from. 

## Solution:  
- We implemented separate classes for users, products, and stores. The user class is an abstract that three types of users: admin, customer, and seller extend to. The store class is a stand-alone class that manages the product catalog. We used the singleton approach to make sure there is only one instance of store class at any time. The product class has fields representing all essential information of a product including name, id, price, quantity, etc. For storage,  we use ArrayLists to store our customers, sellers, products catalog, cart, etc. We also implement a session class that allows only one customer to occupy a session at atime.
- In terms of the user interface, we use JavaFX and CSS to stylize our pages. We use Scene Builder for the GUI and CSS for stylization since it is much less tedious than adding components manually. Then, we load the FXML files using FXMLLoader.
- We split the UI into one dedicated to the customer (the one buying the product), the seller (the one putting the product on sale), and the admin (the one monitoring the customer and seller).
- In the Customer Section, we created a login and sign in page, a main page, a checkout page, and a profile page. The login and sign in page allow for information security and identity verification, our customer can create an account and access their profile information and cart. The main page contains items currently sold on the store’s catalog, and user can add products to their cart. The profile page contains user information provided during the sign-in process. The checkout page allows the user to view their cart, add/remove products from their card, and enter essential payment information. We use basic event handlers for page transitions, adding products to our data containers. We create separate FXML files for product cards and use display methods in the controller to showcase it on the screen dynamically. Some data structures we used are GridPane for displaying the product cards, anchorpane for high-level layout, HBox and VBox for general layout, ChoiceBox to access profile and to sign out, ScrollPane to allow our UI to display more products.
- In the Seller Section we split it up to have 3 screens so the seller can have easy access to what they want to do. First we have the home screen which is just a holder so let the seller access the add and remove pages. On the add page this is a simple and easy place for the seller to add items to their store. This page uses a ChoiceBox to move us to the add, remove, or sign out. On the add page they can add the item name, ID, price, and description. There is also an option to add an image but it is optional. If sellers add an image it will show up with that image but if they do not there is a placeholder image for them and it will appear as that image. The UI here was mainly made with text boxes and also imagesView. We made it so once you add an item there is a label on screen to tell you the item was added so you know it is there. Then on the remove page they are able to remove items they have in their store by putting in the item name, ID, price, and description. Similar to the add page there this page uses mainly text boxes and having a label there to let us know when we have removed an item. It is very easy for sellers to do this by just signing up and going through the process of adding and removing. 
- In the Admin section, we have decided to initialize 4 of us as admins to ensure the privacy and security of the ecommerce webpage. Therefore, each of us has a different account and password from the beginning to be able to manage the system in the best way. Each admin has a different position but the powers are the same. We can check how many customers and sellers there are currently. Besides, we can also check users' accounts, passwords, and all information. Therefore, security is our top priority. Not only that, if a user commits any violations, we can remove their account from our system. We use ArrayList to create accounts for 4 admins. Regarding UI in Admin, we will mostly use VBox to keep everything presented neatly and easy to see. We will create a separate FXML file for the user card and then create a controller to display it for each different user. Creating a separate FXML will help us save time to be able to display a large number of different users in the most synchronous and neat way. Thanks to that, we can also easily check each person's information quickly and accurately.

## Steps to run our program:
1. Clone project from our github repo.
2. Navigate to the Main.java file.
3. Run as normal using command/button.
4. Sign up and login to your customer/seller account. Or login as admin using our admin account details.

## Program Snapshots:
- Welcome Screen
<img width="699" alt="Screenshot_2023-12-16_at_11 53 00_AM" src="https://github.com/ducvub10/CS151-Ecommerce_Webpage/assets/136019230/018fe2e7-c7e6-4a3a-9d77-2d392310d6ad">

- Sign in screen for Customers
<img width="694" alt="2" src="https://github.com/ducvub10/CS151-Ecommerce_Webpage/assets/136019230/d11d847e-c1d6-4603-a84d-2aed725658f5">


- Sign in screen for Sellers
<img width="693" alt="11" src="https://github.com/ducvub10/CS151-Ecommerce_Webpage/assets/136019230/2306af93-ec7a-46a3-92f0-887a463a7124">

- Sign in screen for Admins
<img width="694" alt="12" src="https://github.com/ducvub10/CS151-Ecommerce_Webpage/assets/136019230/1cda7b73-a9b7-4278-9a6d-d5496fe7b704">
  
- Sign Up Screen 
<img width="696" alt="3" src="https://github.com/ducvub10/CS151-Ecommerce_Webpage/assets/136019230/411f0f0e-7913-4b9d-af80-55e271bbfd27">
<img width="696" alt="4" src="https://github.com/ducvub10/CS151-Ecommerce_Webpage/assets/136019230/af44d228-cecc-4d69-9e8c-6e5b6bc844a8">
<img width="693" alt="5" src="https://github.com/ducvub10/CS151-Ecommerce_Webpage/assets/136019230/84473cd2-426a-4a35-9257-82e155246956">

- Seller Main Page
<img width="525" alt="10" src="https://github.com/ducvub10/CS151-Ecommerce_Webpage/assets/136019230/3ecc184c-5322-4303-bfeb-dba10e296f68">

- Seller Add Page
<img width="590" alt="6" src="https://github.com/ducvub10/CS151-Ecommerce_Webpage/assets/136019230/6eee1b9c-7852-49fb-9691-bc7114a8548a">

- Seller Remove Page
<img width="614" alt="9" src="https://github.com/ducvub10/CS151-Ecommerce_Webpage/assets/136019230/b2dc7f65-e45d-4746-a03f-2c5657ef8cdf">

- Customer Main Page
<img width="1004" alt="7" src="https://github.com/ducvub10/CS151-Ecommerce_Webpage/assets/136019230/8d001230-8a4a-495f-883d-33b11c9dfe6b">

- Cart Page
<img width="1002" alt="8" src="https://github.com/ducvub10/CS151-Ecommerce_Webpage/assets/136019230/0547b187-b172-495c-ac56-bc8eaba7bb5f">

- Admin Main Page
<img width="863" alt="14" src="https://github.com/ducvub10/CS151-Ecommerce_Webpage/assets/136019230/0d9ec81c-5a64-44d0-ac5f-bb3f17dbe561">
<img width="867" alt="13" src="https://github.com/ducvub10/CS151-Ecommerce_Webpage/assets/136019230/ba695503-217f-44b0-a801-f03af78c0fe7">



## Reference
Vzenun’s [E-Commerce_Application-JAVA-](https://github.com/Vzenun/E-Commerce_Application-JAVA-).\
Adithkrishnan98’s [ECommerce-Java](https://github.com/adithkrishnan98/ECommerce-Java/tree/main).
