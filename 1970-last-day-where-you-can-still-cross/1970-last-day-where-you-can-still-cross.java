/*
             MAIN CATCH IS THAT BINARY SEARCH SHOULD HAVE COME IN OUR MIND ; / BECAUSE ANSWER HERE
             IS IN MONTONICALLY DIFFEREING , KYONKI EK INDEX KE BAAD SE JAANA IMPOSSIBLE HOGA ; 

             AUR USSE PHLE JAANA SAB MEIN TRUE SO WE CAN USE BINARY SERCH FOR IT ; 


*/

class Solution {
    public int latestDayToCross(int row, int col, int[][] cells) {
        
        int matrix[][] = new int[row][col] ; 
        
        HashMap<String,Integer> map = new HashMap<>() ; 



        for( int i = 0 ; i < cells.length ; i++)
        {
            int temp[] = cells[i] ; 

            // String s = "" + temp[0] + "_" + temp[1]  ; 


// <--------------------- niche wali line mein mistake kar di thi ;----------------------- 
         String s = "" + (temp[0]-1) + "_" + (temp[1]-1)  ;  // cells mein entry jo di hai 
         // wo 1 based indexing ke hissab se di hai ; 
            

            map.put(s , i) ; // now binary search mein bhi dhundna aasan ho isliye hashmap use kara
            // because what we will do , we will check ki kisi row ya column mein 1 present h ya nhi 
            // aur present h toh wo kis day mein aaya tha , agar jis day mein wo aaya tha
            // wo current day se phle ka h , toh hi us value pe hum 1 maanenge ;

            // System.out.println(map.get(s)) ; 

        }
     
      
            int low = 0 ; 
            int high = cells.length-1 ; 
        
        int answer = -1 ; 

         while( low <= high)
         {

               int mid = low + (high-low)/2 ; 

               boolean visited[][] = new boolean[row][col] ; 

               boolean hai = false ; 

               for( int column = 0 ; column < col ; column++)
               {
                //    if( matrix[0][column] == 1) // kyonki iske through nhi ja sakte ; 
                //    continue ; 

                     String str = "" + 0 + "_" + column ; 

                     if(map.containsKey(str) == true && map.get(str) <= mid) // means is cell pe 1 hoga
                     {
                         continue ; 
                     }
                 
                   

                   boolean isPossible = helper( matrix , 0 , column , visited , map , mid) ; 

                   if(isPossible == true)
                   {
                       hai = true; 
                       break ; 
                   }
                //    else
                //    {
                //        high = mid-1 ; 
                //    }
               }

                if( hai == true)
                {
                    // System.out.println( mid + " " + true) ; 
                    answer = mid+1 ; 
                    low = mid+1 ; 
                }
                else
                {
                    // System.out.println( mid + " " + false) ;
                    high = mid-1 ; 
                }
                


        }


        return answer ; 
    }
    public boolean helper( int matrix[][] , int row , int column , boolean visited[][] ,  HashMap<String,Integer> map , int day )
    {
        if( row < 0 || row >= matrix.length || column < 0 || column >= matrix[0].length)
        {
            return false ; 
        }

         
        //  if(matrix[row][column] == 1)
        //  return false ; 

         String str = "" + row  + "_" + column ; 
             
            //  if(map.containsKey(str))
            //  {
            //      System.out.println( " ye. h " + map.get(str)) ; 
            //  }
             if(map.containsKey(str) == true && map.get(str) <= day) // means is cell pe 1 hoga
             {
                return false ; 
             }

         
        if( row == matrix.length-1)
        {
            // System.out.println(row + " " + column + " " + " day = " + day + " true" ) ; 
            return true ; 
        } 

        if(visited[row][column] == true)
        return false ; 

        visited[row][column] = true ; 

        boolean option1 = helper(matrix , row+1 , column , visited , map , day) ;

        if(option1 == true)
        return true; 
         boolean option2 = helper(matrix , row , column+1 , visited , map , day) ;

         if(option2 == true)
        return true; 

          boolean option3 = helper(matrix , row, column-1, visited , map , day) ;

          if(option3 == true)
        return true; 

           boolean option4 = helper(matrix , row-1 , column , visited, map , day) ; 

           if(option4 == true)
        return true; 
         

         return false ;
             
        
    }
}