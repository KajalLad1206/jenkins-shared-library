#!/usr/bin/env groovy

package com.example

class Docker implements Serializable {
    def script

    Docker(script) {
        this.script = script
    }
    //    def buildDockerImage(String imageName){
    //        script.sh 'echo Logging into Docker...'
    //        script.withCredentials([
    //                script.usernamePassword(credentialsId: 'dockerhub-credential', usernameVariable: 'USER', passwordVariable: 'PWD')
    //        ]) {
    //            script.sh "docker build -t $imageName ."
    //            script.sh "echo $script.PWD | docker login -u $script.USER  --password-stdin"
    //            script.sh "docker push $imageName"
    //        }
    //    }

    def dockerLogin() {
        script.sh 'echo Logging into Docker...'
        script.withCredentials([
                script.usernamePassword(credentialsId: 'dockerhub-credential', usernameVariable: 'USER', passwordVariable: 'PWD')
        ]) {
                script.sh "echo $script.PWD | docker login -u $script.USER  --password-stdin"
        }
    }
     def dockerBuild(String imageName){
         script.sh "docker build -t $imageName ."
     }
    def dockerImagePush(String imageName){
        script.sh "docker push $imageName"
    }

}