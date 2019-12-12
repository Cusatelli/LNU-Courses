# Test Cases
## Overview
| No. | Requirements | Use Case | Test Case | Name | Type |
|:---:|:---:|:---:|:---|:---|:---:|
| 1 | 1 | - | JUnit Test 1 | Integration | A |
| 2 | 2 | - | JUnit Test 2 | Response | A |
| 3 | - | - | JUnit Test 3 | View | A |
| 4 | - | - | JUnit Test 4 | Grouped | A |
| 5 | 3 | 1 | Test Server 1.1 | Start Server | M |
| 6 | 3 | 1 | Test Server 1.2 | Wrong Socket | M |
| 7 | 3 | 1 | Test Server 1.3 | Taken Socket | M |
| 8 | 5 | 1 | Test Server 1.4 | Access Log Written | M |
| 9 | 3 | 2 | Test Server 2.1 | Stop Server | M |
| 10 | 5 | 2 | Test Server 2.2 | Access Log Written on Server Stop | M |
| 11 | 2 | 3 | Test Resource 1 | HTTP 1.1 Status 200 | M |
| 12 | 2 | 3 | Test Resource 2 | HTTP 1.1 Status 400 | M |
| 13 | 2 | 3 | Test Resource 3 | HTTP 1.1 Status 403 | M |
| 14 | 2 | 3 | Test Resource 4 | HTTP 1.1 Status 404 | M |
| 15 | 2 | 3 | Test Resource 5 | HTTP 1.1 Status 405 | M |
| 16 | 1 | - | Test Responsive 1 | High Load (1 000 Users) | M |
| 17 | 1 | - | Test Responsive 2 | High Load (50 000 Users) | M |
| 18 | 4 | - | Test License 1 | GPL-2.0 License | M |
| 19 | 3 | - | Test Operating System 1 | Operating System | M |
| 20 | - | 1 | Test Vulnerability 1 | Vulnerability Check | A |
| 21 | - | - | Test Browser 1 | Browser | M |
| 22 | - | - | Test Performance 1 | Performance | M |
| 23 | - | - | Test Acceptance 1 | Acceptance | A/M |

## JUnit Tests
### Integration
| JUnit Test 1 | Integration |
|---|---|
| Requirement | Req 1: The Web-Server should be responsive under High Load. |
| Use Case | - |
| Scenario | Confirm that pre-existing JUnit Tests are functioning. |
| Precondition | Server is running. |
| Test Steps | Run the Integration package as JUnit Test. |
| Expected Results | All tests pass with a print out in console which says how many times the server has been created successfully, failed or throws an Exception. |
| Comments | Automated Test Package Location: ‘<i>tests/se/lnu/http/integration</i>’. |

### Response
| JUnit Test 2 | Response |
|---|---|
| Requirement | Req 2: The Web-Server must follow minimum requirements for HTTP 1.1. |
| Use Case | - |
| Scenario | Confirm that pre-existing JUnit Tests are functioning. |
| Precondition | Server is running. |
| Test Steps | Run the Response package as JUnit Test. |
| Expected Results | All tests pass. Response status should work as intended. |
| Comments | Automated Test Package Location: ‘<i>tests/se/lnu/http/response</i>’. |

### View
| JUnit Test 3 | View |
|---|---|
| Requirement | - |
| Use Case | - |
| Scenario | Confirm that pre-existing JUnit Tests are functioning & test if console logs expected values from the Server. |
| Precondition | Server is running. |
| Test Steps | Run the view package as JUnit Test. |
| Expected Results | All tests pass. Console displays expected values from server. |
| Comments | Automated Test Package Location: ‘<i>tests/se/lnu/http/view</i>’. |

### Grouped
| JUnit Test 4 | Grouped |
|---|---|
| Requirement | - |
| Use Case | - |
| Scenario | A Group of Automated Tests confirming the functionality of pre-existing JUnit Tests. |
| Precondition | Server is running. |
| Test Steps | Run the ‘<i>se.lnu.http</i>’ package as JUnit Test. |
| Expected Results | All tests pass. |
| Comments | Automated Test Package Location: ‘<i>tests/se/lnu/http</i>’. |

