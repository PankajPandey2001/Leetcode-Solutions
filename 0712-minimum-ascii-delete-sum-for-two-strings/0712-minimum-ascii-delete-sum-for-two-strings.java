class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        

        // clearly the question is of dp , because , we have multiple ways , 
        // to make strings equal ; 


        HashMap<String,Integer> map = new HashMap<>() ; 

        return helper(s1 , s2 , s1.length()-1 , s2.length()-1 , map ) ; 


    }
    public int helper(String s1, String s2 , int i , int j , HashMap<String,Integer> map)
    {

        // step2 write base case ; 

        if( i == -1 && j == -1)
        return 0 ; 

        
        String temp = "" + i + "_" + j ; 

        if(map.containsKey(temp))
        return map.get(temp) ; 

        if( i == -1)
        {
             int sum = 0 ; 

            for( int k = 0 ; k <= j ; k++)
            {
                 sum += s2.charAt(k) ; 
            }

            map.put(temp,sum) ; 
            return sum ; 
        }
        else if( j == -1)
        {
             int sum = 0 ; 

            for( int k = 0 ; k <= i ; k++)
            {
                 sum += s1.charAt(k) ; 
            }
map.put(temp,sum) ; 
            return sum ; 
        }



        // now two option ; 

        if( s1.charAt(i) == s2.charAt(j))
        {
           
            int sum =  helper(s1, s2, i-1, j-1 , map) ;
            map.put(temp,sum) ;  
            return sum ; 
        }
        else
        {
             int option1 = helper(s1, s2, i-1 , j , map) + s1.charAt(i) ; 

             int option2 = helper(s1, s2, i, j-1 , map ) + s2.charAt(j) ; 


             int sum =  Math.min(option1 , option2) ; 
             map.put(temp,sum) ; 
             return sum ; 
        }
    }
}