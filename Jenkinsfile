node{
    stage('SCM Checkout'){
       
        git 'https://github.com/marcosmateom/proyectoDB2-seguros.git'
    }
    stage('Compile-Package'){
        //obtener el maven
         def mvnHome = tool name: 'Maven 3.6.2', type: 'maven'

        sh "${mvnHome}/bin/mvn package"
    }
}