import java.util.*;
class RotatedSorted {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int start = 0;
        int end = n - 1;
        int ans = -1;

        // To find pivot index in the array

        if (nums[start] < nums[end]) {
            return -1;
        }

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] <= nums[n - 1]) {
                end = mid - 1;
            } else {
                ans = mid;
                start = mid + 1;
            }
        }
        return ans;
    }

    public int binarySearch(int[] nums, int target, int min, int max) {

        while (min <= max) {
            int mid = min + (max - min) / 2;

            if (nums[mid] == target)
                return mid;
            else if (nums[mid] < target)
                min = mid + 1;
            else
                max = mid - 1;
        }
        return -1;
    }

    public int search(int[] nums, int target) {

        int pIndex = pivotIndex(nums);
        int n = nums.length;

        if (pIndex == -1) {
            int ans = binarySearch(nums, target, 0, n - 1);
            return ans;
        }

        else {
            if (target >= nums[0] && target <= nums[pIndex]) {
                int ans = binarySearch(nums, target, 0, pIndex);
                return ans;
            } else if (target >= nums[pIndex + 1] && target <= nums[n - 1]) {
                int ans = binarySearch(nums, target, pIndex + 1, n - 1);
                return ans;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        RotatedSorted obj = new RotatedSorted();
        int[] nums = { 4, 5, 6, 7, 0, 1, 2 };
        int target = 0;
        int ans = obj.search(nums, target);
        System.out.println(ans);
    }
}