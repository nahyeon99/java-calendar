package practice;

public class Calendar {
    private static int[] MAX_DAY = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private static int[] LEAP_MAX_DAY = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    // 윤년,평년 체크하는 메소드
    private boolean isLeapYear(int year) {
        if(year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
            return true;
        } else {
            return false;
        }
    }
    // 달의 maxDay 리턴해주는 메소드
    private int getMaxDayOfMonth(int year, int month) {
        int maxDay = isLeapYear(year) ? LEAP_MAX_DAY[month] : MAX_DAY[month];
        return maxDay;
    }


    public void printCalendar(int year, int month) {
        System.out.printf(" << %4d월 %3d일 >>\n", year, month);
        System.out.println(" SU MO TU WE TH FR SA");
        System.out.println("---------------------");

        // 1일의 요일 알아내기
        int weekday = getWeekday(year, month);

        // 첫 주, 해당 요일만큼 공간 띄우기
        for(int i = 0; i<weekday; i++) {
            System.out.print("   ");
        }

        for(int i = 1; i<=getMaxDayOfMonth(year, month); i++) {
            System.out.printf("%3d", i);
            if((i+weekday) % 7 == 0) System.out.println();
        }
        System.out.println();
    }

    private int getWeekday(int year, int month) {
        int STANDARD_WEEKDAY = 4; // 1970/1/1 목 기준

        int sYear = 1970;
        int cnt = 0;

        // 기준 날짜로부터 년도 차이만큼 day 더하기
        // 고려해야할 점: 윤년인가 평년인가
        for(int i = sYear; i < year; i++) {
            // 윤년인지 확인
            int delta = isLeapYear(i) ? 366 : 365;
            cnt += delta;
        }

        // 기준 월로부터 일자 차이만큼 day 더하기
        for(int i = 1; i<month; i++) {
            int delta = getMaxDayOfMonth(year, i);
            cnt += delta;
        }

        int weekday = (cnt+STANDARD_WEEKDAY) % 7;

        return weekday;
    }
}