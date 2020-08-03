pipeline {
    agent any
    stages {
        stage ('Build') {
            steps {
                sh 'mvn -V install' 
            }
            post {
                success {
                    junit 'target/surefire-reports/**/*.xml' 
                }
            }
        }
    }
}
