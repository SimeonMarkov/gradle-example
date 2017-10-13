node {
   // Mark the code checkout 'stage'....
   stage "Checkout"

   // Checkout code from repository
   checkout scm

   def workspace = pwd()
   echo "Workspace is ${workspace}"

   // Mark the code build 'stage'....
   stage "Build"
   // Run the gradle build
   sh " bash cd ~/IdeaProjects/gradle-example; pwd"
}
