import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.util.Arrays;

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
    int target = data[x];
    data[x] = data[start];
    data[start] = target;

    if (start!= end) {
      start+=1;
    }
    while (start != end) {
      if (data[start] >= target) {
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
      start -= 1;
    }
    else {
      data[s] = data[start];
      data[start] = target;
    }
    return start;
  }

  //----------------------------------------------------------------
  //test cases from George's driver in the Google Group
  public static boolean test(int[] data, int k, int start, int end) {
      for (int i = start; i < end; i++) {
          if (i < k) {
              if (data[i] > data[k]) {
                  return false;
              }
          } else if (i > k) {
              if (data[i] < data[k]) {
                  return false;
              }
          }
      }
      return true;
  }

  public static void main(String[] args) {
    // int[] b = {1,2};
    // System.out.println(makeAllWords(3,3));
    // System.out.println(makeAllWords(4,2));
    // System.out.println(makeAllWords(1,26));
    // System.out.println(partition(b,2,9));

    int[] data1 = {10, 80, 30, 90, 40, 50, 70};
    System.out.println(Arrays.toString(data1));
    int index1a = partition(data1, 0, 6);
    System.out.println("1a: " + test(data1, index1a,0,6));
    System.out.println(Arrays.toString(data1) + " "+index1a+"\n");
    // System.out.println(Arrays.toString(data1));

    int index1b = partition(data1, 2, 5);
    System.out.println("1b: " + test(data1, index1b,2,5));
    // System.out.println(Arrays.toString(data1) + " "+index1b+"\n");

    int[] data2 = {6, 3, 7, -1, 7, 4, 10, -21};
    int index2a = partition(data2, 2, 7);
    System.out.println("2a: " + test(data2, index2a,2,7));
    System.out.println(Arrays.toString(data2));

    int index2b = partition(data2, 1, 4);
    System.out.println("2b: " + test(data2, index2b,1,4));

    int[] data3 = {78};
    //System.out.println(Arrays.toString(data3));
    int index3 = partition(data3, 0, 0);
    System.out.println("3: " + test(data3, index3,0,0));
    //System.out.println(Arrays.toString(data3) + "\n");

    int[] data4 = {3, 1};
    int index4 = partition(data4, 0, 1);
    //System.out.println(Arrays.toString(data4));
    System.out.println("4: " + test(data4, index4,0,1));
    System.out.println(Arrays.toString(data4) + "\n");
    //
    // for (int i = 0; i < 100; i++) {
    //     try {
    //         Random gen = new Random();
    //         int[] test = new int[i * 1000 + 1];
    //         for (int j = 0; j < test.length; j++) {
    //             test[j] = gen.nextInt();
    //         }
    //         int start = Math.abs(gen.nextInt()) % test.length;
    //         int end = start + Math.abs(gen.nextInt()) % (test.length - start);
    //         //System.out.println(start + ", " + end);
    //         //System.out.println(Arrays.toString(test));
    //         int index = partition(test, start, end);
    //         if (!test(test, index,start,end)) {
    //             System.out.print("FAILURE ON LENGTH " + (i * 1000 + 1));
    //             System.exit(1);
    //         }
    //     } catch (Exception e) {
    //         e.printStackTrace();
    //         System.out.println(e);
    //         System.out.print("FAILURE ON LENGTH " + (i * 1000 + 1));
    //         System.exit(1);
    //     }
    // }
  }
}
