# Use a Tomcat base image that includes Java
FROM tomcat:8.5-jdk8

# Copy the .war file into the webapps directory of Tomcat
COPY target/*.war /usr/local/tomcat/webapps/app.war
