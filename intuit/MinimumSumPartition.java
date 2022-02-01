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
                    int n = sc.nextInt();
                    int A[] = new int[n];
                    for(int i = 0;i<n;i++)
                        A[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minDifference(A,n));
                }
                sc.close();
        }
}    // } Driver Code Ends


//User function Template for Java

class Solution
{

	public int minDifference(int arr[], int n) 
	{ 
	    // Your code goes here
	    if(n == 0) {
            return -1;
        }
    
        int sumOfArray = 0;
        for(int i = 0; i < n; i++) {
          sumOfArray = sumOfArray + arr[i];
        }
        
        int sum = sumOfArray / 2;
        
        boolean[][] mat = new boolean[n][sum + 1];
        
        for(int i = 0; i < n; i++) {
          mat[i][0] = true;
        }
        
        for(int j = 0; j <= sum; j++) {
          if(j == arr[0]) {
            mat[0][j] = true;
          }
        }
        
        for(int i = 1; i < n; i++) {
          for(int j = 1; j <= sum; j++) {
            
            if(mat[i - 1][j]) {
              mat[i][j] = true;
            } else {
              if(j >= arr[i]) {
                mat[i][j] = mat[i - 1][j - arr[i]];  
              }
            }
          }
        }
        
        int lastRow = n - 1;
        int firstPartitionSum = -1;
        
        for(int j = sum; j >= 0; j--) {
          if(mat[lastRow][j]) {
            firstPartitionSum = j;
            break;
          }
        }
        
        int secondPartitionSum = sumOfArray - firstPartitionSum;
        
        return Math.abs(firstPartitionSum - secondPartitionSum);
	} 
}
