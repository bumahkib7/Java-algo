package org.example;

import java.util.Arrays;

public class CrossSum {
    /*
    solve the problem recursively
     */
    public static int crossSum(int n) {
        if (n < 10) {
            return n;
        } else {
            return n % 10 + crossSum(n / 10);
        }

    }
    /*
    explanation of the recursive solution:
    1. if the number is less than 10, return the number
    2. if the number is greater than 10, return the last digit of the number plus the cross sum of the number without the last digit


     */

    /*
    solve the problem iteratively
     */
    public static int crossSumIterative(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
    /*
    explanation of iterative solution:
    12345
    1234
    123
    12
    1

    1 + 2 + 3 + 4 + 5 = 15
     */

    /*
    solve using memoization
     */
    public static int crossSumMemo(int n) {
        int sum = 0;
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        if (memo[n] != -1) {
            return memo[n];
        }
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        memo[n] = sum;
        return sum;
    }

    /*
    explanation of the memoization solution:
    1. The function checks if the memo array has a value at the index n, if it does, it returns the value.
    2. The function sets the value at the index n to the sum of the value at the index n and the value at the index n / 10.
    3. The function returns the value at the index n.
     */


    //Solve using dynamic programming
    public static int crossSumDynamic(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i / 10] + i % 10;
        }
        return dp[n];
    }

    /*
    explanation of the dynamic programming solution:
    1. The function creates an array of integers dp with a length of n + 1.
    2. The function sets the value at the index 0 of the dp array to 0.
    3. The function loops from 1 to n, setting the value at the index i of the dp array to the sum of the value at the index i / 10 and the value at the index i % 10.
    4. The function returns the value at the index n of the dp array.
     */
}
