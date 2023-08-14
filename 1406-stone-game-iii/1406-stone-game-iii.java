class Solution {
    public String stoneGameIII(int[] stoneValue) {
        

        // this is simple take or not take ; question , instead of returning array for
        // both alice and bob value , what we will do is that we will find ; the maximum
        // value which can be taken by that member , we will use 0 and 1 to tell that ,
        // whose turn is there ; 


      // instead of finding maximum value for both alice and bob , we will find only
      // value of alice , means maximum value which alice can take,(because alice is taking)
      // first turn , so alice will start making favourable move for himself ;  
      // and then for that maximum value , we will find respective value for bob 
      // by subtracting   aliceValue from totalValue ; 

      // now we will compare these values, if aliceVAlue is greater than alice win , and 
      // same other conidition , 

       HashMap<String , Integer> map = new HashMap<>() ; 

        int valueAliceMax = helper(stoneValue , 0 , 1 , map) ; 

         int total = 0 ; 

        for( int i = 0 ; i < stoneValue.length ; i++)
        {
            total += stoneValue[i] ; 
        }


        int valueBob = total - valueAliceMax ; 

        if( valueAliceMax > valueBob)
        {
            return "Alice" ; 
        }
        else if( valueBob > valueAliceMax)
        {
            return "Bob" ; 
        }
        else
        return "Tie" ; 

    }
    public int helper(int stoneValues[] , int index , int turn, HashMap<String , Integer> map )
    {
        if( index >= stoneValues.length)
        {
            return 0 ; 
        }
 



       String s = "" + index + "_" + turn ; 

       if( map.containsKey(s))
       return map.get(s) ; 


        if( turn == 1 ) // means alice ki turn hai , toh ye maximum score karne ki kosish karea
        {

            int opt1 = Integer.MIN_VALUE ; 
             int opt2 = Integer.MIN_VALUE ; 
              int opt3 = Integer.MIN_VALUE ; 


              opt1 = helper( stoneValues , index+1 , 0 , map) + stoneValues[index] ; 


              if( index+1 < stoneValues.length)
              opt2 = helper( stoneValues , index+2 , 0 , map) + stoneValues[index] + stoneValues[index+1];

              if( index+2 < stoneValues.length)
              opt3 =  helper( stoneValues , index+3 , 0 , map) + stoneValues[index] + stoneValues[index+1] + stoneValues[index+2] ;



       
              map.put( s,  Math.max(opt1 , Math.max(opt2,opt3)) ); 
              return Math.max(opt1 , Math.max(opt2,opt3)) ; 
        }
        else
        {
            int opt1 = Integer.MAX_VALUE ; 
             int opt2 = Integer.MAX_VALUE ; 
              int opt3 = Integer.MAX_VALUE ; 


              opt1 = helper( stoneValues , index+1 , 1 , map) ; 


              if( index+1 < stoneValues.length)
              opt2 = helper( stoneValues , index+2 , 1 , map)  ;  


              if( index+2 < stoneValues.length)
              opt3 =  helper( stoneValues , index+3 , 1 , map)  ; 



             map.put(s,Math.min(opt1 , Math.min(opt2,opt3))) ; 
              return Math.min(opt1 , Math.min(opt2,opt3)) ; 
        }
    }
}