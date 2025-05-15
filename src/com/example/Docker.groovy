#!/usr/bin/env groovy

package com.example

class Docker implements Serializable {
    def script

    Docker(script) {
        this.script = script
    }
    def buildDockerImage(String imageName){
        script.withCredentials([
                script.usernamePassword(credentialsId: 'dockerhub-credential', usernameVariable: 'USER', passwordVariable: 'PWD')
        ]) {
            script.sh 'echo Logging into Docker...'
            script.sh "docker build -t $imageName ."
            script.sh "echo $script.PWD | docker login -u $script.USER  --password-stdin"
            script.sh "docker push $imageName"
        }
    }


}