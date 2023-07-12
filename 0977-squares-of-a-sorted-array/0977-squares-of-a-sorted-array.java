class Solution {
    public int[] sortedSquares(int[] nums) {
        
        int i = 0 ;

        int j = nums.length-1 ;

         int answer[] = new int[nums.length] ; 
         int index = answer.length-1 ; 

        while( i <= j )
        {
            if(Math.abs(nums[i]) > Math.abs(nums[j]))
            {
               answer[index] = nums[i]*nums[i] ; 
               i++ ; 
            }
            else
            {
                answer[index] = nums[j]*nums[j] ; 
                j-- ; 
            }

            index--  ; 
        }


        return answer ; 
    }
}