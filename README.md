# Webshop for XXS

## Setup Intellij

### Initial Setup

1. Create an .env file in the root folder of the backend
2. Add environment variabler:
    - POSTGRES_USERNAME
    - POSTGRES_PASSWORD
    - DATABASE_NAME
    - POSTGRES_PORT
3. Download and install ".env file support" plugin for intellij. (Make sure it's working, might need to restart idea)
4. Enable "EnvFile" in "Run/Debug Configurations"
5. Select the .env file you created in step 1

### Running the App

1. Run `docker compose up -d` in terminal. (Spins up a docker container for postgres)
2. Run backend from idea or another docker container

## Link to Postman test for security

https://www.getpostman.com/collections/1591bbc3e3de4d28a527
