package day20230616;

public class ex2 {

	public static void main(String[] args) {
//	while문을 이용하여, 1~100(100포함x)의 값에서 number가 짝수마다 +가 출력되고, 홀수마다 -가 출력되는 코드를 작성하시오.
		int number = 0;
		// number의 값을 어떻게 증가시킬것인가??
		while (number <100) {
			number++;
			if (number % 2 == 0)
				System.out.print("+");
			else if (number % 2 != 0) 
				System.out.print("-");
		}
	}

}
