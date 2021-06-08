# Abacc Cultural Club Portal

Online management portal of an organization with admin panel. Feel free to use or modify this project.<br>
Postgres is used for data persistance and Spring Security & JWT are used for handling authentication.<br>
In addition, botstrap is used for template design<br><br>

# Docker Build
To build docker image, install docker in your system <br>
then open terminal in your project directory and run the following command <br>

```
mvn clean install -DskipTests=true
```
It will create the "abaccAdelaide.jar" file in target directory then run the following command to create docker image <br>

```
docker compose up
```
Now you have 2 docker containers up and running in your system.<br>
