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
                run(java : 'JAVA_HOME') {
                    bat 'java -jar target/testset.jar'
                }

//                bat 'java -jar target/testset.jar'
            }
        }
    }
}