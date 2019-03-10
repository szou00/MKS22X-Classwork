import java.util.List;
import java.util.ArrayList;
import java.util.Random;

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

  public static int partition ( int [] data, int start, int end){
    Random rand = new Random();
    int s = start;
    int x = rand.nextInt(end+1-start) + start;
    while (start != end) {
      target = data[x];
      data[x] = data[start];
      data[start] = target;
      start+=1;
      if (data[start] > target) {
        int temp = data[end];
        data[end] = data[start];
        data[start] = temp;
        end-=1;
      }
      else {
        start+=1;
      }
    }
    if (data[start] > target) {
      data[s] = data[start-1];
      data[start-1] = target;
    }
    else {
      data[s] = data[start];
      data[start] = target;
    }
    return start;
  }

  public static void main(String[] args) {
    int[] b = {1,2};
    // System.out.println(makeAllWords(3,3));
    // System.out.println(makeAllWords(4,2));
    // System.out.println(makeAllWords(1,26));
    System.out.println(partition(b,2,9));
  }
}
