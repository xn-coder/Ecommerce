# Electronics E-Commerce Application

This is a full-fledged e-commerce platform developed for selling electronic devices. The application allows users to browse products, add items to the cart, complete purchases, and track their orders. Additionally, it includes a robust admin panel for managing products and orders efficiently.

## Features

### User-Side Functionality
- **Browse Products**: Users can view a list of available electronic devices, along with detailed information like price, specifications, and availability.
- **Product Details**: Each product has a dedicated page displaying its description, specifications, reviews, and more.
- **Cart and Checkout**: Users can add products to the cart, manage quantities, and proceed through the checkout process to place orders.
- **Order Tracking**: Users can view the status of their placed orders in real time.
- **Authentication**: JWT-based authentication ensures secure login and registration for customers.
- **Responsive Design**: Built using Thymeleaf, HTML, and CSS, the UI is fully responsive and mobile-friendly.


## Tech Stack

- **Backend**: Spring Boot, Spring Data JPA
- **Frontend**: Thymeleaf, HTML, CSS
- **Database**: MySQL
- **Security**: JWT-based authentication for secure user login and admin access
- **ORM**: Hibernate
- **Build Tool**: Maven


## Screenshots

1. Sign Up Screen:
    The sign-up page allows new users to create an account by providing their name, email, password, and other necessary details. The form includes validation to ensure accurate data entry, enabling users to securely register for the e-commerce platform.


![sign1](https://github.com/user-attachments/assets/05c9d177-d667-4527-bf22-3a91b9b23f74)


![sign2](https://github.com/user-attachments/assets/c3a4e6cf-e946-4dbf-bdd2-007f097bbb62)


2. Login Screen:
    The login page is where registered users can enter their credentials (email and password) to access their accounts. It includes password validation and JWT-based authentication for secure login.

   
![logIn1](https://github.com/user-attachments/assets/49d7d155-8264-428a-8333-f29640a2ae27)


If password is incorrect it gives error message


![logIn2](https://github.com/user-attachments/assets/88b97bdd-1606-4098-97c1-e514bfb5ca14)

3. Home Screen:
    The home page showcases a list of electronic devices available for purchase. Each product       is displayed with its image, price, and basic details. Users can browse the products and click on individual items for more detailed information.


![home222](https://github.com/user-attachments/assets/25f31a02-ce2f-4284-bb0b-4089ea8ccb61)

4. Cart Screen:
    The cart page allows users to view the products they have added for purchase. They can          modify quantities, remove items, or proceed to checkout. The cart updates in real-time as       users make changes, displaying  the total price and estimated delivery time.


![afterhome](https://github.com/user-attachments/assets/84d7e04e-7e69-48ac-99a1-094c59cc4bda)


5. Checkout Process
   - Users can review their order summary before finalizing the purchase.
   - Secure payment options are integrated to ensure smooth transactions.
   - After checkout, users can track their orders in the order history section.

![aftercart](https://github.com/user-attachments/assets/e1cd3043-3e47-47e9-a45b-0c1cbfc8c684)

