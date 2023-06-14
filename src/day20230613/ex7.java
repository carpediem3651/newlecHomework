package day20230613;

public class ex7 {

	public static void main(String[] args) {
//		문제) while문을 이용하여 정수 1부터 100이하의 정수 중 3의 배수만 출력하세요.
		int num = 1;
		
		while(0<num && num<=100) {
			if(num % 3 == 0) {
				System.out.println(num);
			}
			
			num++;
		}
	}

}
