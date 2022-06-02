<!-- Tamplate from https://github.com/othneildrew/Best-README-Template -->
<div id="top"></div>

<!-- PROJECT LOGO -->
<br />
<div align="center">
  <a href="https://github.com/othneildrew/Best-README-Template">
    <img src="images/logo.png" alt="Logo" width="80" height="80">
  </a>

  <h3 align="center">XXS Hiking Equipment</h3>

  <p align="center">
    A project to learn frontend & backend development in our batchelor course!
    <br />
    <br />
    <a href="http://gr02.appdev.cloudns.ph/">View Demo</a>
    ·
    <a href="https://github.com/jKm00/hiking-equipment/issues">Report Bug</a>
    ·
    <a href="https://github.com/jKm00/hiking-equipment/issues">Request Feature</a>
  </p>
</div>

<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#built-with">Built With</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#backend"backend>Backend</a>
            <ul>
                <li><a href="#intellij-setup">IntelliJ Setup</a></li>
                <li><a href="#running-the-backend">Running the Backend</a></li>
            </ul>
        </li>
        <li><a href="#frontend"backend>Frontend</a></li>
      </ul>
    </li>
    <li><a href="#license">License</a></li>
    <li><a href="#contact">Contact</a></li>
    <li><a href="#acknowledgments">Acknowledgments</a></li>
    <li><a href="#postman-tests">Postman tests</a></li>
  </ol>
</details>

<!-- ABOUT THE PROJECT -->

## About The Project

![XXS Front Page Screen Shot](documentation/readme-images/front-page.png)

A project to learn both frontend and backend development. This project is used in our batchelor program for learning purposes only.

Our webpage is designed for a fictional company (XXS) with the main purpose of selling premium hiking equipment. For now you can add items to cart and place an order, but the order will never get processed.

<p align="right">(<a href="#top">back to top</a>)</p>

### Built With

The frameworks and tools used in this project:

- [React.js](https://reactjs.org/)
- [Spring Boot](https://spring.io/)
- [PostgreSQL](https://www.postgresql.org/)
- [Docker](https://www.docker.com/)

<p align="right">(<a href="#top">back to top</a>)</p>

<!-- GETTING STARTED -->

## Getting Started

### Backend

#### IntelliJ SetUp

1. Create an `.env` file in the root folder of the backend (/backend)
2. Add environment variabler:
   - `POSTGRES_USERNAME`
   - `POSTGRES_PASSWORD`
   - `DATABASE_NAME`
   - `POSTGRES_PORT`
3. Download and install ".env file support" plugin for intellij. (Make sure it's working, might need to restart idea)
4. Enable "EnvFile" in "Run/Debug Configurations" and select the `.env` file created in step 1

#### Running the Backend

1. Run `docker compose up -d` in terminal. (Spins up a docker container for postgres)
2. Run backend from idea or another docker container

### Frontend

1. Add an `.env` file in the root folder of the frontend (/frontent/webapp)
2. Add environment variable `REACT_APP_API_BASE_URL` that points to the url of the the API (e.g. http://localhost:8080/api)
3. Run `npm install` to make sure all dependencies are installed
4. Run `npm start` to start the web application

<p align="right">(<a href="#top">back to top</a>)</p>

<!-- LICENSE -->

## License

Distributed under NTNU. Only for learning purposes

<p align="right">(<a href="#top">back to top</a>)</p>

<!-- CONTACT -->

## Contact

Eduard Andrei Cristea - eduardac@ntnu.no  
Richileu Alphonso Bailey - richileb@ntnu.no  
Torstein Eide - torstei@ntnu.no  
Joakim Edvardsen - joakied@ntnu.no

<p align="right">(<a href="#top">back to top</a>)</p>

<!-- ACKNOWLEDGMENTS -->

## Acknowledgments

- [Readme Template](https://github.com/othneildrew/Best-README-Template#getting-started)

<p align="right">(<a href="#top">back to top</a>)</p>

## Postman tests

https://www.getpostman.com/collections/1591bbc3e3de4d28a527
