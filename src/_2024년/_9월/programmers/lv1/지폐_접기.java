package _2024년._9월.programmers.lv1;

public class 지폐_접기 {
    public int solution(int[] wallet, int[] bill) {
        int result = 0;
        swap(wallet);
        swap(bill);

        while(wallet[0] < bill[0] || wallet[1] < bill[1]) {
            bill[1] /= 2;

            swap(wallet);
            swap(bill);

            result++;
        }

        return result;
    }

    private void swap(int[] arr) {
        if(arr[0] > arr[1]) {
            int temp = arr[0];
            arr[0] = arr[1];
            arr[1] = temp;
        }
    }
}
