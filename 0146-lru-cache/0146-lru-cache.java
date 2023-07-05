/*
    BASICALLY JIASE IS QUESITON MEIN EK SEQUENCE BNA HUA HAI , AB HUMEIN ADD AUR REMOVE , AUR GET 
    IS TRAH SE KARNE HAIN KI SAB O(1) MEIN HO , SO IMAGINE FOR THAT WE WILL NEED ONE DEQUEUE , 
    AND ONE HASHMAP IN WHICH FOR EVEYR KEY HIS ADDRESS AND VALUE IS PREESNT ; 



*/

// EDGE CASE TO HANDLE IS WHEN , CAPACITY OF THE DATA STRUCTURE IS 1 ; 

class Node
{
    int value ; 
    int key ; 
    Node prev ; 
    Node after ;

    public Node(int value , int key)
    {
        this.value = value; 
        this.key = key ; 
        prev = null ; 
        after = null ; 
    }
}
class LRUCache {

    Node head = null ; 
    Node tail = null ; 
    int size = 0 ; 
    HashMap<Integer,Node> map = new HashMap<>() ; 

    public LRUCache(int capacity) {
         size = capacity ; 
         map  = new HashMap<>() ; 
         head = null ; 
         tail = null ; 
    }
    
    public int get(int key) {
         
         if(map.containsKey(key) == false) 
         return -1 ; 


         Node temp = map.get(key) ; 

          reorder(temp) ; 
        //  if(temp == head ) // matlab jo last mein add kara h usi ko dubara call hui toh kisi bhi 
        //  // order mein change nhi hoga ; 
        //  {
        //        return temp.value ; 
        //  }


        //  if(temp == tail)
        //  {
        //      tail.prev.after = null ; 
        //      tail = tail.prev ; 

        //      temp.prev = null ; 
        //      temp.after = head ; 
        //      head = temp ;

        //      return temp.value ; 
        //  }

        //  if(temp.prev != null)
        //  {
        //      temp.prev.after = temp.after ; 
        //  }

        //  if(temp.after != null)
        //  {
        //      temp.after.prev = temp.prev ; 
        //  }


        //  temp.prev = null ; 
        //  temp.after = head ; 

        //  head = temp ; 

         return temp.value ; 
    }
    
    public void put(int key, int value) {
         
         Node temp = null ; 

        if(map.containsKey(key))
        {
            temp = map.get(key) ; 

            temp.value = value ; 

            reorder(temp) ; 
            return ; 
        }



        if(map.size() == size)
        {
            // then remove tail from the linked list ; 

            int tempKey = tail.key ; 

            map.remove(tempKey) ;  // yahaan galti kar di thi 
             
             if(tail.prev != null)
             {
                 tail.prev.after = null ; 
                  tail = tail.prev ;
             }
             else
             {

                 // else block mein tab hi aayenge jab size 1 hoga ; 

                 // NICHE JO HEAD AND TAIL KO NULL KARA H WO KARNA BHOT JARURI HAI ; 
                 // KYONKI JAB CAPACITY 1 HOGI , TOH JAISE WO NODE NIKALENGE ; 
                 // TOH SIZE 0 HO JAYGA ISLYE HEAD AUR TAIL KO DUBARA NULL KARNA JARURI H ; 
                 head = null ; 
                 tail = null ;
             }
             

            
        }


         

         temp = new Node(value , key) ;
         map.put(key , temp) ; 
         
         if(head == null || map.size() == 0) // ye map.size() ==0 edge case ke liye likha h. ; 
         {
             head = temp ;
             tail = temp ; 

             return ; 
         }
         temp.after = head ;
         head.prev = temp ;  
         head = temp ; 
    }
    public void reorder( Node temp)
    {
           
         if(temp == head ) // matlab jo last mein add kara h usi ko dubara call hui toh kisi bhi 
         // order mein change nhi hoga ; 
         {
               return  ; 
         }


         if(temp == tail)
         {
             tail.prev.after = null ; 
             tail = tail.prev ; 

             temp.prev = null ; 
             temp.after = head ; 
             head.prev = temp ; 
             head = temp ;

             return ; 
         }

         if(temp.prev != null)
         {
             temp.prev.after = temp.after ; 
         }

         if(temp.after != null)
         {
             temp.after.prev = temp.prev ; 
         }


         temp.prev = null ; 
         temp.after = head ; 
         head.prev = temp ; 

         head = temp ; 


         return ; 
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */