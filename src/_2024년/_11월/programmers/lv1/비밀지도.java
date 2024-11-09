package _2024년._11월.programmers.lv1;

public class 비밀지도 {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] result = new String[n];
        for(int i=0; i<n; i++) {
            String binary1 = addZero(n, Integer.toBinaryString(arr1[i]));
            String binary2 = addZero(n, Integer.toBinaryString(arr2[i]));

            StringBuilder sb = new StringBuilder();
            for(int j=0; j<n; j++) {
                int binary = (binary1.charAt(j) - '0') | (binary2.charAt(j) - '0');
                if(binary == 1) {
                    sb.append('#');
                } else {
                    sb.append(' ');
                }
            }

            result[i] = sb.toString();
        }

        return result;
    }

    private String addZero(int n, String s) {
        while(s.length() < n) {
            s = "0" + s;
        }

        return s;
    }
}
