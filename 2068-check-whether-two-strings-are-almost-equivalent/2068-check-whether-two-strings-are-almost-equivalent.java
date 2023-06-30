class Solution {
    public boolean checkAlmostEquivalent(String word1, String word2) {
        
        int frequency1[] = new int[26] ; 

        int frequency2[] = new int[26] ; 

        for( int i = 0 ; i < word1.length() ; i++)
        {
             frequency1[word1.charAt(i)-'a']++ ; 
        }

        for( int i = 0 ; i < word2.length() ; i++)
        {
             frequency2[word2.charAt(i)-'a']++ ; 
        }


        for( int i = 0 ; i < 26 ; i++)
        {
            if(Math.abs(frequency1[i] - frequency2[i]) > 3)
            return false ; 
        }


        return true ; 
    }
}