import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    public static double getMedian(Vector<Integer> list) {
        int half = list.size() / 2;
        boolean isOdd = ((list.size() & 1) == 1) ? true : false;
        
        return ((isOdd) ? list.get(half) : (list.get(half) + list.get(half - 1)) / 2.0);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        Vector<Integer> list = new Vector<Integer>();
        for(int i = 0; i < n; i++) {
            list.add(scan.nextInt());
        }
        for(int i = 0; i < n; i++) {
            int frequency = scan.nextInt();
            int value = list.get(i);
            while(frequency-- > 1) {
                list.add(value);
            }
        }
        scan.close();
        
        Collections.sort(list);
        
        double median = getMedian(list);
        
        Vector<Integer> lower = new Vector<Integer>();
        Vector<Integer> upper = new Vector<Integer>();
        
        n = list.size();
        
        if (n % 2 == 1) {
            for (int i = 0; i < n / 2; i++) {
                lower.add(list.get(i));
            }
            
            for (int i = n / 2 + 1; i < n; i++) {
                upper.add(list.get(i));
            }
        } else {
            for (int i = 0; i < n / 2; i++) {
                lower.add(list.get(i));
            }
            
            for (int i = n / 2; i < n; i++) {
                upper.add(list.get(i));
            }
        }
        
        double q1 = getMedian(lower);
        double q3 = getMedian(upper);
        
        System.out.println(q3 - q1);
        
    }
}
