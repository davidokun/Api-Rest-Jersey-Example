FROM tomcat:8-alpine

ADD files/tomcat-users.xml /usr/local/tomcat/conf/
ADD files/manager.xml /usr/local/tomcat/conf/Catalina/localhost/

COPY rest-jersey-messenger.war /usr/local/tomcat/webapps/myapp.war

EXPOSE 8080