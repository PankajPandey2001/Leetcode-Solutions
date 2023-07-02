// EDGE CASE WHEN K == 0 ; . THIS SHOULD BE HANDLED SEPERATELY ; 

/*
 
  is quesion  KE LIYE HUMEIN K SIZE KA KOI DATA STRUCTURE CHAHIYE JISME DAALNA AUR NIKALNA BHOT
  // KAM TIME MEIN HO JAAYE , TAAKI HUM AGAR KISI 0 KO FLIP KAREIN TOH USKE INDEX KO 
  US DATA STRUCTURES MEIN DAAL SAKE , AUR A
  JAB SIZE K HO , AUR KOI NYA ZERO AA JAYE TOH SABSE PHLE AAYE 0 KE INDEX KO HTANA PADHEGA ; SO 
  // WE NEED CONTINUOUS ADDIDTION AND DELETION , FOR THAT , WE CAN EITHER USE

  1 . Queue ;  (BEST WILL BE QUEUE , BECAUSE ; ALRADY IMPLEMENTED AS WELL AS) EASY TO FIND IFIRST 
              ADDED INDEX ; 


  1. LINKEDLIST ; 

  2. PRIORITY QUEUE ; 
   
    not ARRAYLIST , BECAUSE IT WILL HAVE HIGH COMPLEXITY ; WHEN WE WILL DELETE FIRST COMING INDEX ; 
*/
class Solution {
    public int longestOnes(int[] nums, int k) {
        
    // option1 , priorityQueue leke dekh le ; 
       
       int max = Integer.MIN_VALUE ; 

        Queue<Integer> q = new LinkedList<>() ; 

        int i = 0 ; 
        int j = 0 ; 

        while( j < nums.length )
        {
            if( nums[j] == 1 )
            {
                j++ ; 
                continue ;
            }


            if(q.size() < k )
            {
                q.add(j) ; 
                j++ ; 
            }
            else if( q.size() == k ) // toh jo sabse phle add kiya tha 0 (means usko flip kara tha
            // usko hata denge queue se max update karne ke baad)
            {
                 
                 if( j - i > max)
                 max = j - i ; 
                  
                 if( k != 0)
                 {
                    int index = q.remove() ; 
                     i = index+1 ; 

                     q.add(j) ;
                 }
                 else
                 {
                     i = j+1; 
                 }
                  
                 j++ ; 
            }
        }

        if(nums.length - i > max)
        max = nums.length - i ; 



        return max ; 
    }
}