## UC1: Start Server
### Starting Server
| Server Test 1.1 | Start Server |
|---|---|
| Requirement | Req 3: The Web-Server must work on Linux, Mac, Windows*. |
| Use Case | UC1: Start Server |
| Scenario | The Server should always start on all Operating Systems. |
| Precondition | Server is offline. |
| Test Steps | <ol><li> Administrator launches Terminal.</li><li> Navigate to the directory where the .jar file is located.</li><li> Input: ‘java -jar MyWebServer.jar PortSocket SharedResource’<br>Press: ‘Enter’</li><li> Open prefered web-browser.</li><li> Enter: ‘localhost:9000’<br>Press: ‘Enter’</li></ol> |
| Expected Results | ‘HTTP Server Started’ is displayed in the Terminal Window.<br>‘It works’ is displayed within the web page ‘localhost:9000’ |
| Alternate Scenario | <ol><li> The web server could not be started due to socket was taken<ol><li>System presents an error message: “Socket XX was taken” (XX is the socket number, Example “80”)</li><li>Exit Use Case</li></ol></li><li>The web server could not be started due restriction on the shared resource container<ol><li>System presents an error message: “No access to folder XX” (XX is the shared resource container provided, Example “\var\www”)</li><li>Exit Use Case</li></ol></li><li> The access log could not be written to<ol><li>System presents an error message. “Cannot write to server log file log.txt”</li><li>Exit Use Case</li></ol></li></ol> |
| Comments | PortSocket: 1091<br>SharedResource: ~/Github/LNU-Courses/2DV610/MyWebServer/tests/se/lnu/http/resources/inner |

### Wrong Socket
| Server Test 1.2 | Wrong Socket |
|---|---|
| Requirement | Req 3: The Web-Server must work on Linux, Mac, Windows*. |
| Use Case | UC1: Start Server |
| Scenario | The Server should show an error message if a wrong port socket is entered. |
| Precondition | Server is offline. |
| Test Steps | <ol><li>Administrator launches Terminal.</li><li>Navigate to the directory where the .jar file is located.</li><li>Input: ‘java -jar MyWebServer.jar PortSocket SharedResource’<br>Press: ‘Enter’</li></ol> |
| Expected Results | ‘Enter a valid port 1-65535 and an optional URL’ is displayed in the Terminal Window. |
| Alternate Scenario | <ol><li>The Web-Server successfully starts<ol><li>System presents ‘HTTP Server started’</li><li>Exit Test Case</li></ol></li></ol> |
| Comments | PortSocket: 1091<br>SharedResource: ~/Github/LNU-Courses/2DV610/MyWebServer/tests/se/lnu/http/resources/inner |

### Taken Socket
| Server Test 1.3 | Taken Socket |
|---|---|
| Requirement | Req 3: The Web-Server must work on Linux, Mac, Windows*. |
| Use Case | UC1: Start Server |
| Scenario | The Server should show an error message if a taken port socket is entered. |
| Precondition | Server is offline. | 
| Test Steps | <ol><li>Administrator launches IDE (i.e. Eclipse 2019.2).</li><li>Enter Arguments: ‘PortSocket SharedResource’ in Run Configurations.</li><li>Run HTTPServerConsole.</li><li>Repeat step 3 once.</li></ol> |
| Expected Results | ‘Port is taken’ is displayed in the Terminal Window. |
| Alternate Scenario | <ol><li>The Web-Server successfully starts<ol><li>System presents ‘HTTP Server started’</li><li>Exit Test Case</li></ol></li></ol> |
| Comments | PortSocket: 1091<br>SharedResource: ~/Github/LNU-Courses/2DV610/MyWebServer/tests/se/lnu/http/resources/inner |

### Access Log Written
| Server Test 1.4 | Access Log Written |
|---|---|
| Requirement | Req 5: The access log should be viewable from a text editor. |
| Use Case | UC1: Start Server |
| Scenario | When a Request is sent to the Server a notification is displayed in the access log. |
| Precondition | Server is running. |
| Test Steps | <ol><li>Send request to server.</li><li>Notification is displayed in the Access Log.</li><li>Access Log is accessible within a Text Editor (i.e NotePad).</li></ol> |
| Expected Results | Log is created. The Access Log is viewable within a Text Editor (i.e NotePad). |
| Alternate Scenario | <ol><li>Access Log is not created.</li><li>Access Log is created but no notifications are displayed.</li></ol> |
| Comments | PortSocket: 1091<br>SharedResource: ~/Github/LNU-Courses/2DV610/MyWebServer/tests/se/lnu/http/resources/inner |
