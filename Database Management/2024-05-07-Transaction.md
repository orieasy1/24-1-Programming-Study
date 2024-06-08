# DB Management 11주차

## Transaction

트랜잭션은 데이터베이스에서 하나의 논리적 기능(데이터베이스 상태를 변화)을 수행하기 위한 작업의 단위를 말한다.

데이터베이스에 접근하는 방법은 쿼리이므로, 즉 여러 개의 쿼리들을 하나로 묶는 단위를 말한다.

데이터베이스의 상태를 변화시킨다는 것은 SELECT, INSERT, DELETE, UPDATE 등등의 SQL을 이용해서 데이터베이스에 접근하는 것을 의미한다. 

단, 앞서 말한 것 처럼 각각의 구문이 아니라 하나의 작업을 위해 더이상 분할될 수 없는 명령들의 모음, 한꺼번에 수행되어야할 일련의 연산모음을 의미한다.

<br>

트랜잭션의 특징은 ACID인데 각각 원자성(Atomic), 지속성(Consistent), 독립성(Isolated), 지속성(Durable)이 있다.

Atomic: State shows either all effects of transaction, or none of them. (All of nothing)
Consistant: Transaction moves from a state where integrity holds, to another where integrity holds.
Isolated: Effect of transactions is the same as transactions is the same ase transactions running one after another. (looks like batch mode)
Durable: Once a transaction has committed, its effects remain in the database. (Persist after the TNX)

<br>

ACID: Atomicity 원자성
원자성은 트랜잭션과 관련된 일이 모두 수행되었거나 되지 않았거나를 보장하는 특징이다.

예를 들어 트랜잭션을 커밋했는데 문제가 발생하여 롤백하는 경우 그 이후에 모두 수행되지 않음을 보장하는 것을 말한다.

커밋: 여러 쿼리(트랜잭션)가 성공적으로 처리되었다고 확정하는 명령어
롤백: 트랜잭션으로 처리한 하나의 묶음 과정을 일어나기 전으로 돌리는 일


예를 들어 100만원을 가진 지원이가 0원을 가진 가현이에게 50만원을 이체한다고 할 때 다음과 같은 operation 단위들로 이루어진 과정을 거칠 것이다.

지원이의 잔고를 조회한다.
지원이에게서 50만원을 뺀다.
가현이에게 50만원을 넣는다.
위 operation이 모두 실행되면 즉 트랜잭션이 성공적으로 이루어지면 지원이 통장에 50만원, 가현이 통장에 50만원이 들어있을 것이다.

만약에 작업을 취소한다고 하면 일부 operation에만 적용되는 것이 아닌 모든 operation에 적용되여 지원이가 100만원, 가현이가 0원을 들고 있는 상황이 되어야한다.

그래서 all or nothing인것이다. 관련 operation이 모두 수행되거나 수행되지 않거나를 보장하는 것이다.



트랜잭션 단위로 여러 로직들을 묶을 때 외부API를 호출하는 것이 있으면 안된다.

만약 있다면 롤백이 일어났을 때 어떻게 처리할 것인지에 대한 해결 방법이 있어야하고 트랜잭션 전파를 신경써서 관리해야한다.

#### DBMS 및 컴퓨터 모델

DBMS가 어떻게 메모리와 디스크를 사용하여 데이터를 저장하고 관리하는지에 대한 모델을 설명

* 공유 메모리: 여러 프로세스가 메인 메모리에서 데이터를 읽고 쓸 수 있습니다.
* 디스크: 전역 메모리는 디스크에서 데이터를 읽어오거나 디스크에 데이터를 쓰는 작업을 할 수 있습니다.
* 로그: 로그는 메인 메모리와 디스크 모두에 걸쳐 저장되는 안정된 디스크 스토리지이다.

<br>
공유메모리는 주로 RAM(Random Access Memory)를 의미한다.
다수의 프로세스나 스레드가 동시에 액세스할 수 있는 메모리 영역이다.
DBMS에서는 이 공유 메모리르 사용하여 다수의 트랜잭션이 동시에 데이터를 읽고 쓸 수 있도록 한다.
빠른 데이터 액세스를 제공하므로 DBMS 성능 향상에 기여하지만 여러 트랜젝션인 동시에 액세스할 때 데이터의 일관성과 동시성을 관리해야하는 복잡성이 존재한다.
<br>

