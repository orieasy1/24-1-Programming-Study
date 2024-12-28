# 약국 길찾기 서비스 part1
## 개발환경과 운영환경 profile 분리하기
### Spring Profile
Spring Profile은 어플리케이션 설정을 특정 환경에서만 적용되기ㅔ 하거나 환경 별(local, develop, production)로 다르게 적용할 때 사용된다.

보통 로컬에서 설정할 설정값과 프로덕션 그러니까 클라우드 서비스에서 사용할 설정 값이 다른 경우가 있다.
따라서 환경별로 설정 값(DB 설정 값이나 API 키 등)을 다르게 적용해야하는데 이 부분을 스프링 프로파일로 해결이 가능하다.
보통 SpringBoot에서는 네이밍 컨벤션으로 제공해준다. (예시: application-{profile}.yml)
어플리케이션 이름 그리고 프로파일 이름 이렇게 지정을 하게 되면 각 프로파일별로 다르게 설정을 해줄 수 있다.
파일을 나누어서 프로파일을 각 환경별로 적용해줄 수 있는 것이다.

SpringBoot는 어플리케이션이 실행될 때 자동으로 applicaiton.properties, application.yml을 찾는다.
yaml파일이 조금 더 Depth로 되어 있어 보기가 편하다는 장점이 있어 yaml을 많이 쓴다.
이 두 파을은 동시에 사용하면 안된다.
같이 존재할 경우 properties가 항상 나중에 로드되어 yaml에 정의한 profile 설정을 덮어쓸 수 있기 때문이다.

yaml파일에서는 ---를 구분자로 구분을 하면, 논리적으로 구분되어 파일을 나누어 쓸 수 있다는 것이 특징이다.
기본적으로 활성화할 profile을 local로 설정한다.
또 spring.profiles.group을 이용해서 여러 profile들을 한꺼번에 그룹지어 하나의 profile로 만들 수 있다.

```yml
spring:
    profiles:
        active: local # default
        group:
            local:  # local, common profile을 그룹지어 함께 어플리케이션 구동
                - common
            prod: # prod, common profile을 그룹지어 함께 어플리케이션 구동
                - common

---
spring:
    config:
        activate:
            on-profile: common  # application-common.yml과 동일한 역할

---
spring:
    config:
        activate:
            on-profile: local

---
spring:
    config:
        activate:
            on-profile: prod

```

이렇게 작성하고 어플리케이션을 run 시켜보면

![image](https://github.com/user-attachments/assets/3a37eac4-d203-47d2-8f0f-d4fae4a5d75e)

위 사진 처럼 두개의 profile이 active하다는 것을 확인할 수 있다.