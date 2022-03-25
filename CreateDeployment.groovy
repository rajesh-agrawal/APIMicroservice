node {
    def mvnHome

    stage('Preparation') { // for display purposes
        // Get some code from a GitHub repository
        git branch: 'development', credentialsId: '83d13a35-f879-4676-a291-b7e606528f2e', url: 'https://github.deere.com/vuucfp6/IntegrationTesting'
        // Get the Maven tool.
        // ** NOTE: This 'M3' Maven tool must be configured
        // **       in the global configuration.
        mvnHome = tool 'Maven 3.6.0'
    }
    stage('Build') {
        // Run the maven build
        withEnv(["MVN_HOME=$mvnHome"]) {
           
			sh "mvn -s /var/lib/jenkins/custom_maven_settings/settings.xml -gs /var/lib/jenkins/custom_maven_settings/settings.xml clean install -DskipTests"
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
       
		sh "mvn -s /var/lib/jenkins/custom_maven_settings/settings.xml -gs /var/lib/jenkins/custom_maven_settings/settings.xml jacoco:prepare-agent verify jacoco:report sonar:sonar -Dmaven.test.skip=false -Dsonar.pitest.mode=reuseReport"
                
            
        }
    }
    stage('Results') {
        junit '**/target/surefire-reports/TEST-*.xml'
        archiveArtifacts 'target/*.jar'
    }
}
