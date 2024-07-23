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
스프링 시큐리티는 스프링 기반의 애플리케이션 보안(인증, 인가, 권한)을 담당하는 스프링 하위 프레임워크이다.

### 인증과 인가
* 인증: 사용자의 신원을 입증하는 과정
    * 사용자가 사이트에 로그인을 할 때 누구인지 확인하는 과정
* 인가: 사이트의 특정 부분에 접근할 수 잇는지 권한을 확인하는 작업
스프링 시ㅠ리티를 사용하면 인증과 인가 관련 코드를 쉽게 

### 스프링 시큐리티
보안 관련 옵션을 많이 제공하며 애너테이션으로 설정도 매우 쉽다.
CSRF 공격, 세션 고정 공격을 방어해주고 요청 헤더도 보안처리를 해주므로 개발자가 보안 관련 개발을 해야하는 부담을 크게 줄여준다.
