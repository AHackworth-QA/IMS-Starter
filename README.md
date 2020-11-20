Coverage: 75.8% total coverage
# Inventory Management System

The following documents contain the neccessary code to work the Iventory Management System (IMS), this includes a customer, order, and, item entity all of which have their own DAO, controller and main classes all of which was coded in java using the software Eclispe. This all links up to a MySQL server that contains the database for the code which can be accessed by typing in the application. 

This IMS is used to create customers, items, and orders. The IMS is controlled via the command line. 

The customers need a first and last name along with an email.
The items need a name, value, and stock.
The Orders need a order quantity, product_id, order_id and a customer_id.

The IMS works off having three Data Access object classes for Customer, Item and Orders which interact with the SQL database that was previously mentioned.

## Getting Started

You can fork the repository and then download the code as a zip file. extract the zip file, then using eclipse open an existing maven project: Done through Fil, Import, Import existing Maven Project. Then you should have a copy of the IMS in Eclipse (find the download link for all this below) 
### Prerequisites

You must have a Intergrated Delevlopment Environment (IDE) installed that can run Java 8 at least I used Eclipse. It must also have the neccessary Maven Pluggin installed so that it can be used. 

```
Install Java 8 development kit from https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html 

Install Maven from https://maven.apache.org/download.cgi

Install Eclipse from https://www.eclipse.org/

Install MySQL Workbench from https://www.mysql.com/products/workbench/
```
It is not recommended to use a more up to date version of the Java development kit as this may not work with the IMS.
### Installing

To install Java you need to download the Java Development Kit (JDK).

Installing the JDK and creating a a proper pathway for the files and environment variables are important to ensure the IMS and java will run properly I suggest using an online guide to make sure this is completed properly I have linked one below.
```
https://docs.oracle.com/javase/10/install/installation-jdk-and-jre-microsoft-windows-platforms.htm#JSJIG-GUID-371F38CC-248F-49EC-BB9C-C37FC89E52A0
```

To install Maven again you need to download the product from the link above in prerequisites. Following the guide below should help with getting the pathway and environment variables setup properly.

```
https://maven.apache.org/install.html
```
To install MySQL Workbench download from the link above and follow this guide.

```
https://dev.mysql.com/doc/workbench/en/wb-installing-windows.html
```

For the Java IDE I used Eclipse but you can use any IDE that will allow the use of Maven as it is a maven project. Use the guide below to get Maven running on your Eclipse IDE.

```
http://roufid.com/how-to-install-maven-on-eclipse-ide/
```
## Using the IMS Project

When using the run feature in eclipse the IMS will work, this will as you which entity you will like to interact with it should look like the following:

Which entity would you like to use?
CUSTOMER: Information about customers
ITEM: Individual Items
ORDER: Purchases of items
STOP: To close the application

Typing in Customers will show you the following:

customer
What would you like to do with customer:
CREATE: To save a new entity into the database
READ: To read an entity from the database
UPDATE: To change an entity already in the database
DELETE: To remove an entity from the database
ADD_ITEMS: adds an Item (specific to Orders)
DELETE_ITEMS: removes an Item (specific to Orders)
RETURN: To return to domain selection

from here you can create, read, update, and delete a customer entity in the IMS. 

If you would like to view the previous section again simply type return and press the enter key.

To stop the application go back to the first screen and type stop.


## Running the tests

When running tests for the application I used both JUnit and Mockito. To use these I imported the JUnit Before, BeforeClass and Test onto a test class for my customer, order and items DAO. Once these were imported I could run them with @BeforeClass, @Before, and, @Test. This would allow me to see the overall test coverage for my IMS.

If you would like to add some tests of your own simply use the file explorer on the left handside of the Eclipse software and move to the section of the IMS file src/test/java then right click the file and select run as JUnit test and this will allow you to see the test coverage 

### Unit Tests 

Explain what these tests test, why and how to run them

```
Give an example
```

### Integration Tests 
Explain what these tests test, why and how to run them

```
Give an example
```

### And coding style tests

Explain what these tests test and why

```
Give an example
```

## Deployment

Add additional notes about how to deploy this on a live system

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

## Versioning

We use [SemVer](http://semver.org/) for versioning.

## Authors

* **Chris Perrins** - *Initial work* - [christophperrins](https://github.com/christophperrins)
* **Adam Hackworth** - [AdamHackworth](https://github.com/AHackworth)

## License

This project is licensed under the MIT license - see the [LICENSE.md](LICENSE.md) file for details 

*For help in [Choosing a license](https://choosealicense.com/)*

## Acknowledgments

* Hat tip to anyone whose code was used
* Inspiration
* etc
