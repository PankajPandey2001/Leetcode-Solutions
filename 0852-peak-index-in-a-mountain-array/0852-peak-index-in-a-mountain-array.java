class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        
        // now array is guaranteed to be the mountain array , now since it is guarantedd , 
        // it is the case of rotated sorted array , whose maximum value we have to find. 
        // no i was wrong it is not the case of rotated sorted array 

        // bca in rotated sorted array , maximum element ke baad just minimum element aatah a
        // for examle { 4, 5, 6, 1, 2 ,3 } ; 

        // but in our question test cases can be , { 4 , 5 , 6 , 3 ,2 , 1} so this is not the 
        // question of finding maximum in sorted rotated array ; 


           // now the main catch is that we have givne that array is sure to be a mountain array ; 
          //  so we will try to reduce the serach space 


          int start = 0 ; 

          int end = arr.length-1 ;

          while( start <= end )
          {
              int mid = start + (end-start)/2 ; 


              // now two edge cases sambhal lo phle hi jaise mid agar 0 th index hua 
              // ya last index hua toh ; 

              if( mid == 0 )
              {
                  if( arr[mid] > arr[1])
                  return 1 ; 
                  else
                   start = mid + 1 ;  
              }
              else if( mid == arr.length-1 ) // waose isme toh direct return akr dena chahiye ; kyonki 
              // mid agar end ke barabaar h matlab search space mein sirf last element bacha h , aur since
              // answer pakka h toh ye hi answer hoga 
              {
                  return mid ;
              }
              else
              {
                   // since humne last ke indexes serpeately handele kar liye , therefore hum ab
                   // saare indexes ke left aur right dono compare kar skate hain , with out gettig 
                   // array out of range , 


                  if( arr[mid] > arr[mid-1] && arr[mid] > arr[mid+1])
                  return mid ; 
                  else if( arr[mid] > arr[mid-1])
                  {
                      // iska matlab answer start se mid mein nhi h , mid+1 se end ki range mein hi hoga ; 


                      start = mid+1 ;
                  }
                  else if( arr[mid] > arr[mid+1]) // means peak element ke right side mein hai mid element
                  {
                       end = mid-1 ; 
                  }
              }
          }


          return -1 ; 
        
    }
}