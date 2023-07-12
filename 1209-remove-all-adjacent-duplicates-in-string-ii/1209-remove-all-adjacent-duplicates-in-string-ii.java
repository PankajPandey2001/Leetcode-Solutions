class Solution {
    public String removeDuplicates(String s, int k) {
        
        Stack<char[]> stack = new Stack<>() ; 

        char ch = s.charAt(0) ; 
        int count = 1 ; 


        int i = 1 ; 

        while( i < s.length())
        {
   
            if( s.charAt(i) == ch)
            {
                count++ ; 
            }
            else
            {
                count = count % k ;  // taaki jo replace ho rahe hain unko hata do ; 

                if( count != 0)
                {
                      if(stack.size() != 0)
                   {
                      char temp[] = stack.peek() ; 

                       if(temp[0] == ch)
                       {
                          stack.pop() ; 

                          count += temp[1] - '0'; 

                          count = count % k ; 

                          if( count != 0)
                          {
                              temp[1] = (char)(count + '0') ; 
                              stack.push(temp) ; 
                          }

                       }
                       else
                       {
                           char newArray[] = {ch , (char)(count + '0')} ; 
                           stack.push(newArray) ; 
                       }
                   } 
                   else
                   {
                        char newArray[] = {ch , (char)(count + '0')} ; 
                        stack.push(newArray) ; 
                   }
                }
                

                    ch = s.charAt(i) ; 
                    count = 1 ; 
                


                  
            }


            i++ ; 
        }



              count = count % k ;  // taaki jo replace ho rahe hain unko hata do ; 

                if( count != 0)
                {
                      if(stack.size() != 0)
                   {
                      char temp[] = stack.peek() ; 

                       if(temp[0] == ch)
                       {
                          stack.pop() ; 

                          count += temp[1] ; 

                          count = count % k ; 

                          if( count != 0)
                          {
                              temp[1] =  (char)(count + '0') ; 
                              stack.push(temp) ; 
                          }

                       }
                       else
                       {
                           char newArray[] = {ch , (char)(count + '0')} ; 
                           stack.push(newArray) ; 
                       }
                   } 
                   else
                   {
                        char newArray[] = {ch , (char)(count + '0') } ; 
                        stack.push(newArray) ; 
                   }
                }

          StringBuilder str = new StringBuilder() ; 


          while(stack.size() != 0)
          {
              char temp[] = stack.pop() ; 
              
               count = temp[1]- '0' ; 

              while(count > 0)
              {
                  str.insert(0 , temp[0] ) ; 

                  count-- ;
              }
              
          }



          return str. toString() ; 

    }
}