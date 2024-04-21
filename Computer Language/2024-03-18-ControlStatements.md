# Computer Language Week4

## Control Statements I

제어문은 말 그대로 프로그램의 흐름을 제어하는데 사용되는 문이다.
프로그램이 특정 조건에 따라 다른 동작을 사용하도록 하거나 반복적으로 일련의 동작을 수행하도록 하는데 사용된다.

### Control Structures 제어 구조

1. Sequential execution
2. Transfer of

성적 1차

```java
package controlStatements.iteration;

import java.util.Scanner;

public class WhileEx02 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int grade = 0;
        double total= 0.0;
        double avg = 0.0;

        while(grade < 10) {
            System.out.println("Input your grade. Grade should be in the range 0 to 100.");
            double score = scanner.nextDouble();
            total += score;
            grade++;
        }
        
        avg = total / 10;
        System.out.println("The class average: " + avg);
        
    }
}
```