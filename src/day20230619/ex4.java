package day20230619;

public class ex4 {

	public static void main(String[] args) {
			
		for(int i=0; i<5; i++) {
			for(int j=0; j<i; j++) {	//공백을 담당하는 for문
				System.out.print(" ");
			}
			for(int j=0; j<5-i; j++) {	//별을 담당하는 for문
				System.out.print("*"); 
			}
			System.out.println();
			}
		}
	}
