class Solution {
    public boolean isValid(String s) {
        
        Stack<Character> stack = new Stack<>() ; 

        for( int i = 0 ; i < s.length() ; i++)
        {
            
            char ch = s.charAt(i) ;

            if( ch == '(' || ch =='{' || ch == '[')
            stack.push(ch) ; 
            else
            {
                if(stack.size() == 0 )
                return false ; 

                if( ch == ')')
                {
                    if( stack.pop() != '(')
                    return false ;

                }
                else if ( ch == '}')
                {
                     if( stack.pop() != '{')
                    return false ;
                }
                 else if ( ch == ']')
                {
                     if( stack.pop() != '[')
                    return false ;
                }
            }
        }
        


        if(stack.size() != 0 )
        return false ; 

        return true ; 
    }
}