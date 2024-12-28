## 자바 백엔드 개발에서 알아두면 좋은 기본 지식들

### 서버와 클라이언트

#### 클라이언트란?
클라이언트는 서버로 요청하는 프로그램을 모두 일컫는 표현이다.
다르게 말하면 서비스나 데이터를 요청하는 사용자 측의 소프트웨어나 장치라고도 할 수 있다.
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

서버: 컴퓨터 네트워크에서 다른 컴퓨터에 대해 자신이 갖고 있는 기능이나 서비스, 데이터 등을 제공하는 컴퓨터 또는 그와 같은 기능을 가진 소프트웨어


**웹 서버의 역할**

* 하드웨어 측면: 웹 서버의 소프트웨어와 컴포넌트 파일을 저장하는 컴퓨터
    * HTML 문서, 이미지, CSS, JS파일 등을 저장
    * 인터넷을 통해 다른 기기들에게 컴포넌트 파일을 주고 받는다.
* 소프트웨어적 측면: 사용자가 홋트 파일에 어떻게 접근하는지를 관리
    * 사용자 HTTP 요청을 받아 정적인 컨텐츠를 제공
    * 동적인 컨텐츠를 젱공하는 경우 WAS에 요청을 보내고 처리한 결과를 전달
<br>

**웹서버의 종류**

* 정적 웹서버: HTTP 서버가 잇는 컴퓨터로서 요청된 파일을 사용자의 브라우저에 그대로 전송, 업데이트X -> 한정적 서비스제공
* 동적 웹서버: 정적 웹서버에 추가된 소프트웨어(어플리케이션 서버와 데이터베이스)로서 요청을 응답하기전에 어플리케이션 서버가 업데이트 되기 때문에 동적이라고 부름, 같은 페이지여도 다른 결과의 웹 페이지를 볼 수 있음

<br><br>
Apache, EC2, Microsoft IIS 등

<br>

### 데이터베이스
데이터베이스: 여러 사람이 데이터를 한 군데 모아 놓고 여러 사람이 사용할 목적으로 관리하는 데이터 저장소

데이터베이스 관리 시스템(DBMS): MySQL, Oracle, postgreSQL등 DB를 관리하기 위한 시스템
<br><br>
클라이언트에서 SQL(DB를 조작하기 위한 언어)로 DBMS에 데이터를 요청하면 DBMS는 데이터베이스에서 데이터를 꺼내 응답한다.
<br>

#### RDB; Relational Database
관계형 데이터베이스

데이터베이스는 여러 가지로 구분할 수 있는데 RDB, NoSQL, NewSQL등 여러 종류가 있다.
그 중 가장 많이 사용하는 데이터베이스가 관계형 데이터베이스, RDB이다.
NoSQL은 Not Only SQL의 약자로 관계형 모델을 넘어서 다양한 데이터 저장 방식을 제공하는 데이터베이스 시스템이고 NewSQL은 관계형 데이터 베이스의 ACID(원자성, 일관성, 격리성, 지속성) 특성을 유지하면서도 NoSQL처럼 수평적 확작성과 성능을 제공하는 새로운 형태의 데이터베이스 시스템이다.
<br><br>
관계형 데이터베이스는 데이터를 행과 열로 이루어진 테이블로 관리하며, 기본키(primary key)를 이용하여 각 행을 식별한다.
RDB에서 유명한 DBMS에는 MySQL, Oracle, postgreSQL 등이 있다.

관계형 데이터베이스는 데이터의 정확성과 일관성을 유지하기 위한 무결성 규칙을 제공한다. 이는 외래키 제약조건, 유니크 제약 조건 등을 포함한다.
또 ACID(원자성, 일관성, 격리성, 지속성) 속성을 보장하는 트랜젝션 관리 기능을 제공한다. 이는 DB 작업이 아넌하고 신뢰성 있게 수행된다느 것을 보장한다.
<br>

#### SQL과 NoSQL이란?
SQL은 Structured Query Language의 약자로 말그대로 쿼리 즉 데이터 검색을 하는 언어이다.
SQL도 하나만 있는 것이 아니라 ANSI 표준 SQL이 있고 RDB별로 방언이 있다.
SQL은 데이터 질의를 위한 언어로 RDB전용이라고 보기 어렵다.
NoSQL에도 SQL엔진을 도입해서 데이터를 조금 더 편하게 질의하도록 지원하는 경우가 많다. 
<br><br>
NoSQL의 뜻은 SQL을 쓰지 않는다는 의미로 사용되기도 하지만 최근에는 Not Only SQL의 의미로 많이 사용한다.
RDB는 데이터 저장, 질의, 수정, 삭제가 용이하지만 반면에 성능을 올리는 것이 쉽지 않다.
데이터베이스의 서능을 높이려면 멋니의 성능을 좋게하는 스케일 업 또는 멋빈을 여러 대로 분리하는 스케일 아웃 이라는 것이 필요하다.
스케일 업은 장비를 업그레이드 하면 되지만, 스케일 아웃은 데이터베이스를 분산하고, 이때 트랜잭션을 사용하면 성능이 떨어지게 된다.
RDB의 이러한 문제를 해결하기 위해 NoSQL이 등장햇으며 데이터 모델링을 어떻게 하느냐에 따라 분류한다.

<br>

