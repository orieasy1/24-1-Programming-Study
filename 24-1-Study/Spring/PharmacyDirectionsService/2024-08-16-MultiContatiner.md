
# 도커를 이용한 다중 컨테이너 환경 구성하기
1. 로컬 환경의 프로파일 채우기
2. 로컬 환경에서 실행할 도커 컴포즈 작성

## 도커 컴포즈 파일 작성
도커 컴포즈란 멀티 컨테이너 도커 어플리케이션을 정의하고실행하는 도구
여러 개의 토커 컨테이너로 부터 이루어진 서비스를 구축 및 네트워크 연결, 실행 순서를 자동으로 관리한다.
<br><br>
yaml 파을은 로컬 환경과 운영환경에서 조금 다르다.
로컬에서 개발을 할 때는 SpringBoot 어플리케이션과 데이터베이스 레디스 모두 다 컨테이너로 띄워서 개발한다고 하면 어플리케이션을 디버깅하기 어렵다.
로컬 환경에서는 데이터베이스와 레디스만 컨테이너로 만들어서 띄워두고 스프링부트 어플리케이션은 인텔리제이를 통해서 편하게 디버깅하면서 테스트할 수 있도록 환경을 세팅해보겠다.
클라우드 서비스 베포할 때는 어플리케이션과 데이터베이스 레디스 모두 다중 컨테이너로 구성해서 배포한다ㅏ.

### 도커 컴포즈 파일 작성 키워드
* version: 도커 컴포즈 바전
* services: 이곳에 실행하려는 컨테이너들을 정의
    * 서비스명(네트워크 호스트 명): 같은 네크웤이 속한 컨테이너끼리 서비스명으로 접근 가능
        * conatianer_name
        * build : 도커 파일이 있는 위치
        * depends_on : 특정 컨테이너에 대한 의존 관계
        * image : 컨테이너 생성 시 사용할 도커 이미지 지정
        * environment : 환경 변수
        * volumes : 호스트 디렉토리 컨테이너 디렉토리
        * ports : 접근 포트 설정(컨테이너 외부:컨테이너 내부), docker run -p 옵션과 같으며 개방할 포트 지정
        * restart: 컨테이너 실행 실패하는 경우 재시작 여부


### 작성
redis와 database 디렉토리 추가
각각 Dockerfile을 생성 및 작성해주고 database에는 config 디렉토리를 추가로 만들어 mariadb.cnf 작성
<br>

#### docker-compose-yml 작성

```go
version: "3.8" //버전명시
services:   // 사용할 서비스명들을 명시하며 각 컨테이너들을 명시
  pharmacy-direction-service-redis: //서비스명 지정
    container_name: pharmacy-direction-service-redis //컨테이너명 지정
    build:
      dockerfile: Dockerfile  //도커파일 이름
      context: ./reids  //도커파일 위치
    image: orieasy1/pharmacy-direction-service-redis  //도커이미지 이름 명시: 도커허브 아이디 명시 후 -> 이름
    // 도커 허브에 푸쉬를 할 때 어떤 레파지토리로 푸쉬를 해야되는지 찾지 못하기 때문에 도커 아이디를 먼저 명시후 도커이미지명 명시
    ports:
      - "6379:6379" //레디스 기본 포트가 6379
  pharmacy-direction-service-database: //서비스명 지정
      container_name: pharmacy-direction-service-database //컨테이너명
      build:
        dockerfile: Dockerfile  //도커파일 이름
        context: ./database //도커 파일 우치
      image:  orieasy1/pharmacy-direction-service-database //도커이미지 명
      environment:  //환경변수 추가
        - MARIADB_DATABASE= pharmacy-direction-service
        - MARIADB_ROOT_PASSWORD=${SPRING_DATASOURCE_PASSWORD} //루트 패스워드는 외부에서 환경변수로 주입, 깃허브에 올라가서는 안되는 정보
      volumes:
        - ./database/config:/etc/mysql/conf.d //한글이 깨지지말라는 설정, 해당 디렉토리가 호스트의 디렉토리를 참조해서 설정을 초기화
      ports:
        - "3306:3306" //데이터 베이스 기본 포트
```

#### ENV 파일 작성
외부에 공개되지 말아야하는 정보들을 추가, gitignore에도 올라가지 않도록 추가

env.env파일을 생성하면 도커 컴포즈가 실행될 때 자동으로 파일을 참조해서 환경변수를 가져옴

```env
SPRING_DATASOURCE_USERNAME=root
SPRING_DATASOURCE_PASSWORD=1234
```

환경변수로 사용할 값들을 env파일에 작성한 후 gitignore파일에 들어가서

```go
###
.env
```

를 작성하여 env파일이 깃허브에 올라가지 않도록 설정해주기


docker-compose -f docker-compose-local.yml up
f라는 옵션을 사용하면 어떤 도커 컴포즈 파일을 실행시킬지 결정할 수 있다.

![image](https://github.com/user-attachments/assets/c5536655-474d-4e25-a4e4-2dfd9bae469f)

up이라는 명령어를 사용하면 명시했었던 데이터베이스가 쭉 올라오게 된다.

docker ps라는 명령어를 사용하여 
![image](https://github.com/user-attachments/assets/3c16442e-0340-4805-8219-32807c5df551)





스프링부트를 이용해 정상적으로 커넥션 확인

application.yml 파일 수정

```
spring:
  config:
    activate:
      on-profile: local
  datasource:
    driver-class-name: org.mariadb.jdbc.Driver
    url: jdbc:mariadb://localhost:3306/phramacy-directions-service
    username: ${SPRING_DATASOURCE_USERNAME}
    password: ${SPRING_DATASOURCE_PASSWORD}
  data:
    redis:
      host: localhost
      port: 6379
  jpa:
    hibernate:
      ddl-auto: create
    show-sql: true
```

이때 로컬에서 개발할 때는 인텔리제이에서 따로 환경변수를 추가해줘야함
edit configuration에 들어가서 modift option 대신 environment variable 클릭 후 추가