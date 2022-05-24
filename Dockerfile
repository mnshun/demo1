# First stage: complete build environment
FROM maven:3.8.5-amazoncorretto-17 AS builder

# add pom.xml and source code
ADD ./pom.xml pom.xml
ADD ./src src/

# package jar
RUN mvn clean package -DskipTests

# Second stage: minimal runtime environment
FROM amazoncorretto:17

# copy jar from the first stage
COPY --from=builder target/demo1-0.0.1-SNAPSHOT.jar demo1-0.0.1-SNAPSHOT.jar

EXPOSE 80

CMD ["java", "-jar", "demo1-0.0.1-SNAPSHOT.jar"]