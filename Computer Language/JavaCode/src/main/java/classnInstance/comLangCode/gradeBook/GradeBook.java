package classnInstance.comLangCode.gradeBook;

public class GradeBook {
    private String courseName;
    private int[] grades;

    public GradeBook(String courseName, int[] grades) {
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
        System.out.printf("%nClass average is %.2f%n", getAverage());

        System.out.printf("Lowest grade is %d%nHighest grade is %d%n%n",
                getLowestGrade(), getHighestGrade());
        outputBarChart();
    }


    //grades
    public void outputGrades() {
        System.out.println("The grades are: ");

        for(int i = 0; i < grades.length; i++){
            System.out.printf("Student %2d: %3d%n", i+1, grades[i]);
        }
    }

    //class average
    public double getAverage(){
        double total = 0;

        for(int i = 0; i < grades.length; i++) {
            total += grades[i];
        }

        return total / grades.length;
    }

    //lowest grade
    public int getLowestGrade() {
        int lowGrade = grades[0];

        for(int grade: grades) {
            if(lowGrade > grade) {
                lowGrade = grade;
            }
        }

        return lowGrade;
    }

    //highest grade
    public int getHighestGrade() {
        int highGrade = grades[0];

        for(int grade: grades) {
            if(highGrade < grade) {
                highGrade = grade;
            }
        }

        return highGrade;
    }

    //grade distribution bar chart
    public void outputBarChart() {
        System.out.println("Grade distribution:");

        int[] frequency = new int[11];
        for(int grade: grades){
            frequency[grade/10]++;
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
