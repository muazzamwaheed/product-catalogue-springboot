node {
   def mvn = tool (name: 'Maven3', type: 'maven') + '/bin/mvn'

   stage('Mvn Package'){
	   sh "${mvn} clean package install"
   }

   stage('Deploy'){
   	   sh "${mvn} deploy"
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
}