FROM tomcat:9-alpine
MAINTAINER Alexandre Ximenes
COPY . /var/www
WORKDIR /var/www
ENTRYPOINT java -jar -Dspring.profiles.active=$PROFILE /ROOT.jar
#ADD ./docker/mysql-connector-java-5.1.36-bin.jar $CATALINA_HOME/lib

EXPOSE 8080