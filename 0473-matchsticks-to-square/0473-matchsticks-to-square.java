/*
    SEE THIS QUESITN IS A INSTANCE OF DIVIDING A ARRAY INTO K SUBSET  , IN WHICH ALL SUBSET HAVE EQUAL
    SUM , SIMILARLY HERE WE HAVE TO DIVIDE , MATCHSTICS ARRAY INTO EQUAL PART , 

    SO WE KONW THAT IT CAN BE DONE BY RECURSION ONLY , BUT IN CASE OF RECURSION WE SHOULD HAVE KNOWLEDGE
    OF HOW WE CAN DO PRUNNING SO THAT UNNECESSARY CALLS CAN BE STOPPED ; 

    HERE SORTING WILL HELP IN IT ; 
*/

class Solution {
    public boolean makesquare(int[] matchsticks) {
        
        // this is a quesiton of backtracking , 
        // BACKTRACKING HAS TIME COMPLEXITY OF HIGH ORDER ; SO IF WE HAVE TO FIND OUT THAT 
        // WE CAN USE BACKTRAKCING OR NOT , IN 2 SECOND , THEN JUST SEE THE CONSTRAINT ; 

        //  NOW MATCKSTICK.LENGTH == 15 AND , WE HAVE TO DIVIDE THESE MATCKSTICK INTO 
        // 4 PART SO THAT , LENGTH OF ALL FOUR PART ARE EQUAL , SO IF WE WILL USE BACKTRACKING 
        /// COMPLEXITY WILL BECOME , 4^(matchstick.length)


        //and matchstick.length == 15 so we can use backtracking bcz 4^15 is feasible ; 


        long arr[] = new long[4] ; // because we have to divide it into four parts ; 
           
           // first just find by finidng sum and then checking whether sum is divisible by 4 or not

     long sum = 0 ; 

           for( int i = 0 ; i < matchsticks.length ; i++)
           {
                 sum += matchsticks[i] ; 

           }
          

          if( sum % 4 != 0 )
          return false ; 


          long limit = sum / 4 ; 
          
          Arrays.sort(matchsticks) ;
          reverse(matchsticks) ;   // sort karenge reverse order MEIN 
          // JISSE PRUNNING HONE MEIN 
          // MADAD MILEGEI , KYONKI IF LARGER NUMBER , PHLE HONGE TOH YE CHANCES H KI , > SUM/4 ; 
        // WALE COMBINATION PHLE HI PRUN HO JAYENGE ; 


        return helper(0 , matchsticks , arr  , limit) ; 
    }
    public boolean helper( int index , int matchsticks[] , long arr[] , long limit)
    {
           
           if( index == matchsticks.length)
           {
               if( arr[0] == arr[1] && arr[1] == arr[2] && arr[2] == arr[3])
               {
                   return true ; 
               }


               return false ; 
           }

           // now we have 4 choice for every element , to keep it in first grpu , second , third or f
           // or fourth ; 
           

           // below written instruction is for prunning so that necessary call can be avoided ; 
              if( arr[0] > limit || arr[1] > limit || arr[2] > limit||  arr[3] > limit)
               {
                   return false; 
               }

           for( int i = 0 ; i < arr.length ; i++)
           {
               arr[i] += (long)matchsticks[index] ; 

               boolean temp = helper(index+1 , matchsticks , arr , limit) ; 

               if( temp == true)
               return true ; 

               arr[i] -= (long)matchsticks[index] ; 
           }

           return false ;
    }
    public void reverse(int arr[])
    {
        int i = 0 ; 
        int j = arr.length-1 ; 

        while( i < j)
        {
             int temp = arr[i] ; 
             arr[i] = arr[j] ; 
             arr[j] = temp; 

             i++ ; 
             j-- ; 
        }
    }
}