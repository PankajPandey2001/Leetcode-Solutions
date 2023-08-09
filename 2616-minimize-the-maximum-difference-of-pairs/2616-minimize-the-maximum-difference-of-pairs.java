// this is combination of binary serach and little greedy ; 

// reference video - https://www.youtube.com/watch?v=1LxCKQ2emQc
class Solution {
    public int minimizeMax(int[] nums, int p) {



        // HINT ; PHLE BAAT TOH MINIMISE THE MAXIMISE LIKHA HUA H , SO IT. GIVES A HINT THAT
         //       WE CAN USE BINARY SEARCH ON ANSWERS TOPIC ; 

        
     // ALSO , answer is bounded ( 0 - 10^9 ) ki range , mein hoga so we can use binary search on answers 
        // technique to find answer.  ( yahaan hum maximum 10^9 ki jagah (MAXIMUM OF ARRAY - MIINIMUM OF ARRAY ) BHI LE SAKTE HAIN ; )




        Arrays.sort(nums) ; // increasing order mein sort kar re hain kyonki difference consecutive
        //number mein hi minimum hota h ; aur humein bas p no of pairs banane hain jinke bich ka difference
        // kam ho , aur sort karne ke baaad hi hum bol sakte hain ki consecutive number kas 

        int min = 0 ; 

        int max = (int)Math.pow(10,9) ; 

        int answer =  Integer.MAX_VALUE ; 


        while( min <= max)
        {
            int mid = (min+max)/2 ; 
              
              

            if( isPossible(mid,nums , p ) == true) // means VALUE MID as a maximum  DIFFERENCE possible h toh fir hum first half mein usse chhota answer dhundenge agar possible hoga toh thik warna ye hi return kar denge 
            {

                System.out.println("possible h ") ; 
                
                answer = mid ; 
                max = mid-1 ; 
            }
            else
            {
                min = mid+1 ; 
            }
        }


        return answer ; 
    }
    // here comes important part kisi integer ke liye check karna ki kya ye integer as a maximum difference
    // possible h ya nhi ; 


    public boolean isPossible( int number , int nums[] , int p )
    {
         int count = 0 ; // this variable will store , the number of pairs we have got till that iteration
         // in which the difference is less than or equal to number ;

         // and jaise count pair se bda ya barabaar hoga hum true return kar denge ; 



         int i = nums.length-1 ; 


         while( i > 0 )
         {

             
              if( nums[i] - nums[i-1] <= number)
              {
                  count++ ; // iska matlab ek pair mil gya jiska difference number se kam ya barabar h

                  i = i - 2 ; // taaki same index wala element 2 pair mein count na ho paaye 
              }
              else
              {
                  i--  ; 
              }

                if( count >= p)
                return true ;  // matlab humein p numbers of Pair mil gye hain ; jiska difference less than number h 
                
         }


         if( count >= p)
         return true ;  // matlab humein p numbers of Pair mil gye hain ; jiska difference less than number h 
         else
         return false ; 
    }
}