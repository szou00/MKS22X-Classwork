import java.util.List;
import java.util.ArrayList;

public class Classwork {

  public static List<String> makeAllWords(int k, int maxLetter) {
    List<String> data = new ArrayList<String>();
    makeAllWords(k, maxLetter, "", data);
    return data;
  }

  public static void makeAllWords(int k, int maxLetter, String str, List<String> data) {
    if (k == 0) {
      data.add(str);
    }
    else {
      for (int i = 0; i < maxLetter; i++) {
        makeAllWords(k-1,maxLetter,str+(char)(i+97),data);
      }
    }
  }

  public static void main(String[] args) {
    System.out.println(makeAllWords(3,3));
    System.out.println(makeAllWords(4,2));
    System.out.println(makeAllWords(1,26));
  }
}
