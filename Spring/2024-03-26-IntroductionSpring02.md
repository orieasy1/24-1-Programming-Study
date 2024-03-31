# 김영한 스프링 입문 - 코드로 배우는 스프링부트, 웹MVC, DB접근기술

## SEssion 2. 스프링 웹 개발 기초

웹 개발에는 크게 3가지 방법이 있다.

* 정적 컨텐츠: 서버에서 하는 것 없이 파일을 그대로 웹 브라우저에 내려주는 것
* MVC와 템플릿 엔진: 서버에서 무엇인가를 해서 html을 동적으로 바꿔서 웹 브라우저에 내리는 것
* API: json이라는 데이터 포맷으로 클라이언트에게 데이터를 전달하는 것, 서버끼리 통신할 때

가 바로 그것이다.
<br>

### 정적컨텐츠

정적 콘텐츠란 서버에서 변하지 않는 콘텐츠를 말한다.
이러한 콘텐츠는 서버 측에서 특별한 처리 없이 직접 클라이언트에 제공되기 때문에 서버에 요청이 오면 항상 동일한 내용을 반환한다.
<br><br>

실제로 아래처럼 코드를 작성하고 run시키면 

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <title>static content</title>
    <meta http-equiv="content-Type" content="text/html; charset=UTF-8">
</head>
<body>
정적 컨텐츠입니다.
</body>
</html>
```

아래처럼 내가 html 파일로 작성한 내용이 화면에 그대로 나타나는 것을 확인할 수 있다.

![image](https://github.com/orieasy1/24-1-Programming-Study/assets/129071350/18b29091-cc4d-49e2-8b2e-7ccf91dfe1ca)

소스보기를 했을 때도 작성했던 html과 같은 내용이 나타난다.

![image](https://github.com/orieasy1/24-1-Programming-Study/assets/129071350/84f20ea9-1147-4a71-a6ae-31b9b63cef82) <br>

이제 화면에 "정적 컨텐츠입니다." 라는 문구가 나타나기 까지의 과정을 알아보고자 한다.

![image](https://github.com/orieasy1/24-1-Programming-Study/assets/129071350/5329aec3-aa7e-47fa-839b-82033f8564cb)

웹 브라우저에 localhost:8080/hello-static.html을 입력하면 내장 톰캣 서버가 이 요청을 받아서 스프링한테 넘긴다.
스프링은 먼저 컨트롤러 쪽에서 hello-static 관련 컨트롤러가 있는지 찾아본다. (컨트롤러가 우선순위에 있다는 뜻)
하지만 이와 매핑된 컨트롤러가 없기에 resources 안에 있는 hello-static.html의 파일을 찾고 이를 반환해준다.
<br>

### MVC와 템플릿 엔진

MVC는 Model, View, Controller를 의미한다.

예전에는 view와 controller가 나뉘어져있지 않고 view에서 모든 것을 다했다.
이것을 model1 방식이라하고 현재는 MVC 스타일을 많이 사용한다.
view는 화면과 관련된 일만, 비즈니스 로직과 서버 뒷단에 관련된 것은 컨트롤러나 뒷단에서 처리하는 방식으로 코드를 짜는 것이다.
<br>

HelloController 클래스에 들어가서 hello-mvc로 맵핑된 메소드를 만들었다.

```java
@GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-templete";
    }
```

이번에는 parameter를 받을 것이다.
앞서 동작과정을 알아보기 위해 작성했던 메소드에서는 값을 직접 받았었는데 이것과는 다르게 외부에서 뭔가 값을 받아오고자한다.
이걸 model에 담으면 view에서 렌더링할 때 사용하게 된다.
파라미터로 넘어온 name을 넘기고자 한다.
hello-template이라는 값을 리턴하면 스프링은 hello-templete이라는 뷰를 찾아서 렌더링 할것이다.
<br><br>
templates 폴더에 들어가서 hello-template.html 파일을 다음과 같이 작성한다.

```html
<html xmlns:th="http://www.thymeleaf.org">
<body>
<p th:text="'hello ' + ${name}">hello! empty</p>

