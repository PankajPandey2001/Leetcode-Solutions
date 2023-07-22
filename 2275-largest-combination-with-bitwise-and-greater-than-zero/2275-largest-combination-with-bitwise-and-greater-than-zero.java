
/*
     The candidates are 24 bits long, so for every bit position, we can calculate the size of     the largest combination such that the bitwise AND will have a 1 at that bit position.


      SO APPORACH IS IS SIMPLE , WE KNOW THAT IN JAVA INT VALUE HAS 32 NUMBER OF BITS , 
      SO FOR EVERY POSITION , 
      WE WILL CHECK THE COUNT OF NUMBERS , HAVING 1 BIT AT THat position , 


      because us combination ka and non zero tab hoga , jab kisi 1 position par sabka bit 1 hoga
      so that and karne par 0 na aaye ; 
*/

class Solution {
    public int largestCombination(int[] candidates) {
        

         int answer = 1 ; 


        for( int i = 1 ; i <= 32 ; i++)
        {
                 int count = 0 ;   // this count will store that how many numbers in given
                                  // array , have , 1 bit at  i th position ; 

                int val = 1 << i ; 

            for( int j = 0 ; j < candidates.length ; j++)
            {
                  int temp = candidates[j] & val ; 

                  if( temp != 0)
                  count++ ;
            }


            if(count > answer) 
            answer = count ; 
        }



        return answer ; 
    }
}