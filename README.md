# 📚 Smart Flashcards - Java Spring Boot Backend

A backend REST API that lets students add flashcards (question + answer), and the system auto-detects the subject intelligently using keyword detection.

## 🚀 Features

- ➕ Add flashcards without manually selecting a subject
- 🧠 Auto-subject detection based on question keywords
- 🎲 Fetch a mixed batch of flashcards by subject
- 💾 In-memory H2 database
- 🧑‍💻 Built with Java + Spring Boot

---

## 📦 Tech Stack

- Java 17
- Spring Boot
- Spring Data JPA
- H2 Database
- Lombok

---

## 📬 API Endpoints

### ✅ POST `/flashcard`

Add a new flashcard.

**Request Body:**
```json
{
  "studentId": "stu001",
  "question": "What is Newton's Second Law?",
  "answer": "Force equals mass times acceleration"
}
```
**Request Body:**
```json
{
  "message": "Flashcard added successfully",
  "subject": "Physics"
}
```
### ✅ GET `/get-subject?student_id=stu001&limit=5`
Get up to 5 flashcards of different subjects for a student.

## 💻 How to Run This Project
Clone the repo

```
git clone https://github.com/ruuofficial/smart-flashcards.git
cd smart-flashcards
```
Run the app
```
./mvnw spring-boot:run
```
Open browser:

`http://localhost:8080/h2-console` → to view DB

`http://localhost:8080/flashcard` → test API with Postman

## 👩‍💻 Made by

**Riya Singhal**  
📧 riyasinghal016@gmail.com  
🔗 [LinkedIn](https://www.linkedin.com/in/ruuofficial)


