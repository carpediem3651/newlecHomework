package function;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

public class HomeWork_0628_Q1 {

	public static void main(String[] args) throws IOException {
		// 죽음의 로또 만들기
		{
			/* ★★★★★★★★메인메뉴 만들기★★★★★★★★ */
			Scanner input = new Scanner(System.in);
			int[] lottos = new int[6];

			END: while (true) {
				System.out.print("┌──────────────────┐\n");
				System.out.print("│  Lotto 관리 프로그램 │\n");
				System.out.print("└──────────────────┘\n");
				System.out.println("1. 번호 자동 생성");
				System.out.println("2. 번호 수동 생성");
				System.out.println("3. 내 로또 번호 보기");
				System.out.println("4. 종료");
				System.out.print("선택 > ");
				System.out.println();
				System.out.println();
				int menu = input.nextInt();
				
				OVER:
				switch (menu) {
				/* ★★★★★★★★CASE 1★★★★★★★★ 번호 자동생성하기 */
				case 1: {

					System.out.print("┌──────────────────┐\n");
					System.out.print("│ lotto번호 자동생성   │\n");
					System.out.print("└──────────────────┘\n");

					System.out.println();

					Random rand = new Random();

					System.out.print("로또 당첨번호:");

					for (int i = 0; i < lottos.length; i++) {
					   lottos[i] = rand.nextInt(45) + 1; // 로또번호 뽑기
					   
//					   ★★★★★★★★★★★★★★★오름차순 정렬 못함★★★★★★★★★★★★★★★
				       
//					    for (int k = 0; k < (lottos.length - 1) - i; k++) // j를 활용해서 이미 숫자가 고정된 자리를 빼준다
//					        if (lottos[k] > lottos[k + 1]) { // 뒷값이 더 크면 값교환
//					            int tmp = lottos[k + 1];
//					            lottos[k + 1] = lottos[k];
//					            lottos[k] = tmp;
//					        }
				       
//					   ★중복처리
				       for (int j = 0; j < i; j++) { // 로또번호 중복제거 앞번호(i)와 뒷번호(j)를 비교한다.
				    	   if (lottos[i] == lottos[j]) {
								i--; // ★★★★★★★★★★★★★★★★★★★★★★★★ 중복값 처리 제대로 못함 로또 번호가 같으면 카운트를 하지 않는다. 무효처리.
								System.out.println("중복됐지롱 다시해");
								break OVER;
				    	   }		
				       }
					}
					
					for(int i=0; i<lottos.length; i++)
						System.out.printf("%d ",lottos[i]); // ★로또번호 출력
					 
					

					System.out.println();

					// 빠져나가는 두개의 경우의수를 만든다.
					System.out.println("1. 저장하고 메인메뉴로 가기");
					System.out.println("2. 취소하고 메인메뉴로 가기");
					System.out.println(">_");

					// 1. 저장하고 메인메뉴로가기
					int menu2 = input.nextInt(); // 번호를 입력한다.

					switch (menu2) {
						case 1: { // 저장하고 메인메뉴로 간다.
							FileOutputStream fos = new FileOutputStream("res/lotto/data.txt");
							PrintWriter fout = new PrintWriter(fos);
	
							for (int i = 0; i < lottos.length; i++) // 파일에 로또 점수 입력
								fout.printf("%d ", lottos[i]);
	
							fout.close();
							fos.close();
	
							break;
						}

						case 2: { // 취소하고 메인 메뉴로간다.
							break OVER;
						} 
					} // switch2 case1 close
				} // switch1 case 1 close
				
//				---------------------------------------- 1. 번호자동생성 완료 -------------------------------------------------
				
				
				case 2: { // 번호 수동 생성 시작
					System.out.print("┌──────────────────┐\n");
					System.out.print("│ lotto번호 수동생성   │\n");
					System.out.print("└──────────────────┘\n");

					System.out.println();

					System.out.print("로또 당첨번호:");

					for (int i = 0; i < lottos.length; i++) {
						lottos[i] = input.nextInt();
						
						// ★중복제거
						for (int j = 0; j < i; j++) { // 로또번호 중복제거 앞번호(i)와 뒷번호(j)를 비교한다.
							if (lottos[i] == lottos[j]) {
								i--; // 로또 번호가 같으면 카운트를 하지 않는다. 무효처리.
								System.out.println("헤헤 중복됐지롱");
								break;
							}
						} 
					}
					
					// ★로또번호 출력
					for(int i=0; i<lottos.length; i++)
						System.out.printf("%d ",lottos[i]); 
					System.out.println();
					
					// 빠져나가는 두개의 경우의수를 만든다.
					System.out.println("1. 저장하고 메인메뉴로 가기");
					System.out.println("2. 취소하고 메인메뉴로 가기");
					System.out.println(">_");

					// 1. 저장하고 메인메뉴로가기
					int menu2 = input.nextInt(); // 번호를 입력한다.

				
					switch (menu2) {
					case 1: { // 저장하고 메인메뉴로 간다.
						FileOutputStream fos = new FileOutputStream("res/lotto/data.txt");
						PrintWriter fout = new PrintWriter(fos);

						for (int i = 0; i < lottos.length; i++) // 파일에 로또 점수 입력
							fout.printf("%d ", lottos[i]);

						fout.close();
						fos.close();

						break;
					}

					case 2: // 취소하고 메인 메뉴로간다.
						break;
					} // switch문 2 close

					System.out.println();
					
				} // switch문 1 끝
				
				} //switch문 1 끝
			} // while문 끝
		} //지역화 
	} //main
} //class
