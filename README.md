# **BACKEND TECH CHALLENGE**

### **What this is**

This is a simple JAVA project that involves 



### **Start-up**

Run the following commands in the command line:

    - mvn clean install 
    - docker build -t challenge-1.0.0.jar .
    - docker-compose up
    
### ** Endpoints: **
    
GET /patient: retrieves a paginated list of all patients, filtered and sorted by either name or age.
curl http://localhost:8080/challenge/patient?page=0&search=a&size=10&sort=age,DESC

GET /patient/{patientId}/consults: retrieves all consults with symptoms associated with a specific patient.
curl http://localhost:8080/challenge/patient/1/consults

GET /speciality: retrieves a list of top specialities based on the number of distinct patients assigned to each one.
curl http://localhost:8080/challenge/speciality

POST /consult: creates a new consult based on the given ConsultDTO and returns the ID of the created consult in the response body.
curl  'http://localhost:8080/challenge/consult' 
--header 'Content-Type: application/json' 
--data-raw '{
    "doctorId": 1,
    "patientId": 1,
    "specialityId": 1
}'



 



 


