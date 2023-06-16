package day20230616;

public class ex3 {

	public static void main(String[] args) {
//		문제) while문을 이용하여, number가 짝수마다 +가 출력되고, 홀수마다 -가 출력되는 코드를 작성해보세요. 이때 x축의
//		문자가 10개가 되면, 줄바꿈을 해보세요.
		int number = 0;
//		int cnt = 0; // 상태변화(줄개행)을 위한 변수 cnt가 5개가 있을 때 마다 개행한다.
		
		while (number <100) {
			number++;
			if (number % 2 == 0) 
				System.out.print("+");
			else if (number % 2 !=0)
				System.out.print("-");
				
			
			if(number %10 == 0) 
				System.out.println();
			
		}
	}

}
