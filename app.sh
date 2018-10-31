#!/bin/bash

IMAGE=ngockhuong/identity:1.0.0
CONTAINER=identity_app
SHARE_VOLUME=app-data

createVolume() {
    echo "Create $SHARE_VOLUME volume"
    docker volume create --driver local \
        --opt type=none \
        --opt device=~/develop/project/my-workspace/java/identity/data \
        --opt o=bind \
        --name $SHARE_VOLUME
}

buildDockerImages() {
    if [ "$(docker images -q $IMAGE)" ]; then
        docker rmi $IMAGE -f
    fi

    docker build -t $IMAGE .
}

deploy() {
    createVolume
    buildDockerImages
    start
}

start() {
    if [ "$(docker ps -aq -f status=exited -f name=$CONTAINER)" ]; then
        docker start $CONTAINER
    elif [ "$(docker ps -q -f name=$CONTAINER)" ]; then
        echo "$CONTAINER is already running"
    else
        echo $CONTAINER
        echo $IMAGE
        docker run -it -p 8080:8080 -v $SHARE_VOLUME:/data -v ~/.m2:/root/.m2 --name $CONTAINER $IMAGE
    fi
}

stop() {
    if [ "$(docker ps -q -f name=$CONTAINER)" ]; then
        docker stop $CONTAINER
    fi
}

clean() {
    if [ "$(docker ps -aq -f status=exited -f name=$CONTAINER)" ]; then
        docker rm $CONTAINER
    fi
}

rebuild() {
    stop
    clean
    start
}

help() {
    echo "
        Usage: ./app.sh [OPTION]

        Options:
            -h, --help       More option information
                --deploy     Deploy application on container docker (Build image, build project and run)
                --rebuild    Rebuild application on container docker (Rebuild project and rerun)
                --start      Start application on container docker
                --stop       Stop application
            -c, --clean      Clean all container exited
    "
}


# main script

while [ ! $# -eq 0 ]
do
    case "$1" in
        --help | -h)
            echo "-- help --"
            help
            exit
            ;;
        --deploy)
            echo "-- deploy application on docker --"
            deploy
            exit
            ;;
        --deploy)
            echo "-- rebuild application on docker --"
            rebuild
            exit
            ;;
        --start)
            echo "-- start application --"
            start
            exit
            ;;
        --stop)
            echo "-- stop application --"
            stop
            exit
            ;;
        --clean)
            echo "-- clean application container exited --"
            clean
            exit
            ;;
    esac
    shift
done
