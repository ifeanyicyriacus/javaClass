public class MultiplicationTableReverse{
	public static void main(String[] args){
		System.out.println("Multiplication table");
		
		for(int row = 12; row >= 1; row -= 1){
			for(int column = 12; column >= 1; column -= 1){
				System.out.printf("%2d x %2d = %3d\t", row, column, (row * column));
			}
			System.out.println();
		}
		
		
	}
}
