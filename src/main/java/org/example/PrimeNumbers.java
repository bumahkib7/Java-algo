package org.example;

public class PrimeNumbers {
    public static void main(String[] args) {
        int n = 100;
        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) {
                System.out.println(i);
            }
        }
    }

    public static boolean isPrime(int n) {
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    /*
    what is a prime number?
    A prime number is a number that is only divisible by 1 and itself.
     */

    /*
    solution:
    1. The isPrime function takes in an integer n and returns true if n is a prime number and false if n is not a prime number.
    2. The function loops through all the numbers from 2 to n - 1 and checks if n is divisible by any of them.
    3. If n is divisible by any of the numbers from 2 to n - 1, the function returns false.
    4. If n is not divisible by any of the numbers from 2 to n - 1, the function returns true.
     */
}
