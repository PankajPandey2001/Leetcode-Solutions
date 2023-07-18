class Node
{
    int key = 0 ; 
    int val = 0 ; 
    Node prev = null ; 
    Node next = null  ; 

    public Node( int val , int key )
    {
        this.val = val ; 
        this.key = key ; 

    }
}
class LRUCache {
         
     HashMap<Integer,Node> map = new HashMap<>() ; 
     Node head = null ;  
     Node tail = null ; 
     int capacity = 0 ; 

    public LRUCache(int capacity) {
        this.capacity = capacity ; 
    }
    
    public int get(int key) {
         
         if(map.containsKey(key) == false)
         return -1 ; 


         Node temp = map.get(key) ; 

         rearrange(temp) ; 

         return temp.val ; 
    }
    
    public void put(int key, int value) {
         
         if(map.containsKey(key))
         {
             Node temp = map.get(key) ; 
             temp.val = value ; 
             rearrange(temp) ; 
              return ; 
         }

         Node temp = new Node(value , key ) ; 
         

         if( map.size() < capacity)
         {
             map.put(key , temp) ; 
             
             if( head == null)
             {
                 head = temp ; 
                 tail = temp ; 
             }
             else
             {
                      temp.next = head ; 

                if( head != null)
               head.prev = temp ; 


                 head = temp ;
             }

            //  temp.next = head ; 

            //  if( head != null)
            //  head.prev = temp ; 


            //  head = temp ; 
         }
         else
         {
             if( capacity == 1 )
             {
                 map.remove(head.key) ; 

                 map.put(key , temp) ; 
                 head = temp ; 
                 tail = temp ; 
             }
             else
             {
                 map.remove(tail.key) ; 
                 tail = tail.prev ; 

                 tail.next = null ; 

                 map.put(key,temp) ;

                 head.prev = temp ; 
                 temp.next = head ; 

                 head = temp ; 
             }
         }



    }
    public void rearrange(Node temp)
    {
        if( temp == head)
        return ; 


        if( temp == tail )
        {
            tail.prev.next = null ; 
            tail = tail.prev ; 

            temp.next = head ; 
            head.prev = temp; 
            head = temp ;

            return ; 
        }



        temp.prev.next  = temp.next ; 

        temp.next.prev = temp.prev ; 


        temp.next = head ; 
        head.prev = temp ; 

        head = temp ; 



    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */