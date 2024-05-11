# 김영한 스프링 입문 - 코드로 배우는 스프링부트, 웹MVC, DB접근기술

## Session 3. 회원 관리 예제 - 백엔드 개발

* 비즈니스 요구사항 정리
* 회원 도메인과 리포지토리 만들기
* 회원 리포지토리 테스트 케이스 작성
* 회원 서비스 개발
* 회원 서비스 테스트
<br>

### 만들어 볼 비즈니스 요구사항 정리

* 데이터: 회원ID, 이름
* 기능: 회원 등록, 조회
* 아직 데이터 저장소가 선정되지 않았다는 가상의 시나리오
를 바탕으로 프로그램에 작성예정

일반적인 웹 애플리케이션은 컨트롤러, 서비스, 리포지토리, 도메인, DB로 구성되어있다.
<br>

**일반적인 웹 애플리케이션 계층 구조**

![image](https://github.com/orieasy1/24-1-Programming-Study/assets/129071350/1ed84d25-92fe-46b2-b88b-a54a333ddbf7)

컨트롤러는 MVC 아키텍처에서 웹 애플리케이션의 요청을 받아들이고 적절한 작업을 수행하는 부분을 담당한다.
주로 HTTP 요청을 받아들이고 요청된 작업을 수행하기 위해 서비스에 요청을 전달한다.

서비스는 비즈니스 로직을 처리하는 부분이다.
비즈니스 도메인 객체를 바탕으로 핵심 비즈니스 로직이 동작하도록 구현이 되었다는 것이 특징이다.
중복된 회원가입 여부를 확인하거나 쿠폰을 발급하 는 등의 작업을 수행한다.

도메인은 회원, 주문, 쿠폰 처럼 주로 데이터베이스에 저장하고 관리되는 비즈니스 도메인 객체이다.
주요 데이터를 나타내고, 해당 도메인 객체의 상태와 행위를 정의한다.

리포지토리는 데이터베이스에 접근하고 도메인 객체를 데이터베이스에 저장하고 관리하는 역할을 한다. 
<br><br>
이러한 요소들이 함께 작동하여 웹 애플리케이션의 동작을 구성하고 사용자 요청에 대한 응답을 생성한다.
<br><br>

**클래스 의존 관계**

![image](https://github.com/orieasy1/24-1-Programming-Study/assets/129071350/09f18ac9-6d78-4ab3-a4db-c919875c6398)

회원 비즈니스 로직에서는 MemberService가 있고 회원을 저장하는 MemberRepository는 저장소가 선정되지 않았으므로 회원 리포지토리는 interface로 설계를 할 것이다.
그리고 이를 단순한 구현체인 Memory MemberRepository로 구현할 것이다.
개발을 진행하기 위해 초기 단계에서는 구현체로 가변운 메모리 기반의 데이터 저장소를 사용하는 경우가 많다.
추후 서비스가 구체화되고 저장소가 정해지만 이를 다시 수정해주면된다.
이것이 인터페이스를 사용하는 이유이기도 하다.
<br><br>
 
### 회원 도메인과 리포지토리 만들기

HelloController.java

```java
package com.example.springstudycode.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello!");
        return "hello";
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam("name") String name) {
        return "hello " + name;
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloAPi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
```
<br>

Member.java

```java
package com.example.springstudycode.domain;

public class Member {
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
```
<br>

MemberRepository.java

```java
package com.example.springstudycode.repository;

import com.example.springstudycode.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id); //요즘은 null을 반환할 떄 Optional로 감싸서 반환하는 것을 선호
    Optional<Member> findByname(String name);
    List<Member> findAll();

}
```
<br>

MemoryMemberRepository.java

```java
package com.example.springstudycode.repository;

import com.example.springstudycode.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository{
    //동시성 문제 고려안함(실무에서는 고려 필수)
    private static Map<Long, Member> store = new HashMap<>();   //저장소
    private static long sequence =0L;   //키값을 생성

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        //null이 반환될 가능성이 있으면 Optional.ofNullable()을 감싸서 반환
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByname(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

}
```


### 회원 리포지토리 테스트 케이스 작성

개발한 기능을 실행해서 테스트할 때 자바의 main 메서드를 통해서 실행하거나 웹 애플리케이션의 컨트롤러르 통해서 해당기능을 실행하다. 이러한 방법은 준비하고 실행하는데 오래 걸리고, 반복 실행하기 어려우면 여러 테스트를 한번에 실행하기 어별다는 단점이 있다.
자바는 JUnit이라는 프레임워크로 테스트를 실행해서 이러한 문제를 해결한다.
<br><br>
test 폴더에 테스트하고 싶은 클래스와 메소드를 작성하고 실행해주면 된다.
이때 테스트하고 싶은 메소드 위에 @Test 어노테이션을 달아준다.
run을 시켜주면 해당 메소드를 테스트할 수 있다.
<br>


MemoryMemberRepositoryTest.java

```java
package com.example.springstudycode.repository;

import com.example.springstudycode.domain.Member;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MemoryMemberRepositoryTest {
    MemberRepository repository = new MemoryMemberRepository();

    @Test
    public void save() {
        Member member = new Member();
        member.setName("spring");

        repository.save(member);

        //내가 repository에 넣은 값이 제대로 들어갔는지 확인
        Member result = repository.findById(member.getId()).get();

        //검증: new에서 내가 넣은 값이랑 디비에서 꺼낸 값이 같은지
        System.out.println("result = " + (result == member));
    }
}
```

위 클래스에서 마지막 코든 두 값이 같은지 확인하고 같으면 값을 출력해준다.
하지만 매번 이렇게 출력결과를 확인할 수 없기 때문에 Assertions를 사용한다.

```java
package com.example.springstudycode.repository;

import com.example.springstudycode.domain.Member;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MemoryMemberRepositoryTest {
    MemberRepository repository = new MemoryMemberRepository();

    @Test
    public void save() {
        Member member = new Member();
        member.setName("spring");

        repository.save(member);

        //내가 repository에 넣은 값이 제대로 들어갔는지 확인
        Member result = repository.findById(member.getId()).get();

        //검증
        Assertions.assertEquals(member, result);
    }
}
```

이 상태에서 run을 시키면 서로 일치하면

![image](https://github.com/orieasy1/24-1-Programming-Study/assets/129071350/d3979f82-f55d-4ab1-8f11-a6a38ba77299)

초록색 체크 표시가 뜨고

![image](https://github.com/orieasy1/24-1-Programming-Study/assets/129071350/1b4f9018-757c-4cb9-8904-3aa8e4677c40)

일치하지 않는다면 이렇게 오류가 나는 것을 확인할 수 있다.
<br><br>
요즘엔 org.assertj.core.api의 Assertions를 많이 사용한다.
좀 더 편하게 쓸 수 있는 형태이다.

```java
package com.example.springstudycode.repository;

import com.example.springstudycode.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class MemoryMemberRepositoryTest {
    MemberRepository repository = new MemoryMemberRepository();

    @Test
    public void save() {
        Member member = new Member();
        member.setName("spring");

        repository.save(member);

        //내가 repository에 넣은 값이 제대로 들어갔는지 확인
        Member result = repository.findById(member.getId()).get();

        //검증
        Assertions.assertThat(member).isEqualTo(result);
    }
}
```

### 회원 서비스 개발

### 회원 서비스 테스트
