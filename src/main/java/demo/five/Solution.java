package demo.five;

public class Solution {
    public static String longestPalindrome(String s) {
        int l = s.length();
        //return the string if string ls length 0 or 1;
        if (l == 0 || l == 1) {
            return s;
        }
        int[][] isPalindrome = new int[l][l];

        for (int i = 0; i < l; i++) {
            isPalindrome[i][i] = 1;
        }
        int start = 0;
        int maxLength = 1;
        for (int i = 0; i < l - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                isPalindrome[i][i + 1] = 1;
                start = i;
                maxLength = 2;
            }
        }
        //from length k=3 to length k=l see any substring is a palindrome
        for (int k = 3; k <= l; k++) {
            for (int i = 0; i < l - k + 1; i++) {
                int j = i + k - 1;
                if (isPalindrome[i + 1][j - 1] == 1 && s.charAt(i) == s.charAt(j)) {
                    start = i;
                    maxLength = k;
                    isPalindrome[i][j] = 1;
                }
            }
        }
        return s.substring(start, start + maxLength);
    }

    public static void main(String[] args) {
        System.err.println(longestPalindrome("abbd"));
    }
}
