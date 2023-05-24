pipeline {
    agent any
	
	tools{
		maven 'maven-4.0.0'
	}
	
    stages {
        stage('Clone') {
            steps {
                // Cloning the repository
				echo 'cloning into'
				sh 'pwd'
				sh 'rm -rf /var/jenkins_home/workspace/azzz/*'
				sh "git clone 'https://MedYoussefNouira:Alternance1997@github.com/MedYoussefNouira/ExamenDevops.git'"
            }
        }

        stage('Build') {
            steps {
				sh 'mvn -f ExamenDevops/pom.xml clean install'
            }
        }
			
			 stage('Test') {
            steps {
                sh 'mvn -f ExamenDevops/pom.xml test'
            }
			}

        stage('Sonar Analysis') {
            steps {
                // Running Sonar analysis
                withSonarQubeEnv('sonar') {
                    sh 'mvn -f ExamenDevops/pom.xml sonar:sonar -Dsonar.login=sqa_8fed2ba5389df35435b294b743b28f852b7f9b7c'
                }
            }
			}
	

        stage('Deploy to Nexus') {
            steps {
                // Deploying to Nexus repository
                withMaven(maven: 'Maven') {
                    sh 'mvn deploy'
                }
            }
        }
    }
}
