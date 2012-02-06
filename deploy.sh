#!/bin/sh

source ./version.properties

MESSAGE="Snapshot $version"

mvn -DaltDeploymentRepository=snapshot-repo::default::file:../mvn-repo/snapshots clean deploy
cd ../mvn-repo/
git add *
git commit -m "$MESSAGE"
git push origin master