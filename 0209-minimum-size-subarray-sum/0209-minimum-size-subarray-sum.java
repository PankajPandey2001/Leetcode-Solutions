/*
  
  EDGE CASE when [1,3,9] target = 5 ; then answer should be 2 , remember this case

*/


class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        
        int i = 0 ; 
        int j = 0 ; 

        int length = Integer.MAX_VALUE  ; 


        int sum = 0 ;

        while( j < nums.length)
        {
            if(nums[j] >= target)
            return 1 ;                    // edge case ; 

             sum += nums[j] ; 

             if( sum < target)
             {
                 j++ ;
                 continue ; 
             }
             else
             {
                 if( j-i + 1 < length)
                 {

                     System.out.println( sum + " " + i + " " + j + " ") ; 
                     length = j-i+1 ; 
                 }


                     while( i <= j && sum >= target )
                     {

                         if( j-i + 1 < length)
                        {
                            System.out.println( sum + " " + i + " " + j + " ") ; 
                           length = j-i+1 ; 
                        }
                         sum -= nums[i] ; 
                         i++ ; 
                     }

                     j++ ;

                     j = Math.max(j , i) ; // in case of [1,2,9,4,3] and target = 5 ; i 4 value
                     // par pahcunh jayga but j , 9 par hi rahega , isliye uper wali contidito
                     // rakhi  
             }
        }

         if( sum >= target) // kyonki last wala bhi consider karenge 
         {
             // ye niche wala whileloop bhi uper wali conditon ko dekhark lagaya ha ;
                   while( i < j && sum >= target )
                     {

                         if( j-i + 1 < length)
                        {
                            System.out.println( sum + " " + i + " " + j + " ") ; 
                           length = j-i+1 ; 
                        }
                         sum -= nums[i] ; 
                         i++ ; 
                     }
         }

           if(length == Integer.MAX_VALUE)
           return 0 ; 
        return length ; 
    }
}