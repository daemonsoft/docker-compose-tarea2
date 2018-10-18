FROM node:8.12.0-alpine
RUN git clone https://github.com/jpoh97/PlayFramework-Angular.git /app \
    && cd /app \
    && npm install 
ENTRYPOINT [ "npm start" ]