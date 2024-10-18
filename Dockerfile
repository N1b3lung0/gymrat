FROM gradle:8.8-jdk-21-and-22-alpine AS builder
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build -x test

FROM amazoncorretto:21-alpine-jdk AS runner
EXPOSE 8080
COPY --from=builder /home/gradle/src/build/libs/*.jar /app/spring-boot-application.jar
ENTRYPOINT ["java","-XshowSettings:vm","-Xmx4096m","-Djava.security.egd=file:/dev/./urandom","-jar","/app/spring-boot-application.jar"]