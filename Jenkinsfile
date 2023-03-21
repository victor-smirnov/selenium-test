node {
	agent { label 'BuiltIn' }
	tool name: 'DefaultMaven', type: 'maven' 
	stage('Git Checkout') {
		checkout([
        	$class: 'GitSCM', 
        	branches: [[name: '*/main']], 
        	doGenerateSubmoduleConfigurations: false, 
        	extensions: [[$class: 'CleanCheckout']], 
        	submoduleCfg: [], 
        	userRemoteConfigs: [[url: 'https://github.com/victor-smirnov/selenium-test.git']]
    	])
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