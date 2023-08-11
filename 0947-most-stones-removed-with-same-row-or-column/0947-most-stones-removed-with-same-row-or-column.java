/*
     the main catch for this question is that , this question should be done by 
     GRAPH ; 

     BECAUSE , THERE IS SOME CONNECTION BETWEEN , STONES TO BE REMOVED , SO FOR 
     CONSIDERING THAT CONNECTIONS , WE WILL USE GRAPH ; 


     WHAT WE WILL DO IS THAT , WE WILL FIND ALL CONNECTED COMPONENSTS , 
     , and in one connected component all can be removed except any one , 
     so we will run dfs and find the count of all connected components' elements -1 '
     and this will be our answer ; 


     
     */
class Solution {
    public int removeStones(int[][] stones) {
        

        HashMap<Integer,ArrayList<Integer>> map = new HashMap<>() ;

        for( int i = 0 ; i < stones.length-1 ; i++)
        {
            for( int j = i+1 ; j < stones.length ; j++)
            {
                  int temp1[] = stones[i] ; 
                  int temp2[] = stones[j] ; 


                  if( temp1[0] == temp2[0] || temp1[1] == temp2[1])
                  {
                      // toh in dono points ke bich mein connection hai ; 


                      if(map.containsKey(i))
                      {
                          ArrayList<Integer> list = map.get(i) ; 

                          list.add(j) ; 
                      }
                      else
                      {
                          ArrayList<Integer> list = new ArrayList<>() ;
                          list.add(j) ; 
                          map.put(i , list) ; 
                      }


                      if(map.containsKey(j))
                      {
                          ArrayList<Integer> list = map.get(j) ; 

                          list.add(i) ; 
                      }
                      else
                      {
                          ArrayList<Integer> list = new ArrayList<>() ;
                          list.add(i) ; 
                          map.put(j , list) ; 
                      }
                  }
            } 
        }


        boolean visited[] = new boolean[stones.length] ; 

        int count = 0 ; 

        for( int i = 0 ; i < visited.length ; i++)
        {
            if( visited[i] == false)
            {
               count +=  dfs(i , map , visited) - 1; 
            }
        }


        return count ; 
    }
    public int dfs(int vertex , HashMap<Integer,ArrayList<Integer>> map , boolean visited[])
    {
         if( visited[vertex] == true)
         return 0 ; 

         visited[vertex] = true ; 


         int count = 1 ; 


         if(map.containsKey(vertex) == false)
         return count ; 

         ArrayList<Integer> list = map.get(vertex) ; 

         for( int i = 0 ; i < list.size() ; i++)
         {
             count += dfs(list.get(i) , map , visited) ; 
         }


         return count ; 
    }
}