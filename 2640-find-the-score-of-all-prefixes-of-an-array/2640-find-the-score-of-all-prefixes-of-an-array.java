class Solution {
    public long[] findPrefixScore(int[] nums) {
        long sum = 0;
        int maxEle=0;
        long[] nums1 = new long[nums.length];

        for (int i = 0 ; i< nums.length; i++)
        {
            maxEle = Math.max(maxEle , nums[i]);
            sum = sum + nums[i] + maxEle;
            nums1[i] = sum;
        }
        return nums1;
    }
}