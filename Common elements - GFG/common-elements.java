//{ Driver Code Starts
//Initial Template for Java

import java.util.*;

public class GFG
{
    public static void main(String args[]) 
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) 
        {
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            int n3 = sc.nextInt();
            
            int A[] = new int[n1];
            int B[] = new int[n2];
            int C[] = new int[n3];
            
            for (int i = 0;i < n1;i++)
            {
                A[i] = sc.nextInt();
            }
            for (int i = 0;i < n2;i++)
            {
                B[i] = sc.nextInt();
            }
            for (int i = 0;i < n3;i++)
            {
                C[i] = sc.nextInt();
            }
            
            Solution sol = new Solution();
            ArrayList<Integer> res = sol.commonElements(A, B, C, n1, n2, n3);
            if (res.size() == 0)
            {
                System.out.print(-1);
            }
            else 
            {
                for (int i = 0;i < res.size();i++)
                {
                    System.out.print(res.get(i) + " ");
                }    
            }
            System.out.println();
        }
    }
}


// } Driver Code Ends


//User function Template for Java

class Solution
{
    ArrayList<Integer> commonElements(int A[], int B[], int C[], int n1, int n2, int n3) 
    {
        // code here 
        
        // the main problem in this quesiton is duplicate withint the same array ; 
        
        ArrayList<Integer> list = new ArrayList<>() ; 
        
        int i = 0 ; 
        int j = 0; 
        int k = 0 ; 
        
        
        while( i < A.length && j < B.length && k < C.length)
        {
            
            if( i != 0 && A[i] == A[i-1])
            {
                i++ ; 
                continue ; 
            }
           else if( j != 0 && B[j] == B[j-1])
            {
                j++ ; 
                continue ; 
            }
           else if( k != 0 && C[k] == C[k-1])
            {
                k++ ; 
                continue ; 
            }
            if( A[i] == B[j] && B[j] == C[k])
            {
                list.add(A[i]) ; 
                i++ ; 
                j++ ; 
                k++ ; 
                continue ; 
            }
            
            
            if( A[i] < B[j] || A[i] < C[k])
            {
                i++ ; 
            }
            else if(  A[i] > B[j] || B[j] < C[k] )
            {
                j++; 
            }
            else if( C[k] < A[i] || C[k] < B[j])
            {
                k++; 
            }
            
            
            
        }
        
        return list ; 
    }
}