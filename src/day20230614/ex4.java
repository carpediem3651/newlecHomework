package day20230614;

public class ex4 {

	public static void main(String[] args) {
		// 문제)66을 소인수 분해하는 프로그램을 만드시오.
		// 소인수 분해 : 어떤 수를 소수인 인수로 분해하는 것.
		// 못풀었다
		
//		풀이1)
		
//		int x = 66;
//		for (int i = 0, j = 2; i < 66; i++, j++) {
//			while(x % j == 0) {
//				x /= j;
//				System.out.printf("%d ", j);
//			}
//		}
		
//		풀이2)
//		// 1은 소수가 아니므로 i의 기준을 2로 잡음.
//		for (int i = 2; i <= primeFactorization; i++) {
//
//			// 66을 i(2)로 나누면 나머지 0, true값이니 while문 실행
//			while ((primeFactorization % i) == 0) {
//		    
//				// 2는 소수이면서 합성수 66을 구성하는 소수이므로 2출력
//				System.out.println(i);
//		        
//				//66을 2로 나눠준 값 33을 primeFactorization에 저장.
//				primeFactorization = primeFactorization / i;
//			}
//
//		}
	}
}
