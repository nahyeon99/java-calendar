package practice;

public class Calendar {
    int[] MAX_DAYS = {0,31,28,31,30,31,30,31,31,30,31,30,31};
    int[] LEAP_MAX_DAYS = {0,31,29,31,30,31,30,31,31,30,31,30,31};

    // 해당 년도가 윤년인지 평년인지 확인하는 메소드
    private boolean isLeapYear(int year) {
        if(year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
            return true;
        } else {
            return false;
        }
    }

    // 해당 월의 maxDay 리턴해주는 메소드
    private int getMaxDay(int year, int month) {
        if(isLeapYear(year)) {
            return LEAP_MAX_DAYS[month];
        } else {
            return MAX_DAYS[month];
        }
    }

    public void printCalendar(int year, int month) {
        System.out.printf(" << %4d년 %3d월 >> \n", year, month);
        System.out.println(" SU MO TU WE TH FR SA");
        System.out.println("---------------------");

        // 요일 check
        // 일:0, 월:1, 화:2, 수:3, 목:4, 금:5, 토:6
        int weekday = getWeekday(year, month, 1);

        int cnt = 0;
        for(int i = 0; i<weekday; i++) {
            System.out.print("   ");
            cnt += 1;
        }
        int maxDay = getMaxDay(year, month);

        for(int i = 1; i<=maxDay; i++) {
            System.out.printf("%3d", i);
            if((i+cnt) % 7 == 0) System.out.println();
        }
        System.out.println();

    }
    private int getWeekday(int year, int month, int day) {
        int sYear = 1970;
        final int STANDARD_WEEKDAY = 4; // 1970/1/1 목요일:4 기준

        int cnt = 0;

        // year 차이만큼 더하기
        for(int i = sYear; i<year; i++) {
            // 윤년이면 cnt += 366, 평년이면 cnt += 365
            int delta = isLeapYear(i) ? 366 : 365;
            cnt += delta;
        }

        // month 차이만큼 더하기
        for(int i = 1; i<month; i++) {
            cnt += getMaxDay(year, i);
        }
        cnt += day - 1;

        // 요일 판단
        int weekday = (cnt + STANDARD_WEEKDAY) % 7;
        return weekday;
    }
}