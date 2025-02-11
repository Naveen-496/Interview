package twopointers;

public class Palindrome2 {

    public static boolean isValidPalindromeTwo(String s) {
        if (isPalindrome(s)) {
            return true;
        }

        for (int i = 0; i < s.length(); i++) {
            String newStr = s.substring(0, i) + s.substring(i + 1);
            if (isPalindrome(newStr)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isValidPalindromeTwoPointers(String s) {
        int left = 0, right = s.length() - 1;
        while (left <= right) {
            if (s.charAt(left) != s.charAt(right)) {
                return isPalindrome(s.substring(0, left) + s.substring(left + 1))
                        || isPalindrome(s.substring(0, right) + s.substring(right + 1));
            }
            left++;
            right--;
        }
        return true;
    }

    public static boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left <= right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static boolean isValidPalindromeTwoPointersOptimal(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return isPalindrome(s, l + 1, r) || isPalindrome(s, l, r - 1);
            }
            l++;
            r--;
        }
        return true;
    }

    public static boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isValidPalindromeTwo("abcda"));
    }
}
