package playground;

import java.util.Scanner;

public class Prompt {
//    private final static String PROMPT = "cal> ";

    public void runPrompt() {
    // 숫자를 입력받아 해당하는 달의 최대 일수를 출력하는 프로그램
        Scanner scanner = new Scanner(System.in);
        Calendar cal = new Calendar();

        int month = 1;
        int year = -1;
        while(true) {
            System.out.println("년도를 입력하세요.");
            System.out.print("YEAR> ");
            year = scanner.nextInt();
            if(year == -1) break;
            System.out.println("달을 입력하세요");
            System.out.print("MONTH> ");
            month = scanner.nextInt();
            if(month == -1) break;
            if(month >12) continue;

            System.out.println("첫번째 요일을 입력하세요. (SU, MO, TU, WE, TH, FR, SA)");
            System.out.print("WEEKDAY> ");
            String weekday = scanner.next();

            cal.printCalendar(year, month, weekday);
        }

        System.out.println("bye~");
        scanner.close();
    }

    public static void main(String[] args) {
        // 셀 실행
        Prompt p = new Prompt();
        p.runPrompt();
    }
}
