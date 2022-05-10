# Webshop for XXS

## Setup

### Run/create docker container for postgres

- Install docker
- First time run `docker run -d --name some-name -p 5000:5432 -e POSTGRESS_PASSWORD=mysecretpassword` where "some-name" is the name of the container and "mysecretpassword" is the database password
- Later you can use docker dashboard to start the container

### Fix env variables

- In intellij, select "Edit configuration"
- Type in "prod" as active profiles
- Add environment variable for the 4 variables specified in application-prod.properties
  - POSTGRES_PORT: the port specified when creating the container, example: 5000
  - DATABASE_NAME: the name of the database within the container
  - POSTGRES_ROOT_USERNAME: postgres unless other was specified
  - POSTGRES_ROOT_PASSWORD: the password you wrote when creating the container

## Link to Postman test for security

https://www.getpostman.com/collections/1591bbc3e3de4d28a527
