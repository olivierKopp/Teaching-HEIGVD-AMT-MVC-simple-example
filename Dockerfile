FROM jboss/wildfly
COPY /target/mvc-simple.war /target/mvc-simple.war
ADD /target/mvc-simple.war /opt/jboss/wildfly/standalone/deployments/

EXPOSE 8080