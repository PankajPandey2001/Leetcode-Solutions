class Solution {
    public void gameOfLife(int[][] board) {
        
        // IF IN PLACE. nhi karni hoti. then we could use , a Hahsmap to store the cell. 
        // whose value we have to toggle , but we have to do it in ON PLACE K 
        // so we will have to mark those cells , whose value we have to change , 
        // without actually toggling them , 

        // so for that we can use , two addition values , one for live cell , jinko toggle
        // karna hai ( lets say  2 ) ,  2 will tell that in this column 1 is present 
        // whose value we have to change to 0 , after the complete process ; 


        // SIMILAR WE WILL USE , ONE VALUE FOR 0 (LETS SAY -1) , 



        for( int i = 0 ; i < board.length ; i++)
        {
            for( int j = 0 ; j < board[0].length ; j++)
            {
                    
                    if(board[i][j] == 0)
                    { 
                         // count the neigbor live cell ; for that we can use function; as
                         // tihis will be repetitive work ; 

                         int count = helper(board , i , j) ; 

                         if( count == 3)
                         {
                             board[i][j] = -1 ; // means after one complete traversal , we
                             // will convert it into , 1 , but in this iteration we will
                             // take it as 0 only ; 
                         }


                    }
                    else
                    {
                         int count = helper( board , i , j) ; 

                         if( count < 2 || count > 3 )
                         {
                             board[i][j] = 2 ; 
                         }
                    }
            }
        }



        for( int i = 0 ; i < board.length ; i++)
        {
            for( int j = 0 ; j < board[0].length ; j++)
            {
                    
                    if(board[i][j] == -1)
                    { 
                        board[i][j] = 1 ; 
                    }
                    else if(board[i][j] == 2 )
                    {
                        board[i][j] = 0 ; 
                    }
            }
        }
    }
    public int helper( int board[][] , int row , int column)
    {
            int count = 0 ; 

        if( row + 1 <  board.length )  // column same ; 
        {
            if( board[row+1][column] == 1 || board[row+1][column] == 2)
            count++ ; 
        }


        if( row -1 >= 0 )  // column same ; 
        {
            if( board[row-1][column] == 1 || board[row-1][column] == 2)
            count++ ; 
        }


         if( column + 1 <  board[0].length )  // column same ; 
        {
            if( board[row][column+1] == 1 || board[row][column+1] == 2)
            count++ ; 
        }


            if( column -1 >= 0 )  // column same ; 
        {
            if( board[row][column-1] == 1 || board[row][column-1] == 2)
            count++ ; 
        }


            if( row+1 < board.length && column + 1 <  board[0].length )  // column same ; 
        {
            if( board[row+1][column+1] == 1 || board[row+1][column+1] == 2)
            count++ ; 
        }

         if( row+1 < board.length && column - 1 >= 0 )  // column same ; 
        {
            if( board[row+1][column-1] == 1 || board[row+1][column-1] == 2)
            count++ ; 
        }


          if( row-1 >= 0  && column + 1 <  board[0].length )  // column same ; 
        {
            if( board[row-1][column+1] == 1 || board[row-1][column+1] == 2)
            count++ ; 
        }


          if( row-1 >= 0  && column -1 >= 0 )  // column same ; 
        {
            if( board[row-1][column-1] == 1 || board[row-1][column-1] == 2)
            count++ ; 
        }



           return count ; 
    }
}