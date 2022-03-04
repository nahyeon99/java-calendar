package playground;

public class Calendar {
    private static int[] MAX_DAYS = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private static int[] LEAP_MAX_DAYS = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public boolean isLeapYear(int year) {
        if(year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) { // 윤년
            return true;
        }
        return false;
    }

    public int getMaxDaysOfMonth(int year, int month) {
        if(isLeapYear(year)) { // 윤년일경우
            return LEAP_MAX_DAYS[month];
        } else { // 평년일경우
            return MAX_DAYS[month];
        }
    }

    public void printCalendar(int year, int month) {
        System.out.printf(" << %4d년 %3d월 >>\n",year, month);
        System.out.println(" SU MO TU WE TH FR SA");
        System.out.println("---------------------");

        // get weekday automatically
        int weekday = getWeekday(year, month, 1);


        for(int i = 1; i<weekday; i++) {
            System.out.print("   ");
        }
        int maxDay = getMaxDaysOfMonth(year, month);
        int count = 7-weekday;
        int delim = (count < 7) ? count : 0;

        // print first line
        for(int i = 1; i<=count; i++) {
            System.out.printf("%3d", i);
        }
        System.out.println();

        // print from second line to last
        count++;
        for(int i = count; i<=maxDay; i++) {
            System.out.printf("%3d", i);
            if(i % 7 == delim)
                System.out.println();
        }
        System.out.println();
        System.out.println();
    }

    private int getWeekday(int year, int month, int day) {
        // 1970년 1월 1일 목요일 기준
        int syear = 1970;
        final int STANDARD_WEEKDAY = 4; // 1970/Jan/1st = Thursday

        int count = 0; // 1년의 총 일수

        for(int i = syear; i < year; i++) {
            int delta = isLeapYear(i) ? 366 : 365;
            count += delta;
        }

        for(int i = 1; i < month; i++) {
            int delta = getMaxDaysOfMonth(year, i);
            count += delta;
        }

        count += day - 1;

        // 요일 판단
        int weekday = (count + STANDARD_WEEKDAY) % 7;
        return weekday;
    }
    //simple test code here
    public static void main(String[] args) {
        Calendar cal = new Calendar();
        // 해마다 요일이 하나씩 바뀌게 되고(+1), 윤년이 끼면 +1+1
        System.out.println(cal.getWeekday(1970,1,1)); // 3
        System.out.println(cal.getWeekday(1971,1,1)); // 4
        System.out.println(cal.getWeekday(1972,1,1)); // 5
        System.out.println(cal.getWeekday(1973,1,1)); // 0
        System.out.println(cal.getWeekday(1974,1,1)); // 1
    }
}