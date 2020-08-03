pipeline {
    agent any
    stages {
        stage ('Build') {
            steps {
                withEnv(["JAVA_HOME=${ tool 'jdk-11' }", "PATH+MAVEN=${tool 'Maven 3.6.3'}/bin:${env.JAVA_HOME}/bin"]) {
                   sh 'mvn -V install' 
                }
            }
            post {
                success {
                    junit 'target/surefire-reports/**/*.xml' 
                }
            }
        }
    }
}
