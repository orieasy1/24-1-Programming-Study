package classnObject2.enumType.selfstudycode;

import java.util.Calendar;

public class WeekExample {
    public static void main(String[] args) {
        Week today = null;

        Calendar cal = Calendar.getInstance();
        int week = cal.get(Calendar.DAY_OF_WEEK);

        switch(week) {
            case 1: today = Week.MONDAY;    break;
            case 2: today = Week.TUESDAY;   break;
            case 3: today = Week.WENSDAY;   break;
            case 4: today = Week.THURSDAY;  break;
            case 5: today = Week.FRIDAY;    break;
            case 6: today = Week.SATURDAY;  break;
        }

        if(today == Week.SUNDAY) {
            System.out.println("일요일에는 예쁜 카페를 갑니다.");
        }else {
            System.out.println("학교 도서관에 가서 공부를 합니다.");
        }
    }
}
