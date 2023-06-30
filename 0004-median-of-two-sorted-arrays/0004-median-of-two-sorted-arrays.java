class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        // intuition is dividing nums1 and nums2 combined into two parts ; 
        // now we will use binary search to find the way to partition arr1 and uske according arr2 ka 
        // partition apne aap nikal jayga ; kyonki number of elements jo left side mein rakhne 
        // hain wo fixed hai ; 

       // EDGE CASES WHENE LENGTH OF ANY ARRAY IS O ; 


       /*

              Tc - O(log(nums1.length)) ; 
              Sc - o(1) ; 

        */
        if(nums1.length == 0 )
        {
             if(nums2.length % 2 == 0)
             {
                 // means 2 median ; 
                
                double answer =  ((double)nums2[nums2.length/2] + (double)nums2[nums2.length/2 -1]) / (double)2 ;
                return answer ; 

             }
             else
             {
                    return (double)(nums2[nums2.length/2]) ; 
             }
        }


       if(nums2.length == 0 )
        {
             if(nums1.length % 2 == 0)
             {
                 // means 2 median ; 
                
                double answer =  ((double)nums1[nums1.length/2] + (double)nums1[nums1.length/2 -1]) / (double)2  ;
                return answer ; 

             }
             else
             {
                    return (double)(nums1[nums1.length/2]) ; 
             }
        }

        
        int low = 0 ;  // because left part mein arr1 ke 0 elements rakh sakte hain minimum ; 

        int high = nums1.length; // because left part mein arr1 ke maximum itne hi elements rakh sakte hian  ; 


        int value = 0 ; 

        if( (nums1.length + nums2.length) % 2 == 0 ) // total length even so , dono part mein equal 
        // elements rakhenge ; 
        {
              value = (nums1.length+nums2.length)/2 ; 
        }
        else
        {
            value = (nums1.length+nums2.length)/2 ;  

            value++ ; // kyonki agar total length odd h toh  left part mein 1 extra element rakhegne ; 
        }


        // now use binary search to find optimal partitioning ; 


        while(low <= high)
        {
            int mid = low + (high-low)/2 ; 

            // mid means arr1 ke mid elements rakhne hain part1 mein ; 

           int left1 = 0  ; // means left part mein array1(nums1) ka maximum element ;
           int left2 = 0 ; // means left part mein array2 ka maximum element ; 
           int right1 = 0 ; // meas right part mein array1 ka minimum element ; 
           int right2 = 0 ; // mean right part mein array 2 ka minimum element ; 


            if(mid == 0 )
            {
                left1 = Integer.MIN_VALUE ;
                right1 = nums1[0] ; 
            }
            else if(mid == nums1.length)
            {
                left1 = nums1[mid-1] ; 
                right1 = Integer.MAX_VALUE ; 
            }
            else
            {
                left1 = nums1[mid-1] ; // kyonki array 0 based indexing hota h 
                right1 = nums1[mid] ; 
            }

            // now number of elements on the left side from the array2 is ; 
            // value - mid ; // total jitne hone cahiye - arr1 ke kitne hain ;


           int  mid2 = value - mid ; 
             
             if(mid2 < 0 || mid2 > nums2.length) // ye possible hi nhi h;
             {

                 if(mid2 < 0)
                 {
                     // means arr1 ke jyada element le liye ; 

                     high = mid-1 ; 
                 }
                 else
                 low = mid+1 ; 

                 continue ; 
             }
             if(mid2 == 0 )
            {
                left2 = Integer.MIN_VALUE ;
                right2 = nums2[0] ; 
            }
             else if(mid2 == nums2.length)
            {
                left2 = nums2[mid2-1] ; 
                right2 = Integer.MAX_VALUE ; 
            }
            else
            {
                left2 = nums2[mid2-1] ; // kyonki array 0 based indexing hota h 
                right2 = nums2[mid2] ; 
            }

              
              if( left1 <= right2 && left2 <= right1)
              {
                  // VALID PARTITION H TOH 

                  if( (nums1.length+nums2.length)% 2 != 0)  // means 1 hi elemnt median hoga
                  return (double)(Math.max(left1,left2)) ; 
                  else
                  {
                      System.out.println(Math.max(left1,left2)+ " " +  Math.min(right1,right2)) ; 
                      double answers = ((double)Math.max(left1,left2) + (double)Math.min(right1,right2)) / (double)2 ; 
                     
                      return answers ; 
                  }
              }
              else if(left1 > right2) // means left part mein array1 ke kam element aane chahiye
              // so high ko kam karenge ; 
              {
                   high = mid-1 ;
              }
              else
              low = mid+1 ; 
        }


        return -1 ; 
    }
}