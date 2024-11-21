import java.util.ArrayList;

public class IntersectionOfArrays{
	public static void main(String[] args){
		int[] array1 = {23, 32, 10, 45, 76};
		int[] array2 = {87, 23, 33, 34, 100, 10};
		System.out.println("Original array lists:");
		System.out.printf("[%s], ", arrayToStringList(array1));
		System.out.printf("[%s]%n", arrayToStringList(array2));
		
		ArrayList<Integer> intersection = findIntersection(array1, array2);
		System.out.println("Intersection:");
		System.out.printf("[%s] %n", arrayListToStringList(intersection));
	}
	
	public static ArrayList<Integer> findIntersection(int[] intList1, int[] intList2){
		ArrayList<Integer> intersection = new ArrayList<Integer>();
		
		for (int element1 : intList1){
			for(int element2 : intList2){
				if (element1 == element2 && !(intersection.contains(element1))){
					intersection.add(element1);
				}
			}
		}
		return intersection;
	
	}
	
	public static String arrayListToStringList(ArrayList<Integer> intList){
		String list ="";
		for(int number: intList){
			list += (number+ " ");
		}
		return list;
	}
	public static String arrayToStringList(int[] intList){
		String list ="";
		for(int number: intList){
			list += (number+ " ");
		}
		return list;
	}
}
