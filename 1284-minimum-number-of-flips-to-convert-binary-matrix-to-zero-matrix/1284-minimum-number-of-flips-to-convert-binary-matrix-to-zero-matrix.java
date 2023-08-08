/*

    THE MAIN CATCH IN THIS QUESTION IS CONSTRAINTS , (check the constraints ) 
    since the value of n and m is maximum 3 ; 

    then we can try all possible ways , without getting TLE ; 
*/

class Solution {
    public int minFlips(int[][] mat) {
           

           // first handle edge cases  ; 


           if( mat.length == 1 && mat[0].length == 1)
           { 
                 if( mat[0][0] == 0)
                 return 0 ; 
                 else
                 return 1 ; 
           }

        // since the value of m and n is very less , and we have to return minimum 
        // number of steps , so we can use , recursion for it ; 

          boolean visited[][]  = new boolean[mat.length][mat[0].length] ; 

          if(isAllZero(mat) == true)
          return 0 ; 

          return helper( mat , visited) ; 


    }
    public int helper( int mat[][] , boolean visited[][])
    {
        int count = Integer.MAX_VALUE ; 

         if(isAllZero(mat) == true)
         return 0 ; 


         for( int i = 0 ; i < mat.length ; i++)
         {
             for( int j = 0 ; j < mat[0].length ; j++)
             {
                  if( visited[i][j] == true)
                  continue ; 
                  

                  flip( mat , i , j) ; 
                  visited[i][j] = true ; 

                  int temp = helper(mat , visited) ; 

                  visited[i][j] = false ; 
                  flip(mat , i , j) ;  // backtrack karte wakt phle jaise kar denge ; 

                  if( temp != -1 && temp < count)
                  count = temp ; 

             }
         }


          if( count == Integer.MAX_VALUE)
          return -1 ; 
          else
         return count+1 ; 
    }
    public void flip ( int mat[][] , int i , int j )
    {
          if( mat[i][j] == 1)
          mat[i][j] = 0 ; 
          else
          mat[i][j] = 1 ; 


          if( i-1 >= 0  )
          {
                 if( mat[i-1][j] == 1)
          mat[i-1][j] = 0 ; 
          else
          mat[i-1][j] = 1 ;
          }


          if( i+1 < mat.length)
          {
                if( mat[i+1][j] == 1)
          mat[i+1][j] = 0 ; 
          else
          mat[i+1][j] = 1 ;
          }


          if( j-1 >= 0)
          {
              if( mat[i][j-1] == 1)
          mat[i][j-1] = 0 ; 
          else
          mat[i][j-1] = 1 ;
          }


          if( j+1 < mat[0].length)
          {
                if( mat[i][j+1] == 1)
          mat[i][j+1] = 0 ; 
          else
          mat[i][j+1] = 1 ;
          }
    }
    public boolean isAllZero( int mat[][])
    {
        for( int i = 0 ; i < mat.length ; i++)
        {
            for( int j = 0 ; j < mat[0].length ; j++)
            {
                if( mat[i][j] == 1 )
                return false ; 
            }
        }


        return true ; 
    }
}