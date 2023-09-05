package _2023년._9월.easy;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        String result = strs[0];
        for(int i=1; i<strs.length && !result.isEmpty(); i++) {
            char[] chars = strs[i].toCharArray();
            char[] chars2 = result.toCharArray();
            int length = 0;
            for(int j=0; j<chars.length && j<chars2.length; j++) {
                if(chars[j] == chars2[j])
                    length++;
                else
                    break;
            }

            result = strs[i].substring(0, length);
        }

        return result;
    }
}
