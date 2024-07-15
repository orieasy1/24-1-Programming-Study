# 스프링부트3과 테스트 코드

## 테스트 코드 개념
테스트 코드란 작성한 코드가 의도대로 잘 동작하고 예상치 못한 문제가 없는지 확인할 목적으로 작성하는 코드이다.
테스트 코드는 유지보수에도 매우 좋고, 코드 수정 시 기존 기능이 제대로 작동하지 않을까하는 걱정하지 않다는 점에서 굉장히 유용하다.
<br>

### 단위 테스트와 통합 테스트

**단위 테스트(Unit Test)**는 하나의 모듈을 기준으로 독립적으로 진행되는 가장 작은 단위의 테스트이다.
단위 테스트를 작성해야하는 핵심적인 이유는 다음과 같다.
* 코드를 수정하거나 기능을 추가할 때 수시로 빠르게 검증할 수 있따.
* 리팩토링 시에 안정성을 확보할 수 있다.
* 개발 및 테스팅에 대한 시간과 비용을 절감할 수 있다.

<br>
또 당연히 단위 테스트를 작성하지 않은 코드들은 테스트를 작성한 코드보다 버그가 있을 확률이 높다.
그리고 통합테스트를 하기 위해서는 캐시, 데이터베이스 등 외부 컴포넌트 들과 연결하는 등 많은 비용이 필요하다.
버그를 발견하지 못하고 배포한다면 모든 버그들을 수정하고 테스트를 반복하는 비용은 엄청날 것이다.
개발 및 테스팅에 대한 비용을 줄이기 위해서는 단위 테스트가 굉장이 중요하다.
<br>

**통합 테스트(Integration Test)**는 모듈을 통합하는 과정에서 모듈 간의 호환성을 확인하기 위해 수행되는 테스트로 단위 테스트와는 어느 정도 반대되는 개념이라고 할 수 있다.

일반적으로 애플리케이션은 여러 개의 모듈로 구성되고 모듈끼리 메세지를 주고 받으며 기능을 수행한다.
이렇게 통합된 모듈들이 올바르게 함께 동작되는지 검증이 필요한데 이것이 통합테스트이다.
웹 페이지로부터 API를 호출하여 올바르게 동작하는지 확인하는 것이기 때문에 시간과 비용이 비교적 많이 든다.

### 좋은 테스트의 특징
CleanCode에 나와있는 좋은 테스트의 특징: FIRST
빠르고 독립적으로 어느 환경에서도 반복적으로 실행이 가능하고 검증할 수 있어야한다.
또 CleanCode에서는 테스트 코드를 실제 코드에 구현하기 직전에 구현하라고 설명하고 있음

1. Fast: 테스트는 빠르게 동작하여 자주 돌릴 수 있어야한다.
2. Independent: 각각의 테스트는 독립적이며 서로 의존해서는 안된다.
3. Repeatable: 어느 환경에서도 반복 가능해야한다.
4. Self-Vaildating: 테스트는 성공 또는 실패로 bool값으로 결과를 내어 자체저긍로 검증되어야 한다.
5. Timely: 테스트는 적시에 즉, 테스트하려는 실제 코드를 구현하기 직전에 구현해야한다.

### 테스트 코드의 given-when-then 패턴
테스트 코드는 test 디렉터리에서 작업한다.
테스트 코드에는 다양한 패턴이 있는데 그중에서 given-when-then 패턴을 사용하려고 한다.
given-when-then 패턴은 테스트 코드를 세 단계로 구분해 작성하는 방식이다.

* given: 테스트 실행을 준비하는 단계
* when: 테스트를 진행하는 단계
* then: 테스트 결과를 검증하는 단계

<br>
만약 새로운 메뉴를 저장하는 코드를 테스트한다면, given절은 메뉴를 저장하기 위한 준비과정 즉 필드를 선언하는 파트, when절은 실제로 메뉴를 저장하는 과정, then절은 메뉴가 잘 저장되었는지를 검증하는 코드가 될 것이다.

```java
@DisplayName("새로운 메뉴를 저장한다")
@Test
public void saveMenuTest() {
    //given
    final String name = "Americano";
    final int price = 2000;

    final Menu americano = new Menu(name, price);

    //when
    final long savedId = menuService.save(americano);

    //then
    final Menu savedMenu = menuService.findById(savedId).get();
    asserThat(savedMenu.getName()).isEqualTo(name);
    asserThat(savedMenu.getPrice()).isEqualTo(price);
}
```

<br>

## 스프링부트3과 테스트
스프링부트는 애플리케이션을 테스트 하기 위한 도구와 애너테이션을 제공한다.
spring-boot-starter-test에 테스트 과련 라이브러리와 기능을 많이 포함하고 있다.

