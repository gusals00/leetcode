package _2024년._5월.programmers.lv2;

public class 이모티콘_할인행사 {
    private int sign = 0;
    private int price = 0;

    public int[] solution(int[][] users, int[] emoticons) {
        dfs(new int[emoticons.length], emoticons, users, 0);

        return new int[]{sign, price};
    }

    private void dfs(int[] percents, int[] emoticons, int[][] users, int index) {
        if(index == emoticons.length) {
            int sign = 0;
            int price = 0;

            for(int i=0; i<users.length; i++) {
                int sum = 0;
                for(int j=0; j<percents.length; j++) {
                    if(users[i][0] <= percents[j]) {
                        sum += emoticons[j] * (1 - (double)percents[j]/100);
                    }
                }

                if(sum >= users[i][1]) {
                    sign++;
                } else {
                    price += sum;
                }
            }

            if(this.sign < sign) {
                this.sign = sign;
                this.price = price;
            } else if(this.sign == sign) {
                this.price = Math.max(price, this.price);
            }

            return;
        }

        for(int i=10; i<=40; i+=10) {
            percents[index] = i;
            dfs(percents, emoticons, users, index+1);
        }
    }
}
