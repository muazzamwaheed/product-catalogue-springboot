node {
   def mvn = tool (name: 'Maven3', type: 'maven') + '/bin/mvn'

   stage('Mvn Package'){
	   sh "${mvn} clean package"
   }
}