package array;

public class HomeWork_0622_4th2 {

	public static void main(String[] args) {
		{
			for(int i=0; i<11; i++) {
				for(int j=0; j<11; j++) {
					if(i == j)
						System.out.printf("%s", "●");
					else if(i == 10-j)
						System.out.printf("%s", "●");
					else
						System.out.printf("%s", "┼");
					
				}
				System.out.println();
			}
			
		}

	}

}
