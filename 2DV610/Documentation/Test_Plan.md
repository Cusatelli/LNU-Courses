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

### Unit Testing
|  |  |
|:---|---|
| Objective | Ensure Functionality & Code Coverage of JUnit Test Suites. |
| Technique | Execute each JUnit Test Suite. |
| Criteria | All Planned Tests have been executed & all issues have been found & exposed. |
| Consideration | The JUnit tests must have been executed while the server is running to simulate a real-life scenario. |
| Testers | Student 1 & Student 2 |

### Integration Testing
|  |  |
|:---|---|
| Objective | Ensure Integration of the Software Modules. |
| Technique | Execute the individual Software Modules as a group to verify the aggregation of the System. |
| Criteria | All Planned Tests have been executed & all issues have been found & exposed. |
| Consideration |  |
| Testers | Student 1 & Student 2 |

### System Testing
|  |  |
|:---|---|
| Objective | Ensure that Functional & Technical Specifications of the System & detect bugs & defects within the Software. |
| Technique | Execute all Test Cases. |
| Criteria | All Planned Tests have been executed & all issues have been found & exposed. |
| Consideration | Unit & Integration Testing must be completed before System Testing can begin. |
| Testers | Student 1 & Student 2 |
| Elements | See Test Cases Documentation |

### Regression Testing
|  |  |
|:---|---|
| Objective | Ensure that Changes does not result in another issues such as faults being uncovered within the application. |
| Technique | Execute Relevant Test Cases multiple times. |
| Criteria | All Planned Tests have been executed & all issues have been found & exposed. |
| Consideration |  |
| Testers | Student 1 & Student 2 |

### Acceptance Testing
|  |  |
|:---|---|
| Objective | Evaluate the Systems Compliance with the Business Requirements and Assess whether it is within acceptable levels. |
| Technique | Ad-Hoc black box testing (See Glossary). |
| Criteria | All issues have been found & addressed. |
| Consideration |  |
| Testers | Student 1 & Student 2 |
| Elements | Ad-Hoc. |

### Alpha Testing
|  |  |
|:---|---|
| Objective | Ensure the quality of the product is up to par with the requirements. |
| Technique | White Box and Black Box Testing performed. |
| Criteria | All Test Cases have been Executed & Passed.<br>All Severity Issues are Fixed & Closed.<br>Delivery of Test Summary Report.|
| Consideration |  |
| Testers | Student 1 & Student 2 |

### Non-Functional Testing
|  |  |
|:---|---|
| Objective | Evaluate the Non-Functional Attributes of the System. |
| Technique | Security, Performance, Stress & Load Testing the System. |
| Criteria | All Planned Tests have been executed & all issues have been found & exposed. |
| Consideration |  |
| Testers | Student 1 & Student 2 |

### Performance Testing
|  |  |
|:---|---|
| Objective | Identify Possible Bottlenecks & Performance Issues |
| Technique | Stress & Load Test will be executed using the SmartMeter.io tool for automated testing. |
| Criteria | The system has on-par Response Times consistently. |
| Consideration |  |
| Testers | Student 1 & Student 2 |
| Elements | Requirement 1: The Web-Server should be responsive under high loads. |

### Load Testing
|  |  |
|:---|---|
| Objective | Identify the Systems Responsiveness & Stability under different workloads. |
| Technique | Use Cases will be executed while using the jMeter tool for automated testing. |
| Criteria | All Planned Tests have been executed & all issues have been found & exposed. |
| Consideration |  |
| Testers | Student 1 & Student 2 |
| Elements | See Test Cases Documentation. |

### Stress Testing
|  |  |
|:---|---|
| Objective | Identify the Systems Responsiveness & Stability under abnormal workloads. |
| Technique | Use Cases will be executed while using the jMeter tool for automated testing. |
| Criteria | All Planned Tests have been executed & all issues have been found & exposed. |
| Consideration |  |
| Testers | Student 1 & Student 2 |
| Elements | See Test Cases Documentation. |

### Usability Testing
|  |  |
|:---|---|
| Objective | Evaluating the Accessibility & Convenience of the System. |
| Technique | Black Box Testing |
| Criteria | The Application is easy to use & all errors are diagnosed correctly. |
| Consideration |  |
| Testers | Student 1 & Student 2 |
| Elements | See Test Cases Documentation. |

### Security Testing
|  |  |
|:---|---|
| Objective | Evaluating the Vulnerability of the System. |
| Technique | Use Cases will be executed while using the Vega tool for automated testing. |
| Criteria | All Possible Tests have been executed & all issues have been found & exposed. |
| Consideration |  |
| Testers | Student 1 & Student 2 |
| Elements | See Test Cases Documentation. |

### Portability Testing
|  |  |
|:---|---|
| Objective | Evaluating the Reusability of the System between different Operating Systems. |
| Technique | Installing & Running the system on different Operating Systems such as Mac OSX, Windows & Linux. |
| Criteria | The Software runs as expected on all Required Operating Systems. |
| Consideration |  |
| Testers | Student 1 & Student 2 |
| Elements | Requirement 3: The Web-Server must work on Linux, Mac OSX & Windows (XP, Vista, 7, 8, 10, Server 2008). |

### Ad-Hoc Testing
|  |  |
|:---|---|
| Objective | Evaluating different aspects of the System. |
| Technique | Testing aspects that do not have Random Use Cases. |
| Criteria | The Software runs as expected on all Required Operating Systems. |
| Consideration | The success rates of these tests relies on the testers capabilities and the institution of the tester performing the tests. |
| Testers | Student 1 & Student 2 |
| Elements | Ad-Hoc (See Glossary). |

