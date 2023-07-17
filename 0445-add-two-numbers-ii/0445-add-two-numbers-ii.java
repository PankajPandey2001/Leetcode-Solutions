/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        if( l1 == null)
        return l2 ; 

        if( l2 == null)
        return l1 ; 
        
        ListNode head1 = reverse(l1 ) ; 
        ListNode head2 = reverse(l2 ) ; 

        

        ListNode tail = null ;
        ListNode head = null ;  

       int carry = 0 ; 
        while( head1 != null && head2 != null)
        {
            int no = head1.val + head2.val + carry ; 

            carry = no / 10  ; 
            no = no % 10 ; 

            head1.val = no ; 
             
             if( head == null)
             {
                 head = head1 ; 
             }
             
              if( head1.next == null)
              tail = head1 ; 

             head1 = head1.next ; 
             head2 = head2.next ; 
        }
        
         if( head1 == null && head2 == null)
        {
             if( carry != 0 )
            {
                tail.next = new ListNode(carry) ; 
            }

            return reverse( head ) ; 
        }
        else if( head1 == null)
        {
            tail.next = head2 ;
            tail = null ; 

            while( head2 != null)
            {
                head2.val += carry ; 
                carry = head2.val / 10 ; 

                head2.val = head2.val % 10 ; 
               
                if( head2.next == null)
                tail = head2 ; 

                head2 = head2.next ; 

            }

            if( carry != 0 )
            {
                tail.next = new ListNode(carry) ; 
            }


              return reverse( head ) ; 
        }
        else 
        {
            tail = head1 ;

            while( head1 != null)
            {
                head1.val += carry ; 
                carry = head1.val / 10 ; 

                head1.val = head1.val % 10 ; 
               
                 if( head1.next == null)
                 tail = head1 ; 

                head1  = head1.next ; 

            }

            if( carry != 0 )
            {
                tail.next = new ListNode(carry) ; 
            }

            return reverse( head ) ; 
        }
       

    }

    public ListNode reverse(ListNode head) {

      ListNode prev = null ; 
      ListNode after = null ; 

      while( head != null)
      {
          after = head.next ; 
          head.next = prev ; 
          prev = head ; 
          head = after ; 
      } 

      return prev ;  
    }


}