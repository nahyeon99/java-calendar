package practice;

public class Calendar {
    int[] MAX_DAYS = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}; // 평년
    int[] LEAP_MAX_DAYS = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}; // 윤년

    private boolean isLeapYear(int year) {
        if(year % 4 == 0 && (year % 100 != 0 || year % 400 == 0 )) { // 윤년
            return true;
        } else {
            return false;
        }
    }

    public int getMaxDaysOfMonth(int year, int month) {
        if(isLeapYear(year)) { // 윤년이면,
            return LEAP_MAX_DAYS[month-1];
        } else { // 평년이면,
            return MAX_DAYS[month-1];
        }
    }

    public void printCalendar(int year, int month) {
        System.out.printf(" << %d년  %d월 >>\n", year, month);
        System.out.println(" SU MO TU WE TH FR SA");

        int endDay = getMaxDaysOfMonth(year, month);

        for(int i = 1; i<= endDay; i++) {
            System.out.printf("%3d", i);
            if(i % 7 == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }
}
