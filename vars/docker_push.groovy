#def call(String Project, String ImageTag, String dockerhubuser){
 # withCredentials([usernamePassword(credentialsId: 'dockerhubuser', passwordVariable: 'dockerhubpass', usernameVariable: 'dockerhubuser')]) {
  #    sh "docker login -u ${dockerhubuser} -p ${dockerhubpass}"
  #}
  #sh "docker push ${dockerhubuser}/${Project}:${ImageTag}"
#}
#def call(String project, String imageTag, String dockerhubuser){

 #   withCredentials([
  #      usernamePassword(
   #         credentialsId: 'dockercred',
    #        usernameVariable: 'DOCKER_USER',
     #       passwordVariable: 'DOCKER_PASS'
     #   )
    #]) {

     #   sh '''
      #      echo "$DOCKER_PASS" | docker login -u "$DOCKER_USER" --password-stdin
       # '''

#        sh """
 #           docker push ${DOCKER_USER}/${project}:${imageTag}
  #      """
   # }
#}/.

def call(String project, String imageTag, String dockerhubuser) {
    withCredentials([
        usernamePassword(
            credentialsId: 'docker',
            usernameVariable: 'DOCKER_USER',
            passwordVariable: 'DOCKER_PASS'
        )
    ]) {
        sh '''
            echo "$DOCKER_PASS" | docker login \
                -u "$DOCKER_USER" --password-stdin
        '''

        sh """
            docker push ${dockerhubuser}/${project}:${imageTag}
        """
    }
}
