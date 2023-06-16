package day20230616;

public class ex5 {

	public static void main(String[] args) {
//		for문을 이용하여 구구단 표를 출력해보세요. 구구단 결과 값이 홀수 일 때만 출력해보세요.
//		예를들면, 다음과 같습니다. 3*2, 3*4의 결과 값이 짝수이기 때문에 생략해요.
//		3*1=3
//		3*3=9
//		3*5=15
		for(int i =0; i<8; i++) {
			for(int j=0; j<9; j++) {
				if((i+2)*(j+1) %2  == 0)
					continue;
					System.out.println((i+2)+"X"+(j+1)+"="+((i+2)*(j+1)));
			}
		}
	}

}
