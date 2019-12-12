# Test Plan
## Objective
The objective of the Test Plan documentation is to describe how the Testing of the System will be implemented & executed
as well as document which requirements will be tested and which will not from the provided [Requirements List](https://docs.google.com/document/d/1fgQngHIZ4_aGIeB2S9YOBCghcBN9EEKBiaN-71MbGac/edit#).

## Background
A small Software Development Company (SDC). “[...] SDC aims to redistribute this server on a wide range of 
Internet Of Things (IOT) to present information from sensors etc. SDC wants an easy to deploy java-web-server that can be 
deployed on many different devices and therefore that can attract attention of a wide range of IOT developers. 
IOT-developers want minimal configuration as well as easy integration and adaptation of the web-server. [...]” 

- [Software Testing Assignment 2: Scenario](https://coursepress.lnu.se/kurs/mjukvarutestning/labs/a2/)

## Goals
### Software Development Company:
- Easy to deploy Java-Web-Server which is compatible with many different devices.
- Attract a wide range of IoT developers.
### Internet of Things:
- Minimal Required Configuration.
- Easy Integration and Adaptation of the Web-Server.
### End-Customers:
- Easy Access.
- Absolute Security.

## Scope
Manual & Automated Testing will be performed to ensure maximum coverage. Manual Testing will ensure that functionality
is on-par with the requirements through different Test Cases. Automated Testing will ensure that the system can handle
heavy workload and analyze overall performance under different load types.

## Testing Levels
### Functional Testing
|  |  |
|:---|---|
| Objective | Functionality & Data Retrieval |
| Technique | Execute Use Cases using valid and invalid input data:<ul><li>Expected Results Occur when Valid Data is used.</li><li>Expected Error or Warning messages are displayed whenever Invalid Data is used.</li><li>Business Rules Applies.</li></ul> |
| Criteria | All Planned Tests have been executed & all issues have been found & exposed. |
| Consideration | Due to all workload being pushed on two developers the test may not reach the desired coverage before the deadline. |
| Testers | Student 1 & Student 2 |
| Elements | <ul><li>Requirement 2: The Web-Server must follow Minimum Requirements for HTTP 1.1.</li><li>Requirement 3: The Web-Server must work of Linux, Mac OSX & Windows (XP, Vista, 7, 8, 10, Server 2008).</li><li>Requirement 5: The Access Log should be viewable from a text editor.</li><li>Use Case 1: Start Server.</li><li>Use Case 2: Stop Server.</li></ul> |


