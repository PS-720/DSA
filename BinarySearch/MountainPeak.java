import java.util.Arrays;
class MountainPeak {
    public int peakIndexInMountainArray(int[] arr) {
        int n = arr.length;
        int start = 0;
        int end = n - 1;
        int ans = -1;

        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(arr[mid] >= arr[mid + 1]) {
                ans = mid;
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        MountainPeak solution = new MountainPeak();
        int[] arr = {0, 2, 1, 0};
        int result = solution.peakIndexInMountainArray(arr);
        System.out.println("Index of peak element: " + result);
    }
}