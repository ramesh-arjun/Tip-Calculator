# Tip-Calculator

Defining the Problem
The client, Mr. XX, is the owner of an Indian restaurant called Madras Mansion. Although the
restaurant has experienced steady traffic, his employees are dissatisfied. Mr. XX can afford to pay
them minimum wage, but the employees have requested a higher salary in order to make ends meet
during an economic downturn. The owner believes that customer tips can solve this problem.
The existing software has an option for customers to enter tips, but it is poorly designed. The
customer must enter in their own tip amount, if any, which disincentivizes them. Mr. XX believes that
if there was a feature that recommended tip amounts so it was clearly visible to the customer, he
could provide a sufficient wage to his workers.
To motivate his employees to not resign and continue Madras Mansion’s excellent service
quality, Mr. XX suggested a program that recommends tip amounts of 10%, 15%, and 20%. He
envisions that a customer could click on a button and have that corresponding tip amount displayed.
Additionally, on Wednesdays, there is a special discount which attracts a significantly greater number
of customers, so he wants those recommended tip amounts to be increased by 5% each.
In order to encourage tips at Madras Mansion, I have volunteered to construct a GUI that can
be added to Mr. XX’s existing restaurant software. The interface of the GUI will be simplistic for the
customer, with buttons indicating the customer to add a recommended tip percentage. My computer
science instructor, Mr. ZZ, has arranged to be my advisor for this tipping calculator program.

Rationale for the Proposed Solution
Since Mr. XX cannot afford to increase employee salaries, customer tips allow the workers to
receive money on top of their existing salary. In order to build a tipping calculator that is clearly
visible to the customer and encourages them to leave a tip, OOP utilizing the Java language is the
most feasible option to construct this program.
Its primary functions are to allow the user to select a tip percentage from a dropdown menu
and calculate a tip based on the entered meal amount. Additionally, the calculator will display the
resulting tip amount based on the customer’s tip selection or entry. A table will then be organized
with the history of tip calculations, including the name, meal amount, tip amount, and timestamp.
Additionally, the management will be able to access and manipulate the table by accessing it through
an in-memory database.
While the GUI is customer-friendly, the program’s components will demonstrate complexity
because based on the day of the week, a selection of tip percentages will be displayed on buttons.
Another component of this solution is the in-memory database, which will allow Mr. XX to access the
table of tip calculations and analyze this data from a management perspective. The Spring Tool Suite
IDE includes all of the tools I need to build this program.
Overall, a tipping calculator will supplement the salaries of the Madras Mansion
employees, and the expected increase in customer tips will promote their satisfaction.

Success Criteria
I. The program will accept the customer’s subtotal.
II. The program will display a generic dropdown menu of tip amounts displayed on all weekdays
except Wednesday.
III. The program will display a specific dropdown menu of tip amounts displayed only on
Wednesdays.
IV. The program will get the current day.
V. The program will organize tip calculations into a table.
VI. The program will implement the H2 database in order for the management to access the tip
calculations table.


VII. The management can utilize SQL queries in order to manipulate the tip calculations table.

