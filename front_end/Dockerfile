FROM node:14 as build
WORKDIR /app
COPY package*.json ./
RUN npm install
RUN npm install react-scripts -g
ARG REACT_APP_PROD_API
ENV REACT_APP_PROD_API=${REACT_APP_PROD_API}
COPY . .
RUN npm run build


FROM nginx:latest
WORKDIR /usr/share/nginx/html
COPY  nginx.conf /etc/nginx/conf.d/default.conf
COPY --from=build /app/build /usr/share/nginx/html
EXPOSE 80