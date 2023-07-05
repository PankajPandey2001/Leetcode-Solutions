class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        
        // boolean visited[] = new boolean[10] ; //because 1 se 9 tak le sakte hain ; 

        List<List<Integer>> answer = new ArrayList<>() ; 

        List<Integer> list = new ArrayList<>() ; 
         
        helper( answer /*, visited */, list , k , n , 0) ;

        return answer ;  
    }
    public void helper( List<List<Integer>> answer , List<Integer> list , int k , int n , int previousValue ) // same dubara repeat na ho islye apne previousVAlue se jyada ka hi 
    // le sakenge ; 
    {
         if( k == 0)
         {
             if( n == 0)
             {
                 answer.add(new ArrayList<>(list)) ; 
                 
             }
           
             return ; 
         }

 
         if( n == 0) // kyonki k 0 nhi hua hoga ; 
         return ; 

         for( int i = previousValue+1 ; i <= 9 ; i++)
         {
            //  if( visited[i] == true)
            //  continue ; 


            //  visited[i] = true ; 

             list.add(i) ; 
             helper(answer /*, visited*/ , list , k-1 , n-i , i ) ; 

            //  visited[i] = false ; 
             list.remove(list.size()-1) ; 
         }

    }
}