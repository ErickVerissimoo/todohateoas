FROM openjdk:17-jdk

VOLUME /tmp

COPY . /app

WORKDIR /app


RUN ./mvnw clean package -DskipTests

ARG JAVA_OPTS
ENV JAVA_OPTS=$JAVA_OPTS

COPY target/todohateoas-0.0.1-SNAPSHOT.jar todohateoas.jar

EXPOSE 3000

ENTRYPOINT ["java", "$JAVA_OPTS", "-Djava.security.egd=file:/dev/./urandom", "-jar", "todohateoas.jar"]
