package _2024년._10월.programmers.lv2;

public class 조이스틱 {
    public int solution(String name) {
        int result = 0;
        int move = name.length()-1;

        for(int i=0; i<name.length(); i++) {
            result += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i)+1);

            int index = i+1;
            while(index < name.length() && name.charAt(index) == 'A') {
                index++;
            }

            move = Math.min(move, Math.min(i*2 + name.length()-index, (name.length()-index)*2 + i));
        }

        return result + move;
    }
}
