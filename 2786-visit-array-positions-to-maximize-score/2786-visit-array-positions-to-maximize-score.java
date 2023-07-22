class Solution {
    public long maxScore(int[] nums, int x) {
        
        
        long even = 0 ; 
        long odd = 0 ; 
        
        
        
        
        for( int i = nums.length-1 ; i >= 0 ;  i--)
        {
             
            long current = 0 ; 
            
            if( nums[i] % 2 == 0)
            {
                long option1 = even + nums[i] ; 
                long option2 = odd + nums[i] - x ; 
                
                current = Math.max(option1,option2) ; 
                
                even = Math.max(even , Math.max(option1,option2)) ; 
            }
            else
            {
                 long option1 = odd + nums[i] ; 
                long option2 = even + nums[i] - x ; 
                
                current = Math.max(option1,option2) ; 
                
                odd = Math.max(odd , Math.max(option1,option2)) ; 
            }
            
            if( i == 0)
            {
                return current ; 
            }
        }
        
        
        return -1 ; 
    }
}