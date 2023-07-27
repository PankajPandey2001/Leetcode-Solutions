class Solution {
    public String shortestPalindrome(String s) {
        

        // this question will be done by mcm variation of dp , 
        // because we have to find , the smallest ; 

         if( isPallindrome(s) == true) // agar s phle hi pallindrome hai , toh return kar denge s ;
         return s ; 


          
 // now the main catch of this problme is that , we have to make stirng paalindorm , and we can
 // insert only from the front ; 

 // now since we can add only in the front , now how many characters needed to be added  , depend
 // on how many characters are staying same in the string ; 

 // therefore starting from the middle index to starting index 
 // , we will check , from which index we can split the string
 // into two parts, such that , complete first part and  prefix of second part , can be match
 // aur agar match ho gye , toh secnod part ke baaki jitne bachhe hain character unko add kardo 
 // aisa karne se , minimum character add honge , aur pallndrome banega ; 



 // now one important point , hum i ko middle se start kar re hian aur one by one decrease 
 // karegne taaki minimum character hi add karne padhein ; 


        for( int i = s.length()/2-1  ; i >= 0 ; i-- )
        {


            // now match karwane ke bhi two tareeke , ek toh us index ko include karke first
            // part maane aur uske right se second part

            // jaisa ye kara h 
            String temp = count( i , i+1 , s) ; 
            
            if(temp.length() != 0 )
            return temp ;
            
            // dusra tareeka ye hai ki , us index ke left se first part , maane aur us index
            // ke right se second part maane , now ye karna mein bhul ra tha , agar ye nhi 
            // karta toh ek type ke cases miss ho jaate , 

            //by below we are assuming ki i th index wala character middle mein hai , aur
            // left part i-1 aur right part i+1 se shurur ho ra hai
            temp = count(i-1 , i+1 , s) ; 

            if(temp.length() != 0 )
            return temp ;
        }

        return (s+s) ; 
    }
    public String count(int i , int j , String s)
    {
        while( i >= 0 )
        {
            if( s.charAt(i) != s.charAt(j))
            return "" ; 

            i-- ; 
            j++ ; 


        }

        // if( i < 0)
        // {
        //     return s.length() - j ; 
        // }

        // return -1 ; 

        StringBuilder str = new StringBuilder() ;
         int k = s.length()-1 ; 

         while( k >= j)
         {
             str.append(s.charAt(k)) ; 
             k-- ; 
         }

         str.append(s); 

         return str. toString() ;
    }
    public boolean isPallindrome(String s)
    {
        int i = 0 ; 
        int j = s.length()-1 ; 

        while(i < j)
        {
            if(s.charAt(i) != s.charAt(j))
            return false ;


            i++ ; 
            j-- ; 
        }

        return true ; 
    }
}