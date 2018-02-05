From java:8
EXPOSE 8082
ADD /target/quiz-service-0.0.1-SNAPSHOT.jar  quiz-service-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-Dspring.profiles.active=docker","-jar","quiz-service-0.0.1-SNAPSHOT.jar"]