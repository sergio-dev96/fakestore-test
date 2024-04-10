pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                // Get some code from a GitHub repository
                git branch: 'main', url: 'https://github.com/sergio-dev96/fakestore-test.git'


            }
        }

        stage('Run Test'){
            steps{
                withMaven(maven: 'MAVEN_HOME'){
                    // Run Maven on a Unix agent.
                    sh "mvn clean verify"

                    // To run Maven on a Windows agent, use
                    //bat "mvn clean verify"
                }
            }
        }
    }

    post {
        always {
            script {
                allure([
                        includeProperties: false,
                        jdk              : '',
                        properties       : [],
                        reportBuildPolicy: 'ALWAYS',
                        results          : [[path: 'target/allure-results']]
                ])
            }
        }
    }
}