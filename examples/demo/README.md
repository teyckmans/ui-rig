# Demo

## Introduction

This demo application contains 2 modules:
 - a backend module that uses spring boot
 - a frontend module that uses ui-rig
 
## Launching

You can start the frontend and backend modules by executing the following Gradle commands
from withing the examples/demo directory:
 - ./gradlew :frontend:run
 - ./gradlew :backend:bootRun
 
Note that the frontend module uses the kotlin-frontend-plugin from jetbrains and start a webpack server in the background.
In order to stop it executed the following Gradle command from within the examples/demo directory:
 - ./gradlew :frontend:stop

Open a browser on http://localhost:8088/ and login with admin/admin to login.

The backend simulates a slow login and has a wait of 1 second in it.

## Finding your way around in the frontend module

The frontend is launched here eu.rigeldev.uirig.demo.main.kt

The eu.rigeldev.uirig.demo.DemoApp class contains the root application logic. 

If you are already familiar with elm you will easily find your way.