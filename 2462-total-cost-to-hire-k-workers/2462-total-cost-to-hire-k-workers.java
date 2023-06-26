class Required implements Comparator<int[]> // so that the top element in the priorityqueue is
// the array in whose 0 th index there will be minimum value , aur agar ek se jyada ki minimum value hain toh chhote index wala top par hoga ; 
{
    @Override
    public int compare( int a[] , int b[])
    {
        if( a[0] < b[0])
        {
            return -1 ; 
        }
        else if( a[0] > b[0])
        return 1 ; 
        else
        {
            if( a[1] < b[1])
            return -1 ;
            else
            return 1 ; 
        }
    }
}
class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        
      
        Required req = new Required() ; 
        PriorityQueue<int[]> pq = new PriorityQueue<>(req) ; 

         
         for( int i = 0 ; i < candidates ; i++)
         {
             int temp[] = {costs[i] , i } ;  // 2 d array isliye lena padha taaki pta chal jaaye
             // ki jo pq se element nikla h array ke starting side wale se nikla hai
             // ya end side wale se , 

             // taaki usi hissab se dekhke hum agla element daal sake , agar pq se aage ki traf
             // se element nikla h toh agla element daalenge bhi aage ki traf se 
             // similary last se pass wala nikla h toh last wala daalenge; 

             // and we have to remember same elements baar baar nhi daalna

             pq.add(temp) ; 
         }

         for( int i = Math.max(costs.length-candidates, candidates); /*to avoid duplicay*/ i >= candidates && i < costs.length ; i++)
         {
              int temp[] = {costs[i] , i } ; 

             pq.add(temp) ; 

         }
         
         int beforeIndex = candidates ;  // matlab ab agar starting se kisi element ko dallan 
         // h toh wo kis index se dalega ; 

         int lastIndex = Math.max(costs.length- candidates , candidates) -1 ; 

           System.out.println(beforeIndex + " "+ lastIndex) ; 
         long sum = 0 ; 

         while( k > 0 )
         {
             if(pq.size() == 0)
             return sum ; 
            
             int temp[] = pq.remove() ; 

             sum += temp[0] ; 
             k-- ; 

           
            if(beforeIndex > lastIndex)// matlab saare element dal chuke hain pq mein // and same
            // elements dubara na dale ; 
            {
                continue ; 
            }

            int index = temp[1] ; 

            if( index < beforeIndex)
            {
                int temp1[] = {costs[beforeIndex] , beforeIndex} ; 

                 pq.add(temp1) ; 
                beforeIndex++ ; 
            }
            else
            {
                int temp1[] = {costs[lastIndex] , lastIndex} ; 
                 pq.add(temp1) ; 
                lastIndex-- ; 
            }





         }


         return sum ; 

    }
}