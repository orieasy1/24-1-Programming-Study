package classnObject.selfStudyCode.carConstructor;

public class Car {
    String company = "Hyundai";
    String model;
    String color;
    int maxSpeed;
    int speed;

    //생성자 선언
    Car(String model, String color, int maxSpeed, int speed) {
        this.model = model;
        this.color = color;
        this.maxSpeed = maxSpeed;
        this.speed = speed;
    }
}
