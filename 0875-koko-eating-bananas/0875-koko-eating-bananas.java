class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        

        int low = 1 ; 
     
       int high = Integer.MIN_VALUE ; 

       for( int i = 0 ; i < piles.length ; i++)
       {
           if( piles[i] > high)
           {
               high = piles[i] ; 
           }
       }


          int answer = 1 ; 

          while( low <= high)
          {
              int mid = low + (high-low)/2 ; 

              System.out.println( "if k ye h = " + mid ) ; 
              if( canEat(mid , piles , h) == true)
              {
                  answer = mid ; 
                   high = mid-1 ; 
                  
              }
              else
              {
                  low = mid+1 ; 
              }

            //   System.out.println(answer) ; 
          }

          return answer ; 
    }

    public boolean canEat(int mid , int piles[] , int h )
    {
         long count = 0 ;

         if( mid == 1 ) 
         {
              for( int i = 0 ; i < piles.length ; i++ )
             {
                  count += (long)piles[i] ; 

             }

             if( count <= h )
             return true ; 
             else 
             return false; 
         } 


         for( int i = 0 ; i < piles.length ; i++ )
         {
             int remainder = piles[i] % mid ; 

             count += (long)piles[i] / (long)mid ; 

             if( remainder != 0 )
             count++ ; 


         }

         System.out.println(count) ; 

         if( count <= h)
         return true ; 

         return false ; 
    }
}