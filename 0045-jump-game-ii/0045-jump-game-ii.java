class Solution {
    public int jump(int[] nums) {
   
   // iska ek tareeka dp wala h , jisme saare call lagake minimum dekhenge ; 
   // par wo o(N) se jyada ki complexkty mein hoga , basically O(N*N) mein ;


   // but we can do this question with simple O(N) approach via greedy approach ; 

   // from starting we will maintain our maximum range , in whcih can go with the one jump ; 
// and then from all those indices , we will select new maximumRange 

        if(nums.length == 1)
        {
            return 0 ; 
        }


        int maximumReach= 0 + nums[0] ; 
         
         if(maximumReach >= nums.length-1)
         return 1 ; // means 1 jump is enough 
         
         int count = 1 ; 
         
         int nextReach = nums[0] ; 


         int j = 1 ; 

         while( j < nums.length)
         {
             if( j == nums.length-1)
             return count ; 
            
             if(maximumReach >= nums.length-1)
             return count ; 
              
              if( j + nums[j] > nextReach )
              {
                  nextReach = j + nums[j] ; 
              }


             if( j == maximumReach)
             {
                 count++ ; 
                 maximumReach = nextReach; 
                 continue ; 
             }


              j++ ; 
         }

         return count ; 


    }
}