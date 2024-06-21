package _2024년._6월.programmers.lv2;

public class 큰_수_만들기 {
    public String solution(String number, int k) {
        int length = number.length()-k;
        int start = 0;
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<length; i++) {
            char max = '0';

            for(int j=start; j<=i+k; j++) {
                if(max < number.charAt(j)) {
                    max = number.charAt(j);
                    start = j+1;

                    if(max == '9')
                        break;
                }
            }
            sb.append(max);
        }

        return sb.toString();
    }
}
