package _2024년._6월.programmers.lv2;

public class 스킬트리 {
    public int solution(String skill, String[] skill_trees) {
        int result = 0;

        for (String skill_tree : skill_trees) {
            String s = skill_tree.replaceAll("[^" + skill + "]", "");

            if(skill.indexOf(s) == 0) {
                result++;
            }
        }

        return result;
    }
}
