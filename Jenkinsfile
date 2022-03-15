node {
    def mvnHome

    stage('Preparation') { // for display purposes
        // Get some code from a GitHub repository
        git branch: 'master',credentialsId:'a908881-github-token', url: 'https://github.deere.com/vuucfp6/IntegrationTesting'
        // Get the Maven tool.
        // ** NOTE: This 'M3' Maven tool must be configured
        // **       in the global configuration.
        mvnHome = tool 'maven'
    }
    stage('Build') {
        // Run the maven build
        withEnv(["MVN_HOME=$mvnHome"]) {
           
			sh "mvn clean install -DskipTests"
        }
    }
	    stage('UnitTest') {
        // Run the maven build
        withEnv(["MVN_HOME=$mvnHome"]) {
            sh "mvn -Dtest=*,!*integration*/**/* test"
        }
    }
	    stage('IntegrationTest') {
        // Run the maven build
        withEnv(["MVN_HOME=$mvnHome"]) {
        
			sh "mvn test -Dtest=*integration*/**/*"

                
      
        }
    }
 stage('QualityMatrix') {
        // Run the maven build
        withEnv(["MVN_HOME=$mvnHome"]) {
       
		sh "mvn jacoco:prepare-agent verify jacoco:report -Dmaven.test.skip=false"
                
            
        }
    }
    stage('Results') {
        junit '**/target/surefire-reports/TEST-*.xml'
        archiveArtifacts 'target/*.jar'
    }
}
