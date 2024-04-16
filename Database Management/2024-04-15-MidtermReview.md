 # Midterm 정리
 
 ## 문제유형

 1) Choose the correct and incorrect answer. (6 questions, 15 points)
 2) Fill in the blanks to describe the essential concepts (7 questions, 15 points)
 3) Draw an E-R diagram considering the following requirements that describe the entities and relationships (1 Question, 20 points)
 4) Write the SQL query to satisfy each requirement. (5 questions, 25 points)
 5) Write the SQL query to satisfy each requirement.–About the View (3 questions, 15 points)
 6) Rewrite SQL query (2 questions, 10 points)



### Data Independence

DBMS가 data를 managing하는데 dominant solution이 된 important reason.

Concpet: Application do not need to worry about how the data is structed and stored.
2가지 data independence때문에 모든 DB관련 members이 독립적으로 작동함. 다른 schema를 고려할 필요가 없음

* Logical data independence: protection from changes in logical structure of data.
    * should not need to ask: can we add a new entity or attribute without rewriting the application?
* Physical data independence: protection from physical layout changes
    * should not need to ask: which disks are the data stored on? Is the data indexed?


### Challenges with Many users

Big challenge: Many users are accessing on DB at the same time.
DB의 임무: DB should make users to feel that they are using DB alone.

Problem

1. Security
2. Performance: Need to provide concurrent access(concurrent sharing)
    * Disk/SSD access is slow, DBMS hide the latency by doing more CPU work concurrently.
3. Consistency: Concurrency can lead to update problems (shared data, continuous change)
    * ensuring that the database remains in a valid state at all times even when multiple concurrent transaction are being executed

### Transaction and Atomicity

A key concept of the transaction: an atomic sequence of DB actions(reads, writes)
DB에서 하나의 노닐적인 기능을 수행하기 위한 작업의 단위

원자성: 트랜잭션과 관련된 일이 모두 수행되었거나 되지 않았거나를 보장하는 특징
Atomicity: An action either completes entirely or not at all

* DBMS ensures atomicity even if a transaction crashes.
* One way to accomplish this: Wrie-ahead logging
    * Before any action is finalized, a corresponding log entry is forced to disk.
* Key idea: Keep a log of all the writes done


### Concurrency 

locking: 여러 트랜잭션이 동시에 실행될 때 그 실행이 일련의 트랜잭션들을 연속적으로 실행한 것과 동등한 결과를 내도록 보장함

락은 트랜잭션이 데이터 항목을 읽거나 쓰기 전에 DBMS로부터 락(잠금)을 요청하고, 이 락을 획득한 후 해당 트랜잭션이 종료될 때까지 유지하는 메커니즘입니다.
트랜잭션이 특정 데이터 항목을 읽거나 쓰기를 원할 때 해당 데이터에 대한 락을 요청합니다.

Locking: before reading or writing, transaction requires a lock from DBMS, holds until the end.

A set of transactions is isloated if their effect is as if all were executed.

### The E/R Model

Database design: Agree on structure of the databse before deciding on a particular implementation.

Consider issuses such us:
* What entities to model
* how entites are related
* what constraints exist in the domain
* how to achive good designs

Entities are the individual objects which are memebers of entity sets.
Entity sets are the classes or types of objects in our model.
<br>

Relationship

There can only be one relationship for evey unique combination of entities

This also means  that the relationship is uniquely determined by the keys of its entities 


Key is a minmal set of attributes that uniquely identifies an entity



### 