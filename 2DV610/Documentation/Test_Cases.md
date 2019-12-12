##### ![](https://mymoodle.lnu.se/pluginfile.php/1/theme_essential/logo/1573077602/lnu-logo.png)
# Test Cases
## Table of Contents
- [Overview](#overview)
- [Junit Tests](#junit-tests)
  * [Integration](#integration)
  * [Response](#response)
  * [View](#view)
  * [Grouped](#grouped)
- [UC1: Start Server](#uc1-start-server)
  * [Starting Server](#starting-server)
  * [Wrong Socket](#wrong-socket)
  * [Taken Socket](#taken-socket)
  * [Access Log Written](#access-log-written)
- [UC2: Stop Server](#stop-server)
  * [Access Log Written on Stop](#access-log-written-on-stop)
- [UC3: Request Shared Resource (Req. 2)](#uc3-request-shared-resource-req-2)
  * [HTTP 1.1 Status](#http-11-status)
- [Requirement 1: Responsive Server under High Load (JMeter)](#requirement-1-responsive-server-under-high-load-jmeter)
  * [High Loads](#high-loads)
- [Requirement 3: Operating System](#requirement-3-operating-system)
  * [Operating System](#operating-system)
- [Requirement 4: GPL-2.0 License](#requirement-4-gpl-20-license)
  * [GPL-2.0 License](#gpl-20-license)
- [Additional Tests](#additional-tests)
  * [Vulnerability](#vulnerability)
  * [Browser](#browser)
  * [Performance](#performance)
  * [Acceptance](#acceptance)


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

## UC2: Stop Server
### Stop Server
| Server Test 2.1 | Stop Server |
|---|---|
| Requirement | Req 3: The Web-Server must work on Linux, Mac, Windows*. |
| Use Case | UC2: Stop Server |
| Scenario | The System stops the Web-Server & Displays that the webserver has been stopped. |
| Precondition | Server is offline. |
| Test Steps | <ol><li>Administrator launches Terminal.</li><li>Navigate to the directory where the .jar file is located.</li><li>Input: ‘java -jar MyWebServer.jar PortSocket SharedResource’<br>Press: ‘Enter’</li><li>Open prefered web-browser.</li><li>Enter: ‘localhost:9000’<br>Press: ‘Enter’</li><li>Input: ‘stop’ in the Terminal<br>Press: ‘Enter’</li></ol> |
| Expected Results | ‘HTTP Server Stopped’ is displayed in the Terminal Window.<br>Web-Page no longer loads. |
| Alternate Scenario | <ol><li>The web server does not Stop.<ol><li>System is still running.</li><li>Exit Test Case.</li></ol></li></ol> |
| Comments | PortSocket: 1091<br>SharedResource: ~/Github/LNU-Courses/2DV610/MyWebServer/tests/se/lnu/http/resources/inner |

### Access Log Written on Stop
| Server Test 2.2 | Access Log Written on Stop |
|---|---|
| Requirement | Req 5: The access log should be viewable from a text editor. |
| Use Case | UC2: Stop Server |
| Scenario | When the server has stopped notification is displayed in the access log. |
| Precondition | Server is running. |
| Test Steps | <ol><li>Input: ‘stop’ in the Terminal Window.<br>Press: ‘Enter’.</li><li>Notification is displayed in the Access Log.</li><li>Access Log is accessible within a Text Editor (i.e NotePad).</li></ol> |
| Expected Results | ‘HTTP Server Stopped’ is displayed in the Terminal Window. |
| Alternate Scenario | <ol><li>The Server does not stop.<ol><li>System is still running.</li><li>Exit Test Case.</li></ol><li>Access Log is created but no notifications are displayed.</li></ol>
| Comments | PortSocket: 1091<br>SharedResource: ~/Github/LNU-Courses/2DV610/MyWebServer/tests/se/lnu/http/resources/inner<br><br>No Log File was created... |

## UC3: Request Shared Resource (Req. 2)
### HTTP 1.1 Status
| Resource Test 1 | HTTP 1.1 Status 200 |
|---|---|
| Requirement | Req 2: The web server must follow minimum requirements for HTTP 1.1 |
| Use Case | UC3: Request Shared Resource |
| Scenario | The Web Server should be able to respond to HTML & Status Code 200. |
| Precondition | Server is running on port 1091. |
| Test Steps | <ol><li>HTTP Request Get: /index.html</li><li>Execute Test.</li></ol> |
| Expected Results | Web Server responds with status code 200. |
| Alternate Scenario | <ol><li>The web Server responds with a different status code.<ol><li>Exit Test Case.</li></ol></li></ol> |
| Comments | Tested with JMeter:<br>:heavy_check_mark: Response Result: 200 |

| Resource Test 2 | HTTP 1.1 Status 400 |
|---|---|
| Requirement | Req 2: The web server must follow minimum requirements for HTTP 1.1 |
| Use Case | UC3: Request Shared Resource |
| Scenario | The Web Server should be able to respond to HTML & Status Code 400. |
| Precondition | Server is running on port 1091. |
| Test Steps | <ol><li>HTTP Request Get: /index.html</li><li>Enter: ‘fml’ in body of html.</li><li>Execute Test.</li></ol> |
| Expected Results | Web Server responds with status code 400. |
| Alternate Scenario | <ol><li>The web Server responds with a different status code.<ol><li>Exit Test Case.</li></ol></li></ol> |
| Comments | Tested with JMeter:<br>:x: Response Result: 400 - Bad Request |

| Resource Test 3 | HTTP 1.1 Status 403 |
|---|---|
| Requirement | Req 2: The web server must follow minimum requirements for HTTP 1.1 |
| Use Case | UC3: Request Shared Resource |
| Scenario | The Web Server should be able to respond to HTML & Status Code 403. |
| Precondition | Server is running on port 1091. |
| Test Steps | <ol><li>HTTP Request Get: /../secret.html</li><li>Execute Test.</li></ol> |
| Expected Results | Web Server responds with status code 403. |
| Alternate Scenario | <ol><li>The web Server responds with a different status code.<ol><li>Exit Test Case.</li></ol></li></ol> |
| Comments | Tested with JMeter:<br>:x: Response Result: 403 - Forbidden |

| Resource Test 4 | HTTP 1.1 Status 404 |
|---|---|
| Requirement | Req 2: The web server must follow minimum requirements for HTTP 1.1 |
| Use Case | UC3: Request Shared Resource |
| Scenario | The Web Server should be able to respond to HTML & Status Code 404. |
| Precondition | Server is running on port 1091. |
| Test Steps | <ol><li>HTTP Request Get: /imaginary.fml</li><li>Execute Test.</li></ol> |
| Expected Results | Web Server responds with status code 404. |
| Alternate Scenario | <ol><li>The web Server responds with a different status code.<ol><li>Exit Test Case.</li></ol></li></ol> |
| Comments | Tested with JMeter:<br>:x: Response Result: 404 - Not Found |

| Resource Test 5 | HTTP 1.1 Status 405 |
|---|---|
| Requirement | Req 2: The web server must follow minimum requirements for HTTP 1.1 |
| Use Case | UC3: Request Shared Resource |
| Scenario | The Web Server should be able to respond to HTML & Status Code 405. |
| Precondition | Server is running on port 1091. |
| Test Steps | <ol><li>HTTP Request IMAGINARY: /index.html</li><li>Execute Test.</li></ol> |
| Expected Results | Web Server responds with status code 405. |
| Alternate Scenario | <ol><li>The web Server responds with a different status code.<ol><li>Exit Test Case.</li></ol></li></ol> |
| Comments | Tested with JMeter:<br>:x: Response Result: 405 - Method Not Supported |

## Requirement 1: Responsive Server under High Load (JMeter)
### High Loads
| Response Test 1 | High Load |
|---|---|
| Requirement | Req 1: The web server should be responsive under high load. |
| Use Case | - |
| Scenario | The Web Server should be able to respond under High Loads. |
| Precondition | Server is running on port 1091. |
| Test Steps | <ol><li>Create 1000 Thread Group Users.</li><li>Set Loop Count to 1.</li><li>Execute Test.</li></ol> |
| Expected Results | The Web-Server is still Responsive. |
| Alternate Scenario | <ol><li>The Server is not responsive under high loads.<ol><li>Long Response Time</li><li>Error Messages are displayed.</li></ol></li></ol> |
| Comments | Tested with JMeter. |

| Response Test 2 | High Load |
|---|---|
| Requirement | Req 1: The web server should be responsive under high load. |
| Use Case | - |
| Scenario | The Web Server should be able to respond under High Loads. |
| Precondition | Server is running on port 1091. |
| Test Steps | <ol><li>Create 100 Thread Group Users.</li><li>Set Loop Count to 500.</li><li>Execute Test.</li></ol> |
| Expected Results | The Web-Server is still Responsive. |
| Alternate Scenario | <ol><li>The Server is not responsive under high loads.<ol><li>Long Response Time</li><li>Error Messages are displayed.</li></ol></li></ol> |
| Comments | Tested with JMeter. |

## Requirement 3: Operating System
### Operating System
| Operating System Test 1 | Test Operating System |
|---|---|
| Requirement | Req 3: The web server must work on Linux, Mac, Windows*. |
| Use Case | - |
| Scenario | Test the Web-Server on three different environments, using Linux, Mac OS X & Windows Operating Systems. |
| Precondition | Access to all three Operating Systems. |
| Test Steps | <ol><li>Install & Run the Web-Server on Windows.</li><li>Install & Run the Web-Server on Linux.</li><li>Install & Run the Web-Server on Mac OS X.</li><li>Exit Test Case.</li></ol> |
| Expected Results | The Web-Server works on all Operating Systems. |
| Comments | <b>Work in Progress…</b> |

## Requirement 4: GPL-2.0 License
### GPL-2.0 License
| License Test 1 | Test GPL-2.0 License |
|---|---|
| Requirement | Req 4: The source code should be released under GPL-2.0. |
| Use Case | - |
| Scenario | The Web-Server should be under a GPL-2.0 Open Source License. |
| Precondition | - |
| Test Steps | <ol><li>Check ReadMe file documentation.</li><li>Check the GPL-2.0 License of the Web-Server.</li><li>Exit Test Case.</li></ol> |
| Expected Results | The Web-Server is GPL-2.0 Licensed. |
| Comments |  |

## Additional Tests
### Vulnerability
| Vulnerability Test 1 | Vulnerability Check |
|---|---|
| Requirement | - |
| Use Case | UC1: Start Server |
| Scenario | The Web-Server Should pass a minimum Vulnerability Check during Server Startup. |
| Precondition | Server is online. |
| Test Steps | <ol><li>Start Server.</li><li>Select a URL with the 1091 Port.</li><li>Execute Test.</li></ol> |
| Expected Results | No Vulnerabilities are found. |
| Comments | Tested with Vega. |

### Browser
| Browser Test 1 | Test Browser |
|---|---|
| Requirement | - |
| Use Case | - |
| Scenario | The Web-Server Should be accessible through multiple web-browsers. |
| Precondition | Server is online. |
| Test Steps | <ol><li>Go to: ‘localhost:9091’ using:<ul><li>Microsoft Edge v.44.18362.449.0 (64-bit).</li><li>Google Chrome v.79.0.3945.79 (64-bit).</li><li>Mozilla Firefox v.71 (64-bit).</li><li>Safari v.12 (64-bit).</li></ul></li></ol> |
| Expected Results | ‘It works’ is displayed in each web-browser when run. |
| Comments |


### Performance
| Performance Test 1 | Test Performance |
|---|---|
| Requirement | - |
| Use Case | - |
| Scenario | The Web-Server Should respond during a performance test. |
| Precondition | Server is online. |
| Test Steps | <ol><li>Start Server.</li><li>Select a URL with the 1091 Port.</li><li>Run SmartMeter.io test.</li><li>Wait for Results...</li></ol> |
| Expected Results | The Server is Responsive. |
| Alternate Scenario | <ol><li>The server is not responsive.<ol><li>Error Messages is displayed.</li></ol></li></ol> |
| Comments | Tested with SmartMeter.io. |

### Acceptance
| Acceptance Test 1 | Test Acceptance |
|---|---|
| Requirement | - |
| Use Case | - |
| Scenario | The Web-Server is tested & ready for release. |
| Precondition | - |
| Test Steps | <ol><li>Run JUnit Tests.</li><li>Run Manual Tests.</li></ol> |
| Expected Results | All Tests Pass. |
| Comments |  |
