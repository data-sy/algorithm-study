package no01;

import java.util.Scanner;

public class Ex012_1373_다른분풀이봐드리기 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
        int decimal = 0;
        int power = 0;

        String binaryStr = scanner.nextLine();
        // 입력값이 int 크기를 넘어가면 런타임 에러가 
        int binary = Integer.parseInt(binaryStr);


        if (binary > 0 && binary < 1111111) {
            int temp = binary;
            while (temp != 0) {
                int digit = temp % 10;
                decimal += digit * Math.pow(2, power);
                temp /= 10;
                power++;
            }
            System.out.print(decimal);
        }
        else {
            System.out.println("1000000안으로 입력해주세요");
        }

	}
}
