[![Build Status](https://travis-ci.org/travis-ci/travis-web.svg?branch=master)](https://travis-ci.org/travis-ci/travis-web)

# Carstore

> Sping Boot and Vue.js project

## Build Setup

```
 install dependencies
npm install

serve with hot reload at localhost:8080
npm run dev

build for production with minification
npm run build

webpack required

Server runnig

Add your own google registration. ${clientSecret} from application.properties - 
is a google secret is a private to allow registration via google. 
You can easily make your own and don't forget add it as aa environment variable.

Run SQL scripts session_tables.sql to create databases for web-sessions. 
It's necessary and be sure you're creating it in the same database. 
Pay attention that my database is Postgres so in case of using other database 
you'll have to change dialect by yourself.
```
To Run the app in dev mode properly you need to run **both** webpack and sping boot
server. Spring will load java container with index.html inside witch links to 
main js located virtually by webpack. Therefore you get dynamic front-end with
full working server side. 

