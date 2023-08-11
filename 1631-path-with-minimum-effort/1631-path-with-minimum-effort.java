/*

   since here we have to find the minimum of the maximum , so whenever we 
   encountered this term , we have to use binary serach ; 


   // now here maximum effort can be the maximum value - minimumVAlue ; 
   or we can take integer.maxvlue also ; 



*/
class Solution {
    public int minimumEffortPath(int[][] heights) {
        
         int min = Integer.MAX_VALUE ; 
         int max = Integer.MIN_VALUE ; 


        for( int i = 0 ; i < heights.length; i++)
        {
            for( int j = 0 ; j < heights[0].length; j++)
            {
                if(heights[i][j] < min)
                {
                    min = heights[i][j] ; 
                }
                

                if( heights[i][j] > max)
                max = heights[i][j] ; 
            }
        }


        int start = 0 ; 

        int end = max - min ; 

        int answer = -1 ; 

        while( start <= end)
        {
            int mid = start + (end-start)/2 ;

            boolean visited[][] = new boolean[heights.length][heights[0].length] ; 
       
               HashMap<String,Boolean> map = new HashMap<>() ; 
            if( isPossible(heights , mid , visited , 0 , 0, map ) == true )
            {
                answer = mid ; 

                end = mid-1 ; 
            }
            else
            {
                start = mid+1 ; 
            }
        }


        return answer ; 
    }
    public boolean isPossible(int heights[][] , int diff , boolean visited[][] , int row , int column , HashMap<String,Boolean> map )
    {

         if( row >= heights.length || row < 0 || column < 0 || column >= heights[0].length)
         return false ; 

         
         visited[row][column] = true ; 

        String s = "" + row + "_" + column ; 

        if(map.containsKey(s))
        return map.get(s) ;


          if( row == heights.length-1 && column == heights[0].length-1)
          {
              map.put(s,true) ;
              return true ; 
          }

        
        if( row +1 < heights.length  && visited[row+1][column] == false)
        {
            if( Math.abs(heights[row][column] - heights[row+1][column]) <= diff)
            {
                boolean opt1 = isPossible(heights , diff , visited , row+1, column , map) ;

                if(opt1 == true)
               { map.put(s , true) ; 
                return true ;
                } 
            }
        }

        if( row -1 >= 0  && visited[row-1][column] == false)
        {
            if( Math.abs(heights[row][column] - heights[row-1][column]) <= diff)
            {
                boolean opt1 = isPossible(heights , diff , visited , row-1, column , map) ;

                if(opt1 == true)
               { map.put(s , true) ; 
                return true ;
                } 
            }
        }

        if( column-1 >= 0  && visited[row][column-1] == false)
        {
            if( Math.abs(heights[row][column] - heights[row][column-1]) <= diff)
            {
                boolean opt1 = isPossible(heights , diff , visited , row , column-1 , map) ;

               if(opt1 == true)
               { map.put(s , true) ; 
                return true ;
                } 
            }
        }

        if( column+1 < heights[0].length && visited[row][column + 1] == false)
        {
            if( Math.abs(heights[row][column] - heights[row][column+1]) <= diff)
            {
                boolean opt1 = isPossible(heights , diff , visited , row, column+1 , map) ;

                if(opt1 == true)
               { map.put(s , true) ;
                return true ;
                } 
            }
        }

          map.put(s , false) ; 
        return false ; 
    }
}