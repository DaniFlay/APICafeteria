FROM amazoncorretto:17-alpine3.17

EXPOSE 9995

ADD target/MenuSpring-2.0.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]