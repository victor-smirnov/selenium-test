node {
	agent { label 'BuiltIn' }
	tools {
    	maven 'DefaultMaven' 
  	}
	stage('Git Checkout') {
		git branch: 'main', url: 'https://github.com/victor-smirnov/selenium-test.git'
	}
	stage('Test Execution') {
		sh 'mvn clean verify'
	}
	stage('Publish Report') {
		publishHTML(target: [
			reportName: 'Serenity Report',
			reportDir: 'target/site/serenity',
			reportFiles: 'index.html',
			keepAll: true,
			alwaysLinkToLastBuild: false,
			allowMissing: false			
		])
	}
}