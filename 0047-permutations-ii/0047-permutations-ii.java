// https://www.youtube.com/watch?v=rR9rPCYIwKc
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        
        // for unique permutation , har index mein ek number bas ek baar hi aana chahiye
        // so uske liye hashmap ka use kar sakte hain 

        HashMap<Integer,HashMap<Integer,Boolean>> map = new HashMap<>() ; 


        List<List<Integer>> answer = new ArrayList<>(); 
 
        helper(nums , 0 , map , answer) ;
        return answer ; 
    }
    public void helper( int nums[] , int index , HashMap<Integer,HashMap<Integer,Boolean>> map , List<List<Integer>> answer)
    {

          if(index == nums.length)
           {
               List<Integer> temp = new ArrayList<>() ;


               for( int i = 0 ; i < nums.length ; i++)
               {
                   temp.add(nums[i]) ; 
               }

               answer.add(temp) ; 

               return ; 
           }
        for( int i = index ; i < nums.length ; i++)
        {
            // sab process same rahega , jaise hum normal permutation lagate hain , bas
            // ek hashamp use kara hai , jisse , har index mein ek baar hi ek element aayga; 


            if( map.containsKey(index) == false )
            {
                 HashMap<Integer,Boolean> visited = new HashMap<>() ; 

                map.put(index, visited) ;    

            }
        


                HashMap<Integer,Boolean> visited = map.get(index) ; 


                if(visited.containsKey(nums[i]))
                continue ;  // kyonki tab us element se exchange nhi karenge ; 


                visited.put(nums[i] , true) ; 

                  // swap
                int temp = nums[i] ; 
                nums[i] = nums[index] ; 
                nums[index] = temp ; 

               helper(nums , index+1 , map , answer) ; 
              
              // swap again 
                temp = nums[i] ; 
                nums[i] = nums[index] ; 
                nums[index] = temp ; 


        }

       // NICHE WALA STEP BHOT JARURI HAI , BHOT ------------------------------------

       // EXPLANATION if startin mein 1 ko lekar baaki sab index ke liye hashmap bna diya , 
       // ab 2 ko lekar agar wo hi hashmap mein check karnege , toh saare preesnt dikhayenge ; 

       // isliye backjaate wakt , us index wale hashmap ko hata denge , taaki naye perumutaion ke
       // liye naye case check kar sakte ; 
        map.remove(index) ; // taaki alag alag permutaiotn ke liye alag alag consideration kar sakte
        // taaki different cases ko ek na samajh le 
    }
}