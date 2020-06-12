node {

    def mvn = tool (name: 'Maven3', type: 'maven') + '/bin/mvn'

        stage('Mvn Package'){
            sh "${mvn} clean package install"
        }

        stage('Remove Container on Dev Server'){
             sh 'docker stop -t 10 product-catalogue'
             sh 'docker rm -v product-catalogue'
         }

        stage('Build Docker Image'){
                sh 'docker build -t muazzamwaheed/product-catalogue:latest .'
        }

        stage('Push Docker Image'){
            withCredentials([string(credentialsId: 'docker-user', variable: 'dockerPassword')]) {
              sh "docker login -u muazzamwaheed -p ${dockerPassword}"
            }
           sh 'docker push muazzamwaheed/product-catalogue:latest'
        }

        stage('Run Container on Dev Server'){
           sh 'docker run -p 9090:9090 -d --name product-catalogue muazzamwaheed/product-catalogue:latest'
        }
}