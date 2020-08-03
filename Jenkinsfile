pipeline {
    agent any
    tools { 
        maven 'Maven 3.6.3' 
        jdk 'jdk-11' 
    }
    environment {
        JAVA_HOME = "${jdk}/bin"
    }
    stages {
        stage ('Initialize') {
            steps {
                sh '''
                    echo "PATH = ${PATH}"
                    echo "M2_HOME = ${M2_HOME}"
                    echo "JAVA_HOME = ${JAVA_HOME}"
                ''' 
            }
        }

        stage ('Build') {
            steps {
                sh 'mvn install' 
            }
            post {
                success {
                    junit 'target/surefire-reports/**/*.xml' 
                }
            }
        }
    }
}
