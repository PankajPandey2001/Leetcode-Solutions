class Solution {
    public int romanToInt(String s) {
        
        HashMap<Character,Integer> map = new HashMap<>() ; 


          map.put('I' , 1 ) ; 
        map.put('V' , 5 ) ;
        map.put('X' , 10) ;
        map.put('L' , 50) ;
        map.put('C' , 100) ;
        map.put('D' , 500 ) ;
        map.put('M' , 1000) ;

         
         int value = 0 ; 

        for( int i = 0 ; i < s.length() ; i++)
        {
            if( i == s.length()-1) 
            {
                value += map.get(s.charAt(i)) ; 
            }
            else
            {
                char ch1 = s.charAt(i) ; 
                char ch2 = s.charAt(i+1) ; 

                if( map.get(ch2) > map.get(ch1))
                {
                    value += map.get(ch2)-map.get(ch1) ; 
                    i++ ;
                }
                else
                {
                    value += map.get(ch1) ;
                }
            }
        }

        return value ; 
    }
}