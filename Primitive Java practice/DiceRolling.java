//chapter7; 
//exercise17;

import java.util.Random;

public class DiceRolling{
  public static void main(String[] args){
    Random diceA, diceB;
    
    diceA = new Random();
    diceB = new Random();
    int[] result = new int[11];
    
    int times = 36_000_000;
    
    while (times > 0){
      int value1 = diceA.nextInt(1, 7);
      int value2 = diceB.nextInt(1, 7);
      result[(value1 + value2 - 2)]++;
      times--;
    }
    
    System.out.println("combination | Tally");
    int count = 2;
    for(int tally: result){
        System.out.printf("%d | %d%n", count, tally);
        count++;
    }
      
  }
}
