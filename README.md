# ⏰ Subscription Reminder System

A secure web-based Subscription Reminder System built with Spring Boot, Thymeleaf, MySQL, and JWT authentication.

This system allows users to register, login, and manage their subscriptions, automatically sending email reminders before any subscription is about to expire. It helps prevent unexpected auto-debits and keeps users informed about their recurring payments.

## 🚀 Features

- User registration and login with secure JWT authentication
- Add, edit, and delete subscriptions
- Set subscription amount and expiry date
- Email notifications 30 days before expiry
- Clean and responsive Bootstrap-based UI
- Secure authentication & authorization using Spring Security + JWT

## 🧭 Tech Stack

| Layer         | Technology |
|---------------|------------|
| Backend       | Spring Boot |
| Frontend      | Thymeleaf + HTML + CSS + Bootstrap |
| Database      | MySQL |
| Security      | Spring Security + JWT |
| Email         | JavaMailSender |
| ORM           | JPA + Hibernate |
| Build Tool    | Maven |
| Version Control | Git / GitHub |

## ⚙️ Setup Instructions

### 1️⃣ Clone the repository

git clone https://github.com/Kaviya-77/SmartSubscriptionTracker

cd SubscriptionReminderSystem

2️⃣ Create MySQL database
CREATE DATABASE subscription_db;

3️⃣ Configure application.properties
# MySQL
spring.datasource.url=jdbc:mysql://localhost:3306/subscription_db?useSSL=false&serverTimezone=UTC
spring.datasource.username=your_db_username
spring.datasource.password=your_db_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

# JWT
app.jwt.secret=ReplaceWithLongSecretKey
app.jwt.expiration=86400000

# Email (Gmail example)
spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username=your_email@gmail.com
spring.mail.password=your_app_password
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true

# Custom settings
subscription.expiry-alert-days=30
💡 Tip: Use a Gmail App Password if 2FA is enabled.

4️⃣ Run the project
mvn clean spring-boot:run
Or run the main application class from your IDE.

✅ Sample Test Scenarios
Register a new user → account created successfully

Add a subscription → appears in user dashboard

Update expiry date → email notification scheduled

Subscription within 30 days → email alert sent

📸 Screenshots

<img width="940" height="423" alt="image" src="https://github.com/user-attachments/assets/25a24d5e-30a1-4d1d-bffd-400f6a05bcbf" />
<img width="940" height="426" alt="image" src="https://github.com/user-attachments/assets/a5f94090-d260-4b16-8ec7-b3b536ff1e2f" />
<img width="940" height="428" alt="image" src="https://github.com/user-attachments/assets/ed722ec0-b9e2-4f55-bee7-ee9f76d1c954" />
<img width="940" height="426" alt="image" src="https://github.com/user-attachments/assets/f7c45701-c366-415b-89de-3c3ab40ecdca" />
<img width="940" height="425" alt="image" src="https://github.com/user-attachments/assets/8c28b8ec-bdbb-4d18-89a9-6574b688e7ac" />
<img width="940" height="359" alt="image" src="https://github.com/user-attachments/assets/d53c2c1b-400e-4a2b-a676-7aa79809d733" />
<img width="940" height="357" alt="image" src="https://github.com/user-attachments/assets/3b29d64f-e5c4-4a43-b57e-9d00a577f765" />

🎬 Demo

https://drive.google.com/file/d/12PXpYEWKaqjHpt2jUMapXLr4G12O2fiA/view?usp=sharing


