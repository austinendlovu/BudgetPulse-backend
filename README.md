

# BudgetPulse – Personal Finance Management System

A personal finance manager built to help individuals and small businesses in Zimbabwe gain control over their financial life.
It promotes smarter money habits through budget tracking, intelligent insights, and clear visualizations.

---

## 🔥 What's Inside

**Frontend**
Built with React 18, TypeScript, Vite, Tailwind CSS, and shadcn/ui for a fast, responsive interface

**Backend**
Powered by Spring Boot and Java, with secure JWT authentication and MySQL for structured data storage

---

## ⚡ Project Structure

```
budgetpulse/
├── frontend/     # React app (UI, dashboards, alerts)
├── backend/      # Spring Boot API (auth, budget logic)
└── README.md     # Project overview (this file)
```

---

## ✨ Key Features

* Budget tracking by income category (e.g. salary, freelance, rental)
* Auto-categorized expense tracking (e.g. food, transport, bills)
* AI-powered recommendations to reduce overspending
* Visual dashboards with real-time spending insights
* Budget limit alerts and overspend notifications
* Exportable monthly and annual financial reports
* Role-based access control and secure authentication

---

## 🚀 Getting Started

### Clone the Project

```bash
git clone https://github.com/austinendlovu/BudgetPulse.git
cd budgetpulse
```

---

### Run the Backend

1. Navigate to the backend directory:

   ```bash
   cd backend
   ```

2. Set your database connection in `application.properties` or `application.yml`:

   ```yaml
   spring:
     datasource:
       url: jdbc:mysql://localhost:3306/budgetpulse
       username: your_db_username
       password: your_db_password

     jpa:
       hibernate:
         ddl-auto: update
       show-sql: true
   ```

3. Build and run:

   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

4. Backend will run at:
   `http://localhost:8080`

5. API Documentation (Swagger):
   `http://localhost:8080/swagger-ui/index.html`

---

### Run the Frontend

1. Navigate to the frontend directory:

   ```bash
   cd ../frontend
   ```

2. Install dependencies:

   ```bash
   npm install
   ```

3. Start development server:

   ```bash
   npm run dev
   ```

4. Frontend will run at:
   `http://localhost:8081`

---

## 🌍 Deployment

**Frontend:**
Deploy using platforms like Vercel, Netlify, or any static site host

**Backend:**
Deploy to services like Railway, Heroku, VPS, or cloud platforms such as AWS, Azure, or GCP

---

## 🤝 Contributing

* Fork the repository
* Create a new feature branch:
  `git checkout -b feature/your-feature`
* Commit and push your changes
* Open a Pull Request

---

## 📜 License

MIT License

---

## 📬 Support

Open an issue in the repository or reach out via GitHub for collaboration, feedback, or ideas around financial literacy and digital empowerment.