* JUnit: 자바 프로그래밍 언어
* Spring Test: 스프링부트 애플리케이션을 위한 통합 테스트 지원
* AssertJ: 검증문인 어설션을 작성하는데 사용되는 라이브러리
* Hamcrest: 표현식을 이해하기 쉽게 만드는 데 사용되는 Matcher 라이브러리
* Mockito: 테스트에 사용할 가짜 객체인 목 객체를
* JSONassert: JSON용 어설션 라이브러리
* JsonPath: JSON 데이터에서 특정 데이터를 선택하고 검색하기 위한 라이브러리

<br>이 중에서 JUnit과 AssertJ를 가장 많이 사용한다.

### 1. JUnit
JUnit은 자바 언어를 위한 단위테스트 프레임워크이다.
단위 테스트란 작성한 코드가 의도대로 작동하는지 작은 단위로 검증하는 것을 말한다.(이 때 단위는 보통 메소드이다.)
JUnit은 단위 테스트를 작성하고 테스트하는데 도움을 주며 사용법도 간단해 쉽게 익힐 수 있으며 테스트 결과가 직관적이라 좋다.
<br>

#### 주요 JUnit 특징

* 테스트 방식을 구분할 수 있는 애너테이션을 제공
* Test 애너테이션으로 메서도를 호출할 때마다 새 인스턴스를 생성, 독립 테스트 가능
* 예상 결과를 검증하는 어설션 메소드 제공
* 사용방법이 단순하고 테스트 코드 작성 시간이 적음
* 자동 실행, 자체 결과를 확인하고 즉각적인 피드백을 제공

#### JUnit 주요 애너테이션 정리

* @BeforeAll
    * 전체 테스트를 시작하기 전에 처음으로 한 번만 실행,
    * 데이터베이스를 연결해야하거나 테스트환경을 초기화할 때 사용
    * 전체 테스트 실행 주기에서 한 번만 호출되어야 하기 때문에 메서드를 static으로 선언
* @BeforeEach
    * 테스트 케이스를 시작하기 전에 매번 실행
    * 테스트 메서드에서 사용하는 객체를 초기화하거나 테스트에 필요한 값을 미리 넣을 때 사용
    * 각 인스턴스에 대해 메서드를 호출해야하므로 메서드 static으로 선언하면 안됨
* @AfterAll
    * 전체 테스트를 마치고 종료하기 전에 한 번만 실행
    * 데이터베이스 연결을 종료할 때나 공통적으로 사용하는 자원ㅇ르 해제할 때 사용
    * 전체 테스트 주기에서 한 번만 호출해야하므로 메서드를 static으로 선언
* @AfterEach
    * 각 테스트 케잇를 종료하기 전 매번 실행
    * 테스트 이후에 특정 데이털를 삭제해야 하는 경우 사용
    * 각 인스턴스에 대해 메서드를 호출행햐나므로 메서드를 static으로 선언하면 안됨

<br>

### 2. AssertJ
AssertJ는 JUnit과 함께 사용해 검증문의 가독성을 높여주는 assertion 라이브러리이다.

Assertions.assertEquals(sum, a+b);

와

assertThat(a + b).isEqualTo(sum);

을 비교해보면 Assertion이 아니라 두 번째 AssertJ를 사용했을 때 a와 b를 더한 것ㅂ이 sum과 같아야 한다는 의미가 확실히 전달되는 것을 확인할 수 있다. 

#### AssertJ에서 자주 사용하는 메서드

* isEqualTo(A): A값과 같은지 검증
* isNotEqualTo(A): A값과 다른지 검증
* contains(A): A값을 포함하는지 검증
* doesNotContation(A): A값을 포함하지 않는지를 검증
* startsWith(A): 접두사가 A인지 검증
* endsWith(A): 접미사가 A인지 검증
* isEmpty(): 비어 있는 값인지 검증
* isNotEmpty(): 비어 있지 않은 값인지 검증
* isPositive(): 양수인지 검증
* isNegative(): 음수인지 검증
* isGreaterThan(1): 1보다 큰 값인지 검증
* isLessThan(1): 1보다 작은 값인지 검증
<br>

### 테스트 코드 작성해보기

```java
@SpringBootTest
@AutoConfigureMockMvc
class TestControllerTest {
    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    private WebApplicationContext context;

    @Autowired
    private MemberRepository memberRepository;

    @BeforeEach //테스트 실행 전 실행하는 메소드
    public void mockMvcSetUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context)
            .build();
    }

    @AfterEach //테스트 실행 후 실행하는 메서드
    public void cleanUp() {
        memberRepository.deleteAll();
    }

    @DisplayName("getAllMembers: 아티클 조회에 성공한다.")
    @Test
    public void getAllMembers() throws Exception {
        //given
        final String url = "/test";
        Member savedMember = memberRepository.save(new Member(1L, "홍길동"))

        //when
        final ResultActions result = mockMvc.perform(get(url)
            .accept(MediaType.APPLICATION_JSON));
        
        result
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(savedMember.getId()))
                .andExpect(jsonPath("$[0].name").value(savedMember.getName()));
    }
}
```

