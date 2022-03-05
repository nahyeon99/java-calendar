package practice;

import java.util.Scanner;

public class Prompt {
    public void runPrompt() {
        Scanner scanner = new Scanner(System.in);

        int year = -1;
        int month = -1;
        while(true) {
            System.out.println("년도를 입력하세요. (exit: -1)");
            System.out.print("YEAR> ");
            year = scanner.nextInt();
            if(year == -1) break;

            System.out.println("달을 입력하세요. (exit: -1)");
            System.out.print("MONTH> ");
            month = scanner.nextInt();
            if(month == -1) break;

            Calendar cal = new Calendar();
            cal.printCalendar(year, month);
        }
        System.out.println("bye~");
        scanner.close();
    }

    public static void main(String[] args) {
        Prompt p = new Prompt();
        p.runPrompt();
    }
}