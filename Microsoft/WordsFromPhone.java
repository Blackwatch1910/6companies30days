// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class PhoneDigit
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();//testcases
        
        
        while(t-- > 0)
        {
            int n = sc.nextInt(); // input size of array
            int arr[] = new int[n]; //input the elements of array that are keys to be pressed
            
            for(int i = 0; i < n; i++)
               arr[i] = sc.nextInt();//input the elements of array that are keys to be pressed
            ArrayList <String> res = new Solution().possibleWords(arr, n);
            for (String i : res) System.out.print (i + " ");
             System.out.println();
              
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    static String keypad[] = new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    //Function to find list of all words possible by pressing given numbers.
    static ArrayList <String> possibleWords(int a[], int N)
    {
        // your code here  
        return func("",a,0,N); 
    }
    static ArrayList<String> func(String p,int a[], int index, int n){
        ArrayList<String> res = new ArrayList<>();
        if (index == n){
            res.add(p);
            return res;
        }
        
        String s = keypad[a[index]];
        for(int i = 0; i < s.length(); i++){
            res.addAll(func(p + s.charAt(i), a, index + 1, n));
        }
        return res;
    }
}