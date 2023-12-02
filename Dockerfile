### baseimage: 컨테이너의 내 에플리케이션이 돌아갈 수 있는 환경을 제공해주는 이미지
# - amazoncorretto:17 이미지 : base 이미지를 Linux로 두고, 그 위에 JDK correto 배포판이 설치된 환경으로 제공하고 있음
# - 이미지는 계층 구조를 띠고 있음! -> 하위에 base 이미지를 두고 그 위로 이미지가 하나씩 쌓이는 형태
FROM amd64/amazoncorretto:17

### baseimage를 바탕으로 다음 설정들을 진행

# RUN, CMD, ENTRYPOINT 등 명령어들이 실행될 컨테이너 속 작업 디렉토리 설정
WORKDIR /app

# COPY {Dockerfile을 기준으로 container에 넣고자 하는 내용의 경로} {container내에 복사할 경로}
# - host machine의 파일/디렉토리를 컨테이너 내 경로에 복사
COPY ./build/libs/cicd-practice-0.0.1-SNAPSHOT.jar /app/APPLICATION.jar

# 컨테이너가 실행될 때 실행할 명령어 지정
# - 위에서 workdir를 /app으로 지정해줬기 때문에 해당 명령어는 /app에서 실행됨
# - 컨테이너의 profile을 지정해줬기 때문에, 다른 환경으로 실행하려면 또다른 Dockerfile을 생성해줘야 한다!
CMD ["java", "-Duser.timezone=Asia/Seoul", "-jar", "-Dspring.profiles.active=deploy", "APPLICATION.jar"]