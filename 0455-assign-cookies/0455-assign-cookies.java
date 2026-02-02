class Solution {
    public int findContentChildren(int[] g, int[] s) {

        // define variables
    int m = g.length;
    int n = s.length;

    int l =0;
    int r =0;

    //Sort both arrays
     Arrays.sort(g);
     Arrays.sort(s);

    // Main logic
     while (l < g.length &&  r < s.length)  
     {
        if (s[r] >= g[l])
        {
            l = l+1;
        }
        r++;
     }

// return answer
     return l;
    }
}