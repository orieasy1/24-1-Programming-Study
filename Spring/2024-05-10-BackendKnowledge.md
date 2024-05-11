## 자바 백엔드 개발에서 알아두면 좋은 기본 지식들

### 서버와 클라이언트

#### 클라이언트란?
클라이언트는 서버로 요청하는 프로그램을 모두 일컫는 표현이다.
다르게 말하면 서비스나 데이터를 요청하는 사용자 측의 소프트웨어나 장치라고도 할 수 잇따.
웹 브라우저가 대표적인 클라이언트 중 하나이다.
주소를 입력하고 정보를 요청하는 행위를 서버에 요청한다고 한다.
그러면 서버는 그 주소에 맞는 화면으로 응답한다.
클라이언트는 요청을 보내고 서버로부터 받은 데이터를 사용자에게 시작적으로 표현하는 작업을 담당한다.
<br>

#### 서버란?
서버는 클라이언트의 요청을 받아 처리하는 주체이다. 클라이언트가 데이터를 요청했다면 데이터를, 단지 서버내에서 처리만 해달라는 요청을 했다면 해당 요청만 처리할수도 있다.
<br><br>
웹서버는 HTML 문서, CSS, JS 파일, 이미지 등 웹 파이지를 구성하는 다양한 리소스를 저장하고 있으며 클라이언트의 요청에 따라 이러한 리소스를 제공한다.
<br>

#### 클라이언트-서버 모델
웹 개발에서 클라이언트-서버 모델은 이 두 구성 요소가 상호작용하는 방식을 설명한다.
클라이언트가 웹페이지나 데이터를 요청하면 서버는 해당 요청을 처리하고 요청된 데이터나 결과를 클라이언트에게 전송한다.

이 가정은 HTTP(HyperText Transfer Protocol)라는 프로토콜을 통해 이루어진다.
웹에서 이루어지는 데이터 교환 규칙으로 데이터를 허떻게 전달할 것인가를 정의한 것이다.
웹 서버는 HTTP 서버라고도 한다.
HTTP는 요청(request)와 응답(response)으로 구성된다.
클라이언트와 서버는 요청과 응답을 주고 받으며 사용자에게 웹페이지를 제공하거나 웹 애플리케이션 기능을 수행한다.

* 요청: 사용자가 웹 브라우저를 통해 특정 웹 페이지를 요청하면 브라우저(클라이언트)는 서버에 해당 페이지를 달라는 HTTP 요청을 보낸다. 이 요청에는 요청방식(GET, POST), 요청하는 리소스의 URL, 헤더(브라우저 정보, 콘텐츠 유형 등) 등의 정보가 포함된다.
    * 요청 방식 
        * GET: 주로 데이터를 조회하기 위해 사용
            * URL의 일부로 데이터를 전송   http://example.com/index?name=John&age=30과 같이 URL 뒤에 ?를 붙이고, 그 뒤에 키=값 형태로 데이터를 추가
            * URL에 데이터가 노출되므로 민감한 정보를 전송하기에는 부적절
            * 많은 양의 데이터를 전송하기에는 어려움
            * 캐싱이 가능하므로 같은 요청은 결과를 캐시에서 바로 가져올 수 있어 효율적이다
        * POST: 서버에 데이터를 전송하여 새로운 리소스를 생성하거나 업데이트하기 위해 사용됨(회원가입, 글작성 등)
            * HTTP 요청의 본문에 포함되어 전송, URL에 데이터가 노출되지 않음
            * 데이터 양에 제한이 없어 많은 양의 데이터를 전송할 수 있다.
            * 캐싱이 되지 않으므로 같은 요청을 여러번 보내도 서버에서는 매번 처리해야한다.
            *파일 업로드와 같은 복잡한 데이터를 전송할 때 주로 사용된다.
* 응답: 서버는 클라이언트의 요청을 받고 처리한 뒤, 요청된 데이터와 함께 상태코드(202 OK, 404 Not Found 등), 응답 헤더 등을 포함한 HTTP 응답을 클라이언트에게 전송한다. 클라이언트는 이 응답을 받아 사용자에게 보여주는 방식으로 웹 페이지를 렌더링한다.

웹 개발에서 서버와 클라이언트의 분리는 개발의 복잡서을 줄이고 유지보수를 용이하게 하며, 보안을 강화하는 등 여러 장점을 제공한다.
<br>

#### 웹 서버란?

* 하드웨어 측면: 웹 서버의 소프트웨어와 컴포넌트 파일을 저낭하는 