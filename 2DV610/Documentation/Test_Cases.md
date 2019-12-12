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
