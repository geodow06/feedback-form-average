FROM maven as build
WORKDIR /build
COPY pom.xml .
COPY . .
RUN mvn clean package

FROM openjdk:8
COPY --from=build /build/target/feedback-form-average-0.0.1-SNAPSHOT.jar average.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","average.jar"]
