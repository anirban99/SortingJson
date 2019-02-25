**Sorting Json File**

**To Run the application**

Using IDE
 
    Run the Main.java 

Using command line -

    mvn clean package

    mvn exec:java -Dexec.mainClass=sorting.Main
    
    mvn test -Dtest=sorting.SortingTest


**Project description**

Main.java - The main class which sets the Json file. It calls the readFile() and writeResult() methods.

Sorting.java -  The class which performs all the operations defined in the various methods

    setFiles() - Used to set the Json file
    readFile() - Used to read and parse the Json file
    sortPlaneCapacity() - Used to sort the total plane capacity
    sortCarCapacity() - Used to sort the total car capacity
    sortTrainCapacity() - Used to sort the total train capacity
    sortPlaneDistinctType() - Used to sort the distinct plane types
    sortCarDistinctType() - Used to sort the distinct car types
    sortTrainDistinctType() - Used to sort the distinct train types
    writeResult() - Used to write the json with the sorted data
    

SortingTest.java - JUnit tests for testing all the methods of Sorting.java