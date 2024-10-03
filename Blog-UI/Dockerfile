FROM node:18.20-alpine
LABEL author=kaustubhd9@gmail.com
WORKDIR /app

COPY package.json .
COPY package-lock.json .

RUN npm install
COPY . .
RUN npm run build
EXPOSE 5173
CMD ["sh", "-c", "npm run dev -- --host 0.0.0.0"]
