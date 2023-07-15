class Solution {
    public int findKthLargest(int[] nums, int k) {
        
        // kth largest ko smallest ki form mein convert karnege , ki kth largest starting
        // se kaun sa hoga , usse dhundna aasan oga 

        
        return helper(nums , 0 , nums.length-1 , k , nums.length-k ) ; 
    }
    public int helper( int nums[] , int start , int end , int k , int index )
    {
         int j = start ; 
         int i = start ; 


         int value = nums[end] ; 

         while( j <= end)
         {
             if( nums[j] <= value) // swap
             {
                 int temp = nums[i] ; 
                 nums[i] = nums[j] ; 
                 nums[j] = temp ; 

                 i++ ; 
                 j++ ; 
             }
             else
             {
                 j++ ; 
             }
         }
         
        //  for( int id = 0 ; id < nums.length ; id++)
        //  {
        //      System.out.print(nums[id] + " ") ; 
        //  }
        //  System.out.println();

         if( i - 1 == index )
         return nums[index] ; 
         else if( i-1 < index)
         return helper(nums , i , end , k , index) ; 
         else
         return helper(nums , start , i-2 , k , index) ; 



    }
}