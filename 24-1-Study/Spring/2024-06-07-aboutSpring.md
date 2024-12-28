NGT learning paths라는 프로그램에 지원하였는데 선정이 되어서 2024년 여름방학동안 백엔드를 마스터한다는 생각으로 공부를 해보려한다.
커리를 따라가기 전에 '스프링부트3 백엔드 개발자 되기'라는 책을 가지고 블로그를 만들어보며 스프링에 대한 지식을 복귀하고 조금 더 탄탄히 하는 시간을 가져보려고 한다.

# 블로그 제작 전 스프링부트3 컨셉 공부

## 스프링과 스프링 부트

### 스프링 Spring Framework

엔터프라이즈 애플리케이션: 대규모의 복잡한 데이터를 관리하는 애플리케이션
<br><br>
소프트웨어 분야가 발전하며 엔터프라이즈 애플리케이션은 점점 복잡해졌다.
은행 시스템만 생각해보아도 몇백, 몇천만의 사람들이 동시에 많은 서비스를 이용한다.
잔고 조회를 하고, 입금이나 출금 요청을하거나 새로운 통장을 개설하기도 한다.
<br>

엔터프라이즈 애플리케이션은 **많은 사용자의 요청을 동시에 처리**해야 하기 때문에 **서버 성능과 안정성, 보안**이 매우 중요하다.
그러나 서버성능, 안정성, 보안 등을 시켱쓰면서 비즈니스 로직(사이트의 기능)까지 개발하기는 매우 어렵다.
엔터프라이즈 애플리케이션을 위한 개발환경을 제공해서 기능 개발에만 집중할 수 있도록하는 것이 필요했던 상황에서 Spring Framework가 등장했다.
2003년 6월에 등장한 스프링 프레임워크는 서버 성능, 안정성, 보안을 매우 높은 수준으로 제공하는 도구로, 개발자들이 기능 개발에만 집중할 수 있게 만들어주었다.
<br><br>

### 스프링부트 SpringBoot

스프링은 장점이 많지만 설정이 매우 복잡하다는 단점이 있다.
이러한 점을 보완하고자 2013년에 스프링부트를 출시하였다.
스프링부트는 스프링 프레임우커를 더 쉽고 빠르게 이용할 수 있도록 만들어주는 도구이다.
빠르게 스프링 프로젝트를 설정할 수 있고 의존성(dependencies) 세트라고 불리는 스타터를 사용해 가편하게 의존성을 사용하거나 관리할 수 있도록 한다.
개발자로 하여금 더 비즈니스 로직 개발에만 집중할 수 있게 만들어주는 도구인 것이다.
<br><br>
스프링 프레임워크와 구별되는 스프링부트의 특징은 다음과 같다.

* 톰캣, 제티, 언더토우과 같은 웹 어플리케이션 서비(Web Application Server, WAS)가 내장되어 있어서 이를 따로 설치하지 않아도 독립적으로 실행시킬 수 있다.
* 빌드 구성을 단순화하는 스프링부트 스타터를 제공한다.
* XML 설정을 하지 않고 자바 코드로 모두 작성할 수 있다.
* jar을 사용해서 자바 옵션만으로도 배포가 가능하다.
* 애플리케이션의 모니터링 관리 도구인 spring actuator을 제공한다.

헷갈리지 말아야할 점은 스프링과 스프링부트가 분리된 것이 아니라 **스프링부트가 스프링에 속해 있는 도구**라는 것이다.
<br><br>

### 개발할 때 스프링과 스프링부트의 차이점

스프링은 엔터 프라이즈 애플리케이션 개발을 더 쉽게 하는 것에, 스프링부트는 개발을 더 빠르고 쉽게하는 것에 목적이 있다.


1. 구성의 차이
스프링은 웹 어플리케이션에 필요한 환경(설정 파일)을 수동으로 구성하고 정의해줘야한다는 특징이 있다.
하지만 스프링부트는 스프링 코어와 스프링MVC의 모든 기능을 로드하므로 수동으로 개발환경을 구성할 필요가 없다.

2. 내장 WAS 유무
스프링 애플리케이션은 일반적으로 톰캣과 같은 WAS에서 배포된다.
이를 위해 프로젝트를 띄우는 서버를 별도로 수동 설정을 해줘야한다.
그러나 스프링 부트는 자체적으로 WAS를 가지고 있기 때문에 jar파일을 만들면 별도로 WAS를 설정하지 않아도 애플리케이션을 실행할 수 있다.

