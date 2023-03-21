pipeline {
	agent { label 'BuiltIn' }
	stages {
		stage('Git Checkout') {
			steps {
				checkout(
			    	[$class: 'GitSCM'],
					url: 'https://github.com/victor-smirnov/selenium-test.git'
				)
			}
		}
		stage('Test Execution') {
			steps {
				sh 'mvn clean verify'
			}
		}
		stage('Publish Report') {
			steps {
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