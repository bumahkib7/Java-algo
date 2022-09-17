package org.example;

public class Euclid {
    /*
    What is Euclid algorithm?
    Euclid algorithm is a method to find the greatest common divisor of two numbers.
    It is based on the following principle:
    If a > b, then gcd(a, b) = gcd(a - b, b)
    If a < b, then gcd(a, b) = gcd(a, b - a)
    If a = b, then gcd(a, b) = a
     */

    /*
    what is the most efficient way to solve euclid algorithm?
    The most efficient way to solve euclid algorithm is to use recursion.
     */

    /*
    why are memoization and dynamic programming not used in this algorithm?
    Memoization and dynamic programming are used to solve problems that have overlapping sub-problems.
    In this algorithm, there are no overlapping sub-problems.
     */

    /*
    why is the iterative solution not efficient?
    The iterative solution is not efficient because it has to go through the whole loop to find the gcd.
     */
    public static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    //memoized version of gcd
    public static int gcdMemoized(int a, int b, int[][] memo) {

        if (memo[a][b] != 0) {
            return memo[a][b];
        } else if (b == 0) {
            return a;
        } else {
            memo[a][b] = gcdMemoized(b, a % b, memo);
            return memo[a][b];
        }
    }

    //iterative version of gcd
    public static int gcdIterative(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }


    public static void main(String[] args) {
        System.out.println(gcd(54, 888));
        System.out.println(gcdIterative(54, 888));
        System.out.println(gcdMemoized(7, 8, new int[1000][1000]));
    }
}
