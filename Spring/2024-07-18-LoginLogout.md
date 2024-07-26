# 로그인 기능을 구현하기 위한 보안과 인증 쫌쫌따리들
회원가입과 로그인 구조는 서로 비슷하다.
다음은 로그인 구조를 표현한 것이다.

![image](https://github.com/user-attachments/assets/8bab2f31-c8e9-4c34-b762-0bb05c490cf3)

클라이언트에서 /login 요청이 들어오면 UserViewController가 해당 요청에 대한 분기 처리를 하고 WebSercurityConfig에 설정한 보안 관련 내용들을 실행한다.
UserViewController가 분기 처리를 하여 UserDetailsService 실행하면 요청을 성공했을 떄 defaultSuccessUrl로 설정한 /articles로 리다이렉트하거나 csrf를 disable한다거나 등의 작업을 한다.
<br><br>
UserDetailsService에서는 loadUserByUsername() 메서드를 실행하여 이메일로 유저를 찾고 반환한다.
여기서 유저는 직접 정의한 User클래스의 객체이고 UserREpository에서 실제 데이터를 가져온다.
<br>

![image](https://github.com/user-attachments/assets/26b92789-7d2f-4944-96db-cabe4470d2e2)

로그아웃 로직은 /logout요청이 오면 UserApiController 클래스에서 로그아웃 로직을 실행한다.
로그아웃 로직은 SecurityContextLogoutHander에서 제공하는 logout() 메서드를 실행

## Spring Security

### 인증과 인가
* 인증: 사용자의 신원을 입증하는 과정
    * 사용자가 사이트에 로그인을 할 때 누구인지 확인하는 과정
* 인가: 사이트의 특정 부분에 접근할 수 잇는지 권한을 확인하는 작업
스프링 시큐리티를 사용하면 인증과 인가 관련 코드를 비교적 아주 쉽게 처리할 수 있다.

### 스프링 시큐리티
스프링 시큐리티는 스프링 기반의 애플리케이션 보안(인증, 인가, 권한)을 담당하는 스프링 하위 프레임워크이다.
<br>

보안 관련 옵션을 많이 제공하며 애너테이션으로 설정도 매우 쉽다.
CSRF 공격, 세션 고정 공격을 방어해주고 요청 헤더도 보안처리를 해주므로 개발자가 보안 관련 개발을 해야하는 부담을 크게 줄여준다.
* CSRF 공격: 사용자의 권한을 가지고 특정 동작을 수행하도록 유도하는 공격
* 세션 고정 공격: 사용자의 인증 정보를 탈취하거나 변조한느 공격

### 스프링 시큐리티와 필터
스프링 시큐리티는 필터 기반으로 동작한다.
다향한 필터들로 나누어져 있으며 각 필터에서 인증, 인가와 관련된 작업을 처리합니다.

![image](https://github.com/user-attachments/assets/a0af3b68-ff7c-4897-bcaf-a96b29f77337)

SecurityContextPersistenceFilter부터 시작해서 아래로 내려가며 FilterSercurityInterceptor까지 순서대로 필터를 거친다.
필터를 실행할 때는 회색 화살표로 연결된 클래스를 거치며 실행된다.
특정 필터를 제거하거나 필터 뒤에 커스텀 필터를 넣는 등의 설정도 많이 제공한다.

|필터명|설명|
|:----|:---|
|SecurityContextPersistenceFilter|SecurityContextRepository에서 SecurityContext(접근 주체와 인증에 대한 정보를 담고 잇는 객체)를 가져오거나 저장하는 역할을 한다.|
|LogoutFilter|설정된 로그아웃 URL로 오는 요청을 확인해 해당 사용자를 로그아웃 처리한다.|
|UsernamePasswordAuthenticationFilter|id와 패스워드가 넘어오면 인증 요청을 위임하는 인증 관리자 역할, 폼기반 로그인을 할 때 사용되는 필터, 인증이 성공하면 AuthenticationSuccessHandler를, 인증에 실패하면 AuthenticationSuccessHandler를, 인증에 실패하면 AuthenticationFailureHandler를 실행한다.|