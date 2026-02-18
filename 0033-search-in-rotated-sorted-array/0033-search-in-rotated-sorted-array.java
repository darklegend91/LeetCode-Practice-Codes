class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int k = 0;
        
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                k = i + 1;
                break;
            }
        }
        if (k == 0) {
            return binarySearch(nums, target, 0, n - 1);
        }

        if (target >= nums[k] && target <= nums[n - 1]) {
            return binarySearch(nums, target, k, n - 1);
        } else {
            return binarySearch(nums, target, 0, k - 1);
        }
    }

    private int binarySearch(int[] nums, int target, int left, int right) {
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
