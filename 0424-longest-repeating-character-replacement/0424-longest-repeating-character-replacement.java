
/*
     
     OPTIMISED APPROACH FOR SOLVING THIS QUESITON IS , SEE THE FIRST ACCEPTED SOLUTION , OR SEE THE
     EDITORIAL ; 


     BUT FOR BRUTE  AND EASY SOLUTION IS  https://leetcode.com/problems/maximize-the-confusion-of-an-exam/description/       see this quesiton , 


     main intuition is that , we will check one by one for each character , that if this character 
     willl lead to the maximum sequence , what will be that , similarly we will try to find out
     for all characters and we will return maximum amongst them ; 
     like i did in the aobve reference video ; 


*/



// - ---------------------------------------EDGE CASE WHEN K == 0 -------------------------___>


class Solution {
    public int characterReplacement(String s, int k) {
        
        // NOW EITHER WE CAN TYR FOR EVERY CHARCTER , MEAN FOR 26 TIMES , OR WE CAN DO ONLY 
        // FOR THOSE CHARACTERS WHICH ARE PRESENT IN S , FOR THAT WE CAN USE PRESNT ARRAY OF SIZE K ; 

         
         int present[] = new int[26] ; 

         for( int i = 0 ; i < s.length() ; i++)
         {
             present[s.charAt(i) - 'A'] = 1 ; 
         }


          Queue<Integer> q = new LinkedList<>() ; 

          int answer = Integer.MIN_VALUE ; 


         for( int i = 0 ; i < 26 ; i++)
         {
             if( present[i] == 1)
             {
                 
                 int temp = helper(s , k , (char)(i+'A') ) ; 

              System.out.println((char)(i+'A') + " "  + temp) ; 

                 if( temp > answer )
                 answer = temp ; 
             }
         }


         return answer ; 
    }
    public int helper (String s , int k , char ch )
    {
        Queue<Integer> q = new LinkedList<>() ; 

       int length = 1 ; 

        int i = 0 ; 
        int j = 0 ; 

        while( j < s.length())
        {
            if( j - i > length)
            length = j-i ; 

            if( s.charAt(j) == ch)
            {
                j++ ; 
                continue ; 
            }


            if( q.size() == k)
            {
                if( k == 0)
                {
                    i = j+1 ; 
                    j++ ; 
                }
                else
                {
                    i = q.remove()+1 ; 
                    q.add(j) ; 
                    j++ ;
                }
                
            }
            else
            {
                q.add(j) ; 
                j++; 
            }
        }


        // important line ; 
        if(s.length() - i > length)
        length = s.length()-i ; 


        return length ;
    }
}