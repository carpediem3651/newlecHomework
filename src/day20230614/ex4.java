package day20230614;

public class ex4 {

	public static void main(String[] args) {
		// 문제)66을 소인수 분해하는 프로그램을 만드시오.
		// 소인수 분해 : 어떤 수를 소수인 인수로 분해하는 것.
		// 못풀었다
		
		int x = 66;
		for (int i = 0, j = 2; i < 66; i++, j++) {
			while(x % j == 0) {
				x /= j;
				System.out.printf("%d ", j);
			}
		}
	}
}
