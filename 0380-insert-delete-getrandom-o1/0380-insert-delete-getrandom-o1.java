class RandomizedSet {
    
    ArrayList<Integer> list = new ArrayList<>()  ; 
     HashMap<Integer,Integer> map = new HashMap<>() ;
    /*
       THE MAIN CATCH IS THAT , WE WANT TO DO ALL OPERATION IN O(N) TIME ; 
       now , we know ,THAT TO CHECK WHETERH ANY NUMBER IS PRESENT OR NOT , IN O(1) TIME 
       WE NEED , HASHMAP , SO WE WILL HAVE TO USE HASHMAP FOR SURE


       BUT GETRANDOM() FUNCTION IS ALSO THERE , AND FOR GETRANDOEM WE NEED HASHMAP , SO 
       THAT WE CAN GIVE RANDOM NUMBERS WITH , EQUAL PROBABILITIES ; 

       SO WE WILL USE BOTH HASHMAP AS WELL AS ARRAY , NOW , MAIN THING IS REMOVE , 
       REMOVING FROM HASHMAP WILL BE O(1) BUT REMOVIGN FROM ARRAY IS O(N) 
       TO MAKE IT O(1) WE, WILL USE SWAPPING TECHNIQUE 


       INSTEAD OF REMOVING FROM RANDOME INDEX , WE WILL SWAP THE VALUE AT THAT INDEX FORM
       LAST INDEX , AND THEN WE WIL REMOVE THE LAST ELEMENT , BY THIS , IN  O(1) ; 

      
      getrandome chahiye isliye , 
    */
    public RandomizedSet() {
        
        // NEED HASHMAP AS WELL AS ARRAYLIST ; 


         list = new ArrayList<>()  ; 
         map = new HashMap<>() ; // value will be the index ; where that
        // value will be present ; 
    }
    
    public boolean insert(int val) {
         
         if(map.containsKey(val))
         {
             return false  ;
         }



         list.add(val) ;
         map.put(val , list.size()-1) ; 

         return true ; 
    }
    
    public boolean remove(int val) {
        
         if(map.containsKey(val) == false)
         return false ;
          
         int index = map.get(val) ; 

         // first swap value at index , with last value in arraylist 
         // so that in o(1) removing can happen ; 
         
         if( index == list.size()-1) // means last index mein hi present hain toh 
         {
             map.remove(list.get(index)) ; 
             list.remove(list.size()-1) ; 
         }
         else
         {
             // now swap the value at that index with last index and then delete the
             // value at last index , so THAT  IN O(1) OPERATION DELETE CAN BE PERFORMED

             map.remove(val) ; 
             map.put(list.get(list.size()-1) , index) ; 

             list.set(index , list.get(list.size()-1) ) ; 
             list.remove(list.size()-1) ; 
         }

         return true ; 

    }
    
    public int getRandom() {
        
        int random = (int)(Math.random() * list.size()) ;

        return list.get(random) ; 
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
          
           
 //       --------------------  SOLUITON OF O(1) ----------------------------- 

 /*

 class RandomizedSet {
    private Map<Integer, Integer> map;
    private List<Integer> listOfNumbers;
    private Random rn;

    public RandomizedSet() {
        this.map = new HashMap<Integer, Integer>();
        this.listOfNumbers = new ArrayList<Integer>();
        this.rn = new Random();
    }
    
    public boolean insert(int val) {
        if (!map.containsKey(val)) {
            listOfNumbers.add(val);
            map.put(val, listOfNumbers.size() - 1);
            return true;
        } 
        return false;
    }
    
    public boolean remove(int val) {
        if (map.containsKey(val)) {
            int index = map.remove(val);
            int lastVal = listOfNumbers.remove(listOfNumbers.size() - 1);
            if (lastVal != val) {
                listOfNumbers.set(index, lastVal);
                map.put(lastVal, index);
            }
            return true;
        } 
        return false;
    }
    
    public int getRandom() {
        int random = rn.nextInt(listOfNumbers.size());
        return listOfNumbers.get(random);
    }
}


 */


