pipeline {
    agent any
	
	environment {
        PATH = "/usr/share/maven/bin:$PATH"
    }

    stages {
        stage('Clone') {
            steps {
                // Cloning the repository
				sh 'pwd'
				sh 'rm -rf /var/jenkins_home/workspace/azzz/*'
				sh "git clone 'https://MedYoussefNouira:Alternance1997@github.com/MedYoussefNouira/ExamenDevops.git'"
            }
        }

        stage('Build') {
            steps {
				export M2_HOME=/usr/share/maven
				export PATH=$PATH:$M2_HOME/bin
				mvn --version
                sh 'mvn clean install'
            }
        }

        stage('Sonar Analysis') {
            steps {
                // Running Sonar analysis
                withSonarQubeEnv('SonarQube') {
                    sh 'mvn sonar:sonar'
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
