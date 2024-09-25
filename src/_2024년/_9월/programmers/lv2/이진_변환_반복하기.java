package _2024년._9월.programmers.lv2;

public class 이진_변환_반복하기 {
    public int[] solution(String s) {
        int zeroCount = 0;
        int transCount = 0;

        while(s.length() > 1) {
            int oneCount = 0;
            for(int i=0; i<s.length(); i++) {
                if(s.charAt(i) == '0') {
                    zeroCount++;
                } else {
                    oneCount++;
                }
            }

            s = Integer.toBinaryString(oneCount);
            transCount++;
        }

        return new int[]{transCount, zeroCount};
    }
}
