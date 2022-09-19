Feature: Create incident in servide now

Background:
Given Endpoint must be declared
And Authentication must be provided
And Add header details
And query parameter must be defined 

#Scenario: TC001 Create incident without body
#When Send the request post for creating the incident
#Then get the status code 
#And validate the statuscode 
#And validate the response contains the number with approporiate value

Scenario: TC002 Create incident with body as file
When Send the request post as a file "TC01_Create_incident" in the body
When Send the request post for creating the incident
Then get the status code 
And validate the statuscode 
And validate the response contains the number with approporiate value

Scenario: TC003 Create incident with body as file
When Send the request post as a file "TC03_Create_incident" in the body
When Send the request post for creating the incident
Then get the status code 
And validate the statuscode 
And validate the response contains the number with approporiate value

Scenario Outline: TC004 Create incident with scenario outline and examples
When Send the request post as a file <filename> in the body
When Send the request post for creating the incident
Then get the status code 
And validate the statuscode 
And validate the response contains the number with approporiate value

Examples:
|filename|
|"TC01_Create_incident"|
|"TC03_Create_incident"|
