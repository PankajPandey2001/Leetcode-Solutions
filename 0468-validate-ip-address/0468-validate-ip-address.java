/// <=-----------------------PROBLEMS IN EDGE CASES --------------------------------___>

/*


THE LENGHT OF THE  parts array will be 8, not 9, when splitting the string "2001:0db8:85a3:0:0:8A2E:0370:7334:" using s.split(":") in Java.

The split() method in Java removes empty trailing elements by default. In this case, the trailing colon (":") results in an empty string after the split, but it is not included as a separate element in the resulting array. Therefore, the length of the parts array will be 8.


ALWAYS REMEMBER S.SPLIT("char") // s.split last mein agar char h toh uske across nhi divide karta ; 
    this is the edge case ;  "2001:0db8:85a3:0:0:8A2E:0370:7334:"

    this is the edge case ; "12..33.4"
*/

class Solution {
    public String validIPAddress(String queryIP) {
        
         queryIP = queryIP.trim();
         
         if(queryIP.length() == 0) // because of edge case
         return "Neither" ; 

     // LINE FOR EDGE CASE ; 
     // IF AT THE END THERE WILL BE . OR : THEN IT CANT BE IPV4 OR IPV6 ; 
         if(queryIP.charAt(queryIP.length()-1) == '.' || queryIP.charAt(queryIP.length()-1) == ':')
         return "Neither" ; 

        String arr1[] = queryIP.split("\\.")  ; 
        String arr2[] = queryIP.split("\\:") ; 


        if( arr1.length != 1 && arr2.length != 1 )
        {
            System.out.println("yahaan par 1 "); 
            return "Neither" ; 
        }
        
           
        if( arr1.length == 4 )
        {
            boolean temp = helper1(arr1) ; 

            if( temp == true)
            return "IPv4" ;
            else
            return "Neither" ; 
        }
        else if( arr2.length == 8)
        {
            boolean temp = helper2(arr2) ; 

            if( temp == true)
            return "IPv6"  ; 
            else
            return "Neither" ; 
        }
        else
        return "Neither" ; 
        

    }
    public boolean helper1( String arr[])
    {
          
        for( int i = 0 ; i < arr.length ; i++)
        {
             String a = arr[i] ; 
                 
                 if(a.length() < 1)
                 return false ; 
                 if(a.length() > 3 )
                 {
                //   System.out.println("yahaan par 2 "); 
                   return false ; 
                 }
                
                if( a.charAt(0) == '0' )
                {
                    if(a.length() == 1)
                    continue ; 

                    return false ; 
                }
                int temp = 0 ; 

                // boolean gotZero = false ; 
                // boolean gotAfterZero = true ; 
                
               for( int j = 0 ; j < a.length() ; j++)
             {
                 char ch = a.charAt(j) ; 
                  
                  // if 0 aa gya aur uske baad bhi saare 0 hain toh we will return false ; 
                
                 if((ch >= '0' && ch <= '9'))
                 {
                    //  if( ch == '0')
                    //  {
                    //      gotZero = true ; 
                    //      gotAfterZero = false ;
                    //  }
                    //  else
                    //  {
                    //      gotAfterZero = true ; 
                    //  }

                     temp = temp*10 + (ch-'0') ; 
                 }
                 else
                 return false ; 
             }
            
            System.out.println(temp) ; 

             if( temp > 255)
            {
                  System.out.println("yahaan par 3 "); 
                   return false ; 
                 } 

            //  if( gotAfterZero == false)
            // {
            //       System.out.println("yahaan par 4 "); 
            //        return false ; 
            //      }

             

        }


        return true ; 
    }
    public boolean helper2 (String arr[])
    {

        if( arr.length > 8)
        return false ;
        for( int i = 0 ; i < arr.length ; i++)
        {
             String a = arr[i] ; 
           if(a.length() < 1)
                 return false ;  
             if(a.length() > 4 )
             return false ; 

             for( int j = 0 ; j < a.length() ; j++)
             {
                 char ch = a.charAt(j) ; 

                 if((ch >= 'a' && ch <= 'f')|| (ch >= 'A' && ch <= 'F') ||  (ch >= '0' && ch <= '9') )
                 {
                     continue ; 
                 }
                 else
                 return false ; 
             }
        }


        return true ; 
    }
}