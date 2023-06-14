package day20230614;

import java.util.Scanner;

public class ex5 {

	public static void main(String[] args) {
		// 입력받은 정수 값을 더 하고 값의 합이 100을 넘으면 종료하라.
		
		Scanner sc = new Scanner(System.in);
		
		int sum = 0;
		
		
		while(sum <= 100) {
			int num = sc.nextInt();
			sum += num;
		}
		
		System.out.println("종료");
	}

}
