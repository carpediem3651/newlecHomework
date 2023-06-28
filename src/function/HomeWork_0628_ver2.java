package function;

import java.util.Scanner;

public class HomeWork_0628_ver2 {
	
	private static void printScore(int[] scores) {
		
		
		System.out.print("┌──────────────────┐\n");
		System.out.print(" 성적 출력 \n");
		System.out.print("└──────────────────┘\n");
		System.out.println();
		
		for(int i=0; i<scores.length; i++)
			System.out.printf("%d, %3d점\n", i+1, scores[i]);
		
		System.out.println();
		System.out.println();
		
	} // printScore
	
	private static int chooseMenu() {
		Scanner input = new Scanner(System.in);

		System.out.print("┌──────────────────┐\n");
		System.out.print(" 메인 메뉴 \n");
		System.out.print("└──────────────────┘\n");
		System.out.println("1. 성적 입력 2. 성적 출력 3. 성적 불러오기 4. 성적 저장하기 9. 프로그램 종료");
		System.out.print("선택 > ");
		System.out.println();
		System.out.println();
		int menu = input.nextInt();

		return menu;
	} // chooseMenu

	private static void inputScore(int[] scores) {
		Scanner input = new Scanner(System.in);

		System.out.print("┌──────────────────┐\n");
		System.out.print(" 성적 입력 \n");
		System.out.print("└──────────────────┘\n");
		System.out.println("성적을 입력하세요");
		System.out.println();

		do {
			System.out.print("국어 성적을 입력하세요. > ");
			scores[0] = input.nextInt();
			System.out.print("수학 성적을 입력하세요. > ");
			scores[1] = input.nextInt();
			System.out.print("영어 성적을 입력하세요. > ");
			scores[2] = input.nextInt();

			if (!(0 <= scores[0] && scores[0] <= 100) || !(0 <= scores[1] && scores[1] <= 100)
					|| !(0 <= scores[2] && scores[2] <= 100))
				System.out.println("성적의 범위(0~100)을 벗어났습니다.");

		} while (!(0 <= scores[0] && scores[0] <= 100) || !(0 <= scores[1] && scores[1] <= 100)
				|| !(0 <= scores[2] && scores[2] <= 100));

		System.out.println();
	} // inputScore

	public static void main(String[] args) {
		int[] scores = new int[3]; // 국영수 성적 담을 배열 각 함수에 공통으로 쓰이기 위해 매개변수로 활용한다.
		
		// 성적 입출력 구조화
		EXIT: 
			while (true) {
				int menu = chooseMenu();

				switch (menu) {
				case 1:
					inputScore(scores);
					break;
				case 2:
					printScore(scores);
					break;
				case 3:
					System.out.println("Bye~~~");
					break EXIT;
				default:
					System.out.println("메뉴는 1~5번만 선택할 수 있습니다.");
					break;
				}
			} //while
	} // main
} // class
