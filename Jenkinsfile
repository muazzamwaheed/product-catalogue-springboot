pipeline {
    agent any
    stages {
        stage ('Compile Stage') {
            steps {
                    sh 'mvn clean compile'
            }
        }
        stage ('Test Stage') {
            steps {
                    sh 'mvn test'
            }
        }

        stage ('Deploy Stage') {
            steps {
                    sh 'mvn deploy'
            }
        }
    }
}