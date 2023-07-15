class KthLargest {

      PriorityQueue<Integer> pq = new PriorityQueue<>() ; 
      int count = 0 ; 


    public KthLargest(int k, int[] nums) {
         count = k ; 


         for( int i = 0 ; i < nums.length ; i++)
         {
             pq.add(nums[i]); 
         }


         while(pq.size() > k )
         {
             pq.remove() ; 
         }

    }
    
    public int add(int val) {
        
        pq.add(val) ; 

     
        while(pq.size() > count )
        {
            pq.remove() ; 
        }

        return pq.peek() ; 
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */