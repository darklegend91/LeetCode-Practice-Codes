class Solution {
    public long minimumSteps(String str) {
        int s = 0;
        int e = 0 ;

        long count =0 ;

        for (; e<str.length(); e++)
        {
            if (str.charAt(e) == '0')
            {
                count = count + (e-s);
                s++;
            }
        }
        return count;
    }
}