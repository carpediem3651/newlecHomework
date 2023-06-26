package array;

import java.util.Random;

public class HomeWork_0623_1th {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] lotto = new int[6];
		int size = 0;

		Random rand = new Random();

//	      for(int i=0; i<1000; i++)
//	      {
//	         int num = rand.nextInt(45)+1;      
//	         System.out.println(num);
//	      }

		// 1. lotto 배열을 랜덤한 값들로 채우고
		for (int i = 0; i < 6; i++) {
			size++;
			lotto[i] = rand.nextInt(45) + 1;
//			System.out.println(lotto[i]);
		}
		

		// 2. 정렬을 한 후에
		for (int j = 0; j < size - 1; j++) {
			{ // step1.최솟값의 인덱스를 찾는다.
				int firstArr = j;// 배열의 첫번 째 위치
				int minIndex = j; // 최초 인덱스를 설정한다. 최초 인덱스는 0
				for (int i = 0; i < size - 1 - firstArr; i++) {
					if (lotto[minIndex] > lotto[i + 1 + j]) { // 설정한 인덱스 다음 나오는 데이터가 인덱스에 담긴 값보다 더 작으면 그 값의 인덱스'i+1'를
																// minIndex에 넣는다.
						minIndex = i + 1 + j;
					}
				}

				// step2.최솟값과 첫번째(인덱스0) 자리의 숫자를 바꾼다.
				int tmp;
				tmp = lotto[firstArr];
				lotto[firstArr] = lotto[minIndex];
				lotto[minIndex] = tmp;
			}
		}
		
		// 3. lotto 배열의 값들을 출력하시오.
		// 단 출력 포맷은 예를 들어 3,4,21,24,30,42 처럼 출력되도록 한다 마지막 숫자에는 쉼표(,)가 없어야 한다.
		for(int i=0; i<lotto.length; i++ ) //
			if(i>4)
				System.out.printf("%d\n", lotto[i]);
			else 
				System.out.printf("%d,", lotto[i]);
	}

}
