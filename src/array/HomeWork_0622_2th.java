package array;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.util.Scanner;

public class HomeWork_0622_2th {

	public static void main(String[] args) throws IOException {
		//1.nums에 15개를 저장할 수 있는 객체 생성
		int[] nums = new int[15];
		int size=0;
		
		{ //2.data2.txt에 저장된 값들을 nums 배열에 로드
			FileInputStream fis = new FileInputStream("res/data2.txt");
			Scanner fiscan = new Scanner(fis);
		
			for(int i=0; fiscan.hasNext(); i++) {
				int num = fiscan.nextInt(); //문자열을 불러와 int로 변환시켜 num에 넣는다.
				nums[i] = num; // 배열에 문자열을 넣는다.
				size++;
			}
			
			fiscan.close();
			fis.close();
			
			System.out.println("로드완료");
		}
		
		{ //3. data-out.txt 배열 값 저장
			FileOutputStream fos = new FileOutputStream("res/data-out.txt"); 
			PrintWriter fout = new PrintWriter(fos, true, Charset.forName("UTF-8"));
			
			for(int i=0; i<size; i++) { //배열의 값을 파일에 저장한다.
				fout.printf("%d,",nums[i]);
			}
			fos.close();
		}
		
	}

}
