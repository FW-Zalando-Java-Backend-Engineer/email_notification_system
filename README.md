# 📬 Email Notification System

A simple Java application that simulates sending email notifications using **Java Threads**. This project demonstrates multithreading concepts including thread creation, execution, and synchronization using `Runnable`, `Thread`, `join()`, and `sleep()`.

---

## 🚀 Purpose

This project was created to teach and reinforce the core concepts of **Java Threads** through a realistic simulation:
- Handle multiple email notifications concurrently
- Improve performance through asynchronous execution
- Learn thread lifecycle and best practices

---

## 🧠 Key Concepts

| Concept       | Explanation                                                                 |
|---------------|-----------------------------------------------------------------------------|
| `Runnable`    | Interface to define a task to be executed by a thread                      |
| `Thread`      | Class used to run tasks concurrently                                        |
| `start()`     | Begins thread execution                                                     |
| `run()`       | Contains the logic to execute when the thread runs                         |
| `sleep()`     | Pauses the current thread for a set duration                               |
| `join()`      | Main thread waits until the child thread completes                         |
| `isAlive()`   | Checks whether a thread is still running                                   |

---

## 📦 Project Structure

```

EmailNotificationSystem/
├── pom.xml
└── src/
├── main/
│   └── java/
│       └── com/example/email/
│           ├── EmailSender.java
│           └── EmailNotificationApp.java
└── test/
└── java/
└── com/example/email/
└── EmailSenderTest.java

````

---

## 📄 How It Works

- A list of "email recipients" is defined.
- Each recipient is assigned a new thread (`EmailSender`) that simulates sending an email.
- Threads run concurrently to improve performance.
- The main thread optionally waits (`join()`) for all email-sending threads to finish.

---

## 🧪 Unit Testing

Includes comprehensive JUnit 5 test coverage:
- Ensure email tasks run without exceptions
- Validate thread behavior (alive, name, timeout)
- Simulate concurrency with `AtomicInteger`
- Handle thread interruption gracefully

---

## 🛠️ Getting Started

### ✅ Prerequisites
- Java 8+
- Maven

### 🧰 Build & Run

```bash
# Compile the project
mvn clean install

# Run the main application
mvn exec:java -Dexec.mainClass="com.example.email.EmailNotificationApp"
````

---

## 🔬 Example Output

```bash
Sending email to: alice@example.com by EmailThread-1
Sending email to: bob@example.com by EmailThread-2
...
Email sent to: alice@example.com by EmailThread-1
Email sent to: bob@example.com by EmailThread-2
...
All emails have been sent.
```

---

## 🧪 Run Tests

```bash
mvn test
```

Tests include:

* `run()` method safety
* Thread naming and lifecycle
* Thread interruption
* Concurrency validation

---

## 📚 Learning Resources

* [Java Thread Lifecycle – Baeldung](https://www.baeldung.com/java-thread-lifecycle)
* [Thread Class – JavaDoc](https://docs.oracle.com/javase/8/docs/api/java/lang/Thread.html)
* [GeeksforGeeks – Java Threads](https://www.geeksforgeeks.org/java-threads/)


