// { Driver Code Starts
    import java.util.*;
    import java.lang.String;
    import java.lang.Math;
    class Main{
        public static void main(String[] args){
            Scanner sc=new Scanner(System.in);
            int t=sc.nextInt();
            while(t-->0){
                String s=sc.next();
                GfG g=new GfG();
                System.out.println(g.missingNumber(s));
            }
        }
    }// } Driver Code Ends
    
    
    /*Complete the function below*/
    class GfG
    {
        static String helper(String s, int i, String next, String missing, int len) {
           
           if(i == s.length()){
               return missing;
           }
           
           if(i > s.length() || i + len > s.length() || s.charAt(i) == '0'){
               return "";
           }
           String res;
           String n = s.substring(i, i + len);
           String nPlusOne = nextN(n);
           if(n.equals(next)){
                res = helper(s, i + len, nPlusOne, missing, len);
                if(!res.equals("")){
                   return res;
                }
           }else if(n.equals(nextN(next)) && missing.equals("")){
                res = helper(s, i + len, nPlusOne, next, len);
                if(!res.equals("")){
                   return res;
               }
           }
           return helper(s, i, next, missing, len + 1);
        }
    
            static String nextN(String n){
                char[] arr = n.toCharArray();
                int sum = (arr[n.length() - 1] - '0') + 1;
                int carry = sum / 10;
                arr[n.length() - 1] = (char)(sum % 10 + '0');
                for(int i = n.length() - 2; i >= 0; i--){
                    sum = arr[i] - '0' + carry;
                    arr[i] = (char)(sum % 10 + '0');
                    carry = sum / 10;
                }
                if(carry != 0)
                    return "" + carry + new String(arr);
                return new String(arr);
            }
        
        public int missingNumber(String s)
           {
           //add code here.
            for(int i = 0; i < s.length(); i++){
           String n = s.substring(0, i + 1);
           String nPlusOne = nextN(n);
           String res = helper(s, i + 1, nPlusOne, "", i + 1);
           if(!res.equals("")){
               return Integer.parseInt(res);
           }
       }
       return -1;
           }
    }
    