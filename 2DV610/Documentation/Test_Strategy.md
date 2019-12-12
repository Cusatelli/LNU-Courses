##### ![](https://mymoodle.lnu.se/pluginfile.php/1/theme_essential/logo/1573077602/lnu-logo.png)

# Test Strategy
## Table of Contents
- [Objective](#objective)
- [Stakeholders](#stakeholders)
- [Resources](#resources)
  * [Hardware](#hardware)
  * [Software](#software)
    + [Integrated Drive Electronics (IDE)](#integrated-drive-electronics-ide)
    + [Testing](#testing)
- [Roles](#roles)
  * [Manager](#manager)
  * [Testers](#testers)
  * [Constraints](#constraints)
- [Strategy](#strategy)
  * [Testing](#testing-1)
    + [Manual](#manual)
    + [Automated](#automated)
- [Risks](#risks)
- [Milestones](#milestones)
- [Package](#package)
  
## Objective
The objective of the Test Strategy documentation is to define a strategy for evaluating the current state of a Web-Server
(“MyWebServer”) Application. The aim is to provide an estimation of how well suited this deprecated software is to use,
with minimal configurations to the source code & how easy it is to integrate with current modern day systems, in its current state.

## Stakeholders
A small Software Development Company (SDC).
“[...] SDC aims to redistribute this server on a wide range of Internet Of Things (IOT) to present information from sensors etc. 
SDC wants an easy to deploy java-web-server that can be deployed on many different devices and therefore that can attract attention 
of a wide range of IOT developers. IOT-developers want minimal configuration as well as easy integration and adaptation of the 
web-server. [...]” 

- [Software Testing Assignment 2: Scenario](https://coursepress.lnu.se/kurs/mjukvarutestning/labs/a2/)

## Resources
### Hardware
| Developer ID | Unit ID | Operating System | Hardware |
|---|---|---|---|
| 1 | 1 | Windows 10<br>64-bit Operating System<br>x64-based processor | HP Pavilion x360 Convertible 14-dh1xxx<br>Intel(R) Core(™) i5-10210U CPU @ 1.60GHz 2.11GHz<br>16GB RAM (15.8GB usable)<br>Intel(R) UHD Graphics (Integrated) |
|   | 2 | Windows 10<br>64-bit Operating System<br>x64-based processor | - |
|   | 3 | Linux<br>Ubuntu 18.04.3 LTS<br>64-bit Operating System<br>GNOME 3.28.2 | Lenovo Thinkpad T510<br>Intel(R) Core(™) i5-M520 CPU @ 2.40GHz x4<br>2.8GB RAM<br>Intel(R) Ironlake Mobile (Integrated) |
|   | 4 | Mac OS X High Sierra | - |
| 2 | 5 | - | - |

## Software
| Name | Version |
|---|---|
| JMeter | - |
| SmartMeter.io | - |
| Postman | - |
| CURL | - |

### Integrated Drive Electronics (IDE)
| Name | Version |
|---|---|
| Eclipse | 2019.2 |

### Testing
| Name | Version |
|---|---|
| JUnit | 5 |
| Mockito | 1.9.5 |
| Vega | - |

## Roles
In this section it is described which participants of the testing team performed which roles & what these roles might involve.

### Manager
The Managers responsibility is Test Planning & Development Test Cases. They are also responsible for prioritizing Test Cases and writing the documentation.

### Testers
Testers are responsible for test implementation and test execution. Both manual and automated testing falls within this responsibility. Though the Manager is responsible for the documentation the Testers are also required to participate in the creation of the Test Plan and communication with all team members.

### Constraints
The major constraints of this project is the current Time Budget of 40 hours per week, per participant. This amounts to approximately 320 total hours between all participants during the upcoming 4 weeks of development.

## Strategy
### Testing
#### Manual
- Test Objective: Execute Test Cases without utilizing any computerization devices.
- Approach: Iterates through all Test Cases.
- Criteria: Detect flaws and document them.
#### Automated
- Test Objective: Detect bugs, fails & errors through automation.
- Approach: Execute Tests with automated tools.
- Criteria: Detect flaws and document them.

## Risks
| No. | Risk | Mitigation | Impact |
|---|---|---|---|
| 1 | Connection Loss | Stable Internet Connection | High |
| 2 | Security Breach | Data Encryption | High |
| 3 | Data Leakage | Non-disclosure Agreements | Medium |
| 4 | Incompetence | Education | Medium |
| 5 | Personal Hindrance | Team Communication | Medium |
| 6 | Natural Disasters | Back-up Data | Low |

## Milestones
| Milestone | Start Date | End Date | Time Spent<br>(hours) |
|---|---|---|---|
| Test Plan | 2019-11-19 | 2019-12 | 20 |
| Test Design | 2019-11-22 | 2019-12 | 25 |
| Test Implementation | 2019-11-28 | 2019-12 | 35 |
| Test Execution | 2019-12-08 | 2019-12 | 25 |
| Test Evaluation | 2019-12-13 | 2019-12 | 40 |

## Package
- Test Plan
- Test Cases
- Test Report
