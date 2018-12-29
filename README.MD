##Car Store
This is a test Spring Boot project.
It's a simple Java web application

####Bulid Instructions ####
* Add your own google registration. __${clientSecret}__ from application.properties - is a google secret is a private to allow registration via google. 
You can easily make your own and don't forget add it as aa environment variable. 
* Run SQL scripts __session_tables.sql__ to create databases for web-sessions. It's necessary and be sure  you're creating it in the same database.
Pay attention that my database is Postgres so in case of using other database you'll have to change dialect by yourself. 
 