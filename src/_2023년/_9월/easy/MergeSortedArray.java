package _2023년._9월.easy;

public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p = m-1;
        int p2 = n-1;
        int k = n+m-1;

        while(p>=0 && p2>=0) {
            if(nums1[p] > nums2[p2]) {
                nums1[k--] = nums1[p--];
            } else {
                nums1[k--] = nums2[p2--];
            }
        }

        while(p2>=0) {
            nums1[k--] = nums2[p2--];
        }
    }
}
