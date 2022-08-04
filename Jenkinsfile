#!/usr/bin/env groovy

pipeline {
    agent none
    environment {
      NEW_VERSION = '1.3.0'
      SERVER_CREDENTIALS = credentials('server-credentials')
    }
    stages {
        stage('build') {
            steps {
                script {
                    echo "Building the application..."
                    echo "building version ${NEW_VERSION}"
                }
            }
        }
        stage('test') {
            steps {
                script {
                    echo "Testing the application..."
                }
            }
        }
        stage('deploy') {
            steps {
                script {
                    echo "Deploying the application..."
                    echo "using server credentials ${SERVER_CREDENTIALS}"
                }
            }
        }
    }
}
