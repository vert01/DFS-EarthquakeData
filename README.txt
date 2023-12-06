This program uses the Bridges API as its dataset. In order for the program to run, it is REQUIRED for the Bridges JAR file to be installed
into the Java Project library. The Bridges JAR file is included within the .zip folder and a tutorial on how to install the the library 
will be linked down below, as well as the instructions how to do it as well for the ECLIPSE IDE.

Step 1: Create a Java Project
File-->New-->Java Project

Step 2: Check Java version
In the new window change the Project name field to your project name, then make sure the JRE Execution Environment is JavaSE-8 or above . Here we are using Java version 17. Click Finish n the lower right-hand corner.

Step 3: Import Jar File into project
Download the latest Bridges Jar file from Bridges home page and save it somewhere convenient on your drive.
On Eclipse, right-click on your project in the Package Explorer window and then click on Java Build Path --> Add External Archives. You should see the following configuration (this is on the Mac, which brings up a file browser).
Step 4: Import BRIDGES Jar file
Locate and select the Bridges.jar file you saved earlier (bridges-java-3.4.2.jar) to import it into your new project (current version 3.4.2)

Step 5: Verification
To verify that you have successfully imported the Jar file, look under the Referenced Libraries section of your project in the Package Explorer window in Eclipse.
If you have got a Project in the Eclipse Package Explorer with your username as the project name, and the referenced libraries section shows the bridges Jar file, you have completed the setup and are ready to build the Singly Linked List class!


https://bridgesuncc.github.io/bridges_setup.html
