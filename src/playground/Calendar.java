package playground;

import java.util.Scanner;

public class Calendar {
    public static void main(String[] args) {
        // 31일 - 1,3,5,7,8,10,12월
        // 30일 - 4,6,9,11월
        // 28,29일 - 2월

        Scanner scanner = new Scanner(System.in);
        System.out.println("달을 입력하세요.");
        int input = scanner.nextInt();

        int[] array = {31,30,28,30,31,30,31,31,30,31,30,31};

        for(int i = 0; i<12; i++) {
            if(input-1 == i) {
                System.out.println(i+1+ "월은 " + array[i]+"일까지 있습니다.");
            }
        }
    }
}
