# tch-tool
This README file explains how to use the TCH Tool programs for "search bank data".

Note that the programs require Java 8 or higher.

---- RUN ON THE COMMAND LINE ----

In the target folder, run the command:

java -jar tch-tool-0.0.1-SNAPSHOT.jar

---- PERFORM SEARCH ----

1. Searching data by Zip code or State or City or Type or Bank Name

   "Please enter search criteria:"  enter Zip code or State or City or Type or Bank Name
   
2. Searching data by City & State

   "Please enter search criteria:"  enter city + "," + state, e.g. "dallas,tx"
   
3. Searching all banks

   "Please enter search criteria:" enter "all"
   
---- IMPLEMENTING UNIT AND INTEGRATION TESTS ---- 

1. Testing in loading the data
   a. read and parse the cvs file 
   b. header detection (not load into java object)
  
2. Testing in data service
   Use Mockito

   