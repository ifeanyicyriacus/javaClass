public class USAFlag{
	public static void main(String[] args){
		int row = 1;
		int tempCounter1 = 1;
		int tempCounter2 = 1;
		int tempCounter3 = 1;
		do{
			while(tempCounter1 <= 6){
				if(row %2 != 0){ System.out.print("* ");}
				else{System.out.print(" *");}
				tempCounter1 += 1;
			}

			while(tempCounter2 <= 34){
			  System.out.print("-");
			  tempCounter2 += 1;
			}
			System.out.println("");
			row += 1;
			tempCounter1 = 1;
			tempCounter2 = 1;
		} while(row <= 5);
		
		while(row <= 11){
			while(tempCounter3 <= 46){
				System.out.print("-");
				tempCounter3 += 1;
			}
			tempCounter3 = 1;
			System.out.println();
			row += 1;
		}
	}
}
