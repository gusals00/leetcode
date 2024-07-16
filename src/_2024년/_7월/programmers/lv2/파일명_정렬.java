package _2024년._7월.programmers.lv2;

import java.util.Arrays;

public class 파일명_정렬 {
    public String[] solution(String[] files) {
        Arrays.sort(files, (o1, o2) -> {
            String[] headAndNumber = getHeadAndNumber(o1.toLowerCase());
            String[] headAndNumber2 = getHeadAndNumber(o2.toLowerCase());

            if(!headAndNumber[0].equals(headAndNumber2[0])) {
                return headAndNumber[0].compareTo(headAndNumber2[0]);
            } else {
                return Integer.compare(Integer.parseInt(headAndNumber[1]), Integer.parseInt(headAndNumber2[1]));
            }
        });

        return files;
    }

    private String[] getHeadAndNumber(String str) {
        String head = str.split("[0-9]")[0];
        String other = str.substring(head.length());

        StringBuilder sb = new StringBuilder();
        char[] chars = other.toCharArray();
        for(int i=0; i<chars.length && Character.isDigit(chars[i]) && sb.length() < 5; i++) {
            sb.append(chars[i]);
        }

        return new String[]{head, sb.toString()};
    }
}
