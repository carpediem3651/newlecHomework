package day20230616;

public class ex4 {

	public static void main(String[] args) {
//		문제) for문을 이용하여 다음처럼 구구단 표를 출력하시오.
//		2*1 =2
//		2*2 =4
//		반복
//		9*9=81
		
		for(int i =0; i<8; i++) {
			for(int j=0; j<9; j++) {
				System.out.println((i+2)+"X"+(j+1)+"="+((i+2)*(j+1)));
			}
		}
	}

}
