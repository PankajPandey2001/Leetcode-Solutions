class Solution {
    public int longestSubarray(int[] nums) {
        

        // it can be done using two pointer approach ; 

        int i = 0 ; 

        int j = 0; 

        int answer = Integer.MIN_VALUE ; 

        int index = -1 ; // if index is -1 then we have not replace othewise we have replace and 
        // that is at index  = index ; 

        while( j < nums.length)
        {

            if( nums[j] == 0 )
            {

                if(index == -1)
                {
                    index = j  ; 
                }
                else
                {
                    if( j - i -1 > answer)
                    {
                        answer = j - i -1 ; 
                    }

                    i = index+1 ; 
                    index = j ; 

                }

            }

            j++ ; 
        }
        
       
          if( j - i -1  > answer) 
            answer = j-i -1; 
        


        return answer ; 
    }

}