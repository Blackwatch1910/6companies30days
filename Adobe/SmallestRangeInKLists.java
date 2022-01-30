// { Driver Code Starts
    import java.util.*;
    import java.io.*;
    import java.lang.*;
    
    public class DriverClass
    {
        public static void main(String args[]) 
        {
           Scanner sc = new Scanner(System.in);
           int t = sc.nextInt();
           int range[];
           while(t-- >0)
           {
             int n = sc.nextInt();
             int k = sc.nextInt();
             int arr[][] = new int[k][n];
               for(int i = 0; i < k; i++)
               {
                for(int j = 0; j < n; j++)
                       arr[i][j] = sc.nextInt();
               }
               range = new Solution().findSmallestRange(arr, n, k);
               System.out.println(range[0] + " " + range[1]);
           }
        }
    }
    // } Driver Code Ends
    
    
    class comp implements Comparator<int[]>{
            public int compare(int[] ar1 , int[] ar2){
                return ar1[0] - ar2[0];
            }
        }
        
    class Solution
    {
        static int[] findSmallestRange(int[][] KSortedArray,int n,int k)
        {
            //add your code here
            PriorityQueue<int[]> pq = new PriorityQueue<>(new comp());
        int[] res = {0,1000000};
        int max = Integer.MIN_VALUE;
        
        for(int i=0 ;i<k;i++){
            int val = KSortedArray[i][0];
            int[] temp = {val , 0 , i};
            max = Math.max(max , val);
            pq.add(temp);
        }
        
        while(true){
            int[] min = pq.poll();
            if(res[1] - res[0] > max - min[0]){
                res[1] = max;
                res[0] = min[0];
            }
            min[1]++;
            if(min[1] == n)
                break;
            if(KSortedArray[min[2]][min[1]] > max){
                max = KSortedArray[min[2]][min[1]];
            }
            int temp[]  = {KSortedArray[min[2]][min[1]] , min[1] , min[2]};
            pq.add(temp);
        }
        
        return res;
        }
    }