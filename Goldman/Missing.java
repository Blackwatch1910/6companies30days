// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().split(" ");

            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            int[] ans = new Solve().findTwoElement(a, n);
            System.out.println(ans[0] + " " + ans[1]);
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solve {
    int[] findTwoElement(int arr[], int n) {
        // code here
        int res[] = new int[2];
        int xor = 0;

        for (int i = 0; i < n; i++) {
            xor ^= arr[i];
        }

        for (int i = 1; i <= n; i++) {
            xor ^= i;
        }

        int rsb = xor & -xor;

        int x = 0;
        int y = 0;

        for (int value: arr) {
            if ((value & rsb) == 0)
                x = x ^ value;
            
            else
                y = y ^ value;
        }

        for (int i = 1; i <= n; i++) {
            if ((i & rsb) == 0) {
                x = x ^ i;
            }
            else {
                y = y ^ i;
            }
        }

        for (int value: arr) {
            if (value == x) {
                res[0] = x;
                res[1] = y;
                break;
            }
            else if (value == y){
                res[0] = y;
                res[1] = x;
                break;
            }
        }
        return res;
    }
}