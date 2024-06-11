# Stage 1: Construire l'application Angular
FROM node:14 as angular-build
WORKDIR /app
COPY package.json package-lock.json ./
RUN npm ci
COPY . .
RUN npm run build -- --output-path=dist

# Stage 2: Construire l'image finale
FROM nginx:latest
COPY --from=angular-build /app/dist /usr/share/nginx/html
COPY nginx.conf /etc/nginx/conf.d/default.conf
EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]