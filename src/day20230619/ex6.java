package day20230619;

public class ex6 {

	public static void main(String[] args) {
		for (int i = 5; i > 0; i--) {
			for (int j = 5 - i; j > 0; j--) {
				System.out.print(" ");
			}
			for (int k = i * 2 - 1; k > 0; k--) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

}
