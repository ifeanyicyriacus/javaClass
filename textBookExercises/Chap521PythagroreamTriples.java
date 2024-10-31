public class Chap521PythagroreamTriples{
	public static void main(String[] args){
		System.out.println("Side A\tSide B\tHypotenuse");
		int sideA = 1;
		while(sideA <= 500){
			int sideB = 1;
			while(sideB <= 500){
				int sideC = 1;
				while(sideC <= 500){
					if ((Math.pow(sideA, 2) + Math.pow(sideB, 2)) ==
						Math.pow(sideC, 2)){
						System.out.printf("%d\t%d\t%d%n", sideA, sideB, sideC);
					}
				  sideC += 1;
				}
				sideB += 1;
			}
			sideA +=1;
		}
	}
}
