package _2024년._4월.medium;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        partition(result, new ArrayList<>(), 0, s);

        return result;
    }

    private void partition(List<List<String>> result, List<String> list, int index, String s) {
        if(s.length() == index) {
            result.add(new ArrayList<>(list));
            return;
        }

        for(int i = index; i<s.length(); i++) {
            if(isPalindrome(index, i, s)) {
                list.add(s.substring(index, i+1));
                partition(result, list, i+1, s);
                list.remove(list.size()-1);
            }
        }
    }

    private boolean isPalindrome(int start, int end, String s) {
        while(start <= end) {
            if(s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }
}
