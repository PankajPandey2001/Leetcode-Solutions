/*.                       Question 
n = 1: return 1 is the base case
n = 2: return count of last entry i.e. 1 1
n = 3: return count of last entry i.e. two 1's so 21
n=4: we have one 2 and one 1 so 1211
n=5: , we have one 1 and one 2 and two 1's so -> 111221
n=6: we have three 1's, two 2's and one 1 so -> 312211
n = 7: we have one 3, one 1, two 2's and two 1's -> 13112221
...

*/

class Solution {
    public String countAndSay(int n) {
         
         if( n == 1)
         return "1" ; 


         String temp = countAndSay(n-1) ;
        
        StringBuilder str = new StringBuilder() ; 

        int count = 1 ; 
         char ch = temp.charAt(0) ; 
        
        int i = 1 ; 

         while( i < temp.length() )
         {
             if( temp.charAt(i) == ch )
             {
                 i++ ; 
                 count++ ; 
             }
             else
             {
                 str.append(count) ; 
                 str.append(ch) ; 

                 count = 1 ; 
                 ch = temp.charAt(i) ; 
                 i++ ; 
             }
         }


         str.append(count) ; 
         str.append(ch) ; 


         return str. toString() ; 
    }
}