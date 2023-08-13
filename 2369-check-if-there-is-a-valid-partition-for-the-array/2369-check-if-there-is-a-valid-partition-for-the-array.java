class Solution {
    public boolean validPartition(int[] nums) {
        

        HashMap<String,Boolean> map = new HashMap<>() ; 
        return helper( nums , 0 , nums.length-1 , map) ; 

    }
    public boolean helper( int nums[] , int start , int end , HashMap<String,Boolean> map)
    {
      
       String s = "" + start + "_" + end ; 

       if( map.containsKey(s))
       return map.get(s) ; 


        if(start > end)
        return true ; 

        if( start == end)
        return false ; 


        if( end - start == 1) // means only 2 element is in the nums , so we have only one option
        {
            if( nums[start] == nums[end])
            return true ; 
            else
            return false ; 
        }

       if( nums[start] == nums[start+1] )
       {
          boolean temp = helper(nums , start+2 , end , map) ; 

          if(temp == true)
          {
              map.put(s,true) ; 
              return true; 
          }
       }

       if( nums[start] == nums[start+1] && nums[start+1] == nums[start+2])
       {
          boolean temp = helper(nums , start+3 , end , map) ; 

          if(temp == true)
          {
              map.put(s,true) ; 
              return true; 
          }
       }


       if( nums[start] == nums[start+1] -1  && nums[start+1] == nums[start+2] -1 )
       {
          boolean temp = helper(nums , start+3 , end , map) ; 

          if(temp == true)
          {
              map.put(s,true) ; 
              return true; 
          }
       }
       
       map.put(s, false) ;
        return false ; 

    }
}