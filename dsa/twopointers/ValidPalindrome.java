package twopointers;

public class ValidPalindrome {

    public static boolean isValidPalindrome(String str) {
        int left = 0, right = str.length() - 1;
        while (left <= right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isValidPalindrome("racecar"));
        System.out.println(isValidPalindrome("raeacar"));
    }
}
