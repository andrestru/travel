FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
EXPOSE 8085
COPY tmp/.*jar /travel.jar
ENTRYPOINT ["java","-jar","/travel.jar"]