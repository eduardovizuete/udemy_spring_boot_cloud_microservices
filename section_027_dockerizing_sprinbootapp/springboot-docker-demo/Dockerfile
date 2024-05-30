FROM eclipse-temurin:21
LABEL mantainer = "javaguides.net@a.com"
WORKDIR /app
COPY target/springboot-docker-demo-0.0.1-SNAPSHOT.jar /app/springboot-docker-demo.jar
ENTRYPOINT ["java", "-jar", "springboot-docker-demo.jar"]
