package _2024년._4월.medium;

public class CompareVersionNumbers {
    public int compareVersion(String version1, String version2) {
        String[] first = version1.split("\\.");
        String[] second = version2.split("\\.");

        int maxLength = Math.max(first.length, second.length);
        for(int i=0; i<maxLength; i++) {
            int one = i >= first.length ? 0 : Integer.parseInt(first[i]);
            int two = i >= second.length ? 0 : Integer.parseInt(second[i]);

            if(one < two) {
                return -1;
            } else if(one > two){
                return 1;
            }
        }

        return 0;
    }
}
