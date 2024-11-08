pipeline {
    agent any

    tools {
        maven 'Maven'
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean package'
            }
        }

        stage('Test') {
            steps {
                bat 'mvn test'
            }
        }

        stage('Check Docker') {
            steps {
                bat 'docker --version'
            }
        }

        stage('Docker Login') {
    steps {
        withCredentials([usernamePassword(credentialsId: 'dockerhub', passwordVariable: 'DOCKERHUB_PASSWORD', usernameVariable: 'DOCKERHUB_USERNAME')]) {
            echo "DOCKERHUB_USERNAME: ${env.DOCKERHUB_USERNAME}"
            echo "DOCKERHUB_PASSWORD: ${env.DOCKERHUB_PASSWORD}"
            bat "echo %DOCKERHUB_PASSWORD% | docker login -u %DOCKERHUB_USERNAME% --password-stdin"
            echo "DOCKERHUB_PASSWORD: ${env.DOCKERHUB_PASSWORD}"  // This will print the password in the logs (only for debugging purposes!)

        }
    }
}


        stage('Docker Build') {
            steps {
                bat 'docker build -t npc1368/comp367-webapp:latest .'
            }
        }

        stage('Docker Push') {
            steps {
                bat 'docker push npc1368/comp367-webapp:latest'
            }
        }
    }

    post {
        always {
            junit '**/target/surefire-reports/*.xml'
        }
    }
}
