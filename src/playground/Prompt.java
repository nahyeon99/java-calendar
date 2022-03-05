package playground;

import java.util.Scanner;

public class Prompt<T> {
    public void printMenu() {
        System.out.println("+----------------------+");
        System.out.println("| 1. 일정 등록");
        System.out.println("| 2. 일정 검색");
        System.out.println("| 3. 달력 보기");
        System.out.println("| h. 도움말 q. 종료");
        System.out.println("+----------------------+");
        System.out.println("명령 (1, 2, 3, h, q)");
        System.out.print("입력 > ");
    }

    private void cmdRegister() {
    }

    private void cmdSearch() {
    }

    private void cmdCal(Scanner s, Calendar c) { // Scanner, Calendar는 외부에서 만들고 참조해서 사용(계속 만들면 오버헤드 발생)
        int year = -1;
        int month = -1;

        System.out.println("년도를 입력하세요.");
        System.out.print("YEAR> ");
        year = s.nextInt();
        System.out.println("달을 입력하세요.");
        System.out.print("MONTH> ");
        month = s.nextInt();
        if(month > 12 || month < 1) {
            System.out.println("잘못된 입력입니다.");
            return;
        }
        c.printCalendar(year, month);
    }

    private void runPrompt() {
        Scanner scanner = new Scanner(System.in);
        Calendar cal = new Calendar();

        while(true) {
            printMenu();
            String cmd = scanner.next();
            if(cmd.equals("1")) cmdRegister();
            else if(cmd.equals("2")) cmdSearch();
            else if(cmd.equals("3")) cmdCal(scanner, cal);
            else if(cmd.equals("4")) printMenu();
            else if(cmd.equals("q")) break;
        }
        System.out.println("Bye");
        scanner.close();
    }

    public static void main(String[] args) {
        // 셀 실행
        Prompt p = new Prompt();
        p.runPrompt();
    }
}
