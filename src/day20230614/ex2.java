package day20230614;

public class ex2 {

	public static void main(String[] args) {
		int cnt = 0;
		
		for(int i=0; i<=100; i++) {
			if(i%2 != 0) {
				cnt++;
			}
		}
		
		System.out.println("홀수의 개수="+cnt);
	}

}
