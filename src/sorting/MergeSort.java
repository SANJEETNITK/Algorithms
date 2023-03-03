package sorting;

public class MergeSort {

    int[] sort(int[] nums) {

        int n = nums.length;
        if(n <= 1) return nums;

        int len1 = n/2;
        int len2 = n - (n/2);

        int firstHalf[] = getSubarray(nums, 0, len1);
        int secondHalf[] = getSubarray(nums, len1, n);

        firstHalf = sort(firstHalf);
        secondHalf = sort(secondHalf);

        int i = 0;
        int i1 = 0;
        int i2 = 0;
        while(i1 < len1 && i2 < len2) {
            if(firstHalf[i1] < secondHalf[i2]) {
                nums[i++] = firstHalf[i1++];
            } else {
                nums[i++] = secondHalf[i2++];
            }
        }

        while(i1 < len1) {
            nums[i++] = firstHalf[i1++];
        }

        while(i2 < len2) {
            nums[i++] = secondHalf[i2++];
        }

        return nums;
    }

    int[] getSubarray(int[] nums, int l, int r) {
        int[] sub = new int[r-l];
        int i = 0;
        while(l < r) {
            sub[i++] = nums[l++];
        }
        return sub;
    }

}
