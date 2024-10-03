package _2024년._10월.programmers.lv2;

public class 양궁대회 {
    private int[] result = new int[11];
    private int maxScore = Integer.MIN_VALUE;

    public int[] solution(int n, int[] info) {
        getScore(0, 0, n, info, 0, new int[11]);

        boolean flag = false;
        for(int i=0; i<result.length; i++) {
            if(result[i] != 0) {
                flag = true;
                break;
            }
        }

        if(flag) {
            return result;
        } else {
            return new int[]{-1};
        }
    }

    private void getScore(int apeachScore, int ryanScore, int remainArrow, int[] info, int index, int[] result) {
        if(index == 11) {
            int diff = ryanScore - apeachScore;
            if(diff > 0 && maxScore <= diff) {
                int[] clone = result.clone();
                if(remainArrow > 0) {
                    clone[10] += remainArrow;
                }

                if(maxScore == diff) {
                    for(int i=10; i>=0; i--) {
                        if(clone[i] > this.result[i]) {
                            this.result = clone;
                            return;
                        } else if(clone[i] < this.result[i]) {
                            return;
                        }
                    }
                } else {
                    maxScore = diff;
                    this.result = clone;
                }
            }

            return;
        }

        if(remainArrow > info[index]) {
            result[index] += info[index] + 1;
            getScore(apeachScore, ryanScore+(10-index), remainArrow-(info[index]+1), info, index+1, result);
            result[index] -= info[index] + 1;
        }

        if(info[index] == 0) {
            getScore(apeachScore, ryanScore, remainArrow, info, index+1, result);
        } else {
            getScore(apeachScore+(10-index), ryanScore, remainArrow, info, index+1, result);
        }
    }
}