<br>이외에도 스프링은 일부 파일은 XML로 직접 생성하고 관리핮만 스프링부트는 XML파일을 사용하지 않고 스프링은 인메모리 DB를 지원하지 않지만 스프링부트는 자동 설정을 지원한다는 차이점이 있다.


##  스프링 콘셉트
스프링의 콘셉트는 IoC/DI, AOP, PSA이다.(POJO랑 똑같음)
이 기술 들을 기반으로 스프링이 만들어졌다.
스프링 프레임워크는 IoC/DI를 통해 객체 간의 의존 관계를 설정하고, AOP를 통해 핵심 관점과 부가 로직을 분리해 개발하며, PSA를 통해 추상화된 다양한 서비스들을 일관된 방시긍로 사용하도록 한다.

### 1. 제어의 역전과 의존성 주입
스프링의 핵심 개념이라 할 수 있을 만큼 중요하다.

#### IoC, 제어의 역전이란?
IoC는 Inversion of Control 즉 제어의 역전의 줄임말이다.
객체의 생성, 생명주기의 관리까지 모든 객체에 대한 제어권이 바뀌었다는 것을 의미한다.

지금까지 자바 코드를 작성해서 객체를 생성할 때, ㅇ객체가 필요한 곳에서 직접 생성했었다.

```java
public claas A {
    B b = new B();
}
```

제어의 역전은 다른 객체를 직접 생성하거나 제어하는 것이 아니라 외부에서 관리하는 객체를 가져와 사용하는 것을 말한다.
위 코드에서 제어의 역전을 사용하면 아래와 같이 코드가 바뀐다.

```java
public class A {
    private B b;
}
```

위 코드에서는 객체를 생성하지 않고 어디선가 받아온 객체를 b에 할당하고 있다.
스프링에서는 이 어디선가가 컨테이너이다.

컨테이너는 보통 객체의 생명주기를 관리하고 생성된 인스턴스들에게 추가적인 기능을 제공하도록 한다.
스프링 프레임워크도 객체를 생성하고 관리하고, 책임지고 의존성 관리를 해주는 컨테이너가 있는데 이것이 바로 IoC 컨테이너이다.
<br><br>
인스턴스 생성부터 소멸까지의 생명주기 관리를 IoC 컨테이너가 해준다.
객체 관리 주체가 개발자가 아니라 IoC 컨테이너가 되기 때문에 개발자는 비즈니스 로직 개발에 집중할 수 있다는 장점이 있다.
<br>
IoC 컨테이너는 객체의 생성을 책임지고 의존성을 주입을 관리한다.
IoC 컨테이너에 빈으로 등록이 되어야 의존성 주입이 가능하다.
POJO의 생성, 초기화, 서비스, 소멸에 대한 권한을 가진다.
보통 개발자들이 직접 POJO를 생성할 수 있지만 컨테이너에게 맡긴다.


#### 스프링 DI란?
스프링에서는 객체들을 관리하기 위해 제어의 역전을 사용한다.
그리고 제어의 역전을 위해 사용하는 방법이 의존성 주입(Dependency Injection), DI이다.
<br><br>
DI는 어떤 클래스가 다른 클래스에 의존한다는 뜻이다.

```java
public class A {
    @Autowired
    B b;
}
```

@Autowired라는 애너테이션을 사용하여 스프링 컨태이너에 있는 빈을 주입하는 것이다.
직접 객체를 생성하지 않고 객체를 주입 받는 것이다.

즉 스프링에서는 클래스A에서 B객체를 쓰고 싶은 경우 객체를 직접 생성하는 것이 아니라 스프링 컨테이너에서 객체를 주입받아 사용한다.
DI를 통해 모듈 간의 결합도가 낮아지고 유연성이 높아진다. <br>

