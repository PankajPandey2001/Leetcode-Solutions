class Solution {
    public int minFallingPathSum(int[][] grid) {

         int dp[][] = new int[grid.length][grid[0].length+1] ; // 1 isliye kyoni hum initial 
         // -1 leke chal re ahin isliye har value ko 1 aage shift karenge ; 

        for( int i = 0 ; i < dp.length ; i++)
        {
            for( int j = 0 ; j < dp[0].length ; j++)
            {
                dp[i][j] = -1 ; 
            }
        }

        return helper( grid , 0 , -1 , dp) ;  // as approach told by striver bhaiya


     /*
        step1 write everything in the form of index ; 
        step1(a) write all possible aways and chhodse the best way
        ste2 think about the base case ; 
        step3 write recurrence realtion

      */ 
    }
    public int helper( int grid[][] , int row , int column , int dp[][])
    {
        if( row == grid.length)
        return 0 ; 

        if(dp[row][column+1] != -1)
        return dp[row][column+1] ; 
       
       int minimum = Integer.MAX_VALUE ; 

        for( int col = 0 ; col < grid[0].length;  col++)
        {
            if( col == column)
            continue ; 

             int option = helper(grid , row+1 , col ,dp ) + grid[row][col] ; 


             if(option  < minimum)
             minimum = option ; 
            
        }


        dp[row][column+1] = minimum ;

        return minimum ; 
    }
}