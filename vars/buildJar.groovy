#!/usr/bin/env groovy

def call(){
     echo "building the jar file for $BRANCH_NAME..!"
     sh 'mvn clean package' ;
}