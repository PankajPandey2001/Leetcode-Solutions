class Solution {
    public boolean search(int[] nums, int target) {
       if( nums.length == 0 )
        return false ; 

        int low = 0 ; 
        int high = nums.length-1 ; 

        while(low <= high)
        {
            int mid = (low + high)/2 ; 

            if( nums[mid] == target)
            return true  ; 
              if( nums[low] == target)
            return true  ; 
              if( nums[high] == target)
            return true  ; 

            //if there are duplicates
          if(nums[low] == nums[mid] ) {
                low++;
                
            }
             else if( nums[low] <= nums[mid]) // means left part is sorted ; 
            {
                if( nums[low] <= target && nums[mid]> target)
                high = mid-1 ; 
                else
                low = mid +1 ; 
            }
            else  // if code comes in this block means right part is sorted ; 
            {
                if( nums[mid] < target && target <= nums[high])
                low = mid +1 ; 
                else
                high = mid -1 ; 
            }

        }

        return false ;   
    }
}