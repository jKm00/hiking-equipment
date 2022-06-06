FROM node:latest
# Add a work directory
WORKDIR /webapp
# Cache and Install dependencies
COPY ./webapp/package.json .
COPY ./webapp/package-lock.json .

RUN npm install
# Copy webapp files
COPY ./webapp/ .
# Build the app
CMD ["npm", "start"]
