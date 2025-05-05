# Validate South African ID

A simple **Java** project built using **Gradle** that performs **validation, extraction**, and **classification** of South African ID numbers using **Test Driven Development (TDD)** principles and **JUnit 5**.

Live Demo: [Check ID Online](https://validatesaid.netlify.app/)  
*(No need to clone the repo. Just try it out in your browser!)*

---

## 🧪 Project Topic: Unit Testing

This project focuses on the **importance and practicality of unit testing** using JUnit, while solving a real-world problem — validating a South African ID number. It demonstrates:
- Writing clean, testable code.
- Developing in small, test-driven increments.
- Understanding test runners and assertions.

---

## ✅ Features

- **ID Validation**  
  Checks for:
  - Correct length (13 digits)
  - Numeric-only content
  - Valid Luhn checksum

- **Date of Birth Extraction**  
  Extracts birth date in `yyyy-MM-dd` format.

- **Gender Detection**  
  Uses the 7th–10th digits to determine if the person is *Male* or *Female*.

- **Citizenship Check**  
  Identifies if the holder is a:
  - SA Citizen (`0`)
  - Permanent Resident (`1`)

- **Edge Case Handling**  
  - Null or empty input
  - Invalid dates (e.g. Feb 30)
  - Invalid checksum
  - Non-numeric IDs

---

## 📁 Project Structure

![Screenshot (13)](https://github.com/user-attachments/assets/96e0c8dd-fdb2-45fd-9302-e9ff9ffd580a)


---

## 🧪 Sample Unit Tests

All functionality is rigorously tested using JUnit:

- Valid and invalid ID numbers
- Checksum validation
- Gender & citizenship extraction
- Date of birth parsing (with invalid edge cases)

> ✅ **All tests pass successfully.**  
> 📸 *[Screenshots attached in the repo]*

---

## 📚 Java & Testing Resources

To deepen your understanding of unit testing in Java:

- [Java Unit Testing Best Practices – Baeldung](https://www.baeldung.com/java-unit-testing-best-practices)
- [JUnit Crash Course – Coding with John (YouTube)](https://www.youtube.com/watch?v=vZm0lHciFsQ&ab_channel=CodingwithJohn)

---

## 💡 Why Unit Testing?

> *"If you don't write tests, your code is always in a state of uncertainty."*

Unit testing helps:
- Prevent regressions
- Improve focus & productivity
- Promote modular, maintainable code
- Catch bugs early and easily

---

## 🛠️ Setting Up (with Gradle CLI)

This project was bootstrapped manually using the Gradle CLI:

```bash
mkdir validate_sa_id
cd validate_sa_id
gradle init  # Choose 'application' project type when prompted

You can build and test this using:
./gradlew test
