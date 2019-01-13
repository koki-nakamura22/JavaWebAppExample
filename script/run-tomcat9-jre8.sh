#!/bin/bash
# Declare variables.
TomcatMajorVer=9
JreMajorVer=8
UseVolumeName="tomcat9"
VolumeDir="/var/lib/docker/volumes/${UseVolumeName}/_data"
CreateServerDir="${HOME}/server/tomcat"
CreateSymbolicLink="${CreateServerDir}/${TomcatMajorVer}"
UseImage="tomcat:${TomcatMajorVer}-jre${JreMajorVer}"
ContainerName="tomcat${TomcatMajorVer}-jre${JreMajorVer}"

# Stop and remove docker container.
docker stop $ContainerName
docker rm $ContainerName

# Create and run docker container.
docker run -p 18080:8080 -d --rm --name $ContainerName -v $UseVolumeName:/usr/local/tomcat $UseImage

# Create symbolic link.
mkdir -p $CreateServerDir
rm $CreateSymbolicLink
ln -sf $VolumeDir $CreateSymbolicLink

# Change permission of docker volume directory for allow access.
sudo chmod 777 -R $VolumeDir