디스크는 데이터를 영구적으로 저장하는 장치로 하드디스크 드라이브와 같은 형태를 가질 수 있다.
디스크는 주 메모리(RAM)에 비해 느리지만 전원이 꺼져도 데이터가 유지된다는 장점이 있따.
Flush in to Disk는 메인 메모리에있는 데이터를 디스크에 영구적으로 기록하는 작업을 말한다.
이 과정은 데이터의 내구성을 보장하기 위해 중요하다.
<br>

로그는 DBMS에서 매우 중요한 역할을 하는 안정적인 디스크 스토리지이다.
로그는 트랜잭션이 수행하는 모든 작업의 순서대로 기록된 시퀀스이다.
이 로그를 사용하여 시스템에 장애가 발생했을 때 데이터를 복구할 수 있다.
예를 들어 시스템이 비정상으로 종료되었을 때 로그에 기록된 정보를 사용하여 마지막 일관된 상태로 데이터를 복구할 수 있다.
로그는 메인 메모리와 디스크에 걸쳐있으며 트랜젝션이 디스크에 영구적으로 기록되기 전에 먼저로그에 기록된다.


A transaction(TXN이라고 표현하기도 함) is a sequence of one or more operations which reflects a single real-world transition.

트랜젝션은 데이터베이스에서 하나의 논리적 기능(데이터 베이스 상태 변화)를 수행하기 위한 작업의 단위를 말한다.
데이터베이스에 접근하는 방법은 쿼리이므로 즉 여러개의 쿼리들을 하나로 묶는 단위를 말한다.

in the real world a TXN either happend completely or not at all.

```SQL
START TRANSACTION
    UPDATE Product
    SET Price = Price - 1.99
    WHERE pname = 'Gizmo'
COMMIT;
```

<br>

#### Transaction in SQL

* In ad-hoc(임시적) SQL: 기본적으로 각 문이 하나의 트랜젝션으로 처리됨
* 프로그램 내에서 여러 개의 구문을 트랜젝션으로 그룹화할 수 있다.

```SQL
START TRANSACTION
    UPDATE Bank SET amount = amount - 100
    WHERE name = 'Bob'

    UPDATE Bank SET amount = amount + 100
    WHERE name = 'Joe'
COMMIT;
```

<br>

#### Motivation of Transaction

1. Recovery & Durability

Keeping the DBMS data consistent and durable in the face of crashes, aborts, system shutdowns, etc.

시스템 충돌, 중단, 시스템 종료 등에도 불구하고 데이터베이스 관리 시스템 데이터를 일관되고 지속 가능하게 유지한다.
이를 위해 모든 거래가 완전히 저장되거나 전혀 저장되지 아도록 보장하며, 트랜젝션을 되돌릴 수 잇는 로그를 유지한다.

2. Currency

Achieving better performance by parallelizing TXNs without creating anomalies.

트랜젝션을 병렬화하여 성능을 향상 시키면서도 이상 현상 없이 사용자가 거래를 마치 독립적으로 실행하는 것처럼 할 수 있도록 한다.
트랜젝션 시작부터 commit 또는 rollback까지의 구문을 사용하여 시스템이 충돌하거나 중단되더라도 데이터의 일관성과 안정성을 보장한다.
<br><br>
동시성의 중요성

사용자 프로그램의 동시 실행은 좋은 DBMS 성능을 위해 필수적이다.
디스크 접근이 빈번하고 느릴 수 있으므로 처리량을 최적화하고 지연 시간을 줄이기 위해 여러 사용자의 트랜젝션을 동시에 처리할 수 있어야한다.


### Write-Ahead Logging TXN Commit Protocol

WAL 커밋 프로토콜 과정
로그먼저 기록 트랜 잭션이 데이터를 변경하려고 할 때 먼저 변경 사항을 로그에 기록, 이 로그는 메인 메모리에서 디스크로 기록

데이터 기록: 로그가 성공적으로 디스크에 기록된 후에, 실제 데이터 페이지의 변경사항을 디스크에 기록한다.

커밋: 모든 관련 로그 레코드가 디스크에 기록되면, 트랜잭션은 커밋됩니다. 이 시점에서, 트랜잭션은 내구성을 가지며 시스템이 충돌해도 보호됩니다.