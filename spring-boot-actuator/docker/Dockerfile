FROM dianplus/tomcat:v8.5-jre-alpine
MAINTAINER Analyser, analyser@gmail.com

COPY ROOT.war /tmp/

RUN  mkdir -p /usr/local/tomcat/webapps/ROOT/ && \
     unzip -o /tmp/ROOT.war -d /usr/local/tomcat/webapps/ROOT/ && \
     rm -f /tmp/ROOT.war
