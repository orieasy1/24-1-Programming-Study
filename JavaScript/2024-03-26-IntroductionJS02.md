# 노마드코더: 바닐라 JS로 크롭앱만들기

<h2>Chap 2. 자바스크립트 입문</h2>

* 자바스크립트 다뤄보기, 자바스크립트로 프로젝트 제작해보기
* html과 자바스크립트 연결방법 이해하기


앞서 말했듯이 자바스크립트는 이미 브라우저에 설치되어있기 때문에 브라우저의 console를 사용해서 자바스크립트를 다룰 수 있다.
하지만 콘솔은 긴 코드를 작성하려고 만들어진 것이 아니기 때문에 자바스크립트 코들르 작성하는 것은 불편하다.
브러우저와 상호작용하기에는 용이하지만 긴 자바스크립트 프로그램을 작성행야하는 경우에는 적합하지 않은 것이다.
<br><br>
현재 app.js와 style.css를 만들어서 브라우저에서 열어보았다.
나의 경우 아무것도 나오지 않고, 강의에서는 작성한 내용만 출력되는 것을 볼 수 있었다.
이것은 파일을 실행시키는 것이 아니라 그저 열어보고 있는 것이다.
파일을 실행시키기 위해서는 css와 자바스크립트를 가져오는 html파일이 필요하다. (html이 풀 역할을 하는 것)
브라우저에서 html파일을 열면 html파일은 css파일과 자바스크립트 파일을 가져오는 것이다.


<h3>JS 코드 작성해보기</h3>

* console.log() : 콘솔에 괄호 안 명령어를 출력주는 도구
* const: 자바스크립트 상수 선언 키워드 <br>
    const는 constant의 줄임말, constant는 상수로 값을 변경할 수 없다.
* let: 자바스크립트에서 변수 선언 키워드
* var: 변수 선언 키워드

```javascript
const a = 5;
const b = 2;
let myName = "easy1"; //create variable

console.log(a + b);
console.log(a * b);
console.log(a / b);
console.log("hello " + myName);

myName= "Lee Jiwon"; //update variable

console.log("Hello! My name is " + myName);

```

기본적으로 const를 사용하고 업데이트가 피룡한 경우에만 let을 사용할 것이다.


사실 자바스크립트는 업데이트가 될 수 없다.
보완을 한다면 패치된다라고 하는 것이 맞는 표현일 것이다.
업데이트라는 것은 오래된 버전을 더 이상 사용하지않고 새로운 버전을 사용한다는 것인데 오래된 버전을 사용하는 수많은 웹사이트에게 그 버전을 사용할 수 없다고 이야기할 수 없기 때문이다. 

**Boolean**

자바스크립트에는 true, false, null 이외에도 undefined라는 타입도 있다.
<br>

<h3>Arrays and Objects</h3>

**Arrays**

Array를 사용하면 효율적으로 코드를 작성할 수 있다.
Array의 목적은 하나의 변수안에 데이터의 list를 가지는 것이다.

```javascript
const daysOfWeek = ["mon", "tue", "wed", "thu", "fri", "sat"];

//Get Item from Array
console.log(daysOfWeek[4]);

//Add one more day to the array
daysOfWeek.push("sun");

console.log(daysOfWeek)
```

```javascript
const toBuy = ["potato", "tomato", "pizza"];

toBuy.push("kimbap");

console.log(toBuy[2]);
```

**Ojects**

만약 게임을 만들고 있다고 생각해보자.
그럼 우리는 캐릭터를 만들어야할 것이다.
그렇다면 

```javascript
const playerName = "Jiwon";
const playerLevel = 1;
const playerPretty = false;
const playerFat = "littel bit";
```

이라고 특성을 선언하는 것보다 한 개의 개체(entity)에 대해 설명하고 있음을 알고있으니 

```javascript
player.name
player.level
player.handsome
```

의 형태로 구현하는 것이 훨씬 나을 것이다.
<br><br>
정돈된 형태를 구현하는 방법으로 배열을 생각해볼수도 있겠지만 object 즉 객체 형태로 구현하는 것이 더 효과적일때도 있다.

```javascript
const player = {
    name: "Jiwon",
    level: 1,
    fat: true,
};

console.log(player);
console.log(player.name);
console.log(player["name"]);
```

객체와 리스트의 다른 점은, 리스트의 경우 모든 값이 같은 의미를 가진다는 특징이 있다.
예를 들어 아까 구현했던 요일 리스트의 경우 저장된 내용이 모두 요일을 나타냈다.
그러나 객체의 경우 모든 같은 의미를 가지지 않는다.

```javascript
const player = {
    name: "Jiwon",
    level: 1,
    fat: true,
};

console.log(player);

player.fat = false;

consloe.log(player.fat)
```

을 실행 후 출력결과를 확인한다면 player.fat 결과가 false로 바뀐 것을 볼 수 있을 것이다.
하지만 앞에서 constant는 수정을 할 수 없다고 배웠다.
그러나 지금 수정한 것은 object안의 무언가를 바꾼 것이기 때문에 충분히 수정이 가능하다.
player라는 객체 자치를 바꾸려고 할 때는 에러가 발생할 것이다.
이 객체는 constant이기 때문이다.
<br><br>
만약 객체 안에 무엇인가를 추가하고 싶다면

```javascript
const player = {
    name: "Jiwon",
    level: 1,
    fat: true,
};

console.log(player);

player.lastName = "potato";
player.level = player.level + 21;
console.log(player);
```

다음과 같이 작성해주기만 하면 된다.
<br>

<h3>Functions</h3>
함수는 내가 계속 반복해서 사용할 수 있는 코드 조각이다.
함수는 어떤 코드들 캡슐화해서 여러번 사용할 수 있게 해준다.

```javascript 
function sayHello() {
    console.log("Hello! My nmae is");
}

sayHello();
```

Hello! My name is 이름. 라는 구문을 반복해서 이름을 바꿔가면 출력하고 싶다고 하자.
그러기 위해서는 argument(인수)를 보내야한다.
여기서는 다음과 같이 작성하여 이름과 관련된 정보를 보내야할 것이다.

```javascript 
function sayHello() {
    console.log("Hello! My nmae is");
}

sayHello("Jiwon");
sayHello("Leezie")
```

함수에서 데이터를 받는 방법은 ()에 데이터를 추가하는 것이다.
위 예시에세는 sayHello()의 괄호 안에 적어주면 된다.

```javascript 
function sayHello(nameOfPerson, age) {
    console.log("Hello! My name is " + nameOfPerson + "and I'm " + age);
}

player.sayHello("Jiwon", 22);
player.sayHello("Leezie", 20)
```

인수를 이용해 정보를 외부에서 함수안으로 받아올 수 있다는 것을 기억해야한다.