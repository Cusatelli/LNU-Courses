# Test Report
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
