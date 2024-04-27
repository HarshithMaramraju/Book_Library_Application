# Book_Library_Application

This is an book library system appliication.
This is developed by springboot java.
This performs all the CRUD operations by sendind the API through Postman tool.
By the MySQL Server DB the data is used to store in the Database.
This project contains all about the book, author, rental/customer.

**#Main feature**

If the book rented,it ensure's the book is already rented. If not rented then it ready to be rent
And time stamp of rented and returned date by LocalDate class which is inbuild class in java
It sets time to each and every customer to 14 days from the book rented, and have to submit with in that 14 days time period.
When the book is returned then is changes its state to true as the book was avalible for other rentals. else is shows false as it ws alardy rented by others.

**#Testing**

All the API's was tedted ans sent by the postman tool by connecting JDBC driver to the project
And all the operations were success and returns a message as it was successfully embeded.

**#Exception Handling and Validation**

Execptions were handled by the the not found class which not gives the http error insted it shows the message that we added for example for 404 it shows Page cant be reach/or not found.
validations for the coloms such as name, isbn, publishedYear etc are validated by the annotations notnull and not blank. nad valid annotation in the restcontroller to provide the correct formate as per the coloum if its was number it should be number it self.

**#Run innstructions**

First start the server and then by the api's which were annotated in the rest controller just go with that api's form opetations in postman and by providing our server localhost (http://localhost:8080/insertBook)
by sending this and seting method to our convenience as insert to post, find to get, update to put, delete to delete, Mapping to put, and to get rentedData and all use get method's.

Swagger was ennabled to get a clear view of this project just we have to give our localhost link in browser after once we start server only, then add swagger-ui to that link so it will redirect to the swaggerr documentation of our project.

Thank you
