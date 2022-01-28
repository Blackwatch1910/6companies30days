// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            
            
            // input n array elements
            String s = read.readLine();

            Solution ob = new Solution();
        
            System.out.println(ob.amendSentence(s));
        }
    } 
} // } Driver Code Ends


//User function Template for Java

 class Solution{
    public String amendSentence(String s){
        //code here
        
        ArrayList<Character> res = new ArrayList<>();
        int index = 0;
        for(char c : s.toCharArray()){
            if(c >= 65 && c <= 90){
                if(index != 0)
                    res.add((char)32);
                    res.add((char)(c+32));
            } else {
                res.add(c);
            }
            index++;
        }

        StringBuilder sb = new StringBuilder();
 
        for (Character ch : res) {
            sb.append(ch);
        }
 
        String ans = sb.toString();
        
        return ans;
    }
}

