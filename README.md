# 🍕 Food Delivery API

A simple **RESTful API** built with **Spring Boot**, **Spring Data JPA**, and **Swagger UI** that manages food items for an online food delivery platform.

---

## ✨ Features

* ➕ **Create** new food items
* 📜 **Get** all food items or by ID
* ✏️ **Update** existing food items
* ❌ **Delete** food items
* 🔍 Interactive API documentation with **Swagger UI**
* 💾 Uses **MySQL/PostgreSQL/H2** (configurable)

---

## 🛠️ Tech Stack

* **Java 17+**
* **Spring Boot 3.x**
* **Spring Data JPA (Hibernate)**
* **Swagger (Springdoc OpenAPI)**
* **Maven**
* **Database**: MySQL (default), can be swapped with PostgreSQL or H2

---

## 📂 Project Structure

```
src/main/java/com/Food_Delivery
│
├── entity
│   └── FoodEntity.java     # JPA entity for food items
│
├── repository
│   └── FoodRepository.java # JPA repository
│
├── service
│   └── FoodService.java    # Business logic layer
│
└── controller
    └── FoodController.java # REST API endpoints
```

---

## ⚙️ Setup Instructions

### 1️⃣ Clone the Repository

```bash
git clone https://github.com/your-username/food-delivery-api.git
cd food-delivery-api
```

### 2️⃣ Configure Database

Update your `application.properties` or `application.yml`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/food_delivery
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

> 💡 For testing, you can use **H2 Database** (no setup required).

### 3️⃣ Build & Run

```bash
mvn spring-boot:run
```

---

## 📖 API Documentation (Swagger UI)

Once the app is running, visit:

👉 [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)
or
👉 [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)

---

## 🚀 API Endpoints

### 🔹 Food APIs

| Method | Endpoint          | Description            |
| ------ | ----------------- | ---------------------- |
| GET    | `/api/foods`      | Get all food items     |
| GET    | `/api/foods/{id}` | Get food item by ID    |
| POST   | `/api/foods`      | Create new food item   |
| PUT    | `/api/foods/{id}` | Update food item by ID |
| DELETE | `/api/foods/{id}` | Delete food item by ID |

### 📦 Example Request (POST - Create Food)

```json
{
  "name": "Margherita Pizza",
  "price": 299.99,
  "description": "Classic cheese pizza with tomato sauce",
  "available": true
}
```

### 📦 Example Response

```json
{
  "id": 1,
  "name": "Margherita Pizza",
  "price": 299.99,
  "description": "Classic cheese pizza with tomato sauce",
  "available": true
}
```

---

## 🧑‍💻 Contributing

Contributions are welcome!

1. Fork the repo
2. Create a new branch (`feature/new-feature`)
3. Commit your changes
4. Push the branch
5. Open a Pull Request

---

## 📜 License

This project is licensed under the **MIT License**.

---

⭐ If you like this project, don’t forget to give it a star on GitHub!

