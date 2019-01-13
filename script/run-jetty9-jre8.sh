#!/bin/sh
UseImage="jetty:9.2.26-jre8"
ContainerName="jetty9-jre8"
docker stop $ContainerName
docker rm $ContainerName
docker run -p 18081:8080 -d --rm --name $ContainerName $UseImage
