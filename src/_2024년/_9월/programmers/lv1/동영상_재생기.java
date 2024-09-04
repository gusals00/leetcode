package _2024년._9월.programmers.lv1;

public class 동영상_재생기 {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int length = getTime(video_len);
        int position = getTime(pos);
        int opStart = getTime(op_start);
        int opEnd = getTime(op_end);

        for (String command : commands) {
            if(opStart <= position && position <= opEnd) {
                position = opEnd;
            }

            if(command.equals("prev")) {
                position -= 10;
                if(position < 0) {
                    position = 0;
                }
            } else {
                position += 10;
                if(length < position) {
                    position = length;
                }
            }

            if(opStart <= position && position <= opEnd) {
                position = opEnd;
            }
        }

        StringBuilder sb = new StringBuilder();
        if(position/60 < 10) {
            sb.append("0");
        }
        sb.append(position/60).append(":");
        if(position%60 < 10) {
            sb.append("0");
        }
        sb.append(position%60);

        return sb.toString();
    }

    private int getTime(String str) {
        String[] split = str.split(":");
        return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
    }
}
