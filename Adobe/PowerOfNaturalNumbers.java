// { Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] input = new String[2]; 
            input = br.readLine().split(" "); 
            int n = Integer.parseInt(input[0]); 
            int x = Integer.parseInt(input[1]); 
            Solution ob = new Solution();
            System.out.println(ob.numOfWays(n, x));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution
{
    //static int MOD = 1e9 + 7;
    static ArrayList<Integer> square(int n, int x){
        
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        
        for(int i=2; Math.pow(i,x)<=n;i++){
            int val =  (int)Math.pow(i,x);
            arr.add(val);
        }
        
        return arr;
    }
    
    static int backtrack(ArrayList<Integer> squares, int index, int currsum, int target, int[][]dp ){
        
        if(currsum==target){
            
            return 1;
        }    
        
        if(currsum > target || index >= squares.size()){
            return 0;
        }
        
        if(dp[currsum][index] != -1){
            return dp[currsum][index];
        }
        
        int count = 0;
        
        count += backtrack(squares, index+1, currsum + squares.get(index), target,dp);
        count += backtrack(squares, index+1, currsum , target,dp);
        
        dp[currsum][index] = count % 1000000007;
        
        return count % 1000000007;
    }
    
    
    static int numOfWays(int n, int x)
    {
        // code here
        ArrayList<Integer> squares = square(n,x);
        int[][]dp = new int[n+1][squares.size()];
        
        for(int[]i: dp){
            Arrays.fill(i,-1);
        }
        return backtrack(squares,0, 0,n,dp);
    }
}