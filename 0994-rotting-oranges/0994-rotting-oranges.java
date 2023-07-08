class Solution {
    public int orangesRotting(int[][] grid) {

       // now thing is very simple that we have to tell the minimum time , in which all fresh orange 
       // will beoome the rotten oranges , and all adjacent fresh orange of rotten oragne will get
       // rotten in same time and in one minute


       // also there can be so many rotten oranges , 

       // now agar hum koi bhi ek rotten orange dekh ke dfs lagayenge toh , ho sakta h koi fresh orange
       // jo kisi aur rotten ke pass mein hokar jaldi ho jaata wo is rotten oragne par dfs
       // lagane se late mein kharab ho ra ho 

       // kul milake baat ye h ki , humein , saare rotten orange ke adjacent walon ko same time 
       // par rotten karana h taaki kam time lage ,  so we cant use dfs
       
       // NOW WE WILL USE BFS , KYONKI , USSE KOI BHI FRESH ORANGE , WO JIS BHI ROOTTEN ORANGE
       // KE CLOSEST HOGA USKE WAJAH SE PHLE HI AA JAYGA QUEUE MEIN SO , JO MINIMUM TIME HOGA WO 
       // HI ANSWER AAYGA APNE MEIN 



       // CONCLUSION is we will do bfs 


       // and in 0 th minute , we will put all rotten oranges in queue , and then we will keep/
       // adding neighbors of rotten oranges in queue , and mark them visited , so that 
       // wo dubara queue mein na aa jaaye ; 
       // isse har fresh orange levelwise queue mein aayga , jisse time jo hoga wo minimum answer hi 
       // hoga 



        int answer = 0 ;   // this will store the answer ; 


        // first we will traverse in grid and we will put all rotten oranges  in level 0 of queu ; 

         Queue<int[]> q = new LinkedList<>() ; 


        for( int i = 0 ; i <  grid.length ; i++)
        {
            for( int j = 0 ; j < grid[0].length ; j++)
            {
                if( grid[i][j] == 2 )
                {
                    int temp[] = new int[]{ i , j } ; 

                    q.add(temp) ; 
                }
            }
        }


        // now in level 0 all rotten oranges daal diye hain ; 


        q.add(null) ; 


        while( q.size() != 1 )
        {
            int temp[] = q.remove() ; 

            if( temp == null)
            {
                answer += 1 ; 
                q.add(null) ; 
                continue; 
            }
             
            int row = temp[0] ; 
            int column = temp[1] ; 

            if( row-1 >= 0 && grid[row-1][column] == 1 )
            {
                grid[row-1][column] = 2 ; 

                int arr[] = new int[]{row-1 , column} ; 
                q.add(arr) ; 

            }
            if( row+1 <  grid.length && grid[row+1][column] == 1 )
            {
                grid[row+1][column] = 2 ; 

                int arr[] = new int[]{row+1 , column} ; 
                q.add(arr) ; 

            }
            if( column-1 >= 0 && grid[row][column-1] == 1 )
            {
                grid[row][column-1] = 2 ; 

                int arr[] = new int[]{row , column-1} ; 
                q.add(arr) ; 

            }
            if( column+1 < grid[0].length && grid[row][column+1] == 1 )
            {
                grid[row][column+1] = 2 ; 

                int arr[]= new int[]{row , column+1} ; 
                q.add(arr) ; 

            }

            

        }

        // return answer ; 
        // hum direct answer return nhi karenge hum dekhenge ki jitne bhi fresh orange 
        // rotten ho re the un sabke rotten hone ke baad kya koi fresh orange bach gya h kya 
        // agar koi bach gya h toh hum return kar denge -1 ; 


        for( int i = 0 ; i <  grid.length ; i++)
        {
            for( int j = 0 ; j < grid[0].length ; j++)
            {
                if( grid[i][j] == 1 )
                {
                    return -1 ; 
                }
            }
        }

        return answer ; 
    }
}