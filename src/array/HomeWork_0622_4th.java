package array;

public class HomeWork_0622_4th {

	public static void main(String[] args) {
		{
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 10; j++) {
					if (i == j)
						System.out.printf("%s", "●");
					else
						System.out.printf("%s", "┼");

				} // for j
				System.out.println();
			} // for i
		}

	}

}
