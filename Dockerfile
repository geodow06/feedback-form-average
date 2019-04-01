FROM maven as build
WORKDIR /build
COPY pom.xml .
RUN mvn verify --fail-never
COPY . .
RUN mvn clean package

FROM openjdk:8
COPY --from=build /build/target/feedback-forms-averages-0.0.1-SNAPSHOT.jar averages.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","averages.jar"]
