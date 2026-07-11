class BinarySearch {
    public int solve(int[] nums, int target, int start, int end) {
        if (start > end)
            return -1;

        int mid = start + (end - start) / 2;
        if (nums[mid] == target)
            return mid;
        else if (nums[mid] < target)
            return solve(nums, target, mid + 1, end);
        else
            return solve(nums, target, start, mid - 1);
    }

    public int search(int[] nums, int target) {
        int n = nums.length - 1;
        int ans = solve(nums, target, 0, n);
        return ans;
    }

    public static void main(String[] args) {
        BinarySearch bs = new BinarySearch();
        int[] nums = { -1, 0, 3, 5, 9, 12 };
        int target = 9;
        System.out.println(bs.search(nums, target));
    }
}