pipeline {
    agent any
    stages {
        stage ('Build') {
            steps {
                sh 'mvn -V install' 
            }
            post {
                success {
                   sh 'ECHO SUCCESS'
                }
            }
        }
    }
}
