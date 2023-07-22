class Solution {
    public boolean isGood(int[] nums) {
        
        int count[] = new int[nums.length] ; 
        
        for( int i = 0 ; i < nums.length ; i++ )
        {
            if(nums[i] >= nums.length)
            {
                return false ; 
            }
            
            
            count[nums[i]]++ ; 
        }
        
        
        for( int i = 1 ; i < count.length-1 ; i++)
        {
            if( count[i] != 1 )
            return false ; 
        }
        
        if(count[count.length-1] != 2)
            return false ; 
        
        
        return true ; 
    }
}