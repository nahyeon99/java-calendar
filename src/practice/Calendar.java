package practice;

import java.util.Date;
import java.util.HashMap;

public class Calendar {
    private static int[] MAX_DAY = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private static int[] LEAP_MAX_DAY = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    private HashMap<Date, PlanItem> planMap = new HashMap<Date, PlanItem>();

    private boolean isLeapYear(int year) {
        if(year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
            return true;
        } else {
            return false;
        }
    }

    public void registerPlan(String strDate, String plan) {
        PlanItem p = new PlanItem(strDate, plan);
        planMap.put(p.getDate(), p);
    }

    public PlanItem searchPlan(String strDate) {
        Date date = PlanItem.getDateFromString(strDate);
        return planMap.get(date);
    }

    private int getMaxDayofMonth(int year, int month) {
        int maxDay = isLeapYear(year) ? LEAP_MAX_DAY[month] : MAX_DAY[month];
        return maxDay;
    }

    public void printCalendar(int year, int month) {
        System.out.printf(" << %4d월 %3d일 >>\n", year, month);
        System.out.println(" SU MO TU WE TH FR SA");
        System.out.println("----------------------");

        // 1일의 요일 알아내기
        int weekDay = getWeekday(year, month);
        for(int i = 0; i<weekDay; i++) {
            System.out.print("   ");
        }

        for(int i = 1; i<=getMaxDayofMonth(year,month); i++) {
            System.out.printf("%3d", i);
            if((i+weekDay) % 7 == 0) System.out.println();
        }
        System.out.println();

    }

    // 요일 반환해주는 메소드
    private int getWeekday(int year, int month) {
        int STANDARD_WEEKDAY = 4; // 1970/1/1 목 기준

        int sYear = 1970;
        int cnt = 0;

        for(int i = sYear; i<year; i++) {
            int delta = isLeapYear(i) ? 366 : 365;
            cnt += delta;
        }

        for(int i = 1; i<month; i++) {
            int delta = getMaxDayofMonth(year, i);
            cnt += delta;
        }

        int weekDay = (cnt+STANDARD_WEEKDAY)%7;
        return weekDay;
    }
}
