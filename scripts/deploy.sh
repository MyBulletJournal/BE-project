#!/usr/bin/env bash

PROJECT_ROOT="/home/ubuntu/BulletBox"
#JAR_FILE="$PROJECT_ROOT/bulletBox-webapp.jar"

APP_LOG="$PROJECT_ROOT/application.log"
ERROR_LOG="$PROJECT_ROOT/error.log"
DEPLOY_LOG="$PROJECT_ROOT/deploy.log"

TIME_NOW=$(date +%c)

# 현재 구동중인 어플리케이션 PID 확인
CURRENT_PID=$(sudo docker container ls -q)
echo "$TIME_NOW > 실행된 프로세스 아이디 $CURRENT_PID 입니다." >> $DEPLOY_LOG

if [ -z $CURRENT_PID ]; then
#  echo "$TIME_NOW > 현재 실행중인 애플리케이션이 없습니다" >> $DEPLOY_LOG
  echo "$TIME_NOW > 현재 구동중인 Docker 컨테이너가 없으므로 종료하지 않습니다." >> $DEPLOY_LOG
else
#  echo "$TIME_NOW > 실행중인 $CURRENT_PID 애플리케이션 종료 " >> $DEPLOY_LOG
  echo "$TIME_NOW > sudo docker stop $CURRENT_PID" # 현재 구동중인 Docker 컨테이너가 있다면, 모두 중지
#  kill -15 $CURRENT_PID
  sudo docker stop $CURRENT_PID
  sleep 5
fi

# docker image build
cd /home/ubuntu/BulletBox
sudo docker build -t bulletbox-spring .
sudo docker run -d -p 8080:8080 bulletbox-spring
#echo "$TIME_NOW > $JAR_FILE 파일 복사" >> $DEPLOY_LOG
#cp $PROJECT_ROOT/build/libs/*.jar $JAR_FILE

# jar 파일 실행
#echo "$TIME_NOW > $JAR_FILE 파일 실행" >> $DEPLOY_LOG
#nohup java -jar $JAR_FILE > $APP_LOG 2> $ERROR_LOG &