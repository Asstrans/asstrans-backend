FROM openjdk:17
VOLUME /tmp
EXPOSE 8080
ADD ./target/agremiados-0.0.1-SNAPSHOT.jar agremiados.jar
ENTRYPOINT ["java", "-jar", "/agremiados.jar"]