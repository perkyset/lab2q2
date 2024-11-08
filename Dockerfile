# Use a Tomcat base image that includes Java
FROM tomcat:8.5-jdk8

# Copy the .war file to the Tomcat webapps directory
COPY target/*.war /usr/local/tomcat/webapps/app.war

# Expose port 8080 for Tomcat
EXPOSE 8080
