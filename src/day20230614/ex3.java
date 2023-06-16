package day20230614;

public class ex3 {

	public static void main(String[] args) {
		//문제) 1!+2!+3!+4!+5!의 값을 구하라		
//		풀이 1)
		
//		int num = 1; // 핵심
//		int sum = 0;
//		
//		for (int i=0; i<5; i++) {
//			num = num*(i+1); //핵심
//			sum +=num;
//		}
//		
//		System.out.println(sum);
	

		
//		풀이2)
		
//		int result =1;
//		int totalSum = 0;
//		for(int i = 0, n = 1; i < 5; i++, n++) {
//			result = n * result ;
//			totalSum += result;
//		}
//		System.out.println(totalSum);
		
		// n=1 1 x result(1)
		// n=2 2 x 1(result)
		// n=3 3 x 2 x 1(result)
		// n=4 4 x 3 x 2 x 1 (result)
		// n=5 5 x 4 x 3 x 2 x 1 (result)
		// --> result = n x result 규칙을 찾아냄.
		
	}
}
