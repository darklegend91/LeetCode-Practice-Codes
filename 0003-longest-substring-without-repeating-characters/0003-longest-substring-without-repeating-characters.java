class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() ==0) return 0;
        HashSet<Character> set = new HashSet<>();

        int len = 1;

        char[] arr = s.toCharArray();

        int left = 0 ;
        int right = 0 ;

        for (right =0 ; right < arr.length; right++)
        {
            while (set.contains(arr[right]))
            {
                set.remove(arr[left]);
                left++;
            }
            set.add(arr[right]);
            len = Math.max(len , right - left +1);
        }

        return len;
    }
}