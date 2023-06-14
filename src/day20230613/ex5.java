package day20230613;

public class ex5 {

	public static void main(String[] args) {
//		문제) for문을 이용하여 1부터 10이하의 정수 중, 홀수만 큰 수부터 작은 순으로 출력하세요.
		for(int i=0; i<=10; i++) {
			if(i % 2 != 0) {
				System.out.println(10-i);
			}
		}
	}

}
