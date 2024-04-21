package chap06Class.car;

class Car {
    String company;
    String model;
    String color;
    int maxSpeed;
    int speed;

    Car() {
        // 필드 초기화를 해주는 것
        this.company = "Hyundai";
        this.model = "Grandeur";
        this.color = "black";
        this.maxSpeed = 350;
        this.speed = 0; // 초기 속도는 0으로 설정
    }
}