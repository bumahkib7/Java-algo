package org.example;

public class FibonacciNumbers {
    public static void main(String[] args) {
        System.out.println(fibonacci(10));
    }
    /*
    WHAT IS FIBONACCI?
    Fibonacci is a sequence of numbers where each number is the sum of the two preceding numbers.
     */

    /*
    WHAT IS RECURSION?
    Recursion is a method of solving a problem where the solution depends on solutions to smaller instances of the same problem.
     */

    /*
    WHAT IS THE BASE CASE?
    The base case is the simplest case of the problem that can be solved without further recursion.
     */

    /*
    WHAT IS THE RECURSIVE CASE?
    The recursive case is the case where the problem is not yet solved and the solution depends on the solution to a smaller instance of the same problem.
     */

    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }
    /*
    explanation:
    1. The fibonacci function takes in an integer n and returns the nth fibonacci number.
    2. The function checks if n is less than or equal to 1, if it is, it returns n.
     */

    //iterative solution
    public static int fibonacciIterative(int n) {
        int a = 0;
        int b = 1;
        int c = 0;
        for (int i = 0; i < n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return a;
    }

    /*
    explanation of the iterative solution:
    0 1 1 2 3 5 8 13 21 34 55
    a b c
    a = 0
    b = 1
    c = 0
    i = 0
    c = a + b = 0 + 1 = 1
    a = b = 1
    b = c = 1
    i = 1
    c = a + b = 1 + 1 = 2
    a = b = 1
    b = c = 2
    i = 2
    c = a + b = 1 + 2 = 3
    a = b = 2
    b = c = 3
     */

    //recursive solution
    public static int fibonacciRecursive(int n) {
        if (n <= 1) {
            return n;
        } else {
            return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
        }
    }

    //memoization solution
    public static int fibonacciMemoization(int n, int[] memo) {
        if (memo[n] != 0) {
            return memo[n];
        }
        if (n <= 1) {
            memo[n] = n;
        } else {
            memo[n] = fibonacciMemoization(n - 1, memo) + fibonacciMemoization(n - 2, memo);
        }
        return memo[n];
    }
    /*
    explanation of the memoization solution:
    1. The fibonacciMemoization function takes in an integer n and an array of integers memo.
    2. The function checks if the value at the nth index of the memo array is not equal to 0, if it is not, it returns the value at the nth index of the memo array.
    3. The function checks if n is less than or equal to 1, if it is, it sets the value at the nth index of the memo array to n.
    4. The function sets the value at the nth index of the memo array to the sum of the fibonacciMemoization function called with n - 1 and memo and the fibonacciMemoization function called with n - 2 and memo.
    5. The function returns the value at the nth index of the memo array.
     */
}
