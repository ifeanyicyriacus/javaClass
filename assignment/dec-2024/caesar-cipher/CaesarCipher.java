public class CaesarCipher{
  private static final String[] alphabets = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
  
  public static boolean isExist(){
    return true;
  }
  
  public static String encrypt(String plainText, int noOfShift){
    String encryptedText = "";
    String[] plainTextList = plainText.replace(" ", "").split("");
    int encryptedLetterId;
    for (String letter: plainTextList){
      encryptedLetterId = (getAlphabetIdByLetter(letter) + noOfShift) % 26;
      encryptedText += alphabets[encryptedLetterId];
    }
    return encryptedText;
  }

  public static String decrypt(String encryptedText, int noOfShift){
    String plainText = "";
    String[] encryptedTextList = encryptedText.split("");
    int plainTextId;
    for (String letter: encryptedTextList){
      plainTextId = (getAlphabetIdByLetter(letter) - noOfShift) % 26;
      plainText += (plainTextId < 0)? alphabets[(26 - Math.abs(plainTextId))] : alphabets[plainTextId];
    }
    return plainText;
  }
  
  public static int getAlphabetIdByLetter(String plainLetter){
    int index = 0;
    for(String letter: alphabets){
      if(plainLetter.equalsIgnoreCase(letter)){
        return index;
      }
      index += 1;
    }
    return -1;
  }
  
}
