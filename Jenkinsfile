node {
    stage('Build ng image') {
        def customNodeImage = docker.build "node-with-ng"
        customNodeImage.inside {
            stage('Pull repository') {
                checkout scm
            }
            stage('Install npm') {
                sh 'npm install'
            }
            stage('Build') {
                sh 'ng build --prod'
            }
            stage('Stash dist folder') {
                stash includes: 'dist/**/*', name: 'distFolder'
            }
        }
    }
}
node {
    stage('Unstash dist folder') {
        unstash 'distFolder'
    }
    stage('Build Docker image') {
        def customImage = docker.build("frankmaciel/snakes-and-ladders-angular-server", "-f ./dockerfiles/nginx/Dockerfile .")
        stage('Push Docker image') {
            docker.withRegistry('https://registry.hub.docker.com', 'dockerhub') {
                customImage.push("$BUILD_NUMBER")
                customImage.push("latest")
            }
        }

    }
}
Commit it, and create a new pipeline in Jenkins just as you did before for the server. Also, add the web hook to GitHub so that every commit triggers a new build.

When everything has been pushed to the Docker registry, just pull and start both application from the SSH console, now with more Docker options activated:

docker pull (yourrepositoryname)/basic-server
docker run --name basic-server --rm --detach -p 8081:8081 (yourrepositoryname)/basic-server
docker pull (yourrepositoryname)/basic-client
docker run --name basic-client --rm --detach -p 80:80 (yourrepositoryname)/basic-client
Now access to your external IP (without adding any port, as we are using the default HTTP port 80), and test that your client works as expected.

Conclusion
This tutorial should have provided a good basis to start developing a more complex application, with the advantage that we can concentrate on just writing code, as applying the new changes is as easy as downloading the latest Docker image (which has been built automatically) and starting it in a new container. I hope it helps someone else too, but it definitely made me learn even more about all the technologies involved. Happy coding!

You can find both applications on my GitHub repository:

Client: https://github.com/AnsgarNell/client
Server: https://github.com/AnsgarNell/server
