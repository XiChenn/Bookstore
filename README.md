Bookstore
=========

### Multitiered Architecturein a Java EE Application Model
![Alt text](https://raw.githubusercontent.com/XiChenn/Bookstore/master/Bookstore/resources/javaArchitecture.jpeg)

### Layers in an Enterprise Application
![Alt text](https://raw.githubusercontent.com/XiChenn/Bookstore/master/Bookstore/resources/enterpriseLayer.jpg)

### Web Layer
The web layer of a web application consists of the web tier components of Java EE such as servlets and JSP. The web layer can access the service layer, but there should not be a tight coupling between the web layer and the service layer. That is, changing the service layer should not impact the web layer.
### Service Layer
The service layer consists of the business tier components of Java EE such as Enterprise JavaBeans (EJBs). The service layer can access the data access layer, but there should be no tight coupling between the service layer and the data access layer. In fact, the service layer should not know anything about the web or data access layer. The service layer provides a coarse-grained interface for the web layer.
### Data Access Layer
The data access layer consists of the data tier components of Java EE such as JDBC and JPA. This layer should not contain any business logic. This layer abstracts the actual persistence mechanism (in other words, JDBC or JPA) from the service layer by providing the coarse-grained interface to the service layer.

### Database
1. The Category table stores the different categories of books; categories include Java, Scala, and so on.
2. The Book table stores the book details such as titles.
3. The Author table stores the details of the authors.

### DAO
The data access layer is responsible for interfacing with the underlying persistence mechanism in a transparent way in order to store and retrieve objects from the database. This transparency means that the data access layer can switch the persistence mechanism from plain JDBC14 to ORM15 persistence technologies such as Hibernate,16 JPA,17 and so on, without affecting the client of the data access layer. This transparency is achieved via the data access object (DAO) pattern, as illustrated as follows:
![Alt text](https://raw.githubusercontent.com/XiChenn/Bookstore/master/Bookstore/resources/DAOPattern.jpeg "DAO Pattern")

### The MVC Pattern
![Alt text](https://raw.githubusercontent.com/XiChenn/Bookstore/master/Bookstore/resources/mvcPattern.jpg "MVC Pattern")
In MVC(also called Model-2), a controller handles the user request instead of another JSP page. The controller is implemented as a servlet. The following steps are executed when the user submits the request:
1. The controller servlet handles the user’s request.
2. The controller servlet instantiates the appropriate JavaBeans based on the request.
3. The controller servlet communicates with the middle tier or directly to the database to retrieve the required data.
4. The controller sets the JavaBeans in one of the following contexts: request, session, or application.
5. The controller dispatches the request to the next view based on the request URL.
6. The view uses the JavaBeans from step 4 to display data.

