class Solution {
    public int minDistance(String word1, String word2) {
        
        int dp[][] = new int[word1.length()][word2.length()] ;

        for( int i =0 ; i < dp.length ; i++)
        {
            for( int j = 0 ; j < dp[0].length ; j++)
            {
                dp[i][j] = -1 ; 
            }
        }

        return helper(word1, word2 , word1.length()-1 , word2.length()-1 , dp) ; 

    }
    public int helper( String word1 , String word2 , int index1 , int index2 , int dp[][] )
    {
         if( index1 < 0 && index2 < 0)
         {
             return 0 ;
         }


         if( index1 < 0)
         {
             return index2+1 ; 
         }

         if( index2 < 0)
         return index1+1 ; 


         if(dp[index1][index2] != -1)
         return dp[index1][index2] ; 

         if( word1.charAt(index1) == word2.charAt(index2))
         {
             dp[index1][index2] = helper(word1 , word2 , index1-1 , index2-1 , dp) ;

             return dp[index1][index2] ; 
         }
         
        int option1 = helper(word1 , word2 , index1 , index2-1 ,dp) + 1  ; 
        int option2 = helper(word1 , word2 , index1-1 , index2 ,dp) + 1 ;

        dp[index1][index2] = Math.min(option1 , option2) ;  

        return dp[index1][index2] ; 
    }
}