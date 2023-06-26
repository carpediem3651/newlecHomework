package array;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.util.Scanner;

public class HomeWork_0622_3th {

	public static void main(String[] args) throws IOException {
		// alphabet이라는 이름으로 문자 15개를 저장할 수 있는 배열 객체를 생성한다
		char[] alphabet = new char[14];
		int size = 0;
		
		{ //로드
			FileInputStream fis = new FileInputStream("res/alphabet.txt");
			Scanner fiscan = new Scanner(fis);
			String input = fiscan.next(); // input에 string으로 파일에 있는 문장을 읽어온다.
			
			for(int i=0; i<alphabet.length; i++) {
				alphabet[i] = input.charAt(i); //charAt을 이용하여 alphabet에 input의 글자 하나하나를 읽어온다.
				System.out.printf("%c,", alphabet[i]); // 제대로 읽어오는지 찍어보자.
				size++;
			}
			System.out.println(size);
			
			fiscan.close();
			fis.close();
			
			System.out.println("로드완료");
		}
		
		{ // nmlkjhgfedcba의 순으로 자리를 바꾼다. 즉 역순으로 자리를 바꾼다. 버블정렬을 써봐.
			for(int j=0; j<size-1; j++) {
				for(int i=0; i<(size-1)-i; i++) {
					char temp;
					temp = alphabet[i];
					alphabet[i] = alphabet[i+1];
					alphabet[i+1] = temp ;
				}	
			}
		}
		
		{ // 파일에 저장하여 출력하셈
			FileOutputStream fos = new FileOutputStream("res/alphabetOut.txt"); 
			PrintWriter fout = new PrintWriter(fos, true, Charset.forName("UTF-8"));
			
			for(int i=0; i<size; i++) { //배열의 값을 파일에 저장한다.
				fout.printf("%c,",alphabet[i]);
			}
			
			fos.close();
		}
	}
}
