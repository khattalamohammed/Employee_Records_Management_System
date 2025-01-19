# Use a smaller base image for the final stage
FROM eclipse-temurin:17-jdk-jammy

# Set the working directory
WORKDIR /app

# Copy the built JAR file from the builder stage
COPY target/rabat-0.0.1-SNAPSHOT.jar app.jar

# Expose the port your application will run on
EXPOSE 8080

# Set the environment variable for the JWT secret key

# Command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]