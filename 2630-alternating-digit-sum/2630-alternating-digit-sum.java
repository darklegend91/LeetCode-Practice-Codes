class Solution {
    public int alternateDigitSum(int n) {
        int num = n;
        int sum = 0;
        int count =0;
        boolean flag = true;
        //Check if number has even digits or odd digits
        while (n > 0)
        {
            n= n/10;
            count++;
        }

        if ( count % 2 !=0)
        {
        flag = true;
        }
        else
        {
        flag = false;
        }

        while (num > 0)
        {
            if (flag == true)
            {
                sum= sum + num%10;
                num = num/10;
                flag  = !flag;
            }
            else
            {
                sum = sum - num%10;
                num = num/10;
                flag  = !flag;
            }
            
        }

        return sum;
    }
}