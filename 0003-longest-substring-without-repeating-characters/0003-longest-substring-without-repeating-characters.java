class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int curr=0;
        if (s.length() ==0) return 0;
        HashSet<Character> set = new HashSet<>();
        int left = 0;

        for (int right = 0 ; right< s.length(); right++)
        {
            char x = s.charAt(right);

            while(set.contains(x))
            {
                set.remove(s.charAt(left));
                left++;
                curr--;
            }
            curr++;
            set.add(x);

            max = Math.max(curr, max);
        }
       
                
      

        return max ;
    }
}