	pipeline {
	    environment {

            registry = "seifderbali/devopsrepository"

            registryCredential = 'dockerhub-id'

            dockerImage = ''

    }
	        agent any

     stages {
        stage('GIT') {

         steps {
                echo 'cloning project from GIT'
                git branch : "master" ,
		credentialsId: 'seifpfe' ,
                url :'https://github.com/seifderbali/DevOpsPipeline.git'
            }
        }
        stage('MVN CLEAN') {
            steps {
               sh 'mvn clean'
            }
        }
        stage('MVN COMPILE') {
            steps {
               sh 'mvn compile'

           }
        }

         stage('Scan') {
               steps {
                 sh "mvn sonar:sonar \
                       -Dsonar.projectKey=BiatDSI \
                       -Dsonar.host.url=http://192.168.1.14:9000 \
                       -Dsonar.login=cb88a6d5fa5ddfa3f62e331bc84dfa25151d5786"
                    echo "sonar succefully"

                      }
                        }

            stage('Nexus Deploy') {
                 steps {
                     sh 'mvn deploy -e'
            }


        }

              stage('Building our image') {

            steps {

                script {

                    dockerImage = docker.build registry + ":latest"

                }

            }

        }

        stage('Deploy our image') {

            steps {

                script {

                    docker.withRegistry( '', registryCredential ) {

                        dockerImage.push()

                    }
                }

            }

        }

        stage('Cleaning up') {

            steps {

                sh "docker rmi $registry:latest"

            }

        }

	    stage(' Docker Compose') {

            steps {
                sh "docker-compose up -d"

            }

        }
}
}
