# Database Management Week5

## SQL: Nested Queries, Group By, Having

### Nested Queries

To find intermediate rsult for the give conditions and then apply another ondtion into the intermediate result, we use nested queires.
중첩 쿼리는 DB에서 복잡한 조건을 처리하고 추출하기 위해 사용된다.
쿼리 안에 포함되는 또 다른 쿼리를 서브 쿼리(subquery)라고 부르며, 서브 쿼리를 포함하고 있는 쿼리는 외부 쿼리라고 부른다.
<br>

**서브쿼리의 특징**

* 반드시 소괄호로 감싸 사용한다.
* 주쿼리를 실행하기 전에 1번만 실행된다.
* 비교 연산자에 서브 쿼리를 사용하는 경우느 서브 쿼리르 오른쪽에 기술해야한다.
* 내부에는 정렬 구문인 ORDER BY문을 사용할 수 없다.
<br>

**서브쿼리가 사용 가능한 곳**

1. SELECT 절
2. FROM 절
3. WHERE 절
4. HAVING 절
5. ORDER BY 절
6. INSERT 문의 VALUES 절
7. UPDATE 문의 SET 절

**서브쿼리의 분류**

1. 단일 행 서브쿼리

* 서브쿼리의 결과가 1행만 반환되는 쿼리
* WHERE절에 사용하는 단일행 서브쿼리의 기본 형식
    ```SQL
    SELECT 열이름
    FROM 테이블명
    WHERE 열 = (
        SELECT 열
        FROM 테이블
        WHERE 검색조건
    );
    ```

2. 다중 행 서브 쿼리

서브 쿼리의 결과가 2건 이상 반환될 수 잇다면 반드시 다중행 비교연산자(IN, ALL, ANY, EXIST)과 함께 사용해야한다.

* IN: 서브쿼리의 결과에 존재하는 임의의 값과 동일한 조건 의미
    * 기본형식
        ```SQL
        SELECT 열
        FROM 테이블명
        WHERE 열 IN (
            SELECT 열
            FROM 테이블
            WHERE 검색조건
        );
        ```
    * 예시 분석
        ```SQL
        SELECT c.city
        FROM Company c
        WHERE c.name IN (
            SELECT pr.maker
            FROM Purchase p
            JOIN Product pr ON p.product = pr.name
            WHERE p.buyer = 'Joe Blow'
        );
        ```
        * 서브쿼리: Purcahse 테이블과 Product 테이블을 조인하는데 p.product열과 pr.name열이 일치하는 행들만 선택, 구매자가 Joe Blow인 행을 선택, maker열만 반환
        (결과: Joe Blow'가 구매한 제품의 제조사인 'maker' 값들만을 반환)
        * 메인쿼리: company 테이블 선택, 서브쿼리에서 도출된 maker 값에 해당하는 이름 선택, city열만 반환
            (결과:  Joe Blow'가 구매한 제품의 제조사인 'maker'의 회사가 위치한 도시를 반환)

* ALL: 서브쿼리의 결과에 존재하는 모든 값을 만족하는 조건
    * 기본형식
        ```SQL
        SELECT 열
        FROM 테이블
        WHERE 열 비교연산자 ALL (
            SELECT 열
            FROM 테이블
            WHERE 검색조건
        );
        ```
        * 서브쿼리의 모든 결과와 메이쿼리의 비교조건 간의 관계를 명확하게 정의하기 위해 비교연산자를 사용한다.
            * > ALL: 서브쿼리 조건보다 큰 값 모두 반환
            * < ALL: 서브쿼리 조건보다 작은 값 모두 반환
            * = ALL: 서브쿼리 조건과 같은 값 모두 반환
    * 예시 분석
        ```SQL
        SELECT name
        FROM Product
        WHERE price > ALL(
            SELECT price
            FROM Product
            WHERE maker = ‘Gizmo-Works’
        );
        ```
        * 서브쿼리: Product 테이블 선택, maker가 Gizmo-Work인 제품들 선택, price열만 반환
        * 메인쿼리: product 테이블 선택, 서브쿼리에서 선택된 모든 price값보다 큰 행 선택, name열 반환

* ANY(SOME): 서브쿼리의 결과에 존재하는 어느 하나의 값이라도 만족하는 조건
    * 기본형식: ALL과 유사
        ```SQL
        SELECT 열
        FROM 테이블
        WHERE 열 비교연산자 ANY (
            SELECT 열
            FROM 테이블
            WHERE 검색조건
        );
        ```
        * 서브쿼리의 모든 결과와 메이쿼리의 비교조건 간의 관계를 명확하게 정의하기 위해 비교연산자를 사용한다.
        * ALL과 다르게 서브쿼리의 값 중 가장 작은 값보다 커도 참이 된다. (ALL은 모든 값보다 커야함)

* EXISTS: 서브쿼리의 결과를 만족하는 값이 존재하는지 여부를 확인하는 조건
    * 기본형식
        ```SQL
        SELECT 열
        FROM 테이블1
        WHERE EXISTS (
            SELECT *
            FROM 테이블2
            WHERE 테이블1.columnX = 테이블2.columnY
        );
        ```
        * 테이블 1에서 테이블 2와 관계된 행이 잇는지 확인하는 것
    * 예시분석
        ```SQL
        SELECT p1.name
        FROM Product p1
        WHERE p1.maker = ‘Gizmo-Works’ AND EXISTS(
            SELECT p2.name
            FROM Product p2
            WHERE p2.maker <> ‘Gizmo-Works’
                AND p1.name = p2.name
        );
        ```
        * 서브쿼리: PRODUCT 테이블 선택, ‘Gizmo-Works’를 제외한 다른 제조사 그리고 메인 쿼리에서 서택된 제품과 동일한 이름을 가진 제품 선택, 이름 열 반환
        * 메인쿼리: PRODCUT 테이블에서 제조사가 ‘Gizmo-Works’인 것들 선택 서브쿼리에서 반환된 이름들과 똑같은 행 선택, 이름 열 반환
    * NOT EXISTS: EXISTS와 반대로 작동, 위예시는 서브쿼리에서 반환되는 이름들과 다른 행의 이름을 반환할 것.
<br>

**Nested queries as alternatives to INTERSECT and MINUS**

