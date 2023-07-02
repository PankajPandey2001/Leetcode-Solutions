class Solution {
    public double findMaxAverage(int[] nums, int k) {
        

        double sum = 0 ; 

        for( int i = 0 ; i <= k-2 ; i++)
        {
              sum += (double)nums[i] ; 
        }

      double max = Integer.MIN_VALUE ; 

        for( int i = 0 ; i <= nums.length- k  ; i++)
        {
            sum += nums[i+k-1] ; 


            if( (double)sum /(double)k > max )
            max = (double)sum /(double)k ; 


            sum -= nums[i] ; 
        }

        return max ;
    }
}