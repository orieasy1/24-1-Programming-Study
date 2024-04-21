package classnInstance.selfStudyCode.car.carConstructor;

public class CarExample {
    public static void main(String[] args) {
        //클래스에 개발자가 선언한 생성자가 있다면 컴파일러는 기본 생성자를 추가하지 않는다.
        //개발자가 선언한 생성자에 맞추어 매개변수를 작성해줘야한다.
        //또한 기본 생성자는 호출할 수 없다.
        Car myCar = new Car("Grandeur", "black", 250);
    }
}
