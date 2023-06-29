// main catch in this problem is that whenever a character is more times in s , than in t , then we will
// replace it , but we wil replace it with the character which is more times ;


/*


        BETTER APPROACH IS



      we can say that there are two way to find ans
1. know element which are in less number (add the difference to get final ans)
2. know element which are in excess number(add diff) + which are unknow element


*/
class Solution {
    public int minSteps(String s, String t) {
        
        // keep one thing in mind that s.length() == t.length() ; 

        int frequency[] = new int[26] ; 

        for( int i = 0 ; i < s.length() ; i++)
        {
            frequency[s.charAt(i)-'a']++ ; 
        }

        for( int i = 0 ; i< t.length() ; i++)
        {
            frequency[t.charAt(i)-'a']-- ; 
        }


        int count = 0 ; 


        int count1 = 0 ;  // now is question mein ye trick use karni h ki , agar ek baar
        // kisi ko kam kara h toh  us stirng mein jab kisi character ko badhayenge toh itne time
        // answer kam add karenge 
        // because we are assuming ki jo jyada baar h usko jo kam baar h usko replace karne mein use 
        // kara h 
        

        for( int i = 0 ; i < 26 ; i++)
        {
           int temp = frequency[i] ; 

             // if temp positive means ye jyada baar h 

             if( temp > 0 )
             {
                 if( count1 > 0)
                 {
                     count += temp ; 
                     count1 += temp ; 
                 }
                 else
                 {
                     // if count1 < 0 means isse phle kisi character ko badhya tha ; ab hum
                     // maan lenge ki is character ko kam karke usko badhaya hoga ; ab kitna kam
                     // kara wo dekhna h 

                     int value = count1 + temp ; 
                    

                     if(value < 0 )
                     {
                         count1 = count1 + temp ;
                         continue ; 
                     }

                     count+= value ; 
                     count1 = value ; 
   
                 }
             }
             else
             {
                 // means s mein ye character kam h 

                 if(count1 < 0 )
                 {
                     count += Math.abs(temp) ; 
                     count1 += temp ; 
                 }
                 else
                 {
                     int value = count1 + temp ; 

                     if( value > 0)
                     {
                         count1 = count1 + temp ; 
                         continue; 
                     } 
                     
                     count += Math.abs(value) ; 
                     count1 = value ;  
                 }
             }
        }


        return count ; 


        
    }
}