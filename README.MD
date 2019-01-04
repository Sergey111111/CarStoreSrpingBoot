[![Build Status](https://travis-ci.org/travis-ci/travis-web.svg?branch=master)](https://travis-ci.org/travis-ci/travis-web)

##Car Store

This is a test Spring Boot project.
It's a simple Java web application

####Bulid Instructions ####
* Add your own google registration codes. __${clientSecret}__ from application.properties - is a google secret is a private to allow registration via google. 
You can easily make your own and don't forget add it as aa environment variable. 
* Run SQL script __auxilary.sql__ to create databases for web-sessions. It's necessary because other scripts will be run by 
Spring. All the entities will be created automatically.Pay attention that my database is Postgres so in case of using 
other database you'll have to change dialect by yourself. 
 