package classnInstance.selfStudyCode;

class Korean{
    String nation = "대한민국";
    String name;
    String ssn;

    Korean(String name, String ssn) {
        this.name = name;
        this.ssn = ssn;
    }
}
public class KoreanExample {
    public static void main(String[] args) {
        Korean k1 = new Korean("이지원", "031025-1234567");
        System.out.println("k1 정보");
        System.out.println("국가: " + k1.nation);
        System.out.println("이름: " + k1.name);
        System.out.println("주민등록번호: " + k1.ssn);

        Korean k2 = new Korean("김은결", "030612-1234567");
        System.out.println("k2 정보");
        System.out.println("국가: " + k2.nation);
        System.out.println("이름: " + k2.name);
        System.out.println("주민등록번호: " + k2.ssn);
    }

}
