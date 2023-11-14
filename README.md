# Smart Stream Recommender - Java with Design Patterns

## Overview:

Welcome to the Smart Stream Recommendation System, a Java-based project incorporating cutting-edge Object-Oriented Programming (OOP) concepts. This robust and modular application excels in delivering personalized stream recommendations to users based on their unique listening history.

## Key Features:

### Advanced Recommendation Algorithm:

- Implemented an algorithm for precise stream recommendations tailored to individual user preferences.

### CSV Input Processing:

- Seamless integration with various data sources through the processing of key CSV files: `streamers.csv`, `streams.csv`, `users.csv`, and commands from `comenzi.txt`.

### Design Patterns Implementation:

- **Command Pattern:**
  - Encapsulation of commands in `comenzi.txt` for seamless extensibility without modifying existing code.

- **Factory Pattern:**
  - Centralized creation of diverse stream types (podcasts, music, audiobooks) to enhance flexibility and accommodate future extensions.

- **Singleton Pattern:**
  - Ensures a single instance of the recommendation system, maintaining consistent system state throughout its lifecycle and optimizing resource consumption.

- **Builder Pattern:**
  - Step-by-step construction of complex stream objects for flexible customization, simplifying the stream creation process.

### User-Friendly Platform:

- A user-friendly interface facilitating user interaction, enabling easy addition, and listening of various stream types, including podcasts, music, and audiobooks.

### Comprehensive Testing:

- **Test Folder:**
  - A dedicated `tests` folder includes a suite of tests ensuring the system's reliability, accuracy, and robustness.

  - **Unit Tests:**
    - Validate individual components for correctness and functionality.

  - **Integration Tests:**
    - Ensure seamless collaboration between different modules and components.

  - **End-to-End Tests:**
    - Verify the entire system's performance, from input processing to recommendation generation.

- **Gradle Test:**
  - Leverage Gradle for automated testing, providing a consistent and efficient testing environment.

## System Advantages:

The integration of OOP principles, design patterns, and comprehensive testing, including Gradle automation, significantly elevates the system's:

- Maintainability
- Scalability
- Extensibility
- Reliability
