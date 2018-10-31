FROM maven:3.3-jdk-8
LABEL authors="Lam Ngoc Khuong <me@ngockhuong.com>"
COPY . /app
WORKDIR /app

# Make port 8080 available to the world outside this container
EXPOSE 8080

# Run application with Maven Tomcat Plugin
ENTRYPOINT ["mvn", "clean", "package", "-DskipTests"]
ENTRYPOINT ["mvn", "tomcat7:run"]
