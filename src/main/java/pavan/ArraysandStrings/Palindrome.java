package src.main.java.pavan.ArraysandStrings;
//A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.
//Given a string s, return true if it is a palindrome, or false otherwise.

public class Palindrome {
    public static void main(String[] args) {
        String input = "adf k2,da";
       // System.out.println(isPalindrome(input));
        //System.out.println(isPalindromeOptimized(input));

        System.out.println(longestPalindrome(input));
    }

    //Using Character and String built-in methods 
    private static boolean isPalindrome(String input) {
        StringBuilder reversed = new StringBuilder();
        StringBuilder cleanedInput = new StringBuilder();
        for(int i=input.length()-1,j=0; i>=0 && j<input.length(); i--, j++){
            char c1 = input.charAt(i);
            char c2 = input.charAt(j);
            if(Character.isLetterOrDigit(c1)) {
                reversed.append(Character.toLowerCase(c1));
            }
            if(Character.isLetterOrDigit(c2)) {
                cleanedInput.append(Character.toLowerCase(c2));
            }    
        }
        return reversed.toString().equals(cleanedInput.toString());
    }

    // No built in methods
    private static boolean isPalindromeOptimized(String input) {
        int left = 0;
        int right = input.length()-1;

        while(left < right) {
            while(left < right && !isAlphaNumberic(input.charAt(left))) { //just skipping the non alphanumberic
                 left++;
            }
            while(left < right && !isAlphaNumberic(input.charAt(right))) { //just skipping the non alphanumberic
                right--;
            }
            char cleft = toLowerCase(input.charAt(left));
            char cright = toLowerCase(input.charAt(right));
            System.out.println(cleft + ":2:" + cright); //adf kF,da
            if(cleft != cright) {
                System.out.println(cleft + ":3:" + cright);
                return false;
            }

            left++;
            right--;
        }
        return true;
    }

    //Helper method to check alphanumberic character
    private static boolean isAlphaNumberic(char c){
        return c>='A' && c<='Z' || c>='a' && c<='z' || c>='0' && c<='9';
    }

    //Helper method to convert to LowerCase
    private static char toLowerCase(char c) {
        return c >='A' && c<='Z' ? (char) (c+32) : c;
    }

    // Extract longest possible Palindrome from given String
   /*  private static String longestPalindrome(String input) {
        //adfbbmttmmbFk
        StringBuilder longPalindrome = new StringBuilder();
        int left = 0;
        int right = input.length()-1;

        while(left < right) {
            if(input.charAt(left) == input.charAt(right)) {
                longPalindrome+
            }
        }

        return longPalindrome.toString();
    }*/
}
