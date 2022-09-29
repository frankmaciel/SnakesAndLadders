pipeline {
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
pipeline {
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