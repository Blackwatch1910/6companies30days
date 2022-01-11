// { Driver Code Starts
    import java.util.*;
 
    class Encoding
    {
       public static void main(String[] args) 
       {
     
          Scanner sc = new Scanner(System.in);
        
          int T = sc.nextInt();
          sc.nextLine();
          while(T>0)
          {
              
            String str = sc.nextLine();
            
            GfG g = new GfG();
            System.out.println(g.encode(str));
            
          
            T--;
          }
       }
    }
    
    // } Driver Code Ends
    
    
    class GfG
     {
        String encode(String str)
        {
              //Your code here
              String s = "";
               int count = 1;
            for (int i = 0; i < str.length(); i++) {
                if (i < str.length() - 1 && str.charAt(i) == str.charAt(i + 1)) {
                    count++;
                } else {
                    s = s + str.charAt(i) + count;
                    count=1;
                }
            }
            return s;
        }
        
     }