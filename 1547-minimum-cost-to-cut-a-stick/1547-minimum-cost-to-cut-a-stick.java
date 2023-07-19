class Solution {
    public int minCost(int n, int[] cuts) {
        
        //  int dp[][] = new int[n+1][n+1] ; 

        //  for( int i = 0 ; i < dp.length ; i++)
        //  {
        //      for( int j = 0 ; j < dp.length ; j++)
        //      { 
        //          dp[i][j] = -1 ; 
        //      }
        //  }       AS DP IS GIVING MEMORY LIMIT EXCEEDED WE CAN USE STRING AS A KEY AND HASHMAP
        // AS DP ARRAY ; 

        HashMap<String,Integer> map = new HashMap<>() ; 
         return helper( cuts , 0 , n , map) ; 
    }
    public int helper(int cuts[] , int start , int end, HashMap<String,Integer> map )
    {
        
        if( start >= end)
        return 0 ;

        String temp = "" + start + "_" + end ; 

        if( map.containsKey(temp))
        return map.get(temp) ; 

        int answer = Integer.MAX_VALUE ; 

        for( int i = 0 ; i < cuts.length ; i++)
        {
            if( cuts[i] > start && cuts[i] < end)
            {
                int temp1 = end-start + helper(cuts , start , cuts[i], map) + helper( cuts , cuts[i] , end ,map) ; 

                if( temp1 < answer)
                answer = temp1 ; 
            }
        }
        
        if( answer == Integer.MAX_VALUE) // means it can not be cut further 
        map.put(temp , 0) ; 
        else 
        map.put(temp , answer) ; 


        return map.get(temp) ; 
    }
}