package array;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class scoreInOutput {
	public static void main(String[] args) throws IOException {
		{
			/* ★★★★★★★★메인메뉴 만들기★★★★★★★★ */
			Scanner input = new Scanner(System.in);
			int[] score = new int[3];

			END: while (true) {
				System.out.print("┌──────────────────┐\n");
				System.out.print(" 메인 메뉴 \n");
				System.out.print("└──────────────────┘\n");
				System.out.println("1. 성적 입력 2. 성적 출력 3. 성적 불러오기 4. 성적 저장하기 9. 프로그램 종료");
				System.out.print("선택 > ");
				System.out.println();
				System.out.println();
				int menu = input.nextInt();

				switch (menu) {
				/* ★★★★★★★★CASE 1★★★★★★★★ */
				case 1: {

					System.out.print("┌──────────────────┐\n");
					System.out.print(" 성적 입력 \n");
					System.out.print("└──────────────────┘\n");
					System.out.println("성적을 입력하세요");
					System.out.println();

					do {
						System.out.print("국어 성적을 입력하세요. > ");
						score[0] = input.nextInt();
						System.out.print("수학 성적을 입력하세요. > ");
						score[1] = input.nextInt();
						System.out.print("영어 성적을 입력하세요. > ");
						score[2] = input.nextInt();

						if (!(0 <= score[0] && score[0] <= 100) || !(0 <= score[1] && score[1] <= 100)
								|| !(0 <= score[2] && score[2] <= 100))
							System.out.println("성적의 범위(0~100)을 벗어났습니다.");

					} while (!(0 <= score[0] && score[0] <= 100) || !(0 <= score[1] && score[1] <= 100)
							|| !(0 <= score[2] && score[2] <= 100));

					System.out.println();

					break;
				} // case 1
				
				/* ★★★★★★★★CASE 2★★★★★★★★ */
				case 2: {
					System.out.print("┌──────────────────┐\n");
					System.out.print(" 성적 출력 \n");
					System.out.print("└──────────────────┘\n");
					System.out.println();

					for (int i = 0; i < score.length; i++)
						System.out.printf("%d, %d점\n", i + 1, score[i]);

					System.out.println();
					System.out.println();
					break;

				} // case 2

				/* ★★★★★★★★CASE 3★★★★★★★★ */
				case 3: {
					System.out.print("┌──────────────────┐\n");
					System.out.print(" 성적을 불러옵니다... \n");
					System.out.print("└──────────────────┘\n");
					System.out.println();

					FileInputStream fis = new FileInputStream("res/score/data.txt");
					Scanner fscan = new Scanner(fis);

					for (int i = 0; i < score.length; i++)
						score[i] = fscan.nextInt(); // 파일에 있는 성적 데이터 불러오기
					
					for (int i = 0; i < score.length; i++)
						System.out.printf("%d, %d점\n", i + 1, score[i]); // 불러온 성적데이터 출력
		
					System.out.println();

					fscan.close();
					fis.close();
					break;
				} // case 3

				/* ★★★★★★★★CASE 4★★★★★★★★ */
				case 4: {
					System.out.print("┌──────────────────┐\n");
					System.out.print(" 성적을 저장했습니다. \n");
					System.out.print("└──────────────────┘\n");
					System.out.println();

					FileOutputStream fos = new FileOutputStream("res/score/data.txt");
					PrintWriter fout = new PrintWriter(fos);
					
					for (int i = 0; i < score.length; i++) // 파일에 성적 입력
						fout.printf("%d ", score[i]);

					System.out.println();

					fout.close();
					fos.close();
					break;
				} // case 4

				/* ★★★★★★★★CASE 9★★★★★★★★ */
				case 9: {
					break END;
				} // case 9

				/* ★★★★★★★★DEFAULT★★★★★★★★ */
				default: {
					System.out.println("잘못된 메뉴 입력입니다.");
					System.out.println();
				} // default
				}// switch
				/* ★★★★★★★★SWITCH 종료★★★★★★★★ */

			} // while (제일 상위 while)
			/* ★★★★★★★★WHILE 종료★★★★★★★★ */
			System.out.println("프로그램을 종료합니다");
			input.close();
		} // 지역화
	} // main
} // class
