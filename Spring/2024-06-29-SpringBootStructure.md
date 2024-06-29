# 스프링부트3 구조 살펴보기
스프링부트는 각 계층이 양 옆의 계층과 통신하는 구조를 따른다.




@RestController는 스프링 프레임워크에서 RESTful 웹 서비스를 개발할 때 사용하는 애노테이션입니다. 이 애노테이션은 주로 JSON 또는 XML 형식의 HTTP 응답을 생성하는 컨트롤러 클래스를 정의할 때 사용됩니다.

@RestController의 역할
@RestController는 두 가지 주요 애노테이션인 @Controller와 @ResponseBody의 조합입니다. 따라서, @RestController로 마크된 클래스는 RESTful 웹 서비스를 제공하기 위한 컨트롤러로 간주됩니다.

@Controller: 이 애노테이션은 스프링 MVC에서 컨트롤러 클래스를 정의할 때 사용됩니다. 컨트롤러 클래스는 웹 요청을 처리하고, 모델 데이터를 뷰에 전달합니다.
@ResponseBody: 이 애노테이션은 메서드가 반환하는 값을 HTTP 응답 본문으로 변환합니다. JSON, XML 등의 형식으로 변환하여 클라이언트에 전달합니다.




포스트맨에서 http://localhost:8080/test를 입력해서 요청을 하면 내가 data.sql에서 입력한 데이터를 확인할 수 있다.