## Features to be Tested
- Minimum Requirements during High Load.
- Minimum Requirements for HTTP 1.1.
- Access to the Log.
- Server Multi-Platform Support.
- Open Source Code following the Licence GPL 2.0

## Features not to be Tested
N/A

## Prioritization
| Test Case | Name | Priority |
|:---|:---|---:|
| Test JUnit 1 | Integration | High |
| Test JUnit 2 | Response | High |
| Test JUnit 3 | View | High |
| Test JUnit 4 | Grouped | High |
| Test Server 1.1 | Start Server | High |
| Test Server 2.1 | Stop Server | High |
| Test Server 2.2 | Access Log is Written on Server Stop | High |
| Test Responsive 1 | High Load | High |
| Test Responsive 2 | High Load | High |
| Test Server 1.4 | Access Log Written | High |
| Test Resource 1 | HTTP 1.1 Status 200 | High |
| Test Resource 2 | HTTP 1.1 Status 400 | High |
| Test Resource 3 | HTTP 1.1 Status 403 | High |
| Test Resource 4 | HTTP 1.1 Status 404 | High |
| Test Resource 5 | HTTP 1.1 Status 405 | High |
| Test Operating System 1 | Test Operating System | High |
| Test Performance 1 | Test Performance | Medium |
| Test Acceptance 1 | Test Acceptance | Medium |
| Test Server 1.2 | Wrong Socket | Medium |
| Test Server 1.3 | Taken Socket | Medium |
| Test Vulnerability 1 | Vulnerability Check | Low |
| Test Browser 1 | Test Browser | Low |
| Test Licence 1 | Test GPL-2.0 License | Low |

## Traceability Matrix
### Requirements
| Identifiers | Tested | 1 | 2 UC1 | 2 UC2 | 2 UC3 | 3 | 4 | 5 |
|:---|:---:|:---:|:---:|:---:|:---:|:---:|:---:|:---:|
| <b>Test Case</b> | <b>23</b> | <b>5</b> | <b>9</b> | <b>6</b> | <b>9</b> | <b>8</b> | <b>3</b> | <b></b> |
| Test JUnit 1 | 1 | :black_medium_square: |   |   |   |   |   |   |
| Test JUnit 2 | 1 |   | :black_medium_square: | :black_medium_square: | :black_medium_square: |   |   |   |
| Test JUnit 3 | - |   |   |   |   |   |   |   |
| Test JUnit 4 | 1 |   | :black_medium_square: | :black_medium_square: | :black_medium_square: |   |   |   |
| Test Server 1.1 | 2 |   | :black_medium_square: |   |   | :black_medium_square: |   |   |
| Test Server 1.2 | 2 |   | :black_medium_square: |   |   | :black_medium_square: |   |   |
| Test Server 1.3 | 2 |   | :black_medium_square: |   |   | :black_medium_square: |   |   |
| Test Server 1.4 | 2 |   | :black_medium_square: |   |   |   |   | :black_medium_square: |
| Test Server 2.1 |   |   |   |   |   |   |   |   |
| Test Server 2.2 |   |   |   |   |   |   |   |   |
| Test Responsive 1 | 1 | :black_medium_square: |   |   |   |   |   |   |
| Test Responsive 2 | 1 | :black_medium_square: |   |   |   |   |   |   |
| Test Resource 1 | 1 |   |   |   | :black_medium_square: |   |   |   |
| Test Resource 2 | 1 |   |   |   | :black_medium_square: |   |   |   |
| Test Resource 3 | 1 |   |   |   | :black_medium_square: |   |   |   |
| Test Resource 4 | 1 |   |   |   | :black_medium_square: |   |   |   |
| Test Resource 5 | 1 |   |   |   | :black_medium_square: |   |   |   |
| Test Operating System 1 | 1 |   |   |   |   | :black_medium_square: |   |   |
| Test Performance 1 | 5 | :black_medium_square: | :black_medium_square: | :black_medium_square: | :black_medium_square: | :black_medium_square: | :black_medium_square: | :black_medium_square: | :black_medium_square: |
| Test Acceptance 1 | 5 | :black_medium_square: | :black_medium_square: | :black_medium_square: | :black_medium_square: | :black_medium_square: | :black_medium_square: | :black_medium_square: | :black_medium_square: |
| Test Vulnerability 1 | 1 |   | :black_medium_square: |   |   |   |   |   |   |
| Test Licence 1 | 1 |   | :black_medium_square: |   |   |   |   |   |   |   |
| Test Browser 1 |   |   |   |   |   |   |   |   |   |   |

## Test Environment
#### Web Server: 'MyWebServer'
| Operating System | Browser | Version | Bits |
|:---|:---|---:|---:|
| Windows 10               | Microsoft Edge  | 44.18362.449.0 | x64 |
|                          | Mozilla Firefox | 71             | x64 |
|                          | Google Chrome   | 79.0.3945.79   | x64 |
| Linux Ubuntu 18.04.3 LTS | Mozilla Firefox | 71             | x64 |
|                          | Google Chrome   | 79.0.3945.79   | x64 |
| Mac OS X High Sierra     | Safari          | 12             | x64 |
|                          | Mozilla Firefox | 71             | x64 |
|                          | Google Chrome   | 79.0.3945.79   | x64 |

#### Java Version: 1.8 & Java SE 13.0.1

## Responsibilities
### Manager
The Manager is responsible for Coordination, Communication with the Project Manager, Final Responsible for Documentation, Design & Evaluation of Tests.

### Tester
The Tester is responsible for designing and executing manual & automated tests as well as documenting results.

