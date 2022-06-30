//Teste
pipeline {
  agent any
  
  stages {
    stage('Get repo') {
      steps {
        git 'https://github.com/bmcentos/jenkins.git'
      }
    }
    stage('Check file') {
      steps {
        sh 'cat pom.xml'
      }
    }
  }
}
