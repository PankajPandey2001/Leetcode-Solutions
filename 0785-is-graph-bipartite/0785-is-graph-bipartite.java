/*
     hint is only one thing that is


     1. IF GRAPH ACYCLIC (NOT CYCLE) , then it will be alwasy bipartite ; 

     2. IF GRAPH CYCLIC ; 

          , then if length of cycle even , then it will be bipartite ; 

          , if length of any cycle is odd, then it can not be partite ; 




*/

class Solution {
    public boolean isBipartite(int[][] graph) {
        
        if(graph.length == 1)
        return true ; 


        // STEP-1 FOR ANY GRAPH QUESITON SINCE IT IS NOT GIVEN THAT , WHETHER GRAPH IS CONNECTED
       //          OR NOT WE WILL SOLVE THINKING THAT IS NOT 
      //          CONNECTED

         HashMap<Integer,Integer> map = new HashMap<>() ; 


         for( int i = 0 ; i < graph.length ; i++)
         {
             if( map.containsKey(i) == true) // means ye phle hi visit ho gya 
             continue ; 


             boolean temp = isOddCyclic( i , graph , map , 0, -1 ) ; 

             if( temp == true)
             return false ; 

         }


         return true ; 
    }
    public boolean isOddCyclic(int vertex , int graph[][] ,  HashMap<Integer,Integer> map, int level , int parent)
    {

    
          if( map.containsKey(vertex))
          {
              if( (level - map.get(vertex)) % 2 == 0)
              return false ; 
              else
              return true ; 
          }



          map.put(vertex , level) ; 

          int temp[] = graph[vertex] ; 

          for( int i = 0 ; i < temp.length; i++)
          {
              if( temp[i] == parent)
              continue ; 


              boolean curr = isOddCyclic( temp[i] , graph , map , level+1 , vertex ) ; 

              if( curr == true)
              return true; 
          }


          return false ; 
    }
}