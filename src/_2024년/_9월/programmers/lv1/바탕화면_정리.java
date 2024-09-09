package _2024년._9월.programmers.lv1;

public class 바탕화면_정리 {
    public int[] solution(String[] wallpaper) {
        int[] result = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE, -1, -1};

        for(int i=0; i<wallpaper.length; i++) {
            char[] chars = wallpaper[i].toCharArray();
            for(int j=0; j<chars.length; j++) {
                if (chars[j] == '#') {
                    result[0] = Math.min(result[0], i);
                    result[1] = Math.min(result[1], j);
                    result[2] = Math.max(result[2], i+1);
                    result[3] = Math.max(result[3], j+1);
                }
            }
        }

        return result;
    }
}
