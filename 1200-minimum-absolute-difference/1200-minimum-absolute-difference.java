class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        

        // sorting is very important for this questio 


        
        Arrays.sort(arr) ; // defintiy need to sort the array ,to find the abosolute theminimum
        // difference ; 


        int difference = Integer.MAX_VALUE ; 

        for( int i = 0 ; i < arr.length-1; i++)
        {
            difference = Math.min(difference , (arr[i+1] - arr[i]) ) ; 
        }

        

        List<List<Integer>> answer = new ArrayList<>() ; 

         for( int i = 0 ; i < arr.length-1; i++)
        {
            if(arr[i+1] - arr[i] == difference) 
            {
                List<Integer> list = new ArrayList<>() ;
                 list.add(arr[i]) ;  
                list.add(arr[i+1]) ; 
               


                answer.add(list) ; 
            }
        }


        return answer ; 
    }
}