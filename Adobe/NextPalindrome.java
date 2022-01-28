// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GfG
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0)
        {
            String s = sc.next();
            Solution obj = new Solution();
            System.out.println(obj.nextPalin(s));
        }
            
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public void swap(StringBuilder s, int index1, int index2){
        
        char x = s.charAt(index1);
        s.setCharAt(index1, s.charAt(index2));
        s.setCharAt(index2, x);
        
    }
    
    public void sort(StringBuilder sb, int index){
        
        String temp = sb.toString().substring(index);
        
        char[]arr = temp.toCharArray();
        Arrays.sort(arr);
        
        for(int i = 0; i < temp.length(); i++){
            sb.setCharAt(index + i, arr[i]);
        }
    }
    
    public String next(StringBuilder s){
        
        int index1 = 0;
        
        for(int i = s.length() - 1; i > 0; i--){
            char x1 = s.charAt(i);
            char x2 = s.charAt(i-1);
             
            if(x2 < x1){
                index1 = i - 1;
                break;
            }
        }
        
        int index2 = s.length() - 1;
        
        for(int i = index1 + 1; i < s.length(); i++){
            char x1 = s.charAt(i);
            char x2 = s.charAt(index1);
            
            if(x1 > x2){
                index2 = i;
            }
        }
        
        
        swap(s, index1, index2);
        sort(s, index1 + 1);
        
        return s.toString();
    }
    
    public String nextPalin(String N) 
    { 
        //complete the function here
        if(N.length() <= 3){
            return  "-1";
        }
        StringBuilder str = new StringBuilder(N.substring(0, N.length()/2));
        String temp = str.toString();
        String nextper = next(str);
        
        
        if(nextper.compareTo(temp) <= 0){
            return "-1";
        }
        
        if(N.length() % 2 != 0){
            String result = "";
            result += nextper;
            result += N.charAt(N.length()/2);
            
            StringBuilder rev = new StringBuilder(nextper);
            rev.reverse();
            result += rev.toString();
            
            return result;
        }
        
        else{
            String result = "";
            result += nextper;
            
            
            StringBuilder rev = new StringBuilder(nextper);
            rev.reverse();
            result += rev.toString();
            
            return result;
        }
    }
}
