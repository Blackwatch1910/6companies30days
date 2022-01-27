// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        
        int t = Integer.parseInt(sc.next());
        while(t>0)
        {
            int n = Integer.parseInt(sc.next());
            Solution T = new Solution();
            List<String> ans = T.AllParenthesis(n);
            String[] sequences = ans.toArray(new String[0]);
            Arrays.sort(sequences);
            int k = sequences.length;
            for(int i=0;i<k;i++)
            {
                System.out.println(sequences[i]);
            }
            
            t--;
            
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    List<String> res;
    public List<String> AllParenthesis(int n) 
    {
        // Write your code here
        res = new ArrayList<>();
        solve(n,n,"");
        return res;
    }
    
    public void solve(int open,int closed, String s) {
        
       if(open==0 && closed==0){
           res.add(s);
       }
       
       if(open > 0){
           solve(open-1,closed,s+'(');
       }
       
       if(closed>open) {
           solve(open,closed-1,s+')');
       }
    }
}