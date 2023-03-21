pipeline {
	agent { label 'BuiltIn' }
	stages {
		stage('Git Checkout') {
			step {
				checkout(
			    	[$class: 'GitSCM'],
					url: 'https://github.com/victor-smirnov/selenium-test.git'
				)
			}
		}
		stage('Test Execution') {
			step {
				sh 'mvn clean verify'
			}
		}
		stage('Publish Report') {
			step {
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
	}
}