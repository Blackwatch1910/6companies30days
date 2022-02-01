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
                String[] S = br.readLine().trim().split(" ");
                int n = Integer.parseInt(S[0]);
                int m = Integer.parseInt(S[1]);
                char [][] board = new char[n][m];
                for(int i = 0; i < n; i++){
                    String[] s = br.readLine().trim().split(" ");
                    for(int j = 0; j < m; j++){
                        board[i][j] = s[j].charAt(0);
                    }
                }
                String word = br.readLine().trim();
                Solution obj = new Solution();
                boolean ans = obj.isWordExist(board, word);
                if(ans)
                    System.out.println("1");
                else
                    System.out.println("0");
           }
        }
    }// } Driver Code Ends
    
    
    class Solution
    {
        public boolean isWordExist(char[][] board, String word)
        {
            // Code here
            
            char[] w = word.toCharArray();
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    if (exist(board, i, j, w, 0)) 
                        return true;
                }
            }
        return false;
        }
        
        //simple dfs
        
        private boolean exist(char[][] board, int i, int j, char[] word, int x) {
            
        if (x == word.length) 
            return true;
        
        if (i < 0 || j < 0 || i == board.length || j == board[i].length) 
            return false;
        
        if (board[i][j] != word[x]) 
            return false;
        
        board[i][j] ^= 256;
        
        boolean exist = exist(board, i, j + 1, word, x + 1) || exist(board, i, j - 1, word, x + 1) || exist(board, i + 1, j, word, x + 1) || exist(board, i - 1, j, word, x + 1);
                
        board[i][j] ^= 256;
        return exist;
        }
    }