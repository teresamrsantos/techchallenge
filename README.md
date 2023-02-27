# **BACKEND TECH CHALLENGE**

### **Project Description**

The project is a Java application built with Spring Boot and Lombok. It uses Flyway for database migrations, Maven as the build tool, and Docker for containerization. The application uses a PostgreSQL database to store patient consults, pathologies, and symptoms.

The purpose of the application is to provide a way to log patient consults in the hospital and keep track of their pathologies and symptoms. The hospital board wants to also be able to keep adding new consults and patients every day and for now they are happy with the pathologies and symptoms they have in their database so that is out of scope.

### **Start-up**

Run the following commands in the command line:

1. Clone the repository to your local machine using git clone <repository-url>.
2. Navigate to the project directory using 'cd <project-name>'.
3. Build the application using Maven by running 'mvn clean install'.
4. Build the Docker image using the provided Dockerfile by running 'docker build -t challenge-1.0.0.jar '.
5. Run the Docker container using the command 'docker-compose up'
    
###  **Usage**
Once the application is running, you can access it using a web browser or a REST API client like Postman. 
The following endpoints are available:

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

###  **Database**
The application uses a PostgreSQL database to store patient consults, pathologies, and symptoms. Flyway is used to manage database migrations, so you don't need to manually create or modify database tables. The database connection properties are configured in the application.properties file located in the project's src/main/resources directory.



 



 


