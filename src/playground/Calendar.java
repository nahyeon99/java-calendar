package playground;

import java.util.Scanner;

public class Calendar {
    private static int[] MAX_DAYS = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private static int[] LEAP_MAX_DAYS = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public boolean isLeapYear(int year) {
        if(year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) { // 윤년
            return true;
        }
        return false;
    }

    public int getMaxDaysOfMonth(int year, int month) {
        if(isLeapYear(year)) { // 윤년일경우
            return LEAP_MAX_DAYS[month-1];
        } else { // 평년일경우
            return MAX_DAYS[month-1];
        }
    }

    // weekday : (SU, MO, WE, TH, FR, SA)
    public void printCalendar(int year, int month, String weekday) {
        System.out.printf(" << %4d년  %3d월 >>\n",year, month);
        System.out.println(" SU MO TU WE TH FR SA");


        int maxDay = getMaxDaysOfMonth(year, month);
        int cnt = 0;
        switch (weekday) {
            case "SU":
                break;
            case "MO":
                cnt = 1;
                System.out.printf("   ");
                break;
            case "TU":
                cnt = 2;
                System.out.printf("   ");
                System.out.printf("   ");
                break;
            case "WE":
                cnt = 3;
                System.out.printf("   ");
                System.out.printf("   ");
                System.out.printf("   ");
                break;
            case "TH":
                cnt = 4;
                System.out.printf("   ");
                System.out.printf("   ");
                System.out.printf("   ");
                System.out.printf("   ");
                break;
            case "FR":
                cnt = 5;
                System.out.printf("   ");
                System.out.printf("   ");
                System.out.printf("   ");
                System.out.printf("   ");
                System.out.printf("   ");
                break;
            case "SA":
                cnt = 6;
                System.out.printf("   ");
                System.out.printf("   ");
                System.out.printf("   ");
                System.out.printf("   ");
                System.out.printf("   ");
                System.out.printf("   ");
                break;
        }
        for(int i = 1; i<=maxDay; i++) {
            System.out.printf("%3d", i);
            if((i+cnt)%7 == 0) {
                System.out.println();
            }
        }
        System.out.println();

//        System.out.println("---------------------");
//        System.out.println("  1  2  3  4  5  6  7");
//        System.out.println("  8  9 10 11 12 13 14");
//        System.out.println(" 15 16 17 18 19 20 21");
//        System.out.println(" 22 23 24 25 26 27 28");
    }
}