class Solution {
    public int maxValue(int[][] events, int k) {
        
        /*
            ye queston dp ke manipulation ka hai ;
            total unique calss teen chij par depend karegi k , index aur last added value ka 
            end day kya hain 

            but agar in teeno ko humne liya toh tle aa jayaga kyonki sirf k*evens.length = 10^6
            hai so agar hum isme last added value bhi add karnge toh , total produce 10^8 se     jyada
            ho jayga SO IT WILL GIVE TLE ; 


            SO WE HAVE TO MAKE CALL IN SUCH A WAY THAT ONLY K AND INDEX SHOULD CHANGE ; 
            AUR LAST ADDED VALUE MAINTAIN HI NA KARNI PADHEE ; 


        */


         Arrays.sort(events , (a,b) -> a[0]==b[0] ? a[1]-b[1] : a[0]-b[0]) ; 


         int dp[][] = new int[events.length][k+1] ; 

         for( int i = 0 ; i < dp.length ; i++)
         {
             for( int j = 0 ; j < dp[0].length ; j++)
             {
                 dp[i][j] = -1 ; 
             }
         }

         return maxValue( events , 0 , k , dp) ; 
    }
    public int maxValue(int events[][] , int index , int k , int dp[][])
    {
        if( k == 0 || index == events.length)
        return 0 ; 



          if(dp[index][k] != -1)
          return dp[index][k] ; 
        // two option is index wale ko lenge , ya nhi lenge ; 

     
        // if nhi lenge ; 
        int option1 = maxValue(events , index+1 , k ,dp) ; //since is index ko le sakte hain , toh 
        // iske next waale ko bina condition lagayen call kar denge kyonki wo toh le hi sakte 
        // honge because array is sorted in increasing order ; 


        // if lenge ; then ye dhyaan dena padhega ki agli call usi index par jaaye jiska starting day isse badha ho ; 

        int tempIndex = search(events , events[index][1] , index , events.length) ;

        

        int option2 = maxValue(events , tempIndex , k-1 , dp) + events[index][2] ; 



        dp[index][k]=  Math.max(option1, option2) ; 
        return dp[index][k] ; 
    }
    public int search( int events[][] , int value ,  int start , int end)
    {
         int index = events.length; 

         while(start < end)
         {
             int mid = start + (end-start)/2 ; 

             if( events[mid][0] > value )
             {
                 end = mid ; 
             } 
             else
             {
                start = mid+1 ; 
             }
         }

         return start ; 
    }
}