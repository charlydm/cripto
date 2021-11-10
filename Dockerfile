FROM openjdk:11-jre
COPY "./target/cripto-0.0.1.jar" "cripto.jar"
EXPOSE 8080
ENTRYPOINT [ "java","-jar","cripto.jar" ]