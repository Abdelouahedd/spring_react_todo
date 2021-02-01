pipeline {
    agent any

    stages {
        stage('Testing Environment') {
            steps {
                dir("back-end/") {
                    sh 'mvn test-Dtest=DemoApplicationTests'
                }
            }
        }
        stage('Build') {
            steps {
                dir("back-end/"){
                    sh 'mvn install -DskipTests'
                }
            }
        }
        stage('Staging') {
            steps {
                sh 'sudo docker-compose build'
                sh 'sudo docker-compose up -d'
            }
        }
      /*   stage('end2end Tests') {
            steps {
                dir("server/") {
                    sh 'mvn test -Dtest=SeleniumSuite'
                }
            }
        } */
    }
}