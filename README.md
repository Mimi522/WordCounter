## Word counter

#### Description:
An application made in Kotlin using Android Studios with the objective of counting the words typed in a text input window. 
The program responsible for filtering the text typed and counting the words present is made using a AWS Lambda Function written in Python.
The communication is made using an API Gateway.

## Project Status:

#### Semi-complete:
Needs to implement a filter for result in JSON obtained from the AWS Lambda Function and display it in a better format on the application.

## Project Screen Shot(s):

[To be added]

## Installation and Setup Instructions

[To be added]

## Reflection

  - What was the context for this project? 
  - What did you set out to build?
  - Why was this project challenging and therefore a really good learning experience?
  - What were some unexpected obstacles?
  - What tools did you use to implement this project?
  
This was 3 days long side project with the intent to test out some basic knowledge of Kotlin and familiarize myself with Android Studio for future projects. The project goal was to have an application on android where I could type some kind of text and then ask for the number of words present on that text.

The initial intent was to be a full Kotlin program until I receive a sugestion from a friend to make the back-end using AWS. AWS was something else I intended to learn so I took the oportunity and added it to this project.

The project started by creating the function in Python responsible for filtering and counting words using regular expression. After that came the challeging part of creating the AWS Lambda Function and API Gateway and testing it out. This was particular challenging since I have never used AWS before and went pretty much blind on this.

Finishing the back-end I moved to the front-end using Android Studio. Took sometime getting used to the interface but making the UI and getting the text input went relatively smoothly. One final step was connecting the Kotlin program with the back-end and displaying the result received in the android screen.
