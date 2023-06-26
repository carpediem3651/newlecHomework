package array;


import java.util.Scanner;

import javax.security.auth.Destroyable;




public class jyheonOmok {

	public static void main(String[] args) {
	   
		      /*
		       * 
		         ┌┬┬┬┬┬┬┬┬┬┬┐board[0][0~11]
		         ├┼┼┼┼┼┼┼┼┼┼┤board[1][0~11]
		         ├┼┼┼┼┼┼┼┼┼┼┤board[2][0~11]
		         ├┼┼┼┼┼┼┼┼┼┼┤board[3][0~11]
		         ├┼┼┼┼┼┼┼┼┼┼┤board[4][0~11]
		         ├┼┼┼┼┼┼┼┼┼┼┤board[5][0~11]
		         ├┼┼┼┼┼┼┼┼┼┼┤board[6][0~11]
		         ├┼┼┼┼┼┼┼┼┼┼┤board[7][0~11]
		         ├┼┼┼┼┼┼┼┼┼┼┤board[8][0~11]
		         ├┼┼┼┼┼┼┼┼┼┼┤board[9][0~11]
		         ├┼┼┼┼┼┼┼┼┼┼┤board[10][0~11]
		         └┴┴┴┴┴┴┴┴┴┴┘board[11][0~11]
		       * 
		       */
		      /* ★★★★★★★★★★★★★★★변수선언★★★★★★★★★★★★★★★★★★★★ */
		      
		      Scanner scan = new Scanner(System.in);
		      
		      int menu = -1;
		      int ox = -1; 
		      int oy = -1;
		      int width = 17;
		      int height =12;
		      
		      char[][] board = new char[height][width];
		      
		      /* ★★★★★★★★★★★★★★★★메인메뉴★★★★★★★★★★★★★★★★★★★★ */
		      OVER: while(true) {
		         do {
		            System.out.println("┌───────────┐");
		            System.out.println("           Omok Game   ");
		            System.out.println("                  by hjh    ");
		            System.out.println("└───────────┘");
		            System.out.println("1. 게임시작");
		            System.out.println("2. 도움말");
		            System.out.println("3. 종료");
		            System.out.print(">");
		            menu = scan.nextInt();
		            
		            if(!(0<menu && menu<4)) {
		               System.out.println("잘못된 값을 넣었습니다.");
		               System.out.println("1, 2, 3 중에 선택하세요.");
		               System.out.println();
		            }
		         }while(!(0<menu && menu<4));
		         
		         MAIN: switch(menu){
		         case 1: {
		               
		            
		            //---------바둑판에 ┼값 넣기-------------
		            for(int y=0; y<height; y++)
		               for(int x=0; x<width; x++)
		                     board[y][x]='┼';
		            
		            //---------바둑판에 가장자리 값 넣기-------------
		            for(int y=0; y<height; y++) {         // i
		               for(int x=0; x<width; x++) {       //j
		                  board[y][width-1] = '┤';
		                  board[0][x] = '┬';
		                  board[height-1][x] = '┴';
		                  board[y][0] = '├';
		                  board[0][0] = '┌';
		                  board[0][width-1] = '┐';
		                  board[height-1][0] = '└';
		                  board[height-1][width-1] = '┘';
		                  
		                  
		                  System.out.printf("%c", board[y][x]);
		               }// for x
		               System.out.println();
		            }// for y
		            //-------------빈 바둑판 출력하기 끝---------------            
		            
		            
		            /* ★★★★★★★★★★★★★★★바둑돌 놓기★★★★★★★★★★★★★★ */
		            
		            System.out.println("10회 남았습니다.");
		            
		               for(int i=0; i<10; i++) {
		                  int omokCount = (i+1)%2; // 홀짝여부 확인
		                  final int BLACK_STONE = 0;
		                  final int WHITE_STONE = 1; //반 나눠서 홀수, 짝수 구분
		                  
		                  switch(omokCount) {
		                  case WHITE_STONE: {
		                     do {
		                        System.out.println("좌표값을 입력하세요. (0~11사이 값 입력)");
		                        System.out.println("그만두기: -1 0");
		                        System.out.println("(x sp y) > ");
		                        ox = scan.nextInt();
		                        oy = scan.nextInt();
		                        
		                        if(ox == -1 && oy == 0)
		                           break MAIN;
		                        
		                        if(!(0<=ox&& ox<=11) || !(0<=oy && oy <=11)) {
		                           System.out.println("잘못된 값을 입력했습니다.");
		                           System.out.println("좌표값을 입력하세요. (0~11 사이 값 입력)");
		                           System.out.println();
		                           continue;
		                        }// if 오류값 넣었을 때
		                        
		                        
		                        if((board[oy][ox] == '○') || (board[oy][ox] == '●')) {
		                           System.out.println("이미 놓아진 자리입니다.");
		                           System.out.println();
		                           i--; // i--?
		                           continue;
		                        } else {
		                           for(int y=0; y<height; y++) {
		                              for(int x=0; x<width; x++) {       //j
		                                 board[oy][ox] = '○';
		                                 System.out.printf("%c", board[y][x]);
		                              }// for x
		                              System.out.println();
		                           }// for y 백돌놓기 종료
		                        }// if 종료 (중복제거)
		                        
		                     }while(!(0<=ox&& ox<=11) || !(0<=oy && oy <=11));
		                     
		                     
		                     System.out.printf("%d회 남았습니다.", 10-(i+1));
		                     System.out.println();
		                     //=====================10회 일 때========================
		                     if((i+1)/10==1) { //10회 수행했다는 걸 나타낸다. 10회가 되었을 때 true가되면서 블록안으로 들어감.
		                        System.out.println("게임이 끝났습니다. 메인으로 돌아갑니다.");
		                        break MAIN;
		                     }
		                     break;
		                  }// case 0 
		                  case BLACK_STONE: {
		                     do {
		                        
		                        System.out.println("좌표값을 입력하세요. (0~11사이 값 입력)");
		                        System.out.println("그만두기: -1 0");
		                        System.out.println("(x sp y) > ");
		                        ox = scan.nextInt();
		                        oy = scan.nextInt();
		                        
		                        if(ox == -1 && oy == 0)
		                           break MAIN;
		                        
		                        
		                        if(!(0<=ox&& ox<=11) || !(0<=oy && oy <=11)) {
		                           System.out.println("잘못된 값을 입력했습니다.");
		                           System.out.println("좌표값을 입력하세요. (0~11 사이 값 입력)");
		                           System.out.println();
		                           continue;
		                        }// if 오류값 넣었을 때
		                        
		                        if((board[oy][ox] == '○') || (board[oy][ox] == '●')) {
		                           System.out.println("이미 놓아진 자리입니다.");
		                           System.out.println();
		                           i--;
		                           continue;
		                        } else {
		                           for(int y=0; y<height; y++) {
		                              for(int x=0; x<width; x++) {       //j
		                                 board[oy][ox] = '●';
		                                 System.out.printf("%c", board[y][x]);
		                              }// for x
		                              System.out.println();
		                           }// for y 흑돌놓기 종료
		                        }// if 종료 (중복제거)
		                        
		                        
		                     }while(!(0<=ox&& ox<=11) || !(0<=oy && oy <=11));
		                     
		                     System.out.printf("%d회 남았습니다.", 10-(i+1));
		                     System.out.println();
		                     break;
		                  }//case 1
		                  default: {
		                     System.out.println("메인 메뉴로 돌아갑니다.");
		                     break MAIN;
		                  }//default end
		               }// switch2 백돌 흑돌 놓기 end
		               }//for i  (게임 반복 횟수) end
		            /* ★★★★★★★★★★★★★★★★★끝★★★★★★★★★★★★★★★★★★★★ */
		            break;
		         }// case 1
		         case 2:{
		            System.out.println("홀수번에는 ●을 짝수번에는 ○을 놓습니다.");
		            System.out.println("0~11사이 값을 2번 입력하세요.");
		            System.out.println();
		            System.out.println();
		            break;
		         }// case 2
		         case 3:{
		            System.out.println("게임을 종료합니다.");
		            break OVER;
		         }// case 3
		         default:{
		            System.out.println("잘못된 값을 넣었습니다.");
		            System.out.println("1, 2, 3 중에 선택하세요.");
		            System.out.println();
		         }
		         }//switch1 전체 메뉴 end
		      }//while(true) 전체 end
		      scan.close();

   }// main
}// class

