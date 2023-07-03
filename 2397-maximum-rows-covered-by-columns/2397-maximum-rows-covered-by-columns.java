// in this question we can take numSelect number of columns and in this column 1 can be treated as 0 
//now we have to tell the mximum no of rows, with no ones and if any one it shuould be on above column ;

// do not misunderstood this questin as k subeset sum , becuause this is question of 
// COMBINATION AND NOT OF PERMUTATON ; 
// REMEBER THIS IS QUESTION OF COMBINATION ; and not of PERMUTATOIN , MEANS BAS SELECT KARNA H , AB
// wo kis number par select ho ra ho usse koi dikkat nhi h ;

class Solution {
    public int maximumRows(int[][] matrix, int numSelect) {
          
          HashMap<Integer,Boolean> map = new HashMap<>() ; // it will contain column which we 
          // have choosen , we have to remember that for each way , the size of Hashmap will be
          // numSelect ; 


              // now we have two option for every colum , means whether to take this column or not
              //in our hashmap , 

        int temp = helper(0  , matrix , numSelect , map) ; 


        return temp ;  
        // now saath saath saare options explore karne hain prunning karne ke ; 

          
    }
    public int helper( int index , int matrix[][] , int numSelect , HashMap<Integer,Boolean> map )
    {
         if( index == matrix[0].length)
         {
             if(numSelect > 0 ) // means hum koi column aur choose kar sakte the , toh abvious h us[ar
             // answr jyada badha hota so 
             return Integer.MIN_VALUE ;  


             int answer = count(matrix ,map) ; 
             return answer ; 

         }
        else if(numSelect == 0 ) // means jitne column le sakte the utne le liye ; 
        {
            int answer = count(matrix ,map) ; 

            return answer ; 
        }
        else if( numSelect > matrix[0].length - index) // for prunning ; 
        {
            return Integer.MIN_VALUE ; 
        }


        // now two opitno lena h ya nhi lena ; 

        // first lena h ; 

        map.put(index , true) ; 
        int option1 = helper( index+1 , matrix , numSelect-1 , map ) ; 

         // second nhi lena ; 
       map.remove(index) ; 
        int option2 = helper(index+1 , matrix , numSelect , map) ; 
       

       return Math.max(option1 , option2) ; 


    }
    public int count( int matrix[][] , HashMap<Integer,Boolean> map )
    {
             int count = 0 ; 
    
        for( int row = 0 ; row < matrix.length ; row++)
        {        
                 boolean canCount = true  ; 
            for( int column = 0 ; column < matrix[0].length ; column++)
            {
                if( matrix[row][column] == 0)
                continue ; 

                if(matrix[row][column] == 1 )
                {
                    if(map.containsKey(column))
                      continue ; 

                    canCount = false ; 
                    break ; 
                }
            }

            if(canCount == true)
            count++ ; 
        }

        return count ; 
    }

}