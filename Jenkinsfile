pipeline {
    agent any
    tools {
        maven 'maven_3.6.1'
    }
    stages {
        stage('Example') {
            steps {
                sh 'clean package'
            }
        }
    }
}