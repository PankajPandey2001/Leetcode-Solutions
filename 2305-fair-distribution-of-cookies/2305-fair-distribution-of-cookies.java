/*

  ------- MAIN THING TO LEARN FROM THIS QUESITON IS THAT TO UNDERSTAND THAT BINARY OR  GREED 
         APPORACH CAN NOT WORK HERE , THEREFORE WE WILL HAVE TO EXPLORE ALL POSSIBLE WAYS -------
         -----------------------------------------

         
  THIS PROBLEM IS VERY IMPORTANT , BECAUSE WE CAN MISUDERSTANDA THIS QUESITN BY , BINARY SERACH 
  OR GREEDY APPROACH , BUT GREEDY AND BINARY WILL NOT WORK HERE ; 

  HERE WE WILL HAVE TO FIND ALL POSSIBLE WAYS , TO DIVIDE THIS ARRAY INTO 4 PARTS ; 

*/

class Solution {
    public int distributeCookies(int[] cookies, int k) {
        
         int arr[] = new int[k] ; 


       // SEE GREEDY APPROACH WILL NOT WORK HERE , AND WE WILL HAVE TO FIND ALL POSSIBLE WAYS,
       // NOW FOR ANY IDNEX , IT HAS K CHOICE, THAT IS TO GO FROM  ANY OF THE INDE ; 

        return helper(0 , cookies , arr , Integer.MIN_VALUE) ; 
    }
    public int helper( int index , int cookies[] , int arr[] , int max)
    {
        // for every index we have k choices , and also backtrack karte wakt wapas jaayenge ; 
          
          if( index == cookies.length )
          return max ; 

           int temp = Integer.MAX_VALUE ; 

          for( int i = 0 ; i < arr.length ; i++)
          {
              arr[i] = arr[i] + cookies[index] ; 

              int option = helper(index+1 , cookies , arr ,  Math.max(max , arr[i])) ; 

              if(option < temp)
              {
                  temp = option ; 
              }


              arr[i] = arr[i] - cookies[index] ; 


          }

          return temp ; 




    }
}