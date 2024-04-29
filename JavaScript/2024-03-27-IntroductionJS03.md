# 노마드코더: 바닐라 JS로 크롭앱만들기

## Chap03. 자바스크립트를 이용한 브라우저에 대한 이해

자바스크립트가 브라우저를 어떻게 움직이게 하는지에 대해 공부해보려 한다.
앞서 html이 css와 자바스크립트를 가져온다고 배웠다.
자바스크립트를 사용하는 이유는 html과 상호작용하기 위해서이다.
즉 html의 요소들을 자바스크립트 코드를 통해 변경할 수 있다는 것이다.

브라우저 콘솔에서 document라고 치면 내가 작성한 html을 확인할 수 있다(가져올 수 있다).
document는 내가 접근가능한 html을 가리키는 브라우저에 이미 존재하는 object이다.
console에 console.dir(document)를 호출해보면 

![image](https://github.com/orieasy1/24-1-Programming-Study/assets/129071350/c7b994a7-fe9c-40b4-b0c5-e3aa5c46b5fd)

다음과 같이 출력되는 것을 확인할 수 있고 동시에 document가 object라는 사실도 확인할 수 있다.
밑으로 스크롤해서 내려보면 title에 momentum이라고 나오는 것을 확인할 수 있는데 이항목은 javascript가 아니라 html에서 정의한 내용이다.
이것은 중요한데 JavaScript에서 html document 객체로 부터 title을 들 고 올 수 있기 때문이다.

![image](https://github.com/orieasy1/24-1-Programming-Study/assets/129071350/6732e931-d2f6-47a8-83fe-d74e078f213c)
