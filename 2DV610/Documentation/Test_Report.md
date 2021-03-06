##### ![](https://mymoodle.lnu.se/pluginfile.php/1/theme_essential/logo/1573077602/lnu-logo.png)
# Test Report
## Table of Contents
- [Overview](#overview)
  * [Automated Tests](#automated-tests)
  * [Manual Tests](#manual-tests)
- [Assessment](#assessment)
  * [Automated Tests](#automated-tests-1)
    + [JUnit Tests](#junit-tests)
    + [Security Tests](#security-tests)
  * [Manual Tests](#manual-tests-1)
    + [Start Server](#start-server)
    + [Status Tests (JMeter)](#status-tests-jmeter)
    + [High Load](#high-load)
  * [Other Tests](#other-tests)
    + [Operating System](#operating-system)
    + [GPL-2.0 License](#gpl-20-license)
    + [Web-Browser](#web-browser)
    + [Performance](#performance)
    + [Acceptance](#acceptance)
- [Evaluation](#evaluation)

## Overview
### Automated Tests
| No. | Description | Operating System | Date | Status |
|:---|:---|:---|:---:|:---:|
| JUnit Test 1 | Integration | Windows | 2019-12-07 | :heavy_check_mark: |
| JUnit Test 2 | Response | Windows | 2019-12-07 | :heavy_check_mark: |
| JUnit Test 3 | View | Windows | 2019-12-07 | :x: |
| JUnit Test 4 | Grouped | Windows | 2019-12-07 | :heavy_check_mark: |
| Vulnerability Test 1 | Vulnerability Check | Windows | 2019-12-07 | :x: |

### Manual Tests
| No. | Description | Operating System | Date | Status |
|:---|:---|:---|:---:|:---:|
| Server Test 1.1 | Start Server | Windows | 2019-12-07 | :heavy_check_mark: |
| Server Test 1.2 | Wrong Socket | Windows | 2019-12-08 | :heavy_check_mark: |
| Server Test 1.3 | Taken Socket | Windows | 2019-12-08 | :heavy_check_mark: |
| Server Test 1.4 | Access Log Written | Windows | 2019-12-08 | :x: |
| Server Test 2.1 | Stop Server | Windows | 2019-12-08 | :heavy_check_mark: |
| Server Test 2.2 | Access Log Written on Server Stop | Windows | 2019-12-09 | :x: |
| Resource Test 1 | HTTP 1.1 Status 200 | Windows | 2019-12-09 | :heavy_check_mark: |
| Resource Test 2 | HTTP 1.1 Status 400 | Windows | 2019-12-09 | :heavy_check_mark: |
| Resource Test 3 | HTTP 1.1 Status 403 | Windows | 2019-12-09 | :heavy_check_mark: |
| Resource Test 4 | HTTP 1.1 Status 404 | Windows | 2019-12-09 | :heavy_check_mark: |
| Resource Test 5 | HTTP 1.1 Status 405 | Windows | 2019-12-09 | :heavy_check_mark: |
| Responsive Test 1 | High Load (1 000 users) | Windows | 2019-12-10 | :heavy_check_mark: |
| Responsive Test 2 | High Load (50 000 users) | Windows | 2019-12-10 | :heavy_check_mark: |
| Operating System Test 1 | Test Operating System | Windows, Linux, Mac OS X | 2019-12-10 | :x: |
| License Test 1 | Test GPL-2.0 License | Windows | 2019-12-10 | :x: |
| Browser Test 1 | Test Browser | Windows | 2019-12-10 | :heavy_check_mark: |
| Performance Test 1 | Test Performance | Windows | 2019-12-10 | :x: |
| Acceptance Test 1 | Test Acceptance | Windows | 2019-12-10 | :heavy_check_mark: |

## Assessment
### Automated Tests
#### JUnit Tests
| No. | Description |
|:---|:---|
| Test JUnit 1 | Integration |
| Requirement | Req 1: The web server should be responsive under high load. |
| Use Case | - |
| Expected Result | All tests pass. |
| Result | One JUnit test fails & output in console:<br>‘fails 0<br>oks:2411<br>exceptions: 0<br>total 2411’ |
| Status | :heavy_check_mark: Passed |

| No. | Description |
|:---|:---|
| Test JUnit 2 | Response |
| Requirement | Req 2: The web server must follow minimum requirements for HTTP 1.1 |
| Use Case | - |
| Expected Result | All tests pass. |
| Result | All tests pass. |
| Status | :heavy_check_mark: Passed |

| No. | Description |
|:---|:---|
| Test JUnit 3 | View |
| Requirement | - |
| Use Case | - |
| Expected Result | All tests pass. Console shows expected results from Server. |
| Result | Fails when port is taken.<br>Result: \<Port is taken\[\]\> but was \<Port is taken \[\]\><br>Automated Test Package:’ tests/se/lnu/http/view’ |
| Status | :x: Failed |

| No. | Description |
|:---|:---|
| Test JUnit 4 | Grouped |
| Requirement | - |
| Use Case | - |
| Expected Result | All tests pass. |
| Result | All tests pass. |
| Status | :heavy_check_mark: Passed |

#### Security Tests
| No. | Description |
|:---|:---|
| Vulnerability Test 1 | Vulnerability Check |
| Requirement | - |
| Use Case | UC1 Start Server |
| Expected Result | No vulnerabilities. |
| Result | No specified charset(UTF-8) within the response header/body was found. |
| Status | :x: Failed |

### Manual Tests
#### Start Server
| No. | Description |
|:---|:---|
| Server Test 1.1 | Start Server |
| Requirement | Req 3: The web server must work on Linux, Mac, Windows*. |
| Use Case | UC1 Start Server |
| Expected Result | ‘HTTP Server Started’ is displayed in Terminal Window.<br>‘It works’ is shown in Web-Page (localhost:1091) |
| Result | ‘HTTP Server Started’ is displayed in Terminal Window.<br>‘It works’ is shown in Web-Page (localhost:1091) |
| Status | :heavy_check_mark: Passed |

| No. | Description |
|:---|:---|
| Server Test 1.2 | Wrong Socket |
| Requirement | Req 3: The web server must work on Linux, Mac, Windows*. |
| Use Case | UC1 Start Server |
| Expected Result | 'Enter a valid port 1-65535 and an optional URL’ is displayed in Terminal Window. |
| Result | 'Enter a valid port 1-65535 and an optional URL’ is displayed in Terminal Window. |
| Status | :heavy_check_mark: Passed |

| No. | Description |
|:---|:---|
| Server Test 1.3 | Taken Socket |
| Requirement | Req 3: The web server must work on Linux, Mac, Windows*. |
| Use Case | UC1 Start Server |
| Expected Result | 'Port is taken’ is displayed in Console Window. |
| Result | 'Port is taken’ is displayed in Console Window. |
| Status | :heavy_check_mark: Passed |

| No. | Description |
|:---|:---|
| Server Test 1.4 | Access Log Written |
| Requirement | Req 5: The access log should be viewable from a text editor. |
| Use Case | UC1 Start Server |
| Expected Result | Access Log is Created & is viewable in a Text-Editor (i.e Notepad). |
| Result | Access Log is not Created & No error message is displayed in the Console Window. |
| Status | :x: Failed |

| No. | Description |
|:---|:---|
| Server Test 2.1 | Stop Server |
| Requirement | Req 3: The web server must work on Linux, Mac, Windows*. |
| Use Case | UC2 Stop Server |
| Expected Result | ‘HTTP Server Stopped’ is displayed in Terminal Window.<br>Web-Page no longer loads  (localhost:1091). |
| Result | ‘HTTP Server Stopped’ is displayed in Terminal Window.<br>Web-Page no longer loads  (localhost:1091) |
| Status | :heavy_check_mark: Passed |

| No. | Description |
|:---|:---|
| Server Test 2.2 | Access Log Written on Server Stop |
| Requirement | Req 5: The access log should be viewable from a text editor. |
| Use Case | UC2 Stop Server |
| Expected Result | Access Log is written & is viewable in a Text-Editor (i.e Notepad). |
| Result | Access Log is not Created & No notification message (like ‘HTTP Server Stopped’  is displayed in the Console Window. |
| Status | :x: Failed |

#### Status Tests (JMeter)
| No. | Description |
|:---|:---|
| Resource Test 1 | HTTP 1.1 Status 200 |
| Requirement | Req 2: The web server must follow minimum requirements for HTTP 1.1 |
| Use Case | UC3 Request Shared Resource |
| Expected Result | ‘Response Code 200’ |
| Result | ‘Response Code 200’ |
| Status | :heavy_check_mark: Passed |

| No. | Description |
|:---|:---|
| Resource Test 2 | HTTP 1.1 Status 400 |
| Requirement | Req 2: The web server must follow minimum requirements for HTTP 1.1 |
| Use Case | UC3 Request Shared Resource |
| Expected Result | ‘Response Code 400’ |
| Result | ‘Response Code 400’ |
| Status | :heavy_check_mark: Passed |

| No. | Description |
|:---|:---|
| Resource Test 3 | HTTP 1.1 Status 403 |
| Requirement | Req 2: The web server must follow minimum requirements for HTTP 1.1 |
| Use Case | UC3 Request Shared Resource |
| Expected Result | ‘Response Code 403’ |
| Result | ‘Response Code 403’ |
| Status | :heavy_check_mark: Passed |

| No. | Description |
|:---|:---|
| Resource Test 4 | HTTP 1.1 Status 404 |
| Requirement | Req 2: The web server must follow minimum requirements for HTTP 1.1 |
| Use Case | UC3 Request Shared Resource |
| Expected Result | ‘Response Code 404’ |
| Result | ‘Response Code 404’ |
| Status | :heavy_check_mark: Passed |

| No. | Description |
|:---|:---|
| Resource Test 5 | HTTP 1.1 Status 405 |
| Requirement | Req 2: The web server must follow minimum requirements for HTTP 1.1 |
| Use Case | UC3 Request Shared Resource |
| Expected Result | ‘Response Code 405’ |
| Result | ‘Response Code 405’ |
| Status | :heavy_check_mark: Passed |

#### High Load
| No. | Description |
|:---|:---|
| Responsive Test 1 | High Load (1 000 users) |
| Requirement | Req 1: The web server should be responsive under high load. |
| Use Case | - |
| Expected Result | Server is Responsive | 
| Result | Server is Responsive |
| Status | :heavy_check_mark: Passed |

| No. | Description |
|:---|:---|
| Responsive Test 2 | High Load (50 000 users) |
| Requirement | Req 1: The web server should be responsive under high load. |
| Use Case | - |
| Expected Result | Server is Responsive | 
| Result | Server is Responsive |
| Status | :heavy_check_mark: Passed |

### Other Tests
#### Operating System
| No. | Description |
|:---|:---|
| Operating System Test 1 | Test Operating Systems |
| Requirement | Req 3. The web server must work on Linux, Mac, Windows*. |
| Use Case | - |
| Expected Result | The Server should work on all Operating Systems (Linux, Mac OS X & Windows) |
| Result | Majority of tests were carried out by Windows users therefore this result is not sufficient to grant a Status of Pass.<br>However with some more hours of work we could probably give a Status of Pass. |
| Status | :x: Not Applicable |

#### GPL-2.0 License
| No. | Description |
|:---|:---|
| License Test 1 | Test GPL-2.0 License |
| Requirement | Req 4: The source code should be released under GPL-2.0. |
| Use Case | - |
| Expected Result | The Server is licensed under GPL-2.0 License. |
| Result | The Server is licensed under the MIT license.<br>A GPL-2.0 License requires you to make your source-code Open Source. However a MIT License does not. |
| Status | :x: Failed |

#### Web-Browser
| No. | Description |
|:---|:---|
| Browser Test 1 | Test Browser |
| Requirement | - |
| Use Case | - |
| Expected Result | ‘It works’ is displayed on all Web-Browsers. |
| Result | ‘It works’ is displayed on all Web-Browsers. |
| Status | :heavy_check_mark: Passed |

#### Performance
| No. | Description |
|:---|:---|
| Performance Test 1 | Test Performance |
| Requirement | - |
| Use Case | - |
| Expected Result | All Tests Pass. |
| Result | Zero Tests Passed. |
| Status | :x: Failed |

#### Acceptance
| No. | Description |
|:---|:---|
| Acceptance Test 1 | Test Acceptance |
| Requirement | - |
| Use Case | - |
| Expected Result | All Tests Pass. |
| Result | Majority of Tests Pass. |
| Status | :heavy_check_mark: Passed |

## Evaluation
In the current state of the Software the Web-Server (‘MyWebServer’) would not be fit for redistribution according to SDCs desires. The majority of Tests concluded passed, however, the ones that failed are too important to the Software as a whole & therefore it would be too costly for SDC or the Client to repair the software before using. This is why we can not recommend further development on this software, with exception to a side-project between larger contracts (Assuming your company is Contract Based).

Since the software does not use the GPL-2.0 License & rather the MIT License it would require all of the source code to be distributed or available for all clients & they would also be free to do whatever they desire with the software. I.E redistribute your work as their own under the ‘MyWebServer’ MIT license agreement.

Furthermore, the ‘MyWebServer’ does not provide all of the required Access Log debugging notifications for a stable release of the software as it is critical to include at minimum a ‘HTTP Server Started’ & ‘HTTP Server Stopped’ in the Logs. Since Server Stopped notifications are not displayed it is very probable that there are many more notifications missing in the current build of the Source Code.

Finally, we had access to all three listed Operating Systems for Testing this Software, however, we were unable to do the testing on these machines due to time-constraints from Personal Issues. This also influences our evaluation to discourage the use of this Software.
