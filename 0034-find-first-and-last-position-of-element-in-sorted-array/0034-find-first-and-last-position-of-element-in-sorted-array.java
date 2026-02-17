class Solution {
    public int[] searchRange(int[] nums, int target) {
        int ans[] = {-1, -1};

        if (nums.length == 0) return ans;

        int val = binarySearch(nums, target, 0, nums.length - 1);
        if (val == -1) return ans;

        int right = val;
        while (right + 1 < nums.length && nums[right + 1] == target) {
            right++;
        }

        int left = val;
        while (left - 1 >= 0 && nums[left - 1] == target) {
            left--;
        }

        ans[0] = left;
        ans[1] = right;

        return ans;
    }

    private int binarySearch(int[] nums, int target, int left, int right) {
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            } 
            else if (nums[mid] > target) {
                right = mid - 1;
            } 
            else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
