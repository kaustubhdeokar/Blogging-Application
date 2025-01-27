# create jar file with command: - `./mvnw clean package -Dprofile=prod`
# build image with command : sudo docker build -t backend_blogit .
FROM openjdk:17
LABEL author=kaustubhd9@gmail.com
EXPOSE 8081

ADD ./target/hrm-backend-1.jar backend.jar
ENTRYPOINT ["java","-jar","backend.jar"]
CMD ["echo","-------------------------------Backend up-------------------------------"]