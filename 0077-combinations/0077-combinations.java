class Solution {
    public List<List<Integer>> combine(int n, int k) {
        
        List<List<Integer>> answer = new ArrayList<>() ; 


        for( int i = 1 ; i <= n + 1- k ; i++ )
        {
            List<Integer> list = new ArrayList<>() ; 

            list.add(i) ; 


            helper(list , answer , i+1 , k-1 , n) ; 



        }

        return answer ; 

    }
    public void helper(List<Integer>list ,  List<List<Integer>> answer  , int number , int count , int limit)
    {
         if( count == 0)
         {

             
             answer.add(new ArrayList<>(list)) ; 
             return ; 
         }


         if( number > limit)
         {
             return ; 
         }


         // now two option hain lenge ya nhi lenge ; 


         // if lenge ; 

         list.add(number) ; 

         helper( list , answer, number+1 , count-1 , limit) ; 

         list.remove(list.size()-1) ; 

         helper(list , answer , number+1 , count , limit) ; 
    }
}