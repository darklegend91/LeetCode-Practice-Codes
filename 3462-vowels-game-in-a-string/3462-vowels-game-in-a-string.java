class Solution {
    public boolean doesAliceWin(String s) {
        String Vowels = "aeiou";
        int count =0;
        for ( char c : s.toCharArray())
        {
            if (Vowels.contains(String.valueOf(c)))
            {
                count++;
            }
        }
        if (count%2 !=0)
        {
            return true;
        }
        if (count ==0)
        {
            return false;
        }

        return true;
    }
}