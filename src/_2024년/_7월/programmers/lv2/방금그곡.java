package _2024년._7월.programmers.lv2;

public class 방금그곡 {
    public String solution(String m, String[] musicinfos) {
        String result = "(None)";
        int maxPlayTime = 0;
        m = changeMelody(m);

        for(int i=0; i<musicinfos.length; i++) {
            String[] infos = musicinfos[i].split(",");
            int playTime = getPlayTime(infos);
            String melody = changeMelody(infos[3]);

            if(melody.length() > playTime) {
                melody = melody.substring(0, playTime);
            } else if(melody.length() < playTime) {
                melody = melody.repeat(playTime/melody.length() + 1);
                melody = melody.substring(0, playTime);
            }


            if(melody.contains(m) && maxPlayTime < playTime) {
                maxPlayTime = playTime;
                result = infos[2];
            }
        }

        return result;
    }

    private int getPlayTime(String[] infos) {
        String[] start = infos[0].split(":");
        String[] end = infos[1].split(":");
        int startTime = Integer.parseInt(start[0]) * 60 + Integer.parseInt(start[1]);
        int endTime = Integer.parseInt(end[0]) * 60 + Integer.parseInt(end[1]);

        return endTime - startTime;
    }

    private String changeMelody(String s) {
        return s.replace("C#", "c")
                .replace("D#", "d")
                .replace("F#", "f")
                .replace("G#", "g")
                .replace("A#", "a")
                .replace("B#", "b");
    }
}
