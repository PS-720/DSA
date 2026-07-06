import java.util.*;
class ReverseWords {
    public String reverseWords(String s) {
        StringBuilder result = new StringBuilder();
        int i = s.length() - 1;

        while (i >= 0) {
            // To remove trailing whitespaces
            while (i >= 0 && s.charAt(i) == ' ') {
                i--;
            }
            // Check value of i
            if(i < 0) {
                break;
            }
            int j = i;
            // Find the start index of word
            while(j >= 0 && s.charAt(j) != ' ') {
                j--;
            }
            // Append the word
            result.append(s.substring(j+1, i+1));
            // Remove extra space
            while (j >= 0 && s.charAt(j) == ' ') {
                j--;
            }
            if(j >= 0) {
                result.append(' ');
            }
            i = j;
        }
        return result.toString();
    }
    public static void main(String[] args) {
        ReverseWords rw = new ReverseWords();
        String s = "  Hello   World  ";
        String reversed = rw.reverseWords(s);
        System.out.println(reversed);
    }
}