</body>
</html>
```

이렇게 작성하면 hello! empty가 'hello ' + ${name}에 해당하는 내용으로 치환이 된다.
그러나 run을 시키고 locallhost:8080/hello-mvc로 접속하면 에러페이지가 뜨고

![image](https://github.com/orieasy1/24-1-Programming-Study/assets/129071350/614f4a08-bdbf-4c88-846c-c22a0648df5a)

console창을 확인해보면

![image](https://github.com/orieasy1/24-1-Programming-Study/assets/129071350/db98bcc5-a553-4e8d-9dc9-b7fff9efd380)

Spring parameter name이 없어서 에   러가 발생한다는 것을 확인할 수 있다.

![image](https://github.com/orieasy1/24-1-Programming-Study/assets/129071350/596e6587-9b6a-4e58-8b0f-2034ea2279bc)

사진처럼 ?=이름을 작성해서 parameter값을 넘겨줄 수 있다.

![image](https://github.com/orieasy1/24-1-Programming-Study/assets/129071350/596e6587-9b6a-4e58-8b0f-2034ea2279bc)

위 처럼 Spring으로 작성해주면 name은 Spring으로 넘어가고 그럼 controller에서 name은 Spring으로 바뀌고 model에 담긴다. 
템플릿에 넘어가면 ${ }안의 값이 Spring으로 바뀐다.
달러표시는 model에서 값을 꺼내는 것을 의미한다.
name이라는 키의 값인 Spring으로 name이 치환되어 표시되는 것이다.

viewResolver가 templates/hello-template.html이라는 파일을 찾아서 Thymeleaf 템플릿 엔진에 처리해달라고 넘긴다.
그럼 템플릿 엔진이 번환을 한 html을 웹 브라우저(클라이언트)에게 넘겨주고 웹 브라우저는 받은 html을 렌더링하여 사용자에게 보여준다. 
변환을 해서 넘겨주는 것이 앞서 설명한 정적컨텐츠와 가장 큰 차이점이다.
그래서 이를 동적으로 생성된 HTML이라 표현한다.
<br><br>
소스 보기를 하면 

![image](https://github.com/orieasy1/24-1-Programming-Study/assets/129071350/92d6c72c-f480-4df6-918d-fbccfff53f55)

작성했던 html과 다르게 Spring 부분이 변환되어 나타나는 것을 확인할 수 있다.
<br><br>
앞서 설명한 MVC 패턴과 웹 템플릿 동작과정 이미지

![image](https://github.com/orieasy1/24-1-Programming-Study/assets/129071350/7261ca0a-5dd7-4349-aabb-6becb6e3710f) <br>

그리고 아래처럼 required 속성을 false로 작성해주면 parameter값을 넘겨주지 않아도 된다.
해당 요청 매개변수가 필수가 아님 선택적임을 나타내기 때문이다.
이렇게 작성해주면 클라이언트가 name이라는 매개변수를 전달하지 않으면 name이 null값으로 설정되고 모델에 추가되어 뷰에서 사용할 수 있다.
<br><br>
위에서 오류가 발생한 것 처럼 required 속성을 생략학나 true로 설정한다면 parameter 누락시 Spring MVC는 MissingServletRequestParameterException 예외를 발생시킬 것이다.

```java
@GetMapping("hello-mvc")
    public String helloMvc(@RequestParam(value = "name", required = false) String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }
```

### API

웹 개발은 MVC 방식에서 View를 찾아서 템플릿 엔진을 통해 렌더링 후 html을 웹브라우저로 넘겨주는 방식과 api으로 데이터를 바로 내리는 방식, 크게 이 두 가지로 생각해볼 수 있다.
<br>

@ResponseBody 어노테이션은 http에서 body부분에 반환하는 데이터(return 뒤에 있는 데이터)를 직접 넣어주겠다는 것이다.
내가 넣어준 데이터가 내가 요청한 클라이언트한테 그대로 내려가는 것이다.
다른 방식과 다르게 view가 존재하지 않는 것이 특징이다.

```java
 @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam("name") String name ) {
        return "hello " + name;
    }
