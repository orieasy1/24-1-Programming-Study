package classnObject.comelangcode.gradeBook;

public class GradeBookTest {
    public static void main(String[] args) {
        int[] gradesArray = {87, 68, 94, 100, 83, 78, 85, 91, 76, 87};

        GradeBook myGradeBook = new GradeBook("146049 Computer Language", gradesArray);
        System.out.println("Welcome to the grade book for" + myGradeBook.getCourseName());
        System.out.println();

        myGradeBook.processGrades();
    }
}
