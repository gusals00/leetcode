package _2023년._10월.easy;

public class Sqrt {
    public int mySqrt(int x) {
        if(x <= 1) return x;
        int start = 1;
        int end = x/2;

        while(start <= end) {
            int mid = (start + end) / 2;

            if(x / mid == mid) {
                return mid;
            } else if(mid >  x / mid) {
                end = mid-1;
            } else {
                start = mid+1;
            }
        }

        return end;
    }
}
