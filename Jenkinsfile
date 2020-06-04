pipeline {
    agent { label 'dockeredge' }


   def mvn = tool (name: 'Maven3', type: 'maven') + '/bin/mvn'
    stages {
        stage('Mvn Package'){
            sh "${mvn} clean package install"
        }

        stage('Remove Container on Dev Server'){
             sh 'docker rm -v product-catalogue'
         }

        stage('Build Docker Image'){
                sh 'docker build -t muazzamwaheed/product-catalogue:0.0.1 .'
        }

        stage('Push Docker Image'){
            withCredentials([string(credentialsId: 'docker-user', variable: 'dockerPassword')]) {
              sh "docker login -u muazzamwaheed -p ${dockerPassword}"
            }
           sh 'docker push muazzamwaheed/product-catalogue:0.0.1'
        }

        stage('Run Container on Dev Server'){
           sh 'docker run -p 9090:9090 -d --name product-catalogue muazzamwaheed/product-catalogue:0.0.1'
        }
    }

}