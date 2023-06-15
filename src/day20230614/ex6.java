package day20230614;

public class ex6 {

	public static void main(String[] args) {
		// 1 1 2 3 5 8 13 21 34 55를 출력하는 코드를 작성하시오. int x = 1; int y = 0, int z = 0;
		// hint 출력코드 맨 앞에 0이 있다고 가정한다.
		int x = 1;
		int y = 0;
		int z = 0;
		
		for(int i = 0; i < 10; i++) {
			System.out.printf("%d ", x);
			z = y + z;
			y = x;
			x = z;
		}
	}

}