![image](https://github.com/orieasy1/24-1-Programming-Study/assets/129071350/d66f14b2-ceef-469d-9e17-3dfe18c5bfc6)

A객체에서 B, C등의 객체를 사용할 때 IoC 컨테이너(외부)에서 생성된 B, C 객체를 주입시켜 setter 혹은 생성자를 통해 사용하는 방식이다.

<br>
Setter 메소드와 생성사를 통해서 의존성 주입을 컨테이너에서 직접할 수 있지만 스프링은 의존 자동주입 기능이 있다.
자동 주입 기능을 사용하면 스프링이 알아서 의존 객체를 찾아서 주입한다.
의존 주입 대상에 @Autowired 어노테이션을 사용하여 주입할 수 있다.
이 어노테이션은 필요한 의존 객체의 타입에 해당하는 빈을 찾아 주입한다.

* @Autowired 필드 주입: 멤버필드에 @Autowired 어노테이션을 선언하여 주입받는 방법
    * 가장 간단한 선언 방식
    * 의존 관계가 보이지 않아 추상적이고 이로 인해 의존성 관계가 복잡해질 수 있다.
    * 의존성 주입 대상 필드에 final 선언이 불가하다.
* @Autowired 생성자 주입: 생성자에 의존성 주입을 받고자 하는 필드에 객체 생성 시 생성자에 주입받는 방식 (권고되는 방법)
    * 해당하는 빅 객체 없이 인스턴스를 만들지 못하도록 강제
    * 의존성 주입 대상의 필드를 final로 선언할 수 있다.
* @Autowired 메소드 주입: 메소드에 @Autowired 어노테이션을 선언하여 주입받는 방법
    * 의존성이 선택적으로 필요한 경우에 사용
    * 의존성 주입대상을 선택적으로 나ㅝ서 주입할 수 있게 부담을 덜어준다.
    * 의존성 주입 대상 필드가 final 선언이 불가능하다. 생성자 주입 방법과 적절하게 상황에 맞게 분배하여 사용할 것

<br>

### 2. 빈과 스프링 컨테이너
#### 스프링 컨테이너
스프링에서는 스프링 컨테이너를 사용해 빈을 생성하고 관리한다.
빈이 생성되고 소멸되기까지의 생명주기를 스프링 컨테이너가 관리하는 것이다.(IoC 컨테이너가 해준다)
또 개발자가 @Autowired와 같은 어노테이션을 사용해 빈을 주입받을 수 있도록 DI를 지원하기도 한다.
<br>

**+ 스프링 컨테이너의 종류**
스프링은 주로 두 가지 타입의 컨테이너를 제공한다.
BeanFactory와 ApplicationContext 이 두가지 인터페이스를 사용해 구현한 클래스로 컨테이너에 접근하 수 있는데 보통 BeanFactory를 구현한 클래스로는 컨테이너에 접근하지 않는다.(직접 사용되지 않는다.)
<br><br>
BeanFactory는 스프링 컨테이너의 최상위 인터페이스로 기본적인 빈 관리 기능을 제공한다.
그러나 ApplicationContext가 BeanFactory를 상속받아 더 많은 기능을 제공하기 때문에 이를 사용해서 컨테이너에 접근하는 것이다.
ApplicationContext는 다음과 같은 추가 기능을 지원한다.

* 메세지 소스 지원: MessageSource
* 파일 리소스 리딩: ResourceLoader
* 이벤트 발행 및 구독(이벤트 프로그래밍 모델 지원)
* 애플리케이션 라이프 사이클 관리

<br>
ApplicationContext의 구현 클래스들

* AnnotationConfigApplicationContext: 자바 애노테이션 기반 설정 파일(예: AppConfig.class)을 읽어 빈을 생성
* GenericXmlApplicationContext: XML 기반 설정 파일(appConfig.xml)을 읽어 빈을 생성.
<br>

#### 빈이란?
빈(Bean): 스프링 컨테이너가 생성하고 관리하는 객체
<br><br>
스프링은 빈을 스프링 컨테이너에 등록하기 위해 XML파일 설정, 애너테이션 추가 등, 여러 가지 방법을 제공한다.

* XML에 직접 등록: \<bean> 태그 사용
* @Bean 어노테이션을 이용
* @Component, @Service, @Repository, @Controller 어노테이션 이용

예를 들어 MyBean이라는 클래스에 @Component 애너테이션을 붙이면 MyBean 클래스가 빈으로 등록된다.
이때 빈의 이름은 클래스 이름의 첫 글자를 소문자로 바꿔 관리한다.
<br><br>
@Component 어노테이션과 @Bean 어노테이션 모두 스프링 프레임워크에서 빈(bean)을 정의하는데 사용되는 두 가지 주요 어노테이션이다.
둘 다 스프링 컨테이너가 관리하는 객체(= bean)을 생성하는데 사용되지만 차이가 있다.

@Component는 클래스 레벌에서 사용되고 해당 클래스가 스프링 컨테이너에 의해 자동으로 빈으로 등록된다.
주로 자동 탐지 및 자동 구성을 위해 사용된다.
@Service, @Repository, @Controller는 @Component의 특화된 형태로 각각 서비스 계층, 데이터 액세스 계층, 프레젠테이션 계층에서 사용된다.
<br><br>
@Bean은 메소드 레벨에서 사용되며 메소드의 반환 값을 스프링 컨테이너에 빈으로 등록하도록 한다.
주로 자바 구성 클래스에서 명시적으로 빈을 정의할 때 사용된다.
특정한 빈 구성 로직이 필요할 때, 또는 외부 라이브러리 클래스의 빈을 등록할 때 사용한다.

<br>

### 3. AOP, 관점 지향 프로그래밍
Aspect Oriented Programming

프로그래밍에 대한 관심을 핵심 관점, 부가 관점으로 나누어서 관심 기준으로 모듈화하는 것.
<br>

핵심적인 관점은 우리가 실제로 적용하고자 하는 비즈니스 로직이고 부가적인 관점은 핵심로직을 실행할 때 로깅, 트랜잭션, 파일 입출력 등이 될 수 있다.
예를 들어 입금과 출금, 계좌 이체, 이자 계산을 하는 프로그램이 있을 때, 지금까지 벌어진 일을 기록하기 위한 로직과 여러 데이터를 관리하기 위한 로직, 보안 등 로직이 포함될 것이다.
이때 핵심 관점은 입금과 출금, 계좌 이체, 이자 계산 로직이고 부가 관점은 로깅, 보안, 트랜젝션 로직이다.
실제 프로그램의 기능을 로직으로 정리하면 다음과 같다.

![image](https://github.com/orieasy1/24-1-Programming-Study/assets/129071350/d28b981f-d051-422a-8ed5-afc055b492ca)

그림을 보면 로깅, 보안, 트랜젝션은 모두 입금과 출금, 계좌 이체, 이자 계산에 필요하다.
소스 코드 상에서 반복해서 사용하는 코드들(여기서는 로깅, 보안 트랜젝션)을 발견할 수 잇는데 이것을 흩어진 관심사(Crosscutting Concerns)라고 부른다.
AOP의 핵심이 핵심 비즈니스 로직과 횡단 관심사 즉 흩어진 관심사를 분리하여 모듈화하는 것으로 이해하면 된다.
<br><br>
여기에 AOP 관점을 적용하면 부가 관점에 해당하는 로직을 모듈화 해 위 그림처럼 개발할 수 있게 해준다.
부가 관점 코드를 핵심 관점 코드에서 분리하는 것이다.
이를 통해 프로그래머는 핵심 관점 코드에만 집중할 수 있게 되고, 프로그램의 변경과 확장에도 유연하게 대응할 수 있어 좋다.
<br>

**주요 개념**

* Aspect: 공통 기능을 모아둔 객체(부가 관점 기능들을 모듈화한 것)
* Advice: Aspect안에 있는 공통 기능 각각의 로직을 의미한다. 실질적인 부가기능을 담은 구현체이다.
    * Before: 메소드 실행 전에 동작
    * After: 메소두 실행 후 (Exception에 상관없이) 동작
    * After-returning: 정상적으로 메소드 실행 후에 동작
    * After-throwing: 메소드 실행 중 Exception 발생 시 동작
    * Around: 메소드 실행 전과 후, 예외 발생 등 모든 시점에서 동작
* JoinPoint: Advice가 적용될 특정 포인트(메소드 실행 시점)
* Pointcut: 포인트 컷은 조인 포인트(JointPoint)의 한 부분, 표현 식으로 JointPoint의 상세한 내용을 지정한다.
    * execution: Advice를 적용할 메소드를 명시할 때 사용
    * within: 특정 타입 패턴에 속하는 모든 메서드를 포인트 컷으로 설정
    * bean: 빈의 이름으로 포인트 컷을 설정
* Weaving: 공통 기능을 적용하는 행위

<br>

### 4. PSA, 이식 가능한 서비스 추상화
Portable Service Abstraction <br>
스프링에서 제공하는 다양한 기술들을 추상화해 개발자가 쉽게 사용하는 인터페이스
<br><br>
PSA란 환경의 변화와 관계없이 일관된 방식의 기술로의 접근환경을 제공하는 추상화 구조를 말한다.(다양한 서비스와 통합할 수 잇는 일관된 추상화 계층을 제공)
특정 클래스가 추상화된 상위 클래스를 일관되게 바라보며 하위 클래스의 기능을 사용하는 것이 PSA의 기본 개념이다.
<br><br>
대표적인 PSA의 예로는 클라이언트이 매핑과 클래스, 메서드 매핑을 위한 애너테이션이 있다.
예를 들어 스프링에서 데이터베이스에 접근하기 위한 기술로는 JPA, MyBatis, JDBC 가은 것들이 있는데, 여기서 어떤 기술을 사용하든 일관된 방식으로 데이터베이스에 접근하도록 인터페이스를 지원한다.