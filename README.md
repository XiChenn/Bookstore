Bookstore
=========
1. The Category table stores the different categories of books; categories include Java, Scala, and so on.
2. The Book table stores the book details such as titles.
3. The Author table stores the details of the authors.

The data access layer is responsible for interfacing with the underlying persistence mechanism in a transparent way in order to store and retrieve objects from the database. This transparency means that the data access layer can switch the persistence mechanism from plain JDBC14 to ORM15 persistence technologies such as Hibernate,16 JPA,17 and so on, without affecting the client of the data access layer. This transparency is achieved via the data access object (DAO) pattern, as illustrated as follows:

![Alt text](https://raw.githubusercontent.com/XiChenn/Bookstore/master/Bookstore/resources/DAOPattern.jpeg "DAO Pattern")

