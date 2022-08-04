#!/usr/bin/env groovy

pipeline {
    agent none
    tools {
      maven 'maven-3.8'
    }
    parameters {
      string(name: 'VERSION', defaultValue: '1.0.0', description: 'version to deploy on prod')
      choice(name: 'VERSION', choices: ['1.1.0', '1.2.0', '1.3.0'], description: '')
      booleanParam(name: 'executeTest', defaultValue: true)
    }
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
            when {
              expression {
                params.executeTests == true
              }
            }
            steps {
                script {
                    echo "Testing the application..."
                }
            }
        }
        stage('deploy') {
            input {
              message "select the env to deploy to"
              ok "Done"
              parameters {
                choice(name: 'ENV', choices: ['DEV', 'STAGE', 'PROD'], description: '')
              }
            }
            steps {
                script {
                    echo "Deploying the application..."
                    echo "to env ${ENV}"
                    // withCredentials([usernamePassword(credentials: 'server-credentials', usernameVariable: USER, passwordVariable: PASSWORD)]) {
                    //   sh -xc 'echo "using server credentials USER: ${USER} and PASSWORD: ${PASSWORD}"'
                    // }
                }
            }
        }
    }
}
