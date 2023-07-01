class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        
         List<String> answer = new ArrayList<>() ; 
         int count = 0 ; 

         StringBuilder str = new StringBuilder(); 

        for( int i = 0 ; i < words.length ; i++)
        {
            if(str.length() == 0)
            {
              str.append(words[i]) ; 
              count++ ; 

            
            // because of edge case  words = ["a"] and maxWidth = 1 ; 
              if(i == words.length - 1) 
                {
                    // means last line so it should be left justified ; 
                    System.out.println("yahaan par") ;
                    String justifie = helper(str , maxWidth) ; 

                    answer.add(justifie) ; 
                      
                      System.out.println(justifie) ; 
                    return answer ; 
                }
            }
           else if( words[i].length() + str.length() + 1 <= maxWidth)// 1 is added considering the space between two words; 
            {   
                // if(str.length() == 0 )
                // {
                //     str.append(words[i]) ; 
                // }
                // else
                str.append(" " + words[i]) ; 


                if(i == words.length - 1) 
                {
                    // means last line so it should be left justified ; 
                    System.out.println("yahaan par") ;
                    String justified = helper(str , maxWidth) ; 

                    answer.add(justified) ; 
                      
                      System.out.println(justified) ; 
                    return answer ; 
                }

                count++ ; 
            }
            else
            {
               
                     String justified = helper(str , count , maxWidth) ; 
                
                System.out.println(i + " " + justified + " size = " + justified.length()) ; 
                      answer.add(justified) ;
                
               

                 str = new StringBuilder() ; 
                  

                 str.append(words[i]) ; 

                 if(i == words.length - 1) 
                {
                    // means last line so it should be left justified ; 
                    System.out.println("yahaan par") ;
                    String justifie = helper(str , maxWidth) ; 

                    answer.add(justifie) ; 
                      
                      System.out.println(justifie) ; 
                    return answer ; 
                }

                 count = 1 ;
            }
        }

        return answer ; 
    }
    public String helper(StringBuilder str ,  int maxWidth)
    {
         while(str.length() < maxWidth)
         {
             str.append(" ") ; 
         }


         return str. toString() ; 

    }
    public String helper(StringBuilder str , int count , int maxWidth)
    {
        // now words total h count ke barabaar bich mein spacing count-1 times hogi ; 
        
         if(count == 1)
         {
             System.out.println(str) ;

             // yahaan par error tha direct return karne se phle , proper spacing karni h 
             
              
              while(str.length() < maxWidth)
            {
               str.append(" ") ; 
            }
             return str. toString() ; 
         }

         System.out.println("yahaan par " + str.length() + " "  + count) ; 
        int totalSpaces = maxWidth - str.length() ; 
        System.out.println(totalSpaces) ;

        int remainder = totalSpaces % (count-1) ; 

        System.out.println(remainder) ;

        int temp = totalSpaces / (count-1) ;  // now itne new spaces adde karne hain har ek word
        // ke end mein  ; aur left spaces mein reaminder times extra daalne hain ; 

        System.out.println(temp) ;


        for( int i = 0 ; i < str.length() ; i++)
        {
            if(str.charAt(i) == ' ')
            {
                for( int j = 1 ; j<= temp ; j++)
                {
                    str.insert(i , ' ') ; 
                }
            }
            else
            continue ; 

            System.out.println(str.length()) ;
            // ab itne spaces add karne ke baad aage bhi toh jaana h ,  warna TLE aa jayga 
            // SO JAB TAK END MEIN NAHI PAHUNCH JAATE , POINTER AAGE BADHAYENGE; 


            for(  ; i < str.length() ; i++)
            {
                if(str.charAt(i) == ' ')
                continue ; 

                break ; 
            }
        }
         
         
          for( int i = 0 ; i < str.length() && remainder > 0  ; i++)
        {
            if(str.charAt(i) == ' ')
            {
                
                    str.insert(i , ' ') ; 
                  remainder-- ; 
            }


             for(  ; i < str.length() ; i++)
            {
                if(str.charAt(i) == ' ')
                continue ; 

                break ; 
            }
        } 


        return str. toString() ;  
    }
}