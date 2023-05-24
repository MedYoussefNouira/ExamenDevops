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

        stage('Sonar Analysis') {
            steps {
                // Running Sonar analysis
                withSonarQubeEnv('sonar') {
                    sh 'mvn -f ExamenDevops/pom.xml sonar:sonar -Dsonar.projectKey=Jenkins'
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
