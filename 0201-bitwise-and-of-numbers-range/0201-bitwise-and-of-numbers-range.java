
/*
    concept  15 ->  1111
            16 - > 10000 ( 16 is power of 2) 

            so from above analysis we can say that number of bits jab kisi number ki dusre number
            se jyda hai , matlab us range , mein koi 2 ki power wala number aa chuka hai
            aur ab is range ke saare number ka and karne par 0 hi aayga , kyonki 2 ki power
            wale number ka ek phle number se and 0 hota hai , 


            c

*/

class Solution {
    public int rangeBitwiseAnd(int left, int right) {


        /*
             APPROACH-1 which we can think here is , checking is there any number which is the 
                        power of 2( LIKE 16 , 4, 8 , 32) , 
                        )either present in the range. if present then and of 
                        entire range will become 0 , because we know that  AND OF POWER OF 2 WITH
                        ITS PREDECESSOR NUMBER IS 0 , IT WILL GIVE the entire and 0 , 

                        AND If not present , means range out of bound nhi jaygi so o(N) 
                        complexity lagakar , kaam bna jayga


             APPROACH-2 , basically cramming ki chij hai , instead of thinking about entire
                          range , left aur right ko consider karo bas
                          aur un dono ko right shift karte raho one by one step until wo 
                          same na ban jaaye , aur jaise wo same ban jaaye , toh jitne baar
                          right shift kiya tha utne hi baar left shift karke return kar 
                          denge ; 

        */



        // consider only left and right ; 
        // if left wale ki total bits , right wale ki bits se kam hai fir toh seedha seedha
        // and unka zero ho jayga kyonki total bit mein difference ka matalb , ek 2 ki power
        // ka koi number aa gya hai , 

           
           int countShift = 0 ; 

        while(left != right) // we will keep left shifting until , left != rigth ; and we will
        {                     // count also that how many times left shifting has done 
            left = left >> 1 ; 
            right = right >> 1 ;
            countShift++ ; 
        } 


        // now utne hi time leftshift kar do ; 


        while(countShift > 0)
        {
            left = left << 1 ;  // yahan left ki jagah right ko bhi kar sakte hain kyonki 
                               // tabhi phle hi humne left aur right ko barbaar kar diya tha 
            countShift-- ;
        }

         return left ; 
        // now agar left aur right ke bich mein koi 2 ki powr wala banda aaya hoga , toh 
        // left aur right dono 0 par hi equal honge , 


        
    }
}