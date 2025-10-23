# ISE Railroad Client

## Overview

The ISE Railroad Client allows you to control a garden railway system either virtually or physically. This client interfaces with the ISE Server Project, enabling control over various locomotive models.

## Build Instructions

To build the project, use the built-in compile button in your development environment. Avoid using Gradle tasks directly, as they may not configure the project correctly for your needs.

## Running the Client

### Prerequisites
Clone and set up the ISE Server Project.
Ensure that the Railroad Server within the ISE Server Project is running.
It is recommended to start at least one locomotive from the server project to ensure the client has a model to control.

### Configuration
The RailroadViewModel class allows you to select the operational environment for the client:

LOCAL: Connects to a locally running Logging Server Environment. Use this for development and 
testing on your local machine.

CABINET: Connects to the Railroad Server located in the cabinet at our Berufsakademie.
This setting is used for demonstrations or actual deployment.

To switch the operational environment, modify the code in the RailroadViewModel class.
Specifically, change the server environment configuration at Line 52.

# Support

For any issues or further assistance, please contact the project maintainer or submit an issue in the project's repository.
