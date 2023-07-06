/* since constraint is small , means maximum 1000 calls will be made , so it means maximum number
   in infinite set could be 1000, THEREFORE WE CAN USE PRIORITY QUEUE. 
   AS THE TC WILL BECOME 1000 LOG(1000) ; WHICH IS FEASIBLE , 


   // we can optimised it , instead of storing all number in priority Queueue , we wll only store 
   // the possible smalleest number ; 


   // intially we will put 1 in pq , becaus it is the smallest , then , we will start popping 
   // and if WE HAVE TO ADD BACK ANY NUMBER SMALER THAN POINTER OF THE PQ , WE WILL PUSH 
   // INTO THE PRIORITY QUEUE , AND REMEMBER CONTINOUS SEQUENCE , USI POINTER SE START HOGA 
   / JAB PQ KA SIZE 1 HO , AUR SIZE 1 SE JYADA H TOH  PQ KA EK  ELEMENT BAS EK NUMBR KO REPRESENT 
   KAREGA , NA KI KISI SEQUENCE KO ; 



     NOTE: , I WAS JUST USING PRIORITYQUEU , BUT THERE IS ONE PROBLEM WITH ONLY PRIORITYQUEUE, THAT 
             WE CAN ENTER DUPLICATE NUMBERS , SO LETS SAY CONTINIOUS SEQUENCEY 10 SE START H , 
             AUR MEINE ADD BACK 4 , DO BAAR KAR DIYA , TOH WO 2 BAAR PRIOITYQUEU MEIN AAJAYGA 
             JISSE EK NUMBER DUPLICATE HO RA H , ISLIYE HASHMAPUSE KARENGE TAAKI SAME NUMBER ; 
             PRIORITY QUEUE MEIN NA AA SAKE ; 


*/
class SmallestInfiniteSet {

        PriorityQueue<Integer> pq = new PriorityQueue<>() ;
        HashMap<Integer,Boolean> map = new HashMap<>() ; 


        int bottom = 0 ; // bottom us pointer ko point karega jhaan se continious sequence mein 
        // number present hai ; 

    public SmallestInfiniteSet() {
        pq = new PriorityQueue<>() ; 
        pq.add(1) ; /// because phle yahaan se start hoga ; kyonki minimum positive phle 1 ih hoga ; 
        bottom = 1 ; 
        map = new HashMap<>() ; // map bas wo element store kargea , jo continuous sequence se phle 
        // means smaller hain 

    }
    
    public int popSmallest() {
        
         if(pq.size() > 1 )
         {
             int key = pq.remove() ; 
             map.remove(key) ;   // ye karna bhot jaruri hai ; 
             return key ; 
         }
         else
         {
             int temp = pq.remove() ; 
             pq.add(temp+1) ; 
             bottom = temp+1 ; 
             return temp ; 
         }
    }
    
    public void addBack(int num) {
        
        if( num < bottom)
        {
            if(map.containsKey(num))
            return ; 

            pq.add(num) ; 
            map.put(num , true ) ;
        }
        
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */