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
                bat 'echo Yutur008* | docker login -u npc1368 --password-stdin'
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