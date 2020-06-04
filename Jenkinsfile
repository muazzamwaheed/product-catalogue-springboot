pipeline {
    agent any
    stages {
        stage('Example') {
            steps {
                def mvnHome = tool name: 'Maven3', type: 'maven'
                def mvnCMD = "${mvnHome}/bin/mvn"
                sh "${mvnCMD} clean package"
            }
        }
    }
}