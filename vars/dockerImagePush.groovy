#!/bin/usr/env groovy
import com.example.Docker
def call(String imageName) {
    return new Docker(this).dockerImagePush(imageName)
}