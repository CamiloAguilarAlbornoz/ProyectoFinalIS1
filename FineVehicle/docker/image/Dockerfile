FROM jboss/wildfly:latest
COPY driver/ /opt/jboss/wildfly/modules/system/layers/base/com/

# Appserver

ENV WILDFLY_USER JCG
ENV WILDFLY_PASS proyectofinal

# Database

ENV DB_NAME vehiculoMulta
ENV DB_USER JCG
ENV DB_PASS proyectofinal
ENV DB_URI db:3306

ENV MYSQL_VERSION 8.0.21
ENV JBOSS_CLI /opt/jboss/wildfly/bin/jboss-cli.sh
ENV DEPLOYMENT_DIR /opt/jboss/wildfly/standalone/deployments/

# Setting up WildFly Admin Console
RUN echo "=> Adding WildFly administrator"
RUN /opt/jboss/wildfly/bin/add-user.sh JCG proyectofinal --silent

EXPOSE 8080 9990 8009
CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0"]
