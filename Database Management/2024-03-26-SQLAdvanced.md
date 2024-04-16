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

![image](https://github.com/orieasy1/24-1-Programming-Study/assets/129071350/761170b1-3786-43d1-8d79-d5437a884a36)


**Practice 8**

1. Display the FIRST_NAME , LAST_NAME, CITY, STATE and PACK_ID for all customers whose internet SPEED is “5Mbps” (Customers and Packages table).
```SQL
SELECT c.FIRST_NAME, c.LAST_NAME, c.CITY, c.STATE, c.PACK_ID
FROM ACDB_CUSTOMERS c
JOIN ACDB_PACKAGES p ON c.PACK_ID = p.PACK_ID
WHERE p.SPEED = '5Mbps';
```
2. Display the FIRST_NAME, MONTHLY_DISCOUNT, PACK_ID, MAIN_PHONE_NUM and SECONDARY_PHONE_NUM for all customers whose SECTOR_ID is Business (Customers, Packages and Sectors tables).
```SQL
SELECT c.FIRST_NAME, c.MONTHLY_DISCOUNT, c.PACK_ID, c.MAIN_PHONE_NUM, c.SECONDARY_PHONE_NUM
FROM ACDB_CUSTOMERS c
JOIN ACDB_PACKAGES p ON c.PACK_ID = p.PACK_ID
JOIN ACDB_SECTORS s ON p.SECTOR_ID = s.SECTOR_ID
WHERE s.SECTOR_NAME = 'Business';
```
3. Display the PACK_ID, internet SPEED, and MONTHLY_PAYMENT for all packages whose MONTHLY_PAYMENT is greater than the maximum MONTHLY_PAYMENT of packages with internet speed equals to “5Mbps”
(Packages table).
 * You can use ALL operator
```SQL
SELECT PACK_ID, SPEED, MONTHLY_PAYMENT
FROM ACDB_PACKAGES
WHERE MONTHLY_PAYMENT > ALL (
    SELECT MONTHLY_PAYMENT
    FROM ACDB_PACKAGES
    WHERE SPEED = '5Mbps'
);
```
4. Display the PACK_ID, internet SPEED and MONTHLY_PAYMENT for all packages whose MONTHLY_PAYMENT is greater than the minimum MONTHLY_PAYMENT of packages with internet speed equals to “5Mbps”
(Packages table).
 * You can use ANY operator
```SQL
SELECT PACK_ID, SPEED, MONTHLY_PAYMENT
FROM ACDB_PACKAGES
WHERE MONTHLY_PAYMENT > ANY (
    SELECT MONTHLY_PAYMENT
    FROM ACDB_PACKAGES
    WHERE SPEED = '5Mbps'
);
```

### Aggregation Operators  집계함수

* SUM: 합
```SQL
SELECT SUM(price * quantity)
FROM Purchase
WHERE product = ‘bagel’
```
* COUNT: 데이터 개수 세기
```SQL
SELECT COUNT(*)
FROM Product
WHERE year > 1995
```
* MIN: 최솟값
```SQL
SELECT MIN(Salary) AS MinSalary
FROM Employees;
```
* MAX: 최댓값
```SQL
SELECT MAX(Age) AS MaxAge
FROM Students;
```
* AVG: 평균
```SQL
SELECT AVG(price)
FROM Product
WHERE maker = “Toyota”
```
<br>

**Practice 10**

1. Display the lowest last name and the highest last name alphabetically (Customers table).
    ```SQL
    SELECT MIN(LAST_NAME) AS LowestLastName, MAX(LAST_NAME) AS HighestLastName
    FROM ACDB_CUSTOMERS;
    ```
2. Display the total number of states (allowing redundancy) and the number of distinct states (Customers table).
    ```SQL
    SELECT COUNT(STATE) AS TotalStates, COUNT(DISTINCT STATE) AS DistinctStates
    FROM ACDB_CUSTOMERS;
    ```
3. Display the lowest, highest, and average monthly discount (Customers table).
    ```SQL
    SELECT MIN(MONTHLY_DISCOUNT) AS MinMonthlyDiscount, MAX(MONTHLY_DISCOUNT) AS MaxMonthlyDiscount, AVG(MONTHLY_DISCOUNT) AS AvgMonthlyDiscount
    FROM ACDB_CUSTOMERS;
    ```
4. Display the names of customers whose monthly discounts are larger than the average monthly discount (Customer table).
    ```SQL
    SELECT FIRST_NAME, LAST_NAME
    FROM ACDB_CUSTOMERS
    WHERE MONTHLY_DISCOUNT > (SELECT AVG(MONTHLY_DISCOUNT) FROM ACDB_CUSTOMERS);
    ```
<br>

### GROUP BY

데이터를 검색할 때 공통 그룹의 정보를 확인해야할 때가 있다.
그리고 그룹의 특정조거능ㄹ 필터링해 해당 그룹의 데이터만 검색해야하는 경우도 많다.
이렇게 데이터를 그룹화할 때 GROUP BY문을 사용한다.
또한 그룹을 필터링할 때는 HAVING 문을 사용한다.

GROUP BY문은 집계 함수와 함께 사용되는 경우가 많다.
집계함수를 사용해 그룹 내값에 대한 요약 통계를 계산하는데 유용하기 때문이다.

예를 들어, 주문 데이터에서 특정 제품을 주문한 고객 그룹 중에서 총 주문 금액이 1000 이상인 그룹을 찾는다면

```SQL
SELECT customer_id, SUM(order_amount) AS total_order_amount
FROM orders
GROUP BY customer_id
HAVING SUM(order_amount) >= 1000;
```

이렇게 쿼리를 작성해줄 수 있을 것이다.

전체 작동과정을 정리해보자면
1. from과 where을 통한 필터링
2. 필터링 후 Group by로 그룹화
3. select 에서 그룹화된 결과물 출력 및 aggregation 수행<br>
    if we use GROUP BY clause to make groups then reslut will be formed in the group, not individual tuples.


**Practice 7**

1. Display the state and the number of customers for each state in the descending order by the number of customers (Customers table).
```SQL
SELECT State, COUNT(*) AS NumCustomers
FROM Customers
GROUP BY State
ORDER BY NumCustomers DESC;
```
2. For each internet package (Customers table)
    A. Display the package number and the number of customers for each package number.
    ```SQL
    SELECT PackageNumber, COUNT(*) AS NumCustomers
    FROM Customers
    GROUP BY PackageNumber;
    ```
    B. Modify the query to display the package number and number of customers for each package number, only for the customers whose monthly discount is greater than 20.
    ```SQL
    SELECT PackageNumber, COUNT(*) AS NumCustomers
    FROM Customers
    WHERE MonthlyDiscount > 20
    GROUP BY PackageNumber;
    ```



**추가: 헷갈리는 비교연산자 정리**

1. 등호 (=): 두 값이 같은지 확인
2. 부등호 (<, >): 왼쪽 값이 오른쪽 값보다 작거나 큰지 확인
3. 작거나 같음 (<=): 왼쪽 값이 오른쪽 값보다 작거나 같은지 확인
4. 크거나 같음 (>=): 왼쪽 값이 오른쪽 값보다 크거나 같은지 확인
5. 부정 등호 (!= 또는 <>): 두 값이 다른지 확인

<br>

**추가: 헷갈리는 논리 연산자 정리**

1. ALL: 모든 비교 집합이 참이면 TRUE
2. AND: 두 조건이 모든 참이면 TRUE
3. ANY: 비교 집하중 하난라도 참이면 TRUE
4. BETWEEN: 피연사자가 번위내에 있으면 TRUE
5. EXISTS: 하위 쿼리에 행이 포함되면 TRUE
6. IN: 피연산자가 리스트 중 하나라도 포함되면 TRUE
7. LIKE: 피연산자가 패턴과 일치하면 TRUE
8. NOT: 조건 부정, 참거짓 반대로
9. OR: 하나의 조건식이 참이면 TRUE
10. SOME: 비교집합 중 리부가 참이면 TRUE
