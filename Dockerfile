FROM maven:latest
RUN mkdir /vietjobs
WORKDIR /vietjobs
COPY . .
EXPOSE 8080
CMD [ "mvn", "spring-boot:run" ]