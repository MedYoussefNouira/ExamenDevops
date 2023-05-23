pipeline {
    agent any

    stages {
        stage('Clone') {
            steps {
                // Cloning the repository
                git 'https://github.com/MedYoussefNouira/ExamenDevops.git'
            }
        }

        stage('Build') {
            steps {
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
