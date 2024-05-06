This project is a simple REST API framework built with Java and the Spring framework. It interacts with a public news API to fetch articles based on various criteria such as keywords, authors, and titles.

Overview
The project provides several basic methods for interacting with the news API, including:

Fetching N news articles
Finding a news article with a specific title or author
Searching articles by keywords
It also includes caching functionality to improve performance by reducing redundant API requests.

Getting Started
Prerequisites
Make sure you have the following installed on your system:

Java Development Kit (JDK) 8 or higher
Apache Maven
Installation
Clone the repository to your local machine:
bash
Copy code
git clone https://github.com/pushkarreddy2305/firstHelp.git
Navigate to the project directory:
bash
Copy code
cd firstHelp
Build the project using Maven:
bash
Copy code
mvn clean install
Running the Application
Once the project is built, you can run the application using the following command:

bash
Copy code
java -jar target/firstHelp.jar
This will start the Spring Boot application, and you should see log messages indicating that the application has started successfully.

Usage
Once the application is running, you can interact with the API endpoints to fetch news articles. Here are some example API endpoints:

Fetch articles by keyword:
bash
Copy code
GET /articles?keyword=<keyword>
Fetch articles by title:
bash
Copy code
GET /articles/title/{title}
Fetch articles by author:
bash
Copy code
GET /articles/author/{author}
Replace <keyword>, <title>, and <author> with the desired search criteria.

Caching
The application uses Caffeine for caching to improve performance by reducing the number of API requests made to the news API. Cached data is stored in memory and expires after a certain period of time.
