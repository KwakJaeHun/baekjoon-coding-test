package Week3.Day4;

public class DPFibo {
    public static void main(String[] args) {
        System.out.println(fibo(6));
        //System.out.println(fiboDp(10));
        //System.out.println(fiboDpWithoutRecursive(10));
    }

    // 단순 피보나치 수 재귀 구연
    private static int fibo(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        return fibo(n - 1) + fibo(n - 2);
    }

    // 피보나치 수 top-down dp
    private static int fiboDp(int n) {
        int memo[] = new int[n + 1];

        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        if (memo[n] != 0) {
            return memo[n];
        }

        memo[n] = fiboDp(n - 1) + fiboDp(n - 2);

        return memo[n];
    }

    // 피보나치 수 bottom-up dp
    private static int fiboDpWithoutRecursive(int n) {
        int memo[] = new int[n + 1];

        memo[0] = 0;
        memo[1] = 1;

        for (int i = 2; i <= n; i++) {
            memo[i] = memo[i - 1] + memo[i - 2];
        }

        return memo[n];
    }
}













