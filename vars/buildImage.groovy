#!/bin/usr/env groovy
import com.example.Docker
def call(String imageName)
{
    return new Docker(this).buildDockerImage(imageName)

    //this function used when you dont want use package like src/com.example
    //    withCredentials([
    //            usernamePassword(credentialsId: 'dockerhub-credential', usernameVariable: 'USER', passwordVariable: 'PWD')
    //    ]) {
    //        sh 'echo Logging into Docker...'
    //        sh "docker build -t $imageName ."
    //        sh "echo $PWD | docker login -u $USER  --password-stdin"
    //        sh "docker push $imageName"
    //    }
}
