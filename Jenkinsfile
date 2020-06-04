node {
   def mvn = tool (name: 'Maven3', type: 'maven') + '/bin/mvn'
   stage('SCM Checkout'){
	    git branch: 'master',
	    url: 'https://github.com/muazzamwaheed/product-catalogue-springboot'
   }

   stage('Mvn Package'){
	   sh "${mvn} clean package"
   }
}