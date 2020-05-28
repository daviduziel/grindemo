podTemplate(containers: [
    containerTemplate(name: 'maven', image: 'maven:3.6.1-jdk-13-alpine', ttyEnabled: true, command: 'cat'),
  ]) {

    node(POD_LABEL) {
        stage('Get a Maven project') {
            git 'https://github.com/daviduziel/grindemo.git'
            container('maven') {
                stage('Build a Maven project') {
                    sh 'mvn -B clean install'
                }
            }
        }

    }
}
