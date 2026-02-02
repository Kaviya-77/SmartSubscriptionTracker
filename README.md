⏰ Subscription Reminder System


A secure web-based Subscription Reminder System built with Spring Boot, Thymeleaf, MySQL, and JWT authentication.

This system allows users to register, login, and manage their subscriptions, automatically sending email reminders before any subscription is about to expire.
It helps prevent unexpected auto-debits and keeps users informed about their recurring payments.

🚀 Features

User registration and login with secure JWT authentication

Add, edit, and delete subscriptions

Set subscription amount and expiry date

Email notifications 30 days before expiry

Clean and responsive Bootstrap-based UI

Admin panel (optional) for managing all users’ subscriptions

Secure authentication & authorization using Spring Security + JWT

🧭 Tech Stack
Layer	Technology
Backend	Spring Boot
Frontend	Thymeleaf + HTML + CSS + Bootstrap
Database	MySQL
Security	Spring Security + JWT
Email	JavaMailSender
ORM	JPA + Hibernate
Build Tool	Maven
Version Control	Git / GitHub
⚙️ Setup Instructions
1️⃣ Clone the repository
git clone https://github.com/YOUR_USERNAME/SubscriptionReminderSystem.git
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

🔐 Authentication & Roles

ROLE_USER — Can manage only their subscriptions

ROLE_ADMIN — Full access (add/edit/delete subscriptions for all users)

✅ Sample Test Scenarios

Register a new user → account created successfully

Add a subscription → appears in user dashboard

Update expiry date → email notification scheduled

Subscription within 30 days → email alert sent

Login as admin → manage all users’ subscriptions

📸 Screenshots

(Replace with actual screenshots from your app)



🎬 Demo

(Replace with your actual demo link)
