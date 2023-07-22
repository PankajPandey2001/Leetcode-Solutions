class Solution {
    public String sortVowels(String s) {
        
        List<Character> list = new ArrayList<>() ; 
        
        for( int i = 0; i < s.length() ; i++)
        {
            char ch = s.charAt(i) ; 
            
            if( ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U')
                list.add(ch) ; 
        }
        
        
        Collections.sort(list) ; 
        
        StringBuilder str = new StringBuilder(s) ; 
        
        int i = 0 ; 
        
        
        for( int j = 0 ; j < s.length(); j++)
        {
            char ch = s.charAt(j) ; 
            
             if( ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U')
             {
                 str.setCharAt(j , list.get(i)) ; 
                 i++ ; 
             }
        }
        
        return str. toString() ; 
    }
}