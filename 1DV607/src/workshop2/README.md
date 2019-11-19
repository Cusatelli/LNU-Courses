# ChangeLog:
Feedback from Teacher:
1. Fix: Hidden dependencies between classes in the view and controller packages 
2. Fix: Business logic in the controller In general very strange inheritance hierarchies.
3. Fix: Design does not follow the domain model. I.e. Members should contain their Boats. 
This is not a good OO-Design, that follows general design principles and the domain model.
4. Fix: In general why are you working with arrays of Objects?! This creates a code base and 
design that is essentially impossible to understand and use. This has also made you not use 
the Member and Boat classes correctly. For example when you are listing members you are 
essentially just printing the saved file, if the format of this file is changed the view 
will be broken (this is more or less in every function). Why do you even have the Member 
and Boat classes? You should encapsulate the persistence properly and not let it spread all 
over the application. You have essentially created more or less a very complicated and 
fragile way to edit a text file... ".

### Versioning Format
````
Major.Minor.Date (MM.mm.YYMMDD):

Major Release: 01
Minor Release: 10
Date: 2019 November 11th

Ex: 01.10.191111
````
### [02.00.191118]
#### Reworked
- Now only Console.java uses methods from ConsoleHandler.java instead of both borrowing from eachother.
- method calls from Controller.java -> Console.java now displays prints properly.

### [01.97.191117]
#### Refactored
- Minor Console.java & ConsoleHandler.java refactoring. Moving code between classes.

### [01.95.191117]
#### Fixed
- Debug (Error) Handling bug which caused it to print empty lines.
- Minor issues with print-outs
- Naming convention for certain methods were incorrectly named.

### [01.90.191115]
#### JavaDocs
- Created Java Documentation for majority of code.
- Fixed minor naming issues.

### [01.90.191114]
#### JavaDocs
- Created Java Documentation for majority of code.
- Fixed minor naming issues.

### [01.75.191114]
#### Fixed
- Majority of bugs which either threw errors causing the program to crash or issues with 
invalid inputs & outputs from/to the database.dat.
- Also properly implemented User-Made-Exceptions to methods in various classes. They should now throw an error message
whenever the signal is triggered.
- Naming was also causing issues thus it is now a scan.next() rather than a scan.nextLine(). Though this is necessary to
make the program work it is unfortunate as it only allows for strings without whitespaces to be entered.

### [01.50.191113]
#### Reworked
- Majority of Member.java & Boat.java to better implement a member & boat relationship.
- BOAT_TYPE.java enumeration so that it is contained within Boat.java as public TYPE enumeration.
- Id.java is now simplified much. Instead of generating a random character & number (from A-Z + 100 to 999) it only 
indexes the next available value after the last registered member. 1 to 'Integer Overflow'.

### [01.50.191113]
#### Reworked
- Majority of Member.java & Boat.java to better implement a member & boat relationship.
- BOAT_TYPE.java enumeration so that it is contained within Boat.java as public TYPE enumeration.
- Id.java is now simplified much. Instead of generating a random character & number (from A-Z + 100 to 999) it only 
indexes the next available value after the last registered member. 1 to 'Integer Overflow'.

### [01.42.191112]
#### Added
- Error Handling extending Exceptions. MemberNotFound.java, BoatNotFound.java, InvalidInputParameter.java. 
To better manage errors when thrown.
- MemberNotFound.java, BoatNotFound.java, InvalidInputParameter.java to existing classes.

### [01.31.191112]
#### Fixed
- New issues and bugs such as start-up sequence & terminate program.

### [01.30.191112]
#### Refactored
- Removed Registry.java & CreateObject.java classes in model/registry/.
- Reworked the FileHandler.java to now work with objects instead of Strings & characters from a text file.
- FileHandler.java contains an ArrayList<Member> which temporarily stores Members (containing Boats) so they can easily be edited in the application at runtime, and saves this ArrayList<Member> to the database after each input action has been completed.
- Removed Hidden Dependencies throughout the project.
- Removed Registry.txt file.
- Added database.dat file to take objects from new FileHandler.java

### [01.24.191111]
#### Improvements
- To the Input Handling of the Application.

### [01.23.191111]
#### Reworked
- the Console.java structure to now also use a ConsoleHandler.java class.
This way I could better control the print-outs in the Console.java by using prebuilt setups.

### [01.15.191111]
#### Refactored
- Updated methods to better work with the "start()", "update()", "exit()" setup built in Controller.java.
- Also quickly fixed imports in other files while still keeping the same method/field names.

### [01.10.191111]
#### Moved
- All code from InputHandler.java & DataHandler.java into Controller.java.
