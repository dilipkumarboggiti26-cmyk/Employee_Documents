FROM eclipse-temurin:17-jdk

COPY target/EmployeeDocument-0.0.1-SNAPSHOT.jar EmployeeDocument-0.0.1-SNAPSHOT.jar

ENTRYPOINT [ "java","-jar","/EmployeeDocument-0.0.1-SNAPSHOT.jar" ]

EXPOSE 8080