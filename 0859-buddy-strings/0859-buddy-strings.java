
class Solution {
    public boolean buddyStrings(String s, String goal) {
        

        /*
            if count of distint elements is not equal to either 2 or 0 then it is not possible
            to swap towo characters to make s equal to goal ; 
            
            if( count == 2) means un do characters ko switch kar sakte hain only if both the character
            set are same ;


            and if(count == 0) then it is possible onlly when a character is same atleast two times
            in difference position is s and goal ; 

        */
        int count = 0 ; 
      
        int equalCount[] = new int[26] ; // to maintain count of equal characters , because if count 0
        // hogi toh , agar ek bhi character 2 baar equal aaya h toh true ho sakta h ; 

        // for example  s = "abab" and goal = "abab" , here count == 0 but , we can swith either 'a' or
        // 'b' because s will still be equal to s as welll as goal ; 

        boolean canChange = false ; 

        char ch1 = 'a' ; 
        char char1 = 'a' ; 
        char ch2 = 'a' ; 
        char char2 = 'a' ;

        // iteration ke baad count exact 2 honi chahiye ya 0 tabhi aisa possible hai aur ch1 aur char2 and ch2 aur char1 same hona chahiye if count == 2 ; 

        if(s.length() != goal.length())
        return false ;


        for( int i = 0 ;  i < goal.length() ; i++)
        {
            if(goal.charAt(i) == s.charAt(i))
           {
               equalCount[goal.charAt(i) - 'a']++ ; 

               if(equalCount[goal.charAt(i) - 'a'] > 1)
               {
                  canChange = true ;  // means if count = 0 hui , toh is character ko swap mein 
                  // count kar sakte hain ;
               }
               continue ; 
           }


            count++ ; 

            if(count > 2)
            return false ; 

            if( count == 1)
            {
                ch1 = s.charAt(i) ; 
                char1 = goal.charAt(i) ; 
            }
            else if( count == 2)
            {
                ch2 = s.charAt(i) ;
                char2 = goal.charAt(i) ; 
            }
        }

        if(count != 2)
        {
            if(count == 0)
            {
               
                return canChange;
            }

            return false ; 
        }

        if( ch1 == char2 && ch2 == char1)
        return true ; 

        return false; 
    }
}