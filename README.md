# Hospital Management System

A Spring Boot application for managing hospital operations including patients, doctors, departments, appointments, and insurance.

## Table of Contents
- [Technologies Used](#technologies-used)
- [Project Structure](#project-structure)
- [API Endpoints](#api-endpoints)
- [Setup Instructions](#setup-instructions)
- [Database Schema](#database-schema)
- [Postman Collection](#postman-collection)
- [Testing](#testing)

## Technologies Used
- Java 17
- Spring Boot 3.x
- Spring Data JPA
- Hibernate
- Maven
- H2 Database (for development)
- Lombok
- RESTful APIs

## Project Structure
```
src/
├── main/
│   ├── java/
│   │   └── com/codingshuttle/HospitalyManagementSystem/
│   │       ├── HospitalyManagementSystemApplication.java
│   │       ├── advice/
│   │       ├── controller/
│   │       ├── dto/
│   │       ├── entity/
│   │       ├── exception/
│   │       ├── repository/
│   │       └── service/
│   └── resources/
│       ├── application.properties
│       └── data.sql
└── test/
    └── java/
        └── com/codingshuttle/HospitalyManagementSystem/
```

## API Endpoints

### Doctor APIs
- `GET /doctors` - Get all doctors
- `GET /doctors/{doctorId}` - Get doctor by ID
- `POST /doctors` - Create a new doctor
- `PUT /doctors/{doctorId}` - Update a doctor
- `DELETE /doctors/{doctorId}` - Delete a doctor
- `GET /doctors/{doctorId}/appointments` - Get appointments of a doctor
- `GET /doctors/{doctorId}/department` - Get department where doctor is head

### Patient APIs
- `GET /patients` - Get all patients
- `GET /patients/{patientId}` - Get patient by ID
- `POST /patients` - Create a new patient
- `PUT /patients/{patientId}` - Update a patient
- `DELETE /patients/{patientId}` - Delete a patient
- `GET /patients/{patientId}/appointments` - Get appointments of a patient
- `GET /patients/{patientId}/insurance` - Get insurance of a patient

### Department APIs
- `GET /department` - Get all departments
- `GET /department/{departmentId}` - Get department by ID
- `POST /department/{doctorId}` - Create a new department with head doctor
- `PUT /department/{doctorId}/{departmentId}` - Add doctor to department
- `GET /department/{departmentId}/doctors` - Get doctors in a department
- `GET /department/{departmentId}/headDoctor` - Get head doctor of department

### Appointment APIs
- `GET /appointment` - Get all appointments
- `GET /appointment/{appointmentId}` - Get appointment by ID
- `GET /appointment/doctor/{doctorId}` - Get appointments by doctor ID
- `GET /appointment/patient/{patientId}` - Get appointments by patient ID
- `POST /appointment/{patientId}/{doctorId}` - Create a new appointment
- `DELETE /appointment/{appointmentId}` - Delete an appointment

### Insurance APIs
- `GET /insurance` - Get all insurances
- `GET /insurance/{insuranceId}` - Get insurance by ID
- `GET /insurance/{insuranceId}/patient` - Get patient by insurance ID
- `POST /insurance/{patientId}` - Assign insurance to patient
- `PATCH /insurance/{patientId}` - Update insurance of patient
- `DELETE /insurance/removeInsurance/{patientId}` - Remove insurance from patient

## Setup Instructions

1. **Prerequisites**
   - Java 17 or higher
   - Maven 3.6 or higher
   - IDE (IntelliJ IDEA, Eclipse, etc.)

2. **Clone the Repository**
   ```bash
   git clone <repository-url>
   cd HospitalyManagementSystem
   ```

3. **Build the Project**
   ```bash
   mvn clean install
   ```

4. **Run the Application**
   ```bash
   mvn spring-boot:run
   ```
   Or run the main class `HospitalyManagementSystemApplication.java`

5. **Access the Application**
   - The application will start on `http://localhost:8080`
   - H2 Console: `http://localhost:8080/h2-console` (if enabled)

## Database Schema

The application uses the following entities:

### Doctor
- id (Long) - Primary Key
- name (String) - Doctor's name
- specialization (String) - Medical specialization
- email (String) - Unique email address
- appointments (Set<Appointment>) - One-to-many relationship with appointments
- department (Department) - One-to-one relationship as head doctor

### Patient
- id (Long) - Primary Key
- name (String) - Patient's name
- dateOfBirth (LocalDate) - Patient's date of birth
- email (String) - Email address
- gender (String) - Gender
- bloodGroup (BloodGroupType) - Blood group enum
- insurance (Insurance) - One-to-one relationship with insurance
- appointments (Set<Appointment>) - One-to-many relationship with appointments

### Department
- id (Long) - Primary Key
- name (String) - Unique department name
- createdAt (LocalDate) - Creation timestamp
- headDoctor (Doctor) - One-to-one relationship with head doctor
- doctors (Set<Doctor>) - Many-to-many relationship with doctors

### Appointment
- id (Long) - Primary Key
- appointmentTime (String) - Appointment time
- reason (String) - Reason for appointment
- patient (Patient) - Many-to-one relationship with patient
- doctor (Doctor) - Many-to-one relationship with doctor

### Insurance
- id (Long) - Primary Key
- policyNumber (String) - Unique policy number
- provider (String) - Insurance provider name
- validUntil (String) - Policy validity date
- patient (Patient) - One-to-one relationship with patient
- createdAt (Instant) - Creation timestamp

## Postman Collection

A Postman collection is included in the project root directory:
- [HospitalyManagementSystem.postman_collection.json](HospitalyManagementSystem.postman_collection.json)

To use it:
1. Open Postman
2. Click "Import" and select the JSON file
3. Set the `baseUrl` variable to your application URL (default: http://localhost:8080)

## Testing

The project includes unit and integration tests in the `src/test` directory.

To run tests:
```
 ./mvnw test
```

## Contributing

1. Fork the repository
2. Create a feature branch
3. Commit your changes
4. Push to the branch
5. Create a Pull Request

## License

This project is licensed under the MIT License.