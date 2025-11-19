class Solution {
    public int longestConsecutive(int[] nums) {

        if (nums.length == 0) return 0;

        HashSet<Integer> set = new HashSet<>();
        for (int x : nums) set.add(x);

        int longest = 0;

        for (int n : set) {

            if (!set.contains(n - 1)) {

                int curr = n;
                int length = 1;

                while (set.contains(curr + 1)) {
                    curr++;
                    length++;
                }

                longest = Math.max(longest, length);
            }
        }

        return longest;
    }
}
