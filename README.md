# Fullstack Invoice Service

Invoice service application developed by Java Spring Boot for Backend, Reactjs for Frontend, Postgresql for Database in Docker 

Following these steps to run app

>  Java-React_InvoiceServiceApp/BE Java/invoice-service/src/main/resources/ go in this path file and run "docker-compose up -d" command in terminal to run PostgreSql in Docker server

> Run the Backend project in IDE

> Java-React_InvoiceServiceApp/FE React/invoice-service/ go in this path file and run "npm install" command in terminal to install packages 

> run "npm start" command in terminal in previous path file

* Backend application will run in "http://localhost:8081/" 
* Frontend application will run in "http://localhost:3000/"

##### Credit limit set "200" in "application.properties". The sum value of amount the invoice added by the users and the amount in the transactions that were previously added to the APPROVED transactions should not exceed 200. The record is saved to the database but the status is marked as NOT_APPROVED.

# User
| Route | HTTP Verb	 | POST body	 | Description	 |
| --- | --- | --- | --- |
| /api/user/getall | `GET` | Empty | List all users. |
| /api/user | `POST` | {'firstName':'Joe', 'lastName':'Doe', 'email':'joedoe@example.com'} | Create a new user. |
| /api/user?userId=1 | `GET` | Empty | Get user by id. |

# Invoice
| Route | HTTP Verb	 | POST body	 | Description	 |
| --- | --- | --- | --- |
| /api/invoice/getall | `GET` | Empty | List all invoices. |
| /api/invoice | `POST` | {'productName':'Keyboard', 'amount':50, 'billNo':'TR005544', 'userId': 1} | Create a new invoice. |
| /api/invoice?userId=1 | `GET` | Empty | Get invoices by user id. |
