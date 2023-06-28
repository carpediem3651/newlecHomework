package array;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.util.Scanner;

public class TaehoOmok {

	public static void main(String[] args) throws IOException {
		/*
		 * ┌┬┬┬┬┬┬┬┬┬┬┐ 
		 * ├┼┼┼┼┼┼┼┼┼┼┤ 
		 * ├┼┼┼┼┼┼┼┼┼┼┤ 
		 * ├┼┼┼┼┼┼┼┼┼┼┤ 
		 * ├┼┼┼┼┼┼┼┼┼┼┤ 
		 * ├┼┼┼┼┼┼┼┼┼┼┤
		 * ├┼┼┼┼┼┼┼┼┼┼┤
		 * ├┼┼┼┼┼┼┼┼┼┼┤ 
		 * ├┼┼┼┼┼┼┼┼┼┼┤ 
		 * ├┼┼┼┼┼┼┼┼┼┼┤ 
		 * ├┼┼┼┼┼┼┼┼┼┼┤ 
		 * └┴┴┴┴┴┴┴┴┴┴┘
		 */
		Scanner scan = new Scanner(System.in);

//		int[] oxes = new int[10];
//		int[] oyes = new int[10];

		int ox = 0;
		int oy = 0;

		int width = 12;
		int height = 12;

		final int WHITE_STONE = 1;
		final int BLACK_STONE = 2;

		int turn = 1;

		char[][] board = new char[height][width];
		int[][] omokMap = new int[height - 2][width - 2]; // 오목맵 파일

		board[oy][ox] = (turn == BLACK_STONE) ? '●' : '○';

		for (int y = 0; y < height; y++)
			for (int x = 0; x < width; x++) {
				board[y][x] = '┼';
				board[0][x] = '┬';
				board[height - 1][x] = '┴';
				board[y][0] = '├';
				board[y][width - 1] = '┤';
				board[0][0] = '┌';
				board[0][width - 1] = '┐';
				board[height - 1][0] = '└';
				board[height - 1][width - 1] = '┘';
			}

		while (true) {
			System.out.println("┌────────────┐");
			System.out.println("│      omok game         │");
			System.out.println("└────────────┘");
			System.out.println();
			System.out.println("1. 게임시작");
			System.out.println("2. 도움말");
			System.out.println("3. 저장하기");
			System.out.println("4. 불러오기");
			System.out.println("9. 종료");
			System.out.print("> ");
			System.out.println();

			int menu = scan.nextInt();

			switch (menu) {

			case 1:

				for (int y = 0; y < height; y++) {
					for (int x = 0; x < width; x++)
						System.out.printf("%c", board[y][x]);// [j][i]
					System.out.println();
				} // 기본 오목판 찍기

				GAME: while (true) {
					//------------------------------------------- 흑돌 입력--------------------------------------------------
					boolean onDark = true;

					do {
						System.out.println("그만두기 : -1 0");
						System.out.println("흑돌(범위 : 1~10) > ");

						oy = scan.nextInt();
						ox = scan.nextInt();

						if (oy == -1 && ox == 0) {
							System.out.println("게임이 종료되었습니다. ");
							break GAME;
						} else if ((oy < 1 || 10 < oy) || (ox < 1 || 10 < ox)) {
							System.out.println("값의 범위는 1~10사이로 입력바랍니다.");
							continue;
						} else if (board[oy][ox] == '○' || board[oy][ox] == '●') {
							System.out.println("오목알의 위치가 겹칩니다.");
							continue;
						}

						onDark = (board[oy][ox] == '○') || (oy < 1 || 10 < oy) || (ox < 1 || 10 < ox);

					} while (onDark);

					board[oy][ox] = '●'; // 검은 돌 설정

					// 흑돌이 포함된 바둑판 출력
					for (int y = 0; y < height; y++) {
						for (int x = 0; x < width; x++)
							System.out.printf("%c", board[y][x]);// [j][i]
						System.out.println();
					}
					
					// --------------------------------백돌입력---------------------------------------
					boolean onWhite = true;

					// 백돌 입력 앞선
					do {
						System.out.println("그만두기 : -1 0");
						System.out.println("백돌(범위 : 0~11) > ");
						oy = scan.nextInt();
						ox = scan.nextInt();

						if (oy == -1 && ox == 0) {
							System.out.println("게임이 종료되었습니다. ");
							break GAME;
						} else if ((oy < 1 || 10 < oy) || (ox < 1 || 10 < ox)) {
							System.out.println("값의 범위는 1~10사이로 입력바랍니다.");
							continue;
						} else if (board[oy][ox] == '흑' || board[oy][ox] == '백') {
							System.out.println("오목알의 위치가 겹칩니다.");
							continue;
						}

						onWhite = (board[oy][ox] == '●') || (oy < 1 || 10 < oy) || (ox < 1 || 10 < ox);
					} while (onWhite);

					board[oy][ox] = '○'; //백돌 입력

					// 백돌 출력
					for (int y = 0; y < height; y++) {
						for (int x = 0; x < width; x++)
							System.out.printf("%c", board[y][x]);// [j][i]
						System.out.println();
					}
				}

				// 2. 도움말
			case 2:
				System.out.println("도움말");
				break;

			// 3. 저장하기
			case 3:
				// 흑 :2 백 1: 나머지 : 0 변환

				for (int y = 0; y < height - 2; y++)
					for (int x = 0; x < width - 2; x++) {
						if (board[y + 1][x + 1] == '흑')
							omokMap[y][x] = BLACK_STONE;
						else if (board[y + 1][x + 1] == '백')
							omokMap[y][x] = WHITE_STONE;
						else
							omokMap[y][x] = 0;
					}

				System.out.println("┌────────────────┐");
				System.out.println("│      Omok.map 확인                     │");
				System.out.println("└────────────────┘");
				System.out.println();

				int size = 0;
				for (int y = 0; y < height - 2; y++)
					for (int x = 0; x < width - 2; x++) {
						System.out.print(omokMap[y][x]);
						size++;
						if (x == width - 3)
							System.out.println();
					}

				System.out.println();
				System.out.println(size);

				// 변환된 값을 omok.map에 저장
				FileOutputStream fos = new FileOutputStream("res/omok.map");
				PrintWriter pw = new PrintWriter(fos, true, Charset.forName("UTF-8"));

				for (int y = 0; y < height - 2; y++)
					for (int x = 0; x < height - 2; x++) {
						pw.print(omokMap[y][x]);
						size++;
						if (x == width - 3)
							pw.println();
					}

				System.out.println("┌────────────────┐");
				System.out.println("│      정상적으로 저장했습니다.       │");
				System.out.println("└────────────────┘");
				System.out.println();
				break;

			// 4. 불러오기
			case 4:
				FileInputStream fis = new FileInputStream("res/omok.map");

				for (int y = 0; y < height - 2; y++)
					for (int x = 0; x < height - 2; x++) {
						board[y + 1][x + 1] = (char) fis.read();
						if (board[y + 1][x + 1] == '2')
							board[y + 1][x + 1] = '흑';
						else if (board[y + 1][x + 1] == '1')
							board[y + 1][x + 1] = '백';
						else
							board[y + 1][x + 1] = '┼';
					}

				for (int y = 0; y < height; y++) {
					for (int x = 0; x < width; x++)
						System.out.printf("%c", board[y][x]);// [j][i]
					System.out.println();
				}

//				for(int y = 0; y<height-2; y++)
//					for (int x= 0; x<width-2; x++) {
//						if(omokMap[y][x] == BLACK_STONE)
//							board[y+1][x+1] = '흑';
//						else if(omokMap[y][x] == WHITE_STONE)
//							board[y+1][x+1] = '백';
//						else
//							board[y+1][x+1] = '┼' ;
//					}

				for (int y = 0; y < height; y++) {
					for (int x = 0; x < width; x++)
						System.out.printf("%c", board[y][x]);// [j][i]
					System.out.println();
				}

				System.out.println("┌────────────────┐");
				System.out.println("│      정상적으로 불러왔습니다.       │");
				System.out.println("└────────────────┘");
				System.out.println();

				break;
			// 9. 종료
			case 5:
				System.out.println("종료");
				return;

			default:
				System.out.println("입력 값은 1~5안으로 입력해주세요.");

			} // switch off
		} // while off
	} // main off

}
