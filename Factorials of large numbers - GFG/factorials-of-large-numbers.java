//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GfG
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0)
        {
            int N = sc.nextInt();
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.factorial(N);
            for (Integer val: ans) 
                System.out.print(val); 
            System.out.println();
        }   
    }
}
// } Driver Code Ends


//User function Template for Java

class Node
{
    int value = 0; 
    Node prev = null ; 
    
    public Node(int val)
    {
        value = val ; 
        prev = null ; 
    }
}
class Solution {
    static ArrayList<Integer> factorial(int N){
        //code here
        
        
        
        // the main thing in this questoni is that this is not normal factorial
        
        // because lets say we have to find factorial of 100 , now 100! have 100 digits ; 
        // now there is not any variable in which this can fit ; 
        
        
        /*
           SO WE WILL EITHER USE ARRAYLIST OR , WE WILL USE THE LINKED LIST , TO STORE THE DIGITS
           NOW ITS BETTER TO USE LINKED LIST BECUASE OF SAPACE OPTIMISATION 
           
           
           and one imporatant point is that ek node par ek hi digit hogi ; 
        */
        
        Node tail = new Node(1) ; 
        
        for( int i = 2 ; i <= N ; i++)
        {
            helper( tail , i ) ; 
        }
        
        
        
        ArrayList<Integer> answer = new ArrayList<>()  ; 
        
        helper2( tail , answer) ; 
        
        return answer ; 
    } 
    public static void helper( Node tail , int i )
    {
        Node temp = tail ;
        
        Node next = null ; 
        int carry = 0 ;
        
        while( temp != null)
        {
            
            if(temp.prev == null)
            next= temp ; 
            
            
            int val = temp.value ; 
            
            int product = val * i + carry ; 
            
            temp.value = product % 10 ; // kyonki ek node par bas single digit hi aaygi
            
            carry = product/10 ; 
            
            temp = temp.prev ; 
        }
        
        while( carry > 0 )
        {
            Node newNode = new Node(carry%10) ; 
            
            next.prev = newNode ; 
            
            next = newNode ; 
            
            carry = carry / 10 ; 
        }
        
        
    }
    public static void helper2( Node tail , ArrayList<Integer> list)
    {
         while( tail != null)
         {
             list.add(0 , tail.value) ; 
             tail = tail.prev ; 
         }
         
         
    }
}