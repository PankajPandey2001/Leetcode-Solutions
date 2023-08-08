/*
   
   THIS IS A QUESTION OF DP , BUT THE MAIN THING IN THIS QUESTION IS TO APPLY MEMOISATION 


   the main catch is how we can apply memoisation in this question to store the 
   repetitive call , 

   first doing without memoistaion , we realised that , there is two variable thing
   index and frequency ; 

   // now frequency is array , but we can not take array as a key , so we will use
   // string here , this is the main catch ; 

*/ 


class Solution {
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        

        // since maximum score bhi nikalna ha , so ya toh greedy se hoga ; 
        // ya dp se , 

        // but greedy se answer sahi nhi hoga , kyoki isme humein saare combination
        // dekhne padhenge ; 


        int frequency[] = new int[26] ; 

 

        for( int i = 0 ; i < letters.length ; i++)
        {
            frequency[letters[i]-'a']++ ; 
        }


      /*
            using of hashmap for memoisation and

            using string(frquency array to string) as a key  is the main catch ; 


      */

      HashMap<Integer,HashMap<String,Integer>> map = new HashMap<>() ; 


        return helper( words , 0 , frequency , score , map ) ; 
        

        
    }
    public int helper( String words[] , int index , int frequency[] , int score[],HashMap<Integer,HashMap<String,Integer>> map)
    {

        if( index == words.length)
        {
            return 0 ; 
        } 


        StringBuilder str = new StringBuilder() ; 

        for( int i = 0 ; i < frequency.length ; i++)
        {
            str.append(frequency[i]+"_") ; 
        }

        String check = str. toString() ; 

        if( map.containsKey(index))
        {
            HashMap<String,Integer> map1 = map.get(index) ; 


            if( map1.containsKey(check))
            return map1.get(check) ; 
        }


          // now har index par 2 option hai 

          // lenge ya nhi , (aur lenge tab hi jab lena possible ho ) ; 


        

        // option-1 --------nahi lenge ; 

        int opt1 = helper(words , index+1 , frequency , score , map ) ; 



        // option2 - take , only take when it is possible ; 
        boolean canTake = helper1( words[index] , frequency) ; 

        if( canTake == false)
        return opt1 ; 

        // update frequency array ; 

        String temp = words[index] ;

        int tempScore = 0 ;  

        for( int i = 0 ; i < temp.length() ; i++)
        {
            tempScore += score[temp.charAt(i) - 'a'] ; 
            frequency[temp.charAt(i) - 'a']-- ; 
        }


        int opt2 = helper( words , index+1 , frequency , score , map) + tempScore ; 


        // now again udpate the frequency array while backtracking ; 

        for( int i = 0 ; i < temp.length() ; i++)
        {
            
            frequency[temp.charAt(i) - 'a']++ ; 
        }


        int answer = Math.max(opt1 , opt2) ; 


         if( map.containsKey(index))
        {
            HashMap<String,Integer> map1 = map.get(index) ; 


            map1.put(check, answer) ; 
        }
        else
        {
            HashMap<String,Integer> map1 = new HashMap<>() ; 
            map1.put(check, answer) ; 

            map.put(index , map1) ; 
        }


        return answer ; 


    }
    public boolean helper1( String s , int frequency[])
    {
        int temp[] = new int[26] ; 


        for( int i = 0 ; i < s.length() ; i++)
        {
            temp[s.charAt(i)-'a']++ ; 
        }

        for( int i = 0 ; i < temp.length ; i++)
        {
            if( temp[i] > frequency[i])
            return false ; 
        }


        return true; 
    }
}