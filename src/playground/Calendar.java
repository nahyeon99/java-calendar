package playground;

import java.util.Scanner;

public class Calendar {
    public static void main(String[] args) {
        // 31일 - 1,3,5,7,8,10,12월
        // 30일 - 4,6,9,11월
        // 28,29일 - 2월
        Scanner scanner = new Scanner(System.in);
        int[] monthArr = {31,28,31,30,31,30,31,31,30,31,30,31};
        while(true) {
            System.out.println("월을 입력하세요.");
            int month = scanner.nextInt();
            if(month == -1) {
                System.out.println("Have a nice day!");
                break;
            }
            for(int i = 0; i<monthArr.length; i++) {
                if(i == month-1) {
                    System.out.println(month + "월은 " + monthArr[i] + "일까지 있습니다.");
                }
            }

        }
    }
}
