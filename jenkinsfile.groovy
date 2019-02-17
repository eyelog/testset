pipeline {
    agent any

    stages {
        stage ('Compile stage'){
            steps {
                withMaven(maven : 'MAVEN_HOME') {
                    bat 'mvn clean compile'
                }
            }
        }

        stage ('Testing stage') {
            steps {
                withMaven(maven : 'MAVEN_HOME') {
                    bat 'mvn test'
                }
            }
        }

        stage ('Deployment stage') {
            steps {
                withMaven(maven : 'MAVEN_HOME') {
                    bat 'mvn deploy'
                }
            }
        }



        stage ('Running stage') {
            steps {
                bat 'java -cp target/testset.jar'
            }
        }
    }
}