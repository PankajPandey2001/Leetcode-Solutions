class Solution {
    public boolean checkValidString(String s) {
         
         /// step for recursion , write the functino in the form of index , 

         // ste2 write base case ; (you can do some prunning also ) ;

         // step3  - wrtie recurrence relation ; 
       
          // no need of stack , we can use just count pointer to keep track of
          // open bracket , because we know we have to take care of only open bracket ;
          // aur jaise close bracket aayga hum ek open bracket ko kam kar denge ; 


          int dp[][] = new int[s.length()][s.length()] ;  // column hum number of coutn 
          // ko represeent karne ke liye use kar re hain 

         return helper( s, 0  , 0 , dp ) ; 
    }
    public boolean helper( String s , int index , int count , int dp[][] )
    {


     
         // base cases 

         if(count < 0)
         return false ; 

         if( index == s.length())
         {
             if( count == 0 )
             return true; 
             else
             return false ; 
         }

         if(dp[index][count] == 1)
         return true ; 
         

         if( dp[index][count] == 2)
         return false ; 

          // prunning 
         if( s.length()-index < count)
         {
             dp[index][count] = 2 ; 
             return false;
         }  // kyonki saare ab close bhi hogne fir bhi open walon ko cover nhi 
         // kar sakte ; 

          
          if( s.charAt(index) == '(')
          {
              boolean opt1 = helper(s , index+1 , count+1 , dp) ; 

              if(opt1 == true)
              {
                  dp[index][count] = 1 ;
                return true ; 
              }
              else
              {
                  dp[index][count] = 2 ; 
                  return false ; 
              }


          }
          else if( s.charAt(index) == ')')
          {
              if( count == 0)
              {
                   dp[index][count] = 2 ; 
                   return false ; 
              }

              boolean opt1 = helper(s , index+1 , count-1 , dp) ; 


              if(opt1 == true)
              {
                  dp[index][count] = 1 ;
                return true ; 
              }
              else
              {
                  dp[index][count] = 2 ; 
                  return false ; 
              }
          }
          else
          {
              // * ko hum open bhi maan sakte hain aur close bhi ; 

            //   if( count == 0 )
            //   return helper(s , index+1 , count+1) ; 


              // both option lenge ; 

              boolean option1 = helper(s , index+1 , count+1 , dp) ;  // considering * as '('
              boolean option2 = helper(s , index+1 , count-1, dp) ;// considering * as ')'
              boolean option3 = helper( s, index+1 , count , dp) ;  // considerint * as empty


              boolean opt1 =  option1||option2|| option3  ; 


              if(opt1 == true)
              {
                  dp[index][count] = 1 ;
                return true ; 
              }
              else
              {
                  dp[index][count] = 2 ; 
                  return false ; 
              }
          }
    }
}