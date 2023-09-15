package _2023년._9월.easy;

public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        int[] arr = new int[256];
        int[] arr2 = new int[256];

        for(int i=0; i<s.length(); i++) {
            if(arr[s.charAt(i)] != arr2[t.charAt(i)])
                return false;

            arr[s.charAt(i)] = i+1;
            arr2[t.charAt(i)] = i+1;
        }

        return true;
    }
}

