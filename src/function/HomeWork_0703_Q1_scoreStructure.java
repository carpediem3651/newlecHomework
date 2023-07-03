package function;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class HomeWork_0703_Q1_scoreStructure {

	public static void main(String[] args) throws IOException {
		int[] scores = new int[3]; // 국영수 성적 담을 배열 각 함수에 공통으로 쓰이기 위해 매개변수로 활용한다.

		// 성적 입출력 구조화
		EXIT: while (true) {
			int menu = chooseMenu();

			switch (menu) {
			case 1: // 성적입력
				inputScore(scores);
				break;
			case 2: // 성적출력
				printScore(scores);
				break;
			case 3: // 성적저장
				saveScore(scores);
				break;
			case 4: // 저장된 성적 불러오기
				bringScore(scores);
				break;
			case 5:
				System.out.println("안뇽~~!");
				break EXIT;
			default:
				System.out.println("메뉴는 1~5번만 선택할 수 있습니다.");
				break;
			}
		} // while
	} // main

	private static void bringScore(int[] scores) throws IOException {
		System.out.print("┌──────────────────┐\n");
		System.out.print(" 성적을 불러옵니다... \n");
		System.out.print("└──────────────────┘\n");
		System.out.println();

		FileInputStream fis = new FileInputStream("res/score/data.txt");
		Scanner fscan = new Scanner(fis);

		for (int i = 0; i < scores.length; i++)
			scores[i] = fscan.nextInt(); // 파일에 있는 성적 데이터 불러오기
		
		for (int i = 0; i < scores.length; i++)
			System.out.printf("%d, %d점\n", i + 1, scores[i]); // 불러온 성적데이터 출력

		System.out.println();

		fscan.close();
		fis.close();		
	}

	//성적 저장
	private static void saveScore(int[] scores) throws IOException {
		System.out.print("┌──────────────────┐\n");
		System.out.print(" 성적을 저장했습니다. \n");
		System.out.print("└──────────────────┘\n");
		System.out.println();

		FileOutputStream fos = new FileOutputStream("res/score/data.txt");
		PrintWriter fout = new PrintWriter(fos);

		for (int i = 0; i < scores.length; i++) // 파일에 성적 입력
			fout.printf("%d ", scores[i]);

		System.out.println();

		fout.close();
		fos.close();
	}

	private static void printScore(int[] scores) {

		System.out.print("┌──────────────────┐\n");
		System.out.print(" 성적 출력 \n");
		System.out.print("└──────────────────┘\n");
		System.out.println();

		for (int i = 0; i < scores.length; i++)
			System.out.printf("%d. %3d점\n", i + 1, scores[i]);

		System.out.println();
		System.out.println();

	} // printScore

	private static int chooseMenu() {
		Scanner input = new Scanner(System.in);

		System.out.print("┌──────────────────┐\n");
		System.out.print(" 메인 메뉴 \n");
		System.out.print("└──────────────────┘\n");
		System.out.println("1. 성적 입력 2. 성적 출력 3. 성적 저장 4. 저장된 성적 불러오기 5. 종료");
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

} // class
