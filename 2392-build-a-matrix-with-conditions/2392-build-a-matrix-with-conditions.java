/* 
edge case
8
[[1,2],[7,3],[4,3],[5,8],[7,8],[8,2],[5,8],[3,2],[1,3],[7,6],[4,3],[7,4],[4,8],[7,3],[7,5]]
[[5,7],[2,7],[4,3],[6,7],[4,3],[2,3],[6,2]]


edge case , in those test ases , jin values mein koi constrainst nhi hai wo kaihn bhi aa sakte hain  , so jo constraints ke bhaar hain unke liye humein hissab bnaana padhega ; 

 */

class Solution {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        

        int matrix[][] = new int[k][k] ; 


        HashMap<Integer,ArrayList<Integer>> column = new HashMap<>() ; 

        HashMap<Integer,ArrayList<Integer>> row = new HashMap<>() ; 


        for( int i = 0 ; i < rowConditions.length ; i++)
        {
            int temp[] = rowConditions[i] ; 

            if(row.containsKey(temp[0]))
            {
                ArrayList<Integer> list = row.get(temp[0]) ; 
                list.add(temp[1]) ; 
            }
            else
            {
                 ArrayList<Integer> list = new ArrayList<>() ; 
                list.add(temp[1]) ; 
                row.put(temp[0] ,list) ; 


            }
            
        }



        for( int i = 0 ; i < colConditions.length ; i++)
        {
            int temp[] = colConditions[i] ; 

            if(column.containsKey(temp[0]))
            {
                ArrayList<Integer> list = column.get(temp[0]) ; 
                list.add(temp[1]) ; 
            }
            else
            {
                 ArrayList<Integer> list = new ArrayList<>() ; 
                list.add(temp[1]) ; 
                column.put(temp[0] ,list) ; 
            }
            
        }


        // now we will do topolical sort for , both rows and column ; and stored them in the
        // stack ; 
         

          Stack<Integer> rowwise = new Stack<>() ; 

          boolean visited[] = new boolean[k+1] ; 
          boolean stackVisited[] = new boolean[k+1] ; 


          for( int i = 1 ; i <= k ; i++)
          {
                if( visited[i] == false && row.containsKey(i))
                {
                    boolean temp = dfs(i , visited , stackVisited , rowwise , row) ;

                    if(temp == false)
                    {
                        int array[][] = {} ; 
                        return array ; 
                    }

                }
          }

          Stack<Integer> colwise = new Stack<>() ; 
          visited = new boolean[k+1] ; 
          stackVisited = new boolean[k+1] ; 



           for( int i = 1 ; i <= k ; i++)
          {
                if( visited[i] == false && column.containsKey(i))
                {
                    boolean temp = dfs(i , visited , stackVisited , colwise , column) ;

                     if(temp == false)
                    {
                        int array[][] = {} ; 
                        return array ; 
                    } 

                }
          }
      
        
         HashMap<Integer,Integer> map = new HashMap<>() ; 
         int count = 0 ; 
        while(rowwise.size() != 0)
        {
            map.put(rowwise.pop() , count) ; 
            count++ ; 
        }


         count = 0 ; 
         HashMap<Integer,Integer> map1 = new HashMap<>() ; 
        
        while(colwise.size() != 0)
        {
            map1.put(colwise.pop() , count) ; 
            count++ ; 
        }


         int lastRow = k-1 ; 
         int lastCol = k-1 ; 

         for( int i = 1 ; i <= k ; i++)
         {
              
              if(map.containsKey(i) && map1.containsKey(i))
              {
                  matrix[map.get(i)][map1.get(i)] = i ;
              }
              else if(map.containsKey(i))
              {
                  matrix[map.get(i)][lastCol] = i ; 

                  lastCol-- ; 
              }
              else if(map1.containsKey(i))
              {
                    matrix[lastRow][map1.get(i)] = i ; 
                    lastRow-- ; 
              }
              else
              {
                  matrix[lastRow][lastCol] = i ; 

                  lastRow-- ; 
                  lastCol-- ; 
              }
         }

          return matrix ; 


    }
    public static boolean dfs( int vertex , boolean visited[] , boolean stackVisited[] ,  Stack<Integer> stack , HashMap<Integer,ArrayList<Integer>> map )
    {

        if(stackVisited[vertex] == true)
        {
            return false ; 
        }

        if( visited[vertex] == true)
        {
            return true ; 
        }

         visited[vertex] = true ; 
         stackVisited[vertex] = true ; 

        if(map.containsKey(vertex) == false)
        {
             stack.push(vertex) ; 

              stackVisited[vertex] = false ; 
             return true ; 
        }

        

        ArrayList<Integer> list = map.get(vertex) ; 


        for( int i = 0 ; i < list.size() ; i++)
        {
           boolean temp =  dfs(list.get(i) , visited , stackVisited , stack , map) ; 

           if(temp == false)
           return false ; 
        }


        stack.push(vertex) ; 
        stackVisited[vertex] = false ; 


        return true ; 
    }
}