# 노마드코더: 바닐라 JS로 크롭앱만들기

## Chap03. 자바스크립트를 이용한 브라우저에 대한 이해

자바스크립트가 브라우저를 어떻게 움직이게 하는지에 대해 공부해보려 한다.

### The Document Object

앞서 html이 css와 자바스크립트를 가져온다고 배웠다.
자바스크립트를 사용하는 이유는 html과 상호작용하기 위해서이다.
즉 html의 요소들을 자바스크립트 코드를 통해 변경할 수 있다는 것이다.

브라우저 콘솔에서 document라고 치면 내가 작성한 html을 확인할 수 있다(가져올 수 있다).
document는 내가 접근가능한 html을 가리키는 브라우저에 이미 존재하는 object이다.
console에 console.dir(document)를 호출해보면 

![image](https://github.com/orieasy1/24-1-Programming-Study/assets/129071350/c7b994a7-fe9c-40b4-b0c5-e3aa5c46b5fd)

다음과 같이 출력되는 것을 확인할 수 있고 동시에 document가 object라는 사실도 확인할 수 있다.
밑으로 스크롤해서 내려보면 title에 momentum이라고 나오는 것을 확인할 수 있는데 이 항목은 javascript가 아니라 html에서 정의한 내용이다.

![image](https://github.com/orieasy1/24-1-Programming-Study/assets/129071350/6732e931-d2f6-47a8-83fe-d74e078f213c) 

이것은 중요한데 JavaScript에서 html document 객체로 부터 title을 들 고 올 수 있기 때문이다.
<br><br>
또 콘솔에 document.title을 검색해보면

![image](https://github.com/orieasy1/24-1-Programming-Study/assets/129071350/b89ece2c-5b4c-4697-95b5-fef4661844da)

내가 설정한 앱 이름인 Momentum이라고 출력되는 것을 확인할 수 있다.
여기서 봤듯이, 자바스크립트는 HTML에 접근하고 읽을 수 있게 설정되어 있다.

index.html 파일에서 title을 Momentum App으로 바꾸면 콜솔 창에 document.title을 쳤을 때 바뀐 결과가 나오는 것을 볼 수 있다.

![image](https://github.com/orieasy1/24-1-Programming-Study/assets/129071350/460e15fe-2340-461c-aa10-f1744cbb0672)

자바스크립트는 html을 자동적으로 읽어오는 것이다.
브라우저가 HTML 정보가 아주 많이 들어있는 document라는 object를 전달해주는 것이다.
우리는 html 코드를 자바스크립트 관점에서 보고 있다.
html에 있는 tilte을 자바스크립트로 가져다 쓸 수 있는 것이다.

![image](https://github.com/orieasy1/24-1-Programming-Study/assets/129071350/008685e4-6802-4056-b6ba-a0b2acb17730)

그리고 위 사진과 같이 자바스크립트에서 html을 읽어올 뿐만 아니라, html을 변경할 수 도 있다.

자바스크립트 파일에서는 title을 Hello from JS로 입력하고 html파일에서는 title을 Hello from HTML이라고 입력 후 돌려보면

![image](https://github.com/orieasy1/24-1-Programming-Study/assets/129071350/d748dc01-b48b-411d-898b-4205e89d18d4)

자바스크립트 파일에서 작성한 문구로 title이 설정되는 것을 확인할 수 있다.
자바스크립트로 HTML을 변경한 것이다.
<br><br>
여기서 제일 중요한 것은 자바스크립트오 html은 연결되어있다는 것이고 html에 접근하고 변경할 수 있으면 document가 시작점이라는 것이다.

### HTML in Javascript

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel = "stylesheet" href="style.css">
    <title>Momentum App</title>
</head>
<body>
    <h1 id = "title">Grab me!</h1>
    <script src="app.js"></script>
</body>
</html>
```

html코드가 다음과 같을 때 document.getElementById("title") 라는 명령어를 입력해서 위 title이라는 이름을 가진 id값을 가져올 수 있다.

![image](https://github.com/orieasy1/24-1-Programming-Study/assets/129071350/3a76683f-ddae-46f6-ad58-3dfffbe26218)

이렇게 해당되는 h1 태그를 가져온다.
<br><br>
이것을 콘솔 창이 아니라 js파일에서 실행하는 방법은 다음과 같다.

```JavaScript
const title = document.getElementById("title");
console.log(title);
```

이때 console.log(); 대신에 console.dir();을 써주면 아래 사진과 같이 title에 담겨있는 많은 정보들을 확인할 수 있다.

![image](https://github.com/orieasy1/24-1-Programming-Study/assets/129071350/9814af2d-d112-4118-8ec6-080dbbc8fb6f)

<br>
여기서 우리가 하고 있는 것은 이 HTML을 가지고 오는거지만, 이걸 자바스크립트에서 하고 있다는 것이 중요한 것이다.

className 항목을 수정해보려한다.
위 사진에서 확인할 수 있 듯이 className 항목은 비어있다.

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel = "stylesheet" href="style.css">
    <title>Momentum App</title>
</head>
<body>
    <h1 autofocus class="Hello" id = "title">Grab me!</h1>
    <script src="app.js"></script>
</body>
</html>
```

다음과 같이 코드에 className 항목을 집어 넣으면 

![image](https://github.com/orieasy1/24-1-Programming-Study/assets/129071350/84b93505-31b1-4b74-bf92-81262470cbe1)

이렇게 클래스 이름에 값이 들어간 것을 확인할 수 있다.

innerText 즉 Grab me!라고 쓴 부분을 자바스크립트에서 수정하고 싶다면

```JavaScript
const title = document.getElementById("title");
title.innerText = "Got u!" 
```

라는 코드를 사용해 수정할 수 있다.
이것이 가능한 이유는 html 코드에서 id를 설정해줬고 자바스크립트의 첫 번째 코드로 그 id가 title인 부분의 element를 가져왔고 그것을 두 번째 코드로 변경했기 때문이다.

html엣 항목들을 들고와서 JavaScript를 통해 변경한다는 것을 알아야한다.
<br><br>

### Searching For Elements

앞에서는 id를 사용해 요소를 찾는 방법에 대해 알아보았다.
이번에는 className을 사용하는 방법을 알아보려한다.

```JavaScript
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel = "stylesheet" href="style.css">
    <title>Momentum App</title>
</head>
<body>
    <h1 class = "hello">Grab me!</h1>
    <h1 class = "hello">Grab me!</h1>
    <h1 class = "hello">Grab me!</h1>
    <h1 class = "hello">Grab me!</h1>
    <h1 class = "hello">Grab me!</h1>

    
    <script src="app.js"></script>
</body>
</html>
```

```JavaScript
const hellos = document.getElementsByClassName("hello");
console.log(hellos);
```

를 적용시키면

![image](https://github.com/orieasy1/24-1-Programming-Study/assets/129071350/dbb5db6a-e86c-4354-aab0-ee2e1d9e95f5)

가 출력된다.
이 형태를 자세히 살펴보면 array 형태인 것을 알 수 있다.
hellos가 많은 h1이 들어있는 array이기 때문에 hellos. 의 형태로 무엇인가를 가져올 수 는 없다.
많은 element를 한번에 가지고 와야하는 경우에  getElementsByClassName()을 사용할 수 있다.
```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel = "stylesheet" href="style.css">
    <title>Momentum App</title>
</head>
<body>
    <div class="hello">
        <h1>Grab me!</h1>
    </div>

    <script src="app.js"></script>
</body>
</html>
```

```JavaScript
const title = document.getElementsByTagName("h1");
console.log(title);
```

위 코드 같은 경우에는 h1 태그가 하나만 있기 때문에 getElementsByTagName()를 상용하여 해당 태그를 선택하는 것이 가능하다.
만약 h1태그가 많다면 이 방법은 적절하지 않다.

실제로 저 코드를 실행시켜보면 h1이 하나만 들어있는 array가 나온다.
여전히 title은 배열의 형태이므로 title. 형태로 뭘 할 수 없다.


element를 가지고 오는 가장 좋은 방법은 querySelector와 querySelectorAll을 ㅇ