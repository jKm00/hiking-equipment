<div id="top"></div>
<!--
*** Thanks for checking out the Best-README-Template. If you have a suggestion
*** that would make this better, please fork the repo and create a pull request
*** or simply open an issue with the tag "enhancement".
*** Don't forget to give the project a star!
*** Thanks again! Now go create something AMAZING! :D
-->

<!-- PROJECT SHIELDS -->
<!--
*** I'm using markdown "reference style" links for readability.
*** Reference links are enclosed in brackets [ ] instead of parentheses ( ).
*** See the bottom of this document for the declaration of the reference variables
*** for contributors-url, forks-url, etc. This is an optional, concise syntax you may use.
*** https://www.markdownguide.org/basic-syntax/#reference-style-links
-->

[![Contributors][contributors-shield]][contributors-url]
[![Forks][forks-shield]][forks-url]
[![Stargazers][stars-shield]][stars-url]
[![Issues][issues-shield]][issues-url]
[![MIT License][license-shield]][license-url]
[![LinkedIn][linkedin-shield]][linkedin-url]

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
4. Enable "EnvFile" in "Run/Debug Configurations" and select the .env file created in step 1

### Running the App

1. Run `docker compose up -d` in terminal. (Spins up a docker container for postgres)
2. Run backend from idea or another docker container

## Link to Postman test for security

https://www.getpostman.com/collections/1591bbc3e3de4d28a527
