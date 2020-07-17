
# Movie Library API

This is a REST API for a movie library application. It's developed under Spring Boot and uses Gradle for building and dependency management.

## Running the application:
You only need JDK 8 installed to run the application.
### Clone this repo:
      git clone https://github.com/ucefizi/movies  
  ### Build it:
      cd movies
      ./gradlew build
 
 ### Run it:
     ./gradlew bootrun

the app launches by default on http://localhost:8080/

## How to use it?

The API is documented using Swagger2. To access the Swagger UI, go to http://localhost:8080/movies/swagger-ui.html and you'll find the endpoints and operations it offers. These endpoints can be called from another service or from a front end app.

## What does it do?

The app loads the initial movie data from a json file into an H2 database. This data is accessed using JPA @Repositories. 
There are a few controllers that handle requests on the data, with some logging to monitor their behaviour.
