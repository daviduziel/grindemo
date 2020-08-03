pipeline {
    agent any
    stages {
        stage ('Build') {
            steps {
                sh 'mvn install' 
            }
            post {
                success {
                   sh 'echo SUCCESS'
                }
            }
        }
    }
}
