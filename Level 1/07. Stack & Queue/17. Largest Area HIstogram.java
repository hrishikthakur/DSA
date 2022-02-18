import java.io.*;
import java.util.*;

public class Main {

   public static int[] nsl(int[] a) {
      int[] nse = new int[a.length];
      Arrays.fill(nse, -1); // agar left se out of bound jaata hai, then initialize with -1

      Stack<Integer> stk = new Stack<>();
      for (int i = 0; i < a.length; i++) {
         while (stk.size() > 0 &&  a[i] <= a[stk.peek()]) {
            stk.pop();
         }
         if (stk.size() > 0)
            nse[i] = stk.peek();

         stk.push(i);
      }
      return nse;
   }

   public static int[] nsr(int[] a) {
      int[] nse = new int[a.length];
      Arrays.fill(nse, a.length); // agar right se out of bound jaata hai, then initialize with a.length

      Stack<Integer> stk = new Stack<>();
      for (int i = a.length - 1; i >= 0; i--) {
         while (stk.size() > 0 &&  a[i] <= a[stk.peek()]) {
            stk.pop();
         }

         if (stk.size() > 0)
            nse[i] = stk.peek();

         stk.push(i);
      }
      return nse;
   }

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int n = Integer.parseInt(br.readLine());
      int[] a = new int[n];
      for (int i = 0; i < n; i++) {
         a[i] = Integer.parseInt(br.readLine());
      }

      int nsl[] = nsl(a);
      int nsr[] = nsr(a);

      int maxArea = 0;
      for (int i = 0; i < n; i++) {
         int currArea = (nsr[i] - nsl[i] - 1) * a[i];
         maxArea =  Math.max(currArea, maxArea);
      }

      System.out.println(maxArea);

   }
}
