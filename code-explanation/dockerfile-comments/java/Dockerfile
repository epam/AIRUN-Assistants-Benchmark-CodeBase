FROM eclipse-temurin:17-jre

LABEL maintainer="testUser@gmail.com"

RUN useradd -m -s /bin/bash appuser

RUN apt-get update && \
    apt-get install -y --no-install-recommends curl && \
    rm -rf /var/lib/apt/lists/*

EXPOSE 8080

ARG JAR_FILE=target/infra-code-explanation-1.0-SNAPSHOT.jar

COPY ${JAR_FILE} /home/appuser/app.jar

RUN chown appuser:appuser /home/appuser/app.jar

USER appuser

ENTRYPOINT ["java", "-jar", "/home/appuser/app.jar"]