```

매겨변수 name의 값을 넣어서 요청하면 다음과 같은 화면이 뜬다.

![image](https://github.com/orieasy1/24-1-Programming-Study/assets/129071350/daf36fa9-20ab-46a2-8037-f1fcd5a2d3e3)

겉으로 보기에는 앞서 진행했던 MVC패턴과 템플릿 엔진을 사용한 방식과 유사해보이지만 페이지 소스를 보면 다음과 같이 내가 넣어준 데이터만 존재하는 것을 확인할 수 있다.

![image](https://github.com/orieasy1/24-1-Programming-Study/assets/129071350/db989a5a-9a16-41df-b16f-433a233d062c) <br>

템플릿 엔진이라는 것은 view라는 템플릿이 있는 상황에서 그것을 조작하는 것이고 API는 데이터를 그대로 내려주는 것이다.
<br>
API형식은 데이터를 효과적으로 전송하고 교환하기 위한 목적으로 사용된다.
이번에는 api방식으로 객체를 전달해보려고 한다.

HelloController 안에 이렇게 코드를 작성하고 작동시키면

```java
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
```

웹 브라우저에 다음과 같이 나타난다.
아래 스타일은 json 파일 형식이다. <br>

![image](https://github.com/orieasy1/24-1-Programming-Study/assets/129071350/2dc0ba87-7409-4596-949f-3fec5f1b5c22)

json은 데이터를 효과적으로 표현하고 교환하기 위한 경량의 데이터 형식이다.
끼-값 쌍으로 이루어져있는 것을 확인할 수 있다.
사람과 기계 모두 이해하기 쉽고 텍스트 기반의 형식이라는 것이 특징이다.
<br><br>
과거에는 xml 파일도 많이 사용했는데 json형식이 보다 가볍고 간다하여 가독성이 높아 요즘은 거의 json형식을 많이 사용하고 있다.
스프링도 기본적으로 객체를 반환하고 ResponseBody라는 어노테이션을 달아놓으면 json으로 반환한다.
<br>

위에서 작성한 자바코드는 Java Bean 규약을 따르고 있다.
<br><br>
Java Bean 규약은 자바 언어에서 재사용가능한 소프트웨어 컴포넌트를 개발하기 위한 규약이다.
<br><br>
클래스 디자인 패턴을 따른다는 것, Property 접근 방식이라는 개념을 사용하여 객체의 상태를 표현한다는 것, 데이터를 캡슐화하여 외부에서 직접 접근할 수 없도록 하는 등의 특징이 있다.
<br><br>
자바 Bean은 주로 데이터와 관련된 작업을 수행하는 객체를 의미한다.
클래스의 필드를 캡슐화하고 외부에서 필드에 직접 접근하지 못하도록 하기 위해 getter setter 메소드를 사용한다.
<br>

이제 API 형식의 동작과정을 살펴보려한다.

![image](https://github.com/orieasy1/24-1-Programming-Study/assets/129071350/d6b86e88-1f33-44a3-90bc-3160c16bad27)

웹 브라우저에서 요청을 하면 내장된 톰캣 서버가 이를 받아 스프링에게 넘겨준다.
그러나 이번에는 @ResponseBody 어노테이션이 붙어있다.
이 어노테이션이 안붙어있으면 내용을 viewResolver에게 넘겨 일치하는 템플릿을 찾지만 여기서는 HttpMessageConverter가 작동한다.
HttpMessageConverter는 전달받은 내용이 단순 문자라면 StringConverter가 동작하고 객체라면 JsonConverter가 작동한다.
객체를 Json 스타일로 바꾸는 것이다.
변환한 내용을 다시 웹 브라우저에게 전송한다.
