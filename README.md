🏥 Medicine Inventory Management System

A secure web-based Medicine Inventory System built with Spring Boot, Thymeleaf, MySQL, and JWT Authentication.
It supports role-based access (ADMIN / VIEWER), automatic email notifications for low stock and upcoming expiry, and a clean Bootstrap-based UI.This project was created to prevent critical situations in hospitals and pharmacies. Without automatic alerts, medicines could expire unnoticed or run out when urgently needed for patients. The system sends notifications for low stock and upcoming expiries, ensuring medicines are always available and safe, so patient care is never compromised.


🚀 Features

Add / Edit / Delete medicines (Admin),
Update stock quantity and expiry date (Admin),
View-only access for viewers (no admin controls shown),
Automatic email notifications using JavaMailSender:
When quantity gets updated,
When expiry date is changed,

When stock goes below the threshold (default: 10),
Expiry alerts for medicines within 30 days of expiry,
Secure authentication & authorization with Spring Security + JWT.

🧭 Tech Stack :
Backend: Spring Boot,
Frontend: Thymeleaf + HTML + CSS + Bootstrap,
Database: MySQL.
Security: Spring Security + JWT.
Email: JavaMailSender,
ORM: JPA + Hibernate,
Build: Maven.

VCS: Git / GitHub

⚙️ Setup Instructions

Clone the repository

git clone https://github.com/Kaviya-77/medicine-inventory.git
cd medicine-inventory

MySQL (create database)

CREATE DATABASE medicine_db;

🔐 Authentication & Roles

ROLE_ADMIN — full access (add/edit/delete/update)
ROLE_VIEWER — read-only


✅ Sample Test Scenarios

Add medicine -> appears on dashboard ,
Update quantity -> email notification sent ,
Update expiry -> email notification sent ,
Reduce quantity below threshold -> low stock email ,
Viewer login -> no edit/delete UI ,
Admin login -> can add / edit / delete


Update application.properties

# MySQL
spring.datasource.url=jdbc:mysql://localhost:3306/medicine_db?useSSL=false&serverTimezone=UTC,
spring.datasource.username=root,
spring.datasource.password=yourpassword,
spring.jpa.hibernate.ddl-auto=update,
spring.jpa.show-sql=true

# JWT
jwt.secret=ReplaceWithLongSecretKey,
jwt.expiration=86400000

# Mail (Gmail example)
spring.mail.host=smtp.gmail.com,
spring.mail.port=587,
spring.mail.username=yourmail@gmail.com,
spring.mail.password=your_app_password,
spring.mail.properties.mail.smtp.auth=true,
spring.mail.properties.mail.smtp.starttls.enable=true

# Custom settings
medicine.low-stock-threshold=10,
medicine.expiry-alert-days=30,
Gmail note: Use an App Password if 2FA is enabled.

# Run the project
mvn clean spring-boot:run
Or run the main application class from your IDE.

📸 Screenshots

<img width="1810" height="736" alt="image" src="https://github.com/user-attachments/assets/1a441754-db4c-4f9c-8bc5-3c3c4ea6f4f1" /> 
<img width="1802" height="725" alt="image" src="https://github.com/user-attachments/assets/a5f957f4-8043-4875-93b5-55ae6f31558f" />
<img width="1796" height="733" alt="image" src="https://github.com/user-attachments/assets/14fa3b2d-302c-4980-b7ac-1f197994a8a9" /> 
<img width="1804" height="731" alt="image" src="https://github.com/user-attachments/assets/c8880c9c-db5c-4d3a-b1a4-dfd38455b15c" /> 
<img width="1811" height="735" alt="image" src="https://github.com/user-attachments/assets/1e34a45f-d707-4b3f-a417-470af83cad40" /> 
<img width="1813" height="735" alt="image" src="https://github.com/user-attachments/assets/3afbaf75-2fd9-40e2-9336-758ade1eb82e" />


🎬 Demo

https://drive.google.com/file/d/1Qmx5eWRZNMUedauUYvIvG-Dsv5gbxt3z/view?usp=sharing
