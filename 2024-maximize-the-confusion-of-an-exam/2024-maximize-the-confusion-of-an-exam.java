class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        
        // humne aisa questoin kara h , par wo , bas sirf ek ka badhana ho toh uske hissab se
        // kara h , jaise 1 ka sequence sabse jyada hona chahiye , aisa karke ; 


        // now , humein true or false jiska bhi jyada ho sake uska badhana hai , toh hum dono ke 
        // liye seperate try kar sakte hain ; 

         Queue<Integer> q = new LinkedList<>() ; 
       
         int max = Integer.MIN_VALUE ; 

          

         int length = helper(answerKey , k , 'T' , q ) ; 

         if(length > max)
         max = length ;


         length = helper(answerKey , k , 'F' , new LinkedList<>()) ; 

          if(length > max)
         max = length ;


         return max ; 
        
    }
    public int helper(String s , int k , char ch , Queue<Integer> q)
    {
        int length = Integer.MIN_VALUE ; 

           int i = 0 ; 
           int j = 0 ; 

           while( j < s.length())
           {

               if( j - i  > length)
                   length = j-i ; 

               if( s.charAt(j) == ch)
               {
                   j++ ;
                    
                   continue ; 
               }


               // if yahaan pahucnh means replace karna padhega ; 

               if(q.size() == k) // means already k replace kar chuke hain , so , sabse phle replace
               // wale ko hatana padhega ; 
               {
                    int index = q.remove() ;

                    i = index+1 ; 

                    q.add(j) ; 
                    j++ ; 
               }
               else
               {
                   q.add(j) ;  //assuming we replaced it ; 

                   j++ ; 
               }
           }

           if(s.length() - i > length)
           length = s.length() - i ; 


           return length; 
    }
}