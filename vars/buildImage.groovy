#!/bin/usr/env groovy

def call(String imageName)
{
    withCredentials([
            usernamePassword(credentialsId: 'dockerhub-credential', usernameVariable: 'USER', passwordVariable: 'PWD')
    ]) {
        sh 'echo Logging into Docker...'
        sh "docker build -t $imageName ."
        sh "echo $PWD | docker login -u $USER  --password-stdin"
        sh "docker push $imageName"
    }
}
