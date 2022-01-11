public class DamagedToy {
    
    static int solution(int n, int m, int k) {

        if (m <= n - k + 1)
            return m + k -1;
        
        m = m - (n - k + 1);

        return (m % n == 0) ? n : (m % n);
    }

    public static void main(String[] args) {
        int n = 10;
        int m = 27;
        int k = 3;

        System.out.println(solution(n, m, k));
    }
}
