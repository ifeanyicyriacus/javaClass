public class TitleCase{
  public String toTitleCase(String text){

    String[] words = text.split(" ");
    for (int index = 0; index < words.length; index += 1){
      String firstLetter = words[index].substring(0,1).toUpperCase();
      String otherLetters = words[index].substring(1).toLowerCase();
      words[index] = firstLetter + otherLetters;      
    }
    return String.join(" ", words);
  }

}
