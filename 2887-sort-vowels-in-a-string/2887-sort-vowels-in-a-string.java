class Solution {
    public String sortVowels(String s) {
        
        char sArray[] = s.toCharArray();
        String Vowels = "AEIOUaeiou";
        
        //Define Array list for vowels
        ArrayList<Character> vList = new ArrayList<>(); 

        for (char c : sArray)
        {
            if (Vowels.contains(String.valueOf(c)))
            {
                vList.add(c);
            }
        }

        Collections.sort(vList);

        int i = 0;
        int j = 0;
        for (char c : sArray)
        {
            if (Vowels.contains(String.valueOf(c)))
            {
                sArray[j] = vList.get(i);
                i++;
            }
            j++;
        }
        

        //Return the answer
        return new String(sArray).trim();
    }
}