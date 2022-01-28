// { Driver Code Starts
    import java.io.*;
    import java.util.*;
    
    class GfG
    {
        public static void main (String[] args)
        {
            
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            
            while(t-- > 0)
            {
                int n = sc.nextInt();
                String arr[] = new String[n];
                
                for(int i = 0; i < n; i++)
                    arr[i] = sc.next();
                
                Solution obj = new Solution();    
                String result[] = obj.winner(arr, n);
                System.out.println(result[0] + " " + result[1]);
                
               
            }
            
        }
    }
    // } Driver Code Ends
    
    
    //User function Template for Java
    
    
    class Solution
    {
        //Function to return the name of candidate that received maximum votes.
        public static String[] winner(String arr[], int n)
        {
            // add your code
            Map<String, Integer> map = new HashMap<>();
            int maxVotes = 0;
            
            for (String s: arr) {
                map.put(s, map.getOrDefault(s, 0) + 1);
                if (map.get(s) > maxVotes)
                    maxVotes = map.get(s);
            }
            
            List<String> names = new ArrayList<>();
            
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                if (entry.getValue() == maxVotes) {
                    names.add(entry.getKey());
                }
            }
            
            String name = getName(names);
            return new String[] {name, String.valueOf(maxVotes)};
        }
        
        private static String getName(List<String> list) {
            String min = list.get(0);
            
            for (int i = 1; i < list.size(); i++) {
                if (list.get(i).compareTo(min) < 0) {
                    min = list.get(i);
                }
            }
            return min;
        }
    }
    
    