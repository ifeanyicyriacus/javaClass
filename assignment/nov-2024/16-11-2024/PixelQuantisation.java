public class PixelQuantisation{
	public static void main(String[] args){
		int[] sample = {23, 32, 10, 45, 19, 27, 59, 56, 99, 94, 101, 104, 139, 149, 172, 173, 174, 76, 87, 23, 33, 34, 100, 10, 297, 320, 720, 9};
		System.out.println("Original array list:");
		System.out.println(arrayToStringList(sample));
	  quantizePixel(sample);
	  System.out.println("Array after PixelQuantisation:");
		System.out.println(arrayToStringList(sample));
	}

	public static void quantizePixel(int[] intArray){
	  for (int index = 0; index < intArray.length; index += 1){
	    if (intArray[index] >= 0 && intArray[index] <= 20){intArray[index] = 10;}
	    else if (intArray[index] <= 40){intArray[index] = 30;}
	    else if (intArray[index] <= 60){intArray[index] = 50;}
	    else if (intArray[index] <= 80){intArray[index] = 70;}
	    else if (intArray[index] <= 100){intArray[index] = 90;}
	    else if (intArray[index] <= 120){intArray[index] = 110;}
	    else if (intArray[index] <= 140){intArray[index] = 130;}
	    else if (intArray[index] <= 160){intArray[index] = 150;}
	    else if (intArray[index] <= 180){intArray[index] = 170;}
	    else {intArray[index] = 190;}
	  }
	}

	public static String arrayToStringList(int[] intArray){
		String list ="";
		for(int number: intArray){
			list += (number+ " ");
		}
		return list;
	}
}
