package playground;

import java.text.ParseException;
import java.util.Scanner;

public class Prompt {
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

    public int parseDay(String week) {
        switch(week) {
            case "su":
                return 0;
            case "mo":
                return 1;
            case "tu":
                return 2;
            case "we":
                return 3;
            case "th":
                return 4;
            case "fr":
                return 5;
            case "sa":
                return 6;
            default:
                return 0;
        }
    }

    private void runPrompt() throws ParseException {
        Scanner scanner = new Scanner(System.in);
        Calendar cal = new Calendar();

        boolean isLoop = true;
        while(isLoop) {
            printMenu();
            String cmd = scanner.next();

            switch(cmd) {
                case "1":
                    cmdRegister(scanner, cal);
                    break;
                case "2":
                    cmdSearch(scanner, cal);
                    break;
                case "3":
                    cmdCal(scanner, cal);
                    break;
                case "h":
                    printMenu();
                    break;
                case "q":
                    isLoop = false;
                    break;
            }
        }
        System.out.println("Bye");
        scanner.close();
    }

    private void cmdSearch(Scanner s, Calendar c) {
        System.out.println("[일정 검색]");
        System.out.println("날짜를 입력해 주세요 (yyyy-MM-dd).");
        String date = s.next();
        PlanItem plan;
        plan = c.searchPlan(date);
        if(plan != null) {
            System.out.println(plan.detail);
        } else {
            System.out.println("일정이 없습니다.");
        }
    }

    private void cmdRegister(Scanner s, Calendar c) throws ParseException {
        System.out.println("[새 일정 등록]");
        System.out.println("날짜를 입력해 주세요. (yyyy-MM-dd).");
        String date = s.next();
        String text = "";
        s.nextLine(); // ignore one newline
        System.out.println("일정을 입력해 주세요.");
        text = s.nextLine(); // 한 줄 통째로 읽기
        c.registerPlan(date, text);
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

    public static void main(String[] args) throws ParseException {
        // 셀 실행
        Prompt p = new Prompt();
        p.runPrompt();
    }
}
