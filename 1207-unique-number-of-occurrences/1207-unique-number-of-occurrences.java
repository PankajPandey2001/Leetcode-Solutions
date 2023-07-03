class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        
        Arrays.sort(arr) ; 

        HashMap<Integer,Boolean> map = new HashMap<>() ; // to store all unique frequencies ; 

        int i = 0 ; 

        while( i < arr.length)
        {
             int j = i+1 ; 

             while( j < arr.length && arr[j] == arr[j-1])
             {
                 j++ ; 
             }

             int count = j - i ; 

            i = j ; 
             if(map.containsKey(count) == true)
             return false ; 


             map.put(count , true) ; 
        }

        return true ; 
    }
}