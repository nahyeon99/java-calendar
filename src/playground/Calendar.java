package playground;

import java.util.Scanner;

public class Calendar {
    public static void main(String[] args) {
        System.out.println("두 수를 입력하세요.");
        Scanner scanner = new Scanner(System.in);
        int num1 = scanner.nextInt();
        String num2 = scanner.next();
        int num2_int = Integer.parseInt(num2);
        System.out.println("두 수의 합은 " + (num1+num2_int) + " 입니다.");
        System.out.println("두 수의 합은 " + (num1+num2) + " 입니다.");
    }
}
