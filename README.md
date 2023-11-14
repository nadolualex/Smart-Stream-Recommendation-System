Title: Smart Stream Recommendation System in Java with Design Patterns

Summary:
I have developed a Smart Stream Recommendation System in Java, leveraging Object-Oriented Programming (OOP) concepts to create a robust and modular application. The system takes input in CSV format, consisting of three key files (streamers.csv, streams.csv, and users.csv), along with a commands file (comenzi.txt). The primary goal is to recommend streams to users based on their listening history.

Key Features:

Algorithm for Stream Recommendation:

Implemented a sophisticated algorithm to recommend streams based on users' listening history, providing personalized recommendations for each user.
Input Files:

The system processes CSV input files (streamers.csv, streams.csv, and users.csv), ensuring seamless integration with various data sources.
Command Pattern:

Utilized the Command design pattern to encapsulate commands specified in comenzi.txt. This promotes extensibility by allowing the addition of new commands without modifying existing code. Each command is represented as an object, making it easy to manage and execute.
Factory Pattern:

Employed the Factory design pattern to create instances of different stream types (podcasts, music, audiobooks). This enhances flexibility by centralizing the stream creation process, making it easier to extend the application with new stream types in the future.
Singleton Pattern:

Incorporated the Singleton design pattern to ensure a single instance of the recommendation system. This guarantees that the system's state remains consistent throughout its lifecycle and avoids unnecessary resource consumption.
Builder Pattern:

Applied the Builder design pattern to construct complex stream objects step by step. This pattern simplifies the stream creation process, allowing for the flexible construction of streams with varying attributes.
User-Friendly Platform:

Developed a user-friendly platform that enables different users to access and interact with the system, facilitating the addition and listening of various stream types, including podcasts, music, and audiobooks.
The combination of OOP principles and design patterns enhances the system's maintainability, scalability, and extensibility. This Smart Stream Recommendation System serves as a versatile and efficient platform for users to explore and enjoy diverse streaming content. The GitHub repository contains the source code and documentation, providing a comprehensive resource for understanding and contributing to the project. 
