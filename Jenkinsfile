#!/usr/bin/env groovy

@Library('jenkins-shared-library')
def gv

pipeline {
    agent any
    tools {
        maven 'maven-3.8'
    }
    stages {
        stage("init") {
            steps {
                script {
                    gv = load "script.groovy"
                }
            }
        }
        stage("build jar") {
            steps {
                script {
                    buildJar()
                }
            }
        }
        stage("build image") {
            steps {
                script {
                    gv.buildImage()
                }
            }
        }
        stage("deploy") {
            steps {
                script {
                  def dockerCmd = 'docker run -p 3000:3080 -d akrivcov/my-repo:1.4'
                  sshagent(['ec2-server-key']) {
                      sh "ssh -o StrictHostKeyChecking=no ec2-user@3.96.130.201 ${dockerCmd}"
                  }
                    // gv.deployApp()
                }
            }
        }
    }
}
