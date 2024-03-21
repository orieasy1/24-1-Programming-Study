<h1>김영한 스프링 핵심 원리 - 기본편 정리</h1>

<h3>섹션1. 객체 지향 설계와 스프링</h3>

EJB의 경우 이론은 좋았지만 사용하기가 복잡하고 느리다는 단점이 있었다.
코드가 지저분해지고 EJB에 의존해야하는 추가적인 문제도 생기게 되었다.

EJB에 불만을 가졌던 개발자 중 로드 조슨이 단순하고 좋은 방법을 제안했다.
이것이 미래의 스프링이 된다.

개빈 킹이라는 개발자도 오픈소스를 마들었는데 그것이 하이버네이트이다.
하이버네이트를 가져와서 자바표준인 JPA를 만들었다.
표준 인터페이스가 있으면 JPA 구현체들도 있어야 한다.
JPA가 있으면 구현체로는 하이버네이트와 EcplipseLink 등등이 있다.
현재도 JPA와 하이버네이트의 시장점유율이 꽤 높다.

로드 존슨의 책 출간 직후 유겐휠러와 얀 카로프가 오픈소스 프로젝트를 제안했다.
스프링의 핵심 코드의 상당수는 유겐휠러가 지금도 개발하고 있다.
스프링의 이름은 전토적인 J2EE(EJB)라는 겨울을 넘어 새로운 시작이라는 뜻으로, 겨울이 끝나고 봄이왔다는 뜻으로 지었다.

**스프링 프레임워크**

* 핵심 기술: 스프링 DI 컨테이너, AOP, 이벤트 기타
* 웹기술: 스프링 MVC, 스프링 WebFlux
* 데이터 접근 기술: 트랜잭션, JDBC, ORM 지원, XML지원
* 기술 통합: 캐시, 이메일, 원격접근, 스케줄링
* 테스트: 스프링 기반 테스트 지원
* 언어니 코틀린, 그루비
* 최근에는 스프링 부트를 통해서 스프링 프레임워크의 기술들을 편리하게 사용

**스프링 부트**

* 스프링을 편리하게 사용할 수 있도록 지원, 최근에는 기본으로 사용
* 편리하게 사용할 수 있도록 해주는 매개체라고 생각하면 좋다.
* 단독으로 실행할 수 있는 스프링 애플리케이션을 쉽게 생성
* Tomcat 같은 웹 서버를 내장해서 별도의 웹 서버를 설치하지 않아도 됨
* 손쉬운 빌드 구성을 위한 starter 종속성 제공
* 스프링과 3rd path(외부) 라이브러리 자동 구성
* 메트릭, 상태 확인, 외부 구성 같은 프로덕션 준비 기능 제공
* 관례에 의한 간결한 설정

요즘 설정이 굉장히 편해진 스프링부트를 기반으로 스프링을 구현한다.
스프링부트 자체로만 무엇을 구현하기에는 아직 부족한 면이 있다.

스프링은 자바 언어기반의 프레임워크인데 자바 언어의 가장 큰 특징은 객체 지향 언어라는 점이다.
즉 스프링은 좋은 객체 지향 애플리케이션을 개발할 수 있게 도와주는 프레임워크이다.


<h3>좋은 객체 지향 프로그래밍이란?</h3>

객체 지향의 특징에는 추상화, 캡슐화, 상속, 다형성 등이 있다.
객체지향 프로그래밍이란 컴퓨터 프로그램을 여러 개의 독립된 단위 즉 객체들의 모임으로 파악하고자 하는 것이다.
이는 프로그램을 유연하고 변경이 용이하게 만들기 때문에 대규모 소프트웨어 개발에 많이 사용된다.

유연하고 변경이 용이하다는 것은 무엇일까?
레고 블럭을 조립하듯이 키보드와 마우스를 갈아 끼우듯이 컴포넌트를 쉽고 유연하게 변경하면서 개발할 수 있는 방법을 말한다.

**다형성**
궁극의 유연함과 변경이 용이한 객체지향의 핵심이 다형성이다.
실세계와 객체 지향을 1:1로 매칭시키기는 어렵다.
하지만 실세계에 비유하면 이해하기 좋은데 역할과 구현으로 세상을 구분하면 된다.
쉽게 말하면 역할이 인터페이스이고 구현이 그 인터페이스를 구현한 객체인 것이다.

운전자의 역할이 있고 자동차의 역할이 있다.
K3나 아반떼 같은 차들이 자동차를 구현할 것이다.
여기서 중요한 것은 자동차가 바뀌어도 여전히 운전자는 자동차를 운전할 수 있다는 것이다.
자동차 역할 인터페이스를 따라서 자동차를 구현했고 운전자는 자동차 인터페이스만 알고 있기 때문에 이것이 가능한 것이다.

다른 대상으로 변환이 가능하고 완전히 새로운 자동차가 나와도 자동차의 역항르 그대로 따라할 수 있다면 자동차를 무한대로 확장할 수 있다.(휘발유 자동차, 전기차 등등)