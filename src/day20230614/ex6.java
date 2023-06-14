package day20230614;

public class ex6 {

	public static void main(String[] args) {
		// 1 1 2 3 5 8 13 21 34 55를 출력하는 코드를 작성하시오. 피보나치 수열
		// 못풀었다
		int x = 1;
		int y = 0;
		int z = 0;
		
		int num1 = 1;
		int num2 = 1;
		int num3 = 2;
		
		System.out.print("1,1,2");
		
		for(int i=0; i<7; i++) {
			num1 = num2;
			num2 = num3;
			num3 = num1+num2;
			System.out.print(","+num3);
		}
	}

}