Criterion C: Development
UML Diagram
Techniques Used in Development
A. Libraries Imported (Java)
B. Spring Boot/In-Memory Database
C. User Interface (JQuery, JavaScript, HTML, CSS)
D. Encapsulation/Getters and Setters (Java)
E. Exception Handling (Java)
F. SQL Queries
G. Object-Oriented Programming/Lists (Java)
H. Inheritance (Java)
Justification of Product Techniques
A. Libraries Imported
● RoundingMode specifies that decimals will be rounded up to the nearest hundredth.
● DecimalFormat allows doubles to be rounded to two decimal places for money values.
● SQL is a language that allows the ability to create, retrieve, update, and delete data.
● Timestamp is a data type that stores information for the date and time fields.
● java.time.LocalDate, along with getDayOfWeek(), obtains the current day of the week. This is
needed for the program to see if the current day of the week is Wednesday.
● java.util.List allows us to search, update, insert, and delete elements in an ordered collection.
● java.util.ArrayList allows for the implementation of ArrayLists, which are dynamic data structures
that can be used to add/remove elements from an array.
● org.springframework is a tool for developing applications using Java.
● Autowired allows the controller class to recognize the repository class.
● Controller manages the data flow from the GUI and back.
● GetMapping maps a get request from the GUI.
● Serializable allows an object to be able to move from one class to the other.
● Crud stands for create, read, update, and delete. CrudRepository helps do these operations on a
database table.
B. Spring Boot/In-Memory Database
The Spring Boot Initializer created a zip file as a Maven Project, which was imported into Spring
Tools Suite, my IDE. Maven is a tool used to manage Java projects. Spring Tools Suite was chosen because
it is simple to use, debug, and run Spring-based applications. This project was built using a Maven clean
compile. Spring Tools Suite can automatically compile using Maven’s clean compile command.
Spring Boot actuator checks the health of the application. Thus, the application is “UP.”
The pom.xml file configures Spring Boot. It contains information about the project and the jars
that needed for various features to be implemented. Opening this file, the Maven dependency holds the
jar files that the application needs to run successfully.
Spring is used to build a RESTful (Representational State Transfer) service that accepts HTTP GET
requests. These are annotations that ensure that HTTP GET requests go to getTip. The request
mapping/save/amount/tipAmount ensures that HTTP POST requests go to the save method.
H2 is an in-memory database which means that the tables will last as long as the server is up. If it
is restarted, then the table is cleared. The application.properties file configures the data source url,
username, and password. In-memory storage was preferable for the purposes of this application, but
file-based storage could have been utilized.
When the password is entered, the user can access the table of tip calculations which organizes
the following data found in create.sql:
C. User Interface
The GUI is created using HTML5, CSS3, and jQuery. HTML5 provides a modern framework for
building responsible GUIs. jQuery is a simple framework to assist with the implementation of each class
in the interface. Calling REST API (save and getTip) follows multi-tier architecture, as shown in the
diagram below.
In the interface, the user is prompted to enter their meal price. Then, a dropdown menu is
displayed. Depending on the day of the week, options of 10%, 15%, and 20% or 15%, 20%, and 25% are
presented. When the user clicks the button titled “Calculate Tip,” the resulting tip calculation is displayed
on the screen. Then, those values are added to a table which displays below the tip calculations.
In the AppController class, the viewHomePage() method renders the user interface.
The first jQuery ajax function calls the calcTip() method with a GET request. The response
function displays the resulting tip calculation in the GUI. The second ajax function calls the save()
method, and this updates the grid displaying tip calculations with the most recent calculation. The grid
organizes the name, meal and tip amounts, and data into a table.
D. Encapsulation/Getters and Setters
Encapsulation is utilized in the AccountEntity class as instance variables are declared as private.
Getter and setter methods retrieve and update values for tip amounts because these values are
continuously changing with each calculation. The public getters and setter methods in the class below
access private variables. For example, getTipTime() receives the timestamp of when the user calculated a
tip, and setTipTime() sends that value to the user interface and adds that value to the table.
E. Exception Handling
If there is an exception while saving the record, this try-catch block catches the exception and
prints out the cause of the exception in the console so it can be troubleshooted.
F. SQL Queries
The H2 database was selected because it has a built-in GUI that we can use to run SQL queries.
The findAll() method uses SELECT * FROM ACCOUNTS (a SQL query to retrieve data from the table
accounts) by using the CrudRepository. CrudRepository automatically creates these SQL statements upon
calling the findAll() and save() methods. The save() method uses the SQL statement INSERT INTO
ACCOUNTS. The calculations are organized in a table with the ID, meal amount, name, tip amount, and
timestamp.
G. Object-Oriented Programming/Lists
List<Account> get() initializes a list of Account objects. repository.findAll() returns the account
entities, loops through them, and organizes them into a list of accounts. The ArrayList<Account> goes to
the GUI and populates the table with the history of tip calculations. Then, the database is called to find
the account entities, which allows elements to be added to the list. get() finds all elements from the
database and returns the entity (result).
.forEach() iterates through a collection, and this complex loop is utilized along with a lambda
expression, which allows for more compact syntax. It accepts acc as an argument, which represents the
account entity for which the name, meal amount, tip amount, and tip time will be displayed in the table.
The method getTip() sends a list of objects to the GUI for the dropdown menu displaying tip
percentages. This first creates an empty ArrayList and then populates this ArrayList with LabelValue
objects. Each LabelValue object has an Id. For example, setId() to 0.3 calculates a 30% tip, and setName()
to “30% - Great” indicates the text displayed in the dropdown. getTip() also has a check for the day of
the week. On Wednesday, each of the tip amounts are elevated by 5% to account for the special discount
at Madras Mansion.
The calcTip() method calculates and formats the tip based on the entered bill amount.
H. Inheritance
Inheritance is utilized as the Repository class extends the methods in the CrudRepository class. It
inherits the save() and findAll() method from the TipController class, as seen through the
repository.save(en) and repository.findAll() method calls.
Justification of Product Structure
This project is structured with all the Java files in the package com.tipcalc. com.tip.calc holds the
TipCalcApplication, which is the main file used to open the application. Under the src/main/resources
directory, the application.properties file holds the needed configurations, and index.html holds all of the
GUI-related code.
The project is separated into two main packages: the tip calculator and the account database.
Because these two packages have different functions, it was sensible to divide it in this manner. Thus,
the information necessary for the restaurant customer is linked to the GUI. On the other hand, the
relevant tipping data for the manager, Mr. XX, is developed under the Account, AccountEntity, and
AccountRepository methods.

References
Docs.oracle.com. 2021. Lambda Expressions (The Java™ Tutorials > Learning the Java Language >
Classes and Objects). [online] Available at:
<https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html> [Accessed 15
November 2021].
Docs.oracle.com. 2021. LocalDate (Java Platform SE 8 ). [online] Available at:
<https://docs.oracle.com/javase/8/docs/api/java/time/LocalDate.html> [Accessed 15
November 2021].
Docs.spring.io. 2021. JpaRepository (Spring Data JPA 2.6.0 API). [online] Available at:
<https://docs.spring.io/spring-data/jpa/docs/current/api/org/springframework/data/jpa/repo
sitory/JpaRepository.html> [Accessed 15 November 2021].
js.foundation, J., 2021. jQuery API Documentation. [online] Api.jquery.com. Available at:
<https://api.jquery.com/> [Accessed 15 November 2021].
Spring.io. 2021. Spring Boot. [online] Available at: <https://spring.io/projects/spring-boot#samples>
[Accessed 15 November 2021].
