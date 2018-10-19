FROM node:8.12.0-alpine
WORKDIR /app
COPY . .
EXPOSE 4200
RUN npm install 
ENTRYPOINT [ "npm", "start" ]