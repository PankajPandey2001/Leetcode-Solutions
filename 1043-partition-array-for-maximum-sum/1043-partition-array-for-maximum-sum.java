
/*

 THIS QUESTION IS BASED ON THE PARTITIONING OF THE ARRAY , BUT THE MAIN CATCH IS IDENTIFYING THAT 
 THIS TOPIC IS OF PARTITIONING ; 


   // WE HAVE TO BASICAALLY 
*/
class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
         
         int dp[][] = new int[arr.length][arr.length] ;

         for( int i = 0 ; i <dp.length ; i++)
         {
             for( int j = 0 ; j < dp[0].length ; j++)
             {
                 dp[i][j] = -1 ; 
             }
         }
         return helper( arr , 0 , arr.length-1 , k , dp) ; 
    }
    public int helper( int arr[], int start , int end , int k , int dp[][] )
    {
         
         if( dp[start][end] != -1)
         return dp[start][end] ; 
         
         if( end - start + 1 <= k )
         {
             // choose maximum from start to end ; and assume humne is ko us value mein convert
             // kar diya hai , aur fir return kar do sum ; 

                 int max = Integer.MIN_VALUE ; 

             for( int i = start ; i <= end ; i++)
             {
                if( arr[i] > max)
                max = arr[i] ; 
             }


             dp[start][end] =  max*(end-start+1) ;

             return dp[start][end] ;  
         }


         // now partition karo , har possible way mein 

         int max = Integer.MIN_VALUE ; 

         for( int i = start+1 ; i <= end ; i++)
         {
            int temp = helper(arr, start , i-1 , k , dp ) + helper(arr , i , end , k ,dp) ; 

            if( temp > max)
            max = temp ; 
         }


         dp[start][end] = max ; 

         return max ; 
    }
}