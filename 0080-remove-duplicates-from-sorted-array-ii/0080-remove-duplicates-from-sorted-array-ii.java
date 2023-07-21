class Solution {
    public int removeDuplicates(int[] nums) {
        

        int k = 0 ;  // means is inde mein ab next element aayga nums ka ; 
        int i = 0 ;  // for itearting in the array ;

        while( i < nums.length )
        {
             int j =  i ; 


             while( j < nums.length && nums[j] == nums[i])
             {
                 j++ ; 
             }


             int count = j - i ; 


             count = Math.min(count , 2 ) ; // kyonki agar 2 se kam h toh utni baar hi 
             // aur 2 se jyada hai toh bas 2 baar hi wo element aayga ; 


             while( count > 0)
             {
                 nums[k] = nums[i] ; 
                 k++ ; 
                 count-- ; 
             }


             i = j ;
        }


        return k ; 
    }

}