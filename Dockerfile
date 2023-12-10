# Use the official Gradle image with JDK 17 for building
FROM gradle:7-jdk17 AS builder

# Set the working directory
WORKDIR /app

# Copy only the necessary files for dependency resolution
COPY build.gradle settings.gradle /app/
COPY src /app/src/

# Resolve dependencies and build the application
RUN gradle build

# Create a new image with the JAR file
FROM openjdk:17-slim

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file from the builder stage to the current location
COPY --from=builder /app/build/libs/UserManagementAPI-0.0.1-SNAPSHOT.jar UserManagementAPI.jar

# Expose the port that your Spring Boot application runs on
EXPOSE 8080

# Specify the command to run your application
ENTRYPOINT ["java", "-jar", "UserManagementAPI.jar"]