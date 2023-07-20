class Solution {
    public int[] twoSum(int[] numbers, int target) {
        
        int start = 0 ; 
        int end = numbers.length-1 ;

        while( start < end)
        {
            if( numbers[start] + numbers[end] == target)
            {
               int arr[] = {start+1 , end+1} ; 
               return arr ; 
            }
            else if( numbers[start]+ numbers[end] < target)
            {
                start++ ; 
            }
            else
            end-- ; 
        }


        int arr[] = {}  ;
        return arr ;  
    }
}