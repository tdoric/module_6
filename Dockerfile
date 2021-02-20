FROM adoptopenjdk/openjdk11:latest
VOLUME /tmp
EXPOSE 8092
ARG JAR_FILE=target/m6.jar
ADD ${JAR_FILE} group.jar
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -jar group.jar" ]