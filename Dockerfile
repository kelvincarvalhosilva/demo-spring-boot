FROM eclipse-temurin:11-jre-alpine
RUN mkdir /opt/app
COPY ./build/libs/demo-spring-boot-0.0.1-SNAPSHOT.jar /opt/app
CMD ["java", "-jar", "/opt/app/demo-spring-boot-0.0.1-SNAPSHOT.jar"]


