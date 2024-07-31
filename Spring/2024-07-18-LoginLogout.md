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
|**UsernamePasswordAuthenticationFilter**|id와 패스워드가 넘어오면 인증 요청을 위임하는 인증 관리자 역할, 폼기반 로그인을 할 때 사용되는 필터, 인증이 성공하면 AuthenticationSuccessHandler를, 인증에 실패하면 AuthenticationSuccessHandler를, 인증에 실패하면 AuthenticationFailureHandler를 실행한다.|
|DefaultLoginPageGeneratingFilter|사용자가 로그인 페이지를 따로 지정하지 않았을 때 기본으로 설정하는 로그인 페이지 관련 필터|
|BasicAuthenticationFilter|요청 헤더에 있는 아이디와 패스워드를 파싱해서 인증 요청을 위임, 인증이 선공하면 AuthenticationSuccessHandler를, 인증에 실패하면 AuthenticationFailureHandler를 실행한다.|
|RequestCacheAwareFilter|로그인 성공 후, 관련 있는 캐시 요청이 있는지 확인하고 캐시 요청을 처리해준다. 례를 들어 로그인하지 않은 상태로 방문했던 페이지를 기억해두었다가 로그이 이후 그 페이지로 이동시켜준다.|
|SecurityContextHolderAwareRequestFilter|HttpServletRequest 정보를 감싼다. 필터 체인상의 다음 필터들에게 부가 정보를 제공하기 위해 사용된다.|
|AnoymousAuthenticationFilter|필터를 호출하는 시점까지 인증되지 않았다면 익명 사용자 전용 객체인 AnonymousAuthentication을 만들어 SecurityContext에 넣어준다.|
|SessionManagementFilter|인증된 사용자와 관련된 세션 관련 작업을 진행한다. 세션 변조 방지 전략을 설정하고, 유효하지 않은 세션에 대한 처리를 하고 세션 생성 전략을 세우는 등의 작업을 처리한다.|
|ExceptionTranslationFilter|요청을 처리하는 중에 발생할 수 있는 예외를 위임하거나 전달한다.|
|**FilterSecurityInterceptor**|접근 결정 관리자, AccessDecisionManager로 권한 부여처리를 위임하므올써 접근 제어 결정을 쉽게 해준다. 이과정에서는 사용자가 인증되어있으므로 유효한 사용자인지도 알 수 있다. 인가 관련 설정을 할수 있다는 것|
<br>

### 스프링 시큐리티의 폼 로그인 인증 처리 절차
사용자가 폼에 id와 패스워드를 입력하면 HTTPServletRequest에 id와 비밀번호 정보가 전달된다.
이때 AuthenticationFilter가 넘어온 id와 비밀번호의 유효성 검사를 한다.
유효성 검사가 끝나면 실제 구현체인 UserPasswordAuthenticationToken을 만들어 넘겨준다.
전달받은 인중용 객체 UsernamePasswordAuthenticationToken을 AuthenticationManager에게 보낸다.
또 최종적으로 AuthenticationProvider에게 보낸다.
<br><br>
AuthenticationProveider에서는 사용자 id를 UserDetailService에 보낸다.
UserDetailService는 사용자 아이디로 찾은 사용자의 정보를 UserDetails 객체로 만들어 AuthenticationProvider에게 전달한다.
이후 DB에 있는 사용자 정보를 가져와 입력정보와 UserDetails의 정보를 비교해 실제 인증 처리를 한다.
AuthenticationProvider, AuthenticationManager, AuthenticationFilter까지 인증이 완료되면 SecurityContextHolder에 Athentication을 저장한다.
인증 성공 여부에 따라 성공하면 AuthenticationSuccessHandler, 실패하면 AuthenticationFailureHandler를 실행한다.

<br>


### 스프링 시큐리티 폼 로그인 인증

#### 작동 방식
1. **로그인 폼**: 사용자는 사용자명(username)과 비밀번호(password)를 입력하여 로그인 폼을 제출합니다.
2. **인증 필터**: 스프링 시큐리티의 `UsernamePasswordAuthenticationFilter`가 로그인 요청을 가로채고 인증을 시도합니다.
3. **사용자 정보 조회**: `UserDetailsService`를 사용하여 데이터베이스에서 사용자 정보를 조회합니다.
4. **비밀번호 검증**: `PasswordEncoder`를 사용하여 입력된 비밀번호를 검증합니다.
5. **세션 생성**: 인증에 성공하면 서버는 세션을 생성하고 세션 ID를 클라이언트에게 쿠키로 전달합니다.
6. **인증 후 처리**: 인증이 성공하면 사용자에게 적절한 응답을 보내거나 지정된 페이지로 리다이렉트합니다.

#### 특징
- 스프링 시큐리티의 강력한 보안 기능을 사용하여 사용자 인증을 처리합니다.
- 설정이 유연하여 다양한 보안 요구 사항을 쉽게 반영할 수 있습니다.
- 기본적으로 세션과 쿠키를 사용하여 인증 상태를 유지합니다.

스프링 시큐리티 폼 로그인 인증은 세션 인증과 쿠키 인증을 포함하여 종합적으로 처리하는 방법입니다. 스프링 시큐리티는 강력한 보안 기능과 유연한 설정을 제공하여 다양한 인증 및 권한 부여 시나리오를 지원합니다.