<br>
앞에서 말했듯이 단위테스트는 메소드 단위로 이루어진다.

#### 테스트하는 로직 전 애너테이션 정리

* @SpringBootTest
    * 메인 애플리케이션 클래스에 추가하는 애너테이션인 @SpringBootApplication이 있는 클래스를 찾고 클래스에 포함되어 있는 빈을 찾은 다음 테스트용 애플리케이션 컨텍스트를 만든다.
* @AutoConfigureMockMvc
    * MockMvc를 생성하고 자동으로 구성하는 애너테이션
    * MockMvc: 애플리케이션을 서버에 배포하지 않고도 테스트용 MVC환경을 만들어 요청 및 전송, 응답 기능을 제공하는 유틸리티 클래스 즉 컨트롤러를 테스트할 때 사용되는 클래스
* @BeforeEach
    * 테스트를 실행하기 전에 실행하는 메서드에 적요하는 어노테이션
    * 위 코드에서는 MockMvcSetUp() 메소드를 통해 MockMvc를 설정해주고 있다.
* @AfterEach
    * 테스트를 실행한 이후에 실행하는 메서드에 적용하는 애너테이션
    * 위 코드에서는 cleanUp() 메솓를 실행해 member 테이블에 있는 데이터들을 모두 삭제해줌

#### 테스트하는 로직에 등장하는 애너테이션 정리



## 컨트롤러 테스트
1. 컨트롤러 테스트의 목적
컨트롤러 테스트는 애플리케이션의 REST API가 기대하는 대로 동작하는지 검증하는 것입니다. 주로 MockMvc를 사용하여 컨트롤러의 HTTP 요청과 응답을 검증합니다.

주요 목적:
엔드포인트 검증: 클라이언트가 보내는 요청에 대해 서버가 올바른 응답을 반환하는지 확인합니다.
HTTP 상태 코드 검증: 요청의 결과로 반환되는 HTTP 상태 코드가 예상한 것인지 확인합니다.
요청 및 응답의 형식 검증: JSON 응답의 구조와 내용이 예상한 대로 구성되어 있는지 검증합니다.
비즈니스 로직 검증: 컨트롤러가 올바르게 서비스 계층의 메소드를 호출하고, 요청을 처리하는지 검증합니다.

2. 왜 컨트롤러만 테스트하나요?
컨트롤러 테스트는 애플리케이션의 전체적인 동작을 검증할 수 있는 방법 중 하나이며, 아래와 같은 이유로 컨트롤러만 테스트하는 경우가 많습니다:

2.1. 엔드포인트의 전체적인 검증
컨트롤러 테스트는 HTTP 요청부터 응답까지의 엔드포인트 전체를 검증합니다. 이를 통해 클라이언트와 서버 간의 통신 흐름이 올바른지 확인할 수 있습니다.

2.2. 서비스와 데이터베이스의 동작 검증
서비스 계층: 컨트롤러는 서비스 계층의 메소드를 호출합니다. 따라서 서비스 계층과 연동된 동작을 검증할 수 있습니다.
데이터베이스와의 상호작용: 통합 테스트에서는 데이터베이스와의 실제 상호작용을 포함하여, 데이터베이스의 상태를 확인할 수 있습니다.

2.3. 다른 테스트와의 차별화
단위 테스트: 서비스 계층의 메소드와 같은 단위별 기능을 테스트합니다.
통합 테스트: 애플리케이션의 여러 구성 요소가 함께 작동하는지 확인합니다.
엔드투엔드 테스트: 전체 시스템의 동작을 검증합니다.


|테스트 종류|설명|예시|
|:--------:|----|----|
|단위 테스트 (Unit Test)|개별 모듈이나 메소드의 기능을 검증하는 테스트|	Service 계층의 메소드가 올바르게 동작하는지 테스트|
|컨트롤러 테스트 (Controller Test)|HTTP 요청과 응답을 통해 API 엔드포인트의 동작을 검증하는 테스트|REST API의 요청과 응답을 검증하는 테스트|
|서비스 테스트 (Service Test)|서비스 계층의 비즈니스 로직을 검증하는 테스트|Service 클래스의 메소드가 올바르게 동작하는지 테스트|
|통합 테스트 (Integration Test)|여러 구성 요소가 함께 올바르게 동작하는지 검증하는 테스트|Controller, Service, Repository 등이 통합된 테스트|
|엔드투엔드 테스트 (End-to-End Test)|전체 시스템의 흐름을 검증하는 테스트|전체 애플리케이션의 기능이 올바르게 동작하는지 검증|


## 추가) TDD 테스트 주도 개발이란?