### IP와 포트
IP(Internet Protocol)는 인터넷에서 컴퓨터 또는 기기들이 서로를 식별하고 통신하기 위한 주소이다.
인터넷 상의 모든 장치에 할당된 고유한 값이다.
이 주소를 통해 데이터 패킷이 올바른 대상 컴퓨터나 장치로 전송될 수 있다.
<br><br>
IP를 알면 서버를 찾을 수 있지만 서버를 이용하기 위해서는 포트까지 알아야한다.
IP가 서버를 찾기 위한 번호라면 포트는 그 서버에서 운용되고 있는 서비스를 구분하기 위한 번호이다.
이렇게 함으로써 하나의 IP주소를 가진 장치에서 여러 프로그램이 네트워크 통신을 동시에 할 수 있다.
<br><br>
포트 번호는 0 ~ 65535까지 숫자로 구성된다.
일부 포트 번호는 특정 용도로 예약이 되어있다.

* HTTP: 80
* HTTPS: 443
* FTP: 21

https://www.naver.com/ 같은 주소를 뜯어보면 www.naver.com은 IP를 쉽게 알아보기 위해 이름표를 붙인 것이고 그 아펭 잇는 https://라는 것은 위에서 언급했듯이 서버의 443번 포트를 사용하기 위한 입력이다.

<br>

### 라이브러리와 프레임워크

#### 라이브러리
라이브러리는 애플리케이션 개발에 필요한 기능인 클래스, 함수 등을 모아놓은 코드의 모음을 말한다. 
도서관보다는 책의 모음으로 받아들이는 것이 좋다.

개발자가 소프트웨어를 만들 때 필요에 따라 원하는 기능을 구현하기 위해 코드의 모음을 가져다 쓸 수 있는 일종의 도구 역할을 하는 것이다.
따라서 개발자는 복잡한 코드를 직접 작성하지 않아도 되므로 원하는 기능을 더 빠르게 개발할 수 있다.
또 라이브러리는 독립적의므로 서로 영향을 크게 주지 않는다.

#### 프레임워크
프레임워크는 소프트웨어 개발을 수월하게 하기 위한 소프트웨어 개발 환경이다. 프레임웤는 틀(frame)과 일하다(work)의 합성어로 일하기 위한 틀을 제공하는 것이다.
프레임웤는 정해진 틀에서 개발해야 한다는 단점이 있지만 개발 효율은 굉장히 높다는 장점이 있다.
프레임워크는 애플리케이션을 개발할 때 전체적인 구조를 잡기 위해 사용하는 것이고, 라이브러리는 개발을 하는 과정에서 필요한 기능을 구현하기 위해 사용하는 것이다.

<br>

### 백엔드 개발자의 업무
백엔드 개발자의 주된 업무는 서버 측 애플리케이션을 개발하는 일이다.
서버에 대한 지식, 프로그래밍 지식, 그리고 만든 프로그램을 배포하고 안전하게 서비스할 수 있게(유지보수)하는 지식이 필요하다.
<br><br>
백엔드 개발자의 업무는 조직마다 다르겠지만 대개는 과제할당 -> 과제 분석 -> 개발 -> 테스트(리뷰) -> QA 및 버그 수정 -> 배포 -> 유지보수 순서로 진행된다.

* 과제분석: 주어진 과제에서 어떤 동작과 조건을 필요로하는지, 어떤 데이터들을 저장해야하는지 등을 결정한다. 제공할 서능과 사용할 기술을 검토하고, 문제가 있다면 해결 방법도 면밀하게 분석하고 정리해야 한다.
* 개발: 기능을 개발하고 버그를 수정, 깃허브 등을 이용해 동료들의 리뷰를 받고 리뷰에 대한 내용을 반영해서 코드의 완성도를 높인다.
* 테스트: 코드가 제대로 동작하는지 테스트하는 과정, 이를 통해 프로그램의 완성도를 높여가는 과정이다. 로직상 문제는 없는지, 성능 한계는 어느 정도인지, 만든 코드가 읽기 편한지, 내가 만든 클래스, 메서드, 함수를 다른 사람이 간편하게 사용할 수 있는지 등까지 검토해야함
* QA: Quality Assurance(품질보증), 프로젝트 시작과 마무리까지 모든 과정을 함께 기획하고 올바른 방향을 찾고 품질 저하 요소를 발견하며 해당 프로젝트의 품질을 올리는데 주목적이 있다.
* 배포와 유지보수
    * QA가 완료되면 서버에 배포를 진행한다. 여러 과제를 한 번에 병합해서 배포하거나 새로운 기능이 추가될 때 마다 배포한다. 애플리케이션을 쉽고 안전하게 배포하고 문제 발생시 쉽게 ㅣㅇ전 버전으로 돌리는 작업으 할 수 있게 준비해야한다.
    * 배포 방법
        * 롤링배포: 특정개수의 서버들을 돌아가며 배포
        * 블루 그린 배포: 똑같은 서버 인스턴스를 띄우고 로드밸런서 설정을 바꿔버리는 배포
        * 카나리 배포: 전체 서버의 특정 비율만큼 배포해보고 문제없는 경우 점점 배포를 늘려가는 배포
    * CI/CD: 개발자는 코드 개발부터 테스트, 배포, 모니터링까지 무한 반복을 하는데 빌드부터 배포까지의 과정을 자동화할 수 있다. 이것을 CI/CD, Continuous Integration, Continuous Delivery & Development라고 한다.
        * CI: 지속적인 통합이라는 뜻으로새로운 코드 변경 사항이 정기적으로 빌드 및 테스트되어 저장소에 통합되는 것을 의미한다.
        * CD: 지속적인 배포를 의미하며 실제 프로덕션 환경까지 변경된 코드가 반영되는 것을 의미한다.