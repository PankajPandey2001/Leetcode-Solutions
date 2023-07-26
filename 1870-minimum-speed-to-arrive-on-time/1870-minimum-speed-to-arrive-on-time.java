class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        
        int min = 0 ; 

        int max = (int)Math.pow(10,7) ;  // koi toh value leni hi thi , to save time , jo question mein given
        // h ki maximum pahunch sakti h , wo le li ; 

        
         int answer= Integer.MAX_VALUE; 

        while( min <= max)
        {
            int mid =(min+max)/2 ; 

            if( mid == 0 )
            return answer ; 

            if( isPossible(dist,mid,hour))
            {
                answer = mid ; 
                max = mid-1 ; 
            }
            else
            {
                min = mid+1 ;
            } 

        }
       
        if( answer == Integer.MAX_VALUE)
        return -1 ; 

        return answer ; 


    }
    public boolean isPossible( int dist[] , int speed , double hour)
    {
            double time = 0 ; 

         for( int i = 0 ; i < dist.length ; i++)
         {
             if( i == dist.length-1)
             {
                 time += (double)(dist[i]) / (double)(speed) ; 
                 break ; 
             }

              if( dist[i] % speed != 0)
              {
                 time += (dist[i]/speed) + 1 ;   
              }
              else
              {
                  time += (dist[i]/speed) ; 
              }
         }


         if( time <= hour)
         {
             return true ; 
         }


         return false ; 
    }
}