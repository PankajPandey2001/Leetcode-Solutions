class Solution {
    public int maxDistToClosest(int[] seats) {
        
        // we will have to check for every index , that , in which index minimum distance is maximum 
        // but karna o(N) mein hi hai , so we will use 2 2d array one called front which will store
        // ki us index se just phle kaun sa index mein koi banda baitha tha

        // and another 2 d array one called back , which will store ki us inde ke just baad kis
        // index mein koi dusra banda baitha h ; and 
        // now for any index the answer is  Math.min( i - backward[i] , forward[i] - i) ; 


        int index = -1 ; 

        int forward[] = new int[seats.length] ; 

        for( int i = 0 ; i < seats.length ; i++)
        {
             if(seats[i] == 1 )
             {
                 forward[i] = index ; 
                 index = i ; 
             }
             else
             {
                 forward[i] = index ; 
             }

        }


        int backward[] = new int[seats.length] ; 

       index = seats.length ; 
        for( int i = seats.length-1 ; i >= 0  ; i--)
        {
             if(seats[i] == 1 )
             {
                 backward[i] = index ; 
                 index = i ; 
             }
             else
             {
                 backward[i] = index ; 
             }

        }


        // for( int i = 0 ; i < seats.length  ; i++)
        // {
        //     System.out.print(forward[i] + " ") ; 

        // }

        // System.out.println() ;

        // for( int i = 0 ; i < seats.length  ; i++)
        // {
        //     System.out.print(backward[i] + " ") ; 

        // }
        // System.out.println() ; 

        int answer = Integer.MIN_VALUE ;
        int idx = -1 ;  

        for( int i = 0 ; i < seats.length ; i++)
        {
            if(seats[i] == 1)
            continue ; 


            int tempindex = forward[i] ; 

           int left = 0 ; 
           int right = 0 ; 

            if(tempindex ==  -1)
            {
                left = Integer.MAX_VALUE ; 
            }
            else
            {
                left = i - tempindex ; 
            }

            System.out.print( i + " " + left ) ; 


            tempindex = backward[i] ; 

            if( tempindex == seats.length)
            {
                right = Integer.MAX_VALUE ; 
            }
            else
            right = tempindex - i ; 

        //    System.out.println( " " + right ) ; 

            if( Math.min(left , right) > answer)
            {
                answer = Math.min(left,right) ; 
                idx = i ; 
            }

            // System.out.println("index ye h " + idx) ; 
        }
        

        return answer ; 
    }
}