// { Driver Code Starts
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
                String A = br.readLine().trim();
                Solution ob = new Solution();
                String ans = ob.FirstNonRepeating(A);
                System.out.println(ans);
            }
        }
    }
    // } Driver Code Ends
    
    
    class Solution
    {
        public String FirstNonRepeating(String A)
        {
            // code here
            //char stream[] = A.toCharArray();
                int charCount[] = new int[26];
                Queue<Character> q = new LinkedList<>();
    
                StringBuilder ans = new StringBuilder();
                
                for (int i = 0; i < A.length(); i++) {
                    char ch = A.charAt(i);
    
                    q.add(ch);
    
                    charCount[ch - 'a']++;
    
                    while (!q.isEmpty()) {
                        if (charCount[q.peek() - 'a'] > 1)
                            q.remove();
                        else {
                            ans.append(q.peek());
                            break;
                        }
                    }
                    if (q.isEmpty())
                        ans.append('#');
                }
                return ans.toString();
        }
    }