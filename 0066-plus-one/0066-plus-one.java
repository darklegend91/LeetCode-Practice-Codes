class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        
        for (int i = n-1; i>=0 ;i--)
        {
            //If i get a elemnt not equal to 9 then just add one in it and return the code
            if (digits[i] != 9)
            {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }

// all are 9 and no if condition is ran;
        int [] res = new int[n+1];

        res[0] = 1;
        return res;
        
    }
}