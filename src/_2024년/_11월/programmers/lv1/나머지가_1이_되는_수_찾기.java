package _2024년._11월.programmers.lv1;

public class 나머지가_1이_되는_수_찾기 {
    public int solution(int n) {
        for(int i=1; i<n; i++) {
            if(n%i == 1) {
                return i;
            }
        }

        return -1;
    }
}
