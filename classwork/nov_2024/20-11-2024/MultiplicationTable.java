public class MultiplicationTable{
  public static void main(String[] args){
    
    
    for(int indexA = 1; indexA <= 10; indexA += 1){
      for(int indexB = 1; indexB <= 10; indexB += 1){
        System.out.printf("%2d x %2d = %3d\t", indexA, indexB, (indexA * indexB));
      }
      System.out.println();
    }
  
  }
}
