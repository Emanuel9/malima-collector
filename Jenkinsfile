pipeline {
    agent {
        label 'MalimaCollector'
    }
    environment {
        DISABLE_AUTH = 'true'
        DB_ENGINE = 'mysql'
    }

    stages {
        stage('Build'){
            steps{
              sh 'mvn clean install'
            }
        }
        stage('Test'){

        }
    }
}