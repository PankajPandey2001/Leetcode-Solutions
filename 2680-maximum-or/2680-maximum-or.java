// reference video. https://www.youtube.com/watch?v=pHjlsUsmGS8

/*
  
  NOW ONE POINT TO REMEMBER IN THIS QUESTION IS 

    WHENEVER WE MULTIPLY ANY NUMBER BY 2 , IT SHIFTS TO LEFT , MEANS ONE BIT WILL INCREASE ,
    SO IF WE ARE MULTIPLYING ANY NUMBER , THEN FOR OPTIOMAL RESULT , USI NUMBER KO BAAR BAAR
    2 SE MULITPLY KARENGE , 

    means , we have to pick any number , and usi ko baar baar multiplly karna hai , k times 
    
    now wo numer kaun sa hoga , iskel iye , har number ko ek ek baar karke dekhenge, 
    but (n*n) na ho , isliye hum suffix array aur prefix array ka use karke , har element
    se phle aur uske baad walon ka OR PHLE HI NIKALKAR RAKH LENGE ,
    jisse baar baar or nikalna nhi padhega




*/

class Solution {
    public long maximumOr(int[] nums, int k) {
        
        long prefix[] = new long[nums.length] ; 
        long sufix[] = new long[nums.length] ; 

           long temp = 0 ; 

           long answer = 0 ; 

        for( int i = 0 ; i < prefix.length ; i++ )
        {
            prefix[i] = temp ; 

            temp = temp | nums[i] ; 
        }
 
             temp = 0 ; 

        for( int i = nums.length-1 ; i  >= 0 ; i--)
        {
              sufix[i] = temp ; 

              temp = temp | nums[i] ; 
        }


        // NOW MOST IMPORTANT POINT IS THAT , WE HAVE STORED VALUE IN SUFIX AND PREFIX ARRAY ; 
        // BECAUSE OF WHICH WE WILL NOT HAVE TO FIND OR AGAIN AND AGAIN ; 



        for( int i = 0 ; i < nums.length ; i++)
        {

            long value = nums[i] * (long)Math.pow(2,k) ;  // it means ahbi hum assume kar re hain 
            // ki nums[i] ko badha rahe hain ; 


            long temporary = sufix[i] | prefix[i] | value ; 

            if( temporary > answer) 
            answer = temporary ; 
        }


        return answer ; 
    }

}