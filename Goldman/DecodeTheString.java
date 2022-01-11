// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String s = in.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.decodedString(s));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
    static int i = 0;
    static String decodedString(String s){
        // code here
        StringBuilder res = new StringBuilder();
        while (i < s.length() && s.charAt(i) != ']') {
            if (Character.isDigit(s.charAt(i))) {
                int k = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i)))
                    k = k * 10 + s.charAt(i++) - '0';
                i++;
                String r = decodedString(s);
                while (k-- > 0) 
                    res.append(r);
                i++;
            }
            else {
                res.append(s.charAt(i++));
            }
            return res.toString();
        }
    }
}