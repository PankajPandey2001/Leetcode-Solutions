class Solution {
    public int slidingPuzzle(int[][] board) {
        
        HashSet<String> set = new HashSet<>() ; 

        String target = "" + 1 + 2 + 3 + 4 + 5 + 0 ; 

        System.out.println(target) ; 

        Queue<int[][]> q = new LinkedList<>(); 

        q.add(board) ; 
        q.add(null) ; 

       int level = 0 ; 

        while(q.size() != 1)
        {
               int temp2[][] = q.remove() ; 

               if( temp2 == null)
               {
                   q.add(temp2) ; 
                   level++ ; 
                   continue ; 
               }

              String temp = "" ; 
          
          board = temp2 ; // kyonki aage har jagah board , likh diya hai ; 

         int row = -1 ; 
         int column = -1 ; 

         for( int i = 0 ; i< 2 ; i++)
         {
             for( int j = 0 ; j < 3 ; j++)
             {
                 temp += board[i][j] ; 

                 if( board[i][j] == 0)
                 {
                     row = i ; 
                     column = j ; 
                 }
             }
         }

         if( temp.equals(target))
         return level ; 

          if( set.contains(temp))
          continue ; 


             set.add(temp) ; 
          
             if(row-1 >= 0)
             { 

                 int newArray[][] = helper(board , row , column , row-1 , column) ; 
                    
                    String temp1 = "" ; 
                    
                  for( int i = 0 ; i< 2 ; i++)
                {
                   for( int j = 0 ; j < 3 ; j++)
                   {
                        temp1 += newArray[i][j] ; 
                   }
                }


                if(set.contains(temp1) == false)
                {
                    q.add(newArray) ; 
                }

             }


              if(row+1 < board.length)
             { 

                 int newArray[][] = helper(board , row , column , row+1 , column) ; 
                    
                    String temp1 = "" ; 
                    
                  for( int i = 0 ; i< 2 ; i++)
                {
                   for( int j = 0 ; j < 3 ; j++)
                   {
                        temp1 += newArray[i][j] ; 
                   }
                }


                if(set.contains(temp1) == false)
                {
                    q.add(newArray) ; 
                }

             }


              if(column-1 >= 0)
             { 

                 int newArray[][] = helper(board , row , column , row , column-1 ) ; 
                    
                    String temp1 = "" ; 
                    
                  for( int i = 0 ; i< 2 ; i++)
                {
                   for( int j = 0 ; j < 3 ; j++)
                   {
                        temp1 += newArray[i][j] ; 
                   }
                }


                if(set.contains(temp1) == false)
                {
                    q.add(newArray) ; 
                }

             }


              if(column+1 < board[0].length)
             { 

                 int newArray[][] = helper(board , row , column , row , column+1 ) ; 
                    
                    String temp1 = "" ; 
                    
                  for( int i = 0 ; i< 2 ; i++)
                {
                   for( int j = 0 ; j < 3 ; j++)
                   {
                        temp1 += newArray[i][j] ; 
                   }
                }


                if(set.contains(temp1) == false)
                {
                    q.add(newArray) ; 
                }

             }



            
        }


        return -1 ; 
    }
    public int[][] helper(int board[][] , int row , int column , int row1 , int column1)
    {
        int arr[][] = new int[board.length][board[0].length] ; 


        for( int i = 0 ; i < arr.length ; i++)
        {
            for( int j = 0 ; j < arr[0].length ; j++)
            {
                arr[i][j] = board[i][j] ; 
            }
        }


       arr[row][column] = arr[row1][column1] ; 
       arr[row1][column1] = 0 ; 

       return arr ; 
    }
}

/*


        GIVNE BELOW IS DFS APPROACH , WHICH DID NOT WORK 


        ALWAYS REMEMBER WHENEVER WE HAVE ASKED , THE LEAST NUMBER OF MOVES , 
        THEN WE SHOULD DO THE QUESITON BY BFS ONLY 
        AND NOT DFS ; 

class Solution {
    public int slidingPuzzle(int[][] board) {
        
        HashSet<String> set = new HashSet<>() ; 

        HashMap<String,Integer> map = new HashMap<>() ; 


        String target = "" + 1 + 2 + 3 + 4 + 5 + 0 ; 


        System.out.println(target); 

        int temp =  helper(board , set , target , map) ; 

          if( temp == Integer.MAX_VALUE)
          return -1 ; 


          return temp ; 
    }
    public int helper( int board[][] , HashSet<String> set , String target , HashMap<String,Integer> map)
    {
         
         String temp = "" ; 


         int row = -1 ; 
         int column = -1 ; 

         for( int i = 0 ; i< 2 ; i++)
         {
             for( int j = 0 ; j < 3 ; j++)
             {
                 temp += board[i][j] ; 

                 if( board[i][j] == 0)
                 {
                     row = i ; 
                     column = j ; 
                 }
             }
         }

         if( temp.equals(target))
         return 0 ; 

          

         if( set.contains(temp))
         return Integer.MAX_VALUE ;

         if( map.containsKey(temp))
         return map.get(temp) ;

         set.add(temp) ; 

         // now we will explore all option;

         
         int min = Integer.MAX_VALUE ;

         if( row-1 >= 0 )
         {
             // phla option hoga ki row-1 wale se swapping kar lein

             board[row][column] = board[row-1][column] ; 

             board[row-1][column] = 0 ; 


             /// now do call and find answer ; 

             int opt = helper(board, set , target , map) ; 

             if( opt < min)
             min = opt ; 

             // backtrack. ;
             board[row-1][column] = board[row][column] ; 

            board[row][column] = 0 ; 
         }


         if( row+1 < board.length )
         {
             // phla option hoga ki row-1 wale se swapping kar lein

             board[row][column] = board[row+1][column] ; 

             board[row+1][column] = 0 ; 


             /// now do call and find answer ; 

             int opt = helper(board, set , target , map) ; 

             if( opt < min)
             min = opt ; 

             // backtrack. ;
             board[row+1][column] = board[row][column] ; 

            board[row][column] = 0 ; 
         }

         if( column-1 >= 0 )
         {
             // phla option hoga ki row-1 wale se swapping kar lein

             board[row][column] = board[row][column-1] ; 

             board[row][column-1] = 0 ; 


             /// now do call and find answer ; 

             int opt = helper(board, set , target , map) ; 

             if( opt < min)
             min = opt ; 

             // backtrack. ;
             board[row][column-1] = board[row][column] ; 

            board[row][column] = 0 ; 
         }
         
         if( column+1 < board[0].length )
         {
             // phla option hoga ki row-1 wale se swapping kar lein

             board[row][column] = board[row][column+1] ; 

             board[row][column+1] = 0 ; 


             /// now do call and find answer ; 

             int opt = helper(board, set , target , map) ; 

             if( opt < min)
             min = opt ; 

             // backtrack. ;
             board[row][column+1] = board[row][column] ; 

            board[row][column] = 0 ; 
         }

         set.remove(temp) ; 

         if( min == Integer.MAX_VALUE)
         {
             map.put(temp, min) ; 
             return min ; 
         }

         
          map.put(temp , min+1) ;

          return min +1 ;

    }
}


*/