package classnObject.comelangcode.gradeBook2;

public class GradeBook {
    private String courseName;
    private int[][] grades;

    public GradeBook(String courseName, int[][] grades) {
        this.courseName = courseName;
        this.grades = grades;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseName() {
        return courseName;
    }


    public void processGrades() {
        outputGrades();

        System.out.printf("Lowest grade is %d%nHighest grade is %d%n%n",
                getLowestGrade(), getHighestGrade());
        outputBarChart();
    }

    public void outputGrades() {
        System.out.printf("The grades are:%n%n");
        System.out.print("            ");

        for(int i = 0; i < grades[0].length; i++){
            System.out.printf("%5s%d  ", "Test", i + 1);
        }
        System.out.printf("%9s%n", "Average");

        for(int student = 0; student < grades.length; student++) {
            System.out.printf("Student %2d", student + 1);

            for (int test : grades[student]) {
                System.out.printf("%8d", test);
            }

            double average = getAverage(grades[student]);
            System.out.printf("%10.2f%n", average);
        }
    }

    public double getAverage(int[] gradesOfStudents) {
        double total = 0.0;

        for (int grade: gradesOfStudents) {
            total += grade;
        }

        return total / gradesOfStudents.length;
    }

    public int getLowestGrade() {
        int lowGrade = grades[0][0];

        for (int[] studentGrades : grades) {
            for (int grade : studentGrades) {
                if (grade < lowGrade){
                    lowGrade = grade;
                }
            }
        }

        return lowGrade;
    }

    public int getHighestGrade() {
        int highGrade = grades[0][0];

        for(int[] studentGrades : grades) {
            for(int grade : studentGrades) {
                if(grade > highGrade){
                    highGrade = grade;
                }
            }
        }

        return highGrade;
    }

    public void outputBarChart() {
        System.out.println("Overall grade distribution:");

        int[] frequency = new int[11];

        for(int[] studentGrades : grades) {
            for(int grade : studentGrades){
                frequency[grade / 10]++;
            }
        }

        for(int i = 0; i < frequency.length; i++) {
            if (i == 10) {
                System.out.printf("%5d: ", 100);
            }
            else {
                System.out.printf("%02d-%02d: ", i * 10, i * 10 + 9);
            }

            for(int j = 0; j < frequency[i]; j++) {
                System.out.print("*");
            }

            System.out.println();
        }
    }
}
