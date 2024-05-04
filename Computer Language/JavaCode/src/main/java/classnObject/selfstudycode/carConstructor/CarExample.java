package classnObject.selfstudycode.carConstructor;

public class CarExample {
    public static void main(String[] args) {
        // Car 객체 생성
        Car myCar = new Car("Grandeur", "black", 250, 60);
        //Car myCAr = new Car();    기본 생성자는 호출할 수 없다.

        // Car 객체 필드값 출력
        System.out.println("제작회사: " + myCar.company);
        System.out.println("모델명: " + myCar.model);
        System.out.println("색깔: " + myCar.color);
        System.out.println("최고속도: " + myCar.maxSpeed);
        System.out.println("현재속도: " + myCar.speed);

        // Car 객체의 필드값 변경
        myCar.speed = 80;
        System.out.println("수정된 속도: " + myCar.speed);
    }
}
