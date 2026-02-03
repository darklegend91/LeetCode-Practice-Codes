class Solution {

    public int addDigits(int num) {
        
        //Base condition
        if (num <10)
        {
            return num;
        }

        //logic to be implemented
        int sum = 0;

        while (num > 0)
        {
        sum = sum + num%10;
        num= num/10;
        }

        //recursion call;
        return addDigits(sum);
    }
}