#!/bin/usr/env groovy

def call()
{
    withCredentials([
            usernamePassword(credentialsId: 'dockerhub-credential', usernameVariable: 'USER', passwordVariable: 'PWD')
    ]) {
        sh 'echo Logging into Docker...'
        sh 'docker build -t kajallad126/java-maven-app:1.5 .'
        sh "echo $PWD | docker login -u $USER  --password-stdin"
        sh 'docker push kajallad126/java-maven-app:1.5'
    }
}
