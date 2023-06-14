package day20230613;

import java.util.Scanner;

public class ex2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		
		
		boolean isOdd = ((x+y)%2 != 0) ? true : false;
		System.out.println(isOdd);
	}

}
