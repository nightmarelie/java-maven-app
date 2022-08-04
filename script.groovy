def buildJar() {
    echo "building the application..."
    sh 'mvn package'
} 

def buildImage() {
    echo "building the docker image..."
    withCredentials([usernamePassword(credentialsId: 'nexus-credentials', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh 'docker build . -t 159.223.162.80:8083/java-maven-app:jma-2.0'
        sh "echo $PASS | docker login -u $USERNAME --password-stdin 159.223.162.80:8083"
        sh 'docker push 159.223.162.80:8083/java-maven-app:jma-2.0'
    }
} 

def deployApp() {
    echo 'deploying the application...'
} 

return this
