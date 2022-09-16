package org.example;

public class IsPalindrome {
    //recursive function to check if a string is a palindrome
    public static boolean isPalindrome(String s) {
        if (s.length() <= 1) {
            return true;
        } else {
            return s.charAt(0) == s.charAt(s.length() - 1) && isPalindrome(s.substring(1, s.length() - 1));
        }
    }


    //solving the problem iteratively
    public static boolean isPalindromeIterative(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }


}
