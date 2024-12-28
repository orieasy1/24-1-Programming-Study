<h1>김영한 스프링 입문 - 코드로 배우는 스프링부트, 웹MVC, DB 접근 기술</h1>

<h3>라이브러리 살펴보기</h3>
프로젝트를 보면 build.gradle이라는 파일이 있다.
이 파일은 프로젝트의 구성을 정의하고 의존성 관리도 해준다. 
build.gradle파일에서 의존성을 선언하면 gradle이 해당 라이브러리를 인터넷에서 다운로드 하거나 로컬 리포지토리에서 가져와 프로젝트에 추가한다.

![image](https://github.com/orieasy1/24-1-Programming-Study/assets/129071350/ab9184ac-37bd-40e1-b20e-897758d0583e)

내가 만든 프로젝트에서 build.gradle 파일을 확인해보면 선언한 의존성 파일이 몇 개 없는 것을 확인할 수 있다.
thymeleaf라는 템플릿 엔진, 웹, test 이 세 가지 밖에 존재하지 않는다.
(thymeleaf는 자바 웹 애플리케이션에서 사용되는 서버사이드 템플릿 엔진으로 html, css 등의 정적 마크업 언어와 서버 사이드 자바코드를 조합하여 동적 웹 페이지를 생성할 수 있도록 지원해준다.)

그러나 실제 라이브러리를 열어보면 내가 끌어오지 않은 많은 라이브러리들이 이미 땡겨와져 있는 것을 확인할 수 있다.
gradle이나 maven 같은 빌드툴들은 의존관계를 다 관리해준다.
spring boot starter web 라이브러리를 당겨오면 tomcat등과 같은 다른 라이브러리들도 당겨온다.
나는 web을 만들기 위해 위 라이브러리를 당겨왔고 spring boot starter web의 경우 자기 자신과 의존 관계에 있는 라이브러리가 있을 것이다.
Gradle은 이 모든 라이브러리를 끌어와준다.
의존에 의존에 의존 관계에 있는 모든 라이브러리를 끌어오고 마지막에는 spring core까지 끌어오는 것이다.

![image](https://github.com/orieasy1/24-1-Programming-Study/assets/129071350/8fe2d8a0-49af-4648-a9a6-cfe5103d2627)

위 사진처럼 gradle을 클릭해서 라이브러리들 간의 의존 관계를 확인할 수 있다.
사진을 자세히 살펴보면 spring boot starter tomcat이라는 이름의 라이브러리를 볼 수 있는데 웹 서버 8080를 띄울 수 있게 해주는 라이브러리이다. 
옛날에는 웹 서버라는 것을 서버에 직접 설치를 해두고 자바 코드를 밀어 넣는 식으로 진행했다.
웹 서버와 개발 라이브러리가 완전히 분리되어있는 것이다.
그러나 요즘은 소스 라이브러리에서 이런 웹서버를 들고 있다.(이걸 imbedded, 내장되어있다고 표현한다.)

<h3>View 환경설정</h3>

제일 처음에 프로젝트를 run시키고 웹에 접속해보면 에러 페이지가 나온다.
이 페이지를 편집해주는 작업을 할 것이다.
스프링부트에서는 static/index.html 파일을 올려두면 Welcome page 기능을 제공한다.
이렇게 작성하는 것은 내가 작성한 파일을 그대로 웹 브라우저에 넘겨주는 정적 페이지이다.
그러나 템플릿 엔진을 쓰면 내가 원하는대로 보다 쉽게 코드를 바꿀 수 있다.

동작 환경(과정)은 다음과 같다.
웹 브라우저가 주소를 던지면 스프링부트는 내장 톰캣서버를 내장하고 있는데 이 서버가 다시 스프링에게 던진다.
locallhost:8080/hello를 던졌으면 스프링에서는 hello에 매핑되어있는 컨트롤러를 찾는다.
그러면 매칭되어있는 메서드가 동작된다.

```java
@Controller
public class HelloController {
    @GetMapping
    public String hello(Model model) {
        model.addAttribute("data", "hello!");
        return "hello";
    }
}
```

현재 내가 작성한 코드에서는 HelloController 안에 있는 hello 메소드가 작동될 것이다.
위 코드를 자세히 살펴보면 model을 넘어오고 addAttribute 메소드를 사용하여 model 객체에 data라는 이름으로 hello! 문자열을 추가한다.
(모델에 data라는 이름의 속성을 추가하고 해당 속성의 값으로 hello!라는 문자열을 할당하는 것)

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Hello</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>
<p th:text = "'안녕하세요. ' + ${data}" >안녕하세요. 손님</p>
</body>
</html>
```

라는 내용의 html 파일을 작성해두었는데 위 컨트롤러에서 작성한 return "hello";라는 구문은 스프링 MVC에게 hello라는 뷰를 찾아서 렌더링하라는 명령을 내리는 것이다.
hello라는 문자열은 뷰의 이름을 나타내고 스프링 MVC는 hello라는 이름의 뷰를 찾아서 렌더링하는 것이다.
hello.html 파일은 Thymeleaf 템플릿 엔진을 사용하고 있으므로 이 템플릿 파일은 Model에 추가된 데이털르 이용하여 동적으로 html을 생성하는데 사용된다.

컨트롤러에서 리턴 값으로 문자를 반환하면(위 예시에서는 hello) viewResolver가 화면을 찾아서 처리한다.
기본적으로 viewResolver는 스프링부트 템플릿 엔진을 기본으로 viewNameㅇ르 매핑하는데 형태는 다음과 같다.
**resources:templates/ + {ViewName} + .html**

그래서 html 파일 중 data는 hello!로 바뀌게 되는 것이다.
<br>

<h3>빌드하고 실행하기</h3>

cmd창으로 빌드하는 법

* cd 폴더경로
* gradlew.bat
* gradlew build
* cd build
* dir
* cd libs
* dir  (여기서 jar파일명 찾기)
* java -jar 파일명

cmd창에서 실행한 경우 인텔리제이에서 동시에 실행할 시 에러발생할 수 있음
