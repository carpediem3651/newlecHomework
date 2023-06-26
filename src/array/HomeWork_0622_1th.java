package array;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class HomeWork_0622_1th {

	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("res/data.txt");
		Scanner fiscan = new Scanner(fis);
		int[] nums = new int[20]; // 데이터를 담을 20크기의 통
		int count = 0; // 배열 통에 몇개의 숫자가 담겼는지 나타내는 변수
		int max=-1; // 최대값을 구하기 위한 변수
		int index = -1;
		
		
		{ // 문제1. 파일에 담긴 값들의 개수를 구하시오.
			for(int i=0; fiscan.hasNextInt(); i++) { //배열의 0번째부터 배열에 데이터가 존재하는 위치까지 데이터를 불러온다. hasNextInt는 진리값으로 다음 숫자가 있는지 여부를 확인한다. 
				int num = fiscan.nextInt(); //문자열을 불러와 int로 변환시켜 num에 넣는다.
				nums[i] = num; // 배열 nums에 데이터(숫자)를 담는다.
				count++; // 반복문을 돌 때 마다 count를 하나씩 증가시켜 배열에 데이터가 몇 개 있는지 알 수 있다.
			}
			System.out.printf("count is %d\n", count);
		}		
//		
//		{ // 문제2. 파일에 담긴 값들 중에 가장 큰 값이 무엇인지 출력하시오.
//			for(int i=0; i<count-1; i++ ) {
//				if(max<nums[i])
//					max=nums[i];
//			} 
//			System.out.printf("max is %d\n", max);
//		}
		
		{
		  // 문제3. 파일에 담긴 데이터 값 중에 숫자값 10이 담긴 위치를 출력하시오.	
			
			for(int i=0; i<count-1; i++) {
				index++;
				if(nums[i]==10) {
					System.out.printf("index is %d\n", index);
				}
			}
			
		}
			
		
			
		fiscan.close();
		fis.close();
	}

}
