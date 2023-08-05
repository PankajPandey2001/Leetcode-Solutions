class Solution {
    public int countSquares(int[][] matrix) {
        

        int count = 0 ; 


        for( int i = matrix.length-1 ; i >= 0 ; i--)
        {
            for( int j = matrix[0].length-1 ; j >= 0 ; j--)
            {
                 if( i == matrix.length-1 || j == matrix[0].length-1)
                 {
                     if( matrix[i][j] == 1)
                     {
                         count++ ; 
                     }


                     continue ; 
                 }


                         if( matrix[i][j] == 0)
                         {
                             continue ; 
                         }
                         else
                         {
                             int right = matrix[i][j+1] ; 

                             int down = matrix[i+1][j] ; 

                             int opt = Math.min(down , right) ;  

                            //    if( matrix[i+opt][j+opt] == 1)

                              if( matrix[i+opt][j+opt] >= 1) // yahaan par ye likhna hai
                              // uper wali codnition likhi oth false ho jayga , kyonki hum ye 
                              // chahte hain ki yahaan , [i+opt][j+opt] mein 0 na ho bas ; 
                              // ho sakta ho wahaan humne phle hi kuh aur update kar diya ho ; 
                               {
                                   matrix[i][j] = opt + 1 ; 
                                   count += opt+1 ; 
                               }
                               else
                               {
                                   matrix[i][j] = opt ; 
                                   count += opt ; 
                               }
                         }
                     
                 
            }
        }

        return count ; 
    }
}