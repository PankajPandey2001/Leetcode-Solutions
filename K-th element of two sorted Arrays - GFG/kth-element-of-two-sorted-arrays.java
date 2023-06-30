//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            StringTokenizer stt = new StringTokenizer(br.readLine());
            
            int n = Integer.parseInt(stt.nextToken());
            int m = Integer.parseInt(stt.nextToken());
            int k = Integer.parseInt(stt.nextToken());
            int a[] = new int[(int)(n)];
            int b[] = new int[(int)(m)];
            
            
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }
            String inputLine1[] = br.readLine().trim().split(" ");
            for (int i = 0; i < m; i++) {
                b[i] = Integer.parseInt(inputLine1[i]);
            }
            
            
            Solution obj = new Solution();
            System.out.println(obj.kthElement( a, b, n, m, k));
            
        }
	}
}

// } Driver Code Ends


//User function Template for Java


class Solution {
    public long kthElement( int arr1[], int arr2[], int n, int m, int k) {
        
        
        // 
        
        int value = k+1 ;      // we will keep k elements in left part of the division ; 
        
        
        int low = 0 ; 
        int high = arr1.length ; 
        
        
        while( low <= high)
        {
            int mid = low + (high-low)/2 ; 
            
            // we will assume that arr1 mein se mid element humne left mein rakhe ; 
            
            if(mid > k ) // ye toh phle hi possible nhi h ; // kyonki humein left side mein sirf k elemnts
            // rakhne hain taaki hum direct return kar sake ;
            {
                high = mid-1 ;
                continue ; 
            }
            
            
            int mid2 = k - mid ; // kyonki arr2 mein se mid element lenge taaki left part
            // mein total element k ho sakein ;
            
            if(mid2 < 0 )
            {
                high = mid-1 ; 
                continue ; 
            }
            if(mid2 > arr2.length)
            {
                low = mid+1 ; 
                continue ; 
            }
            
            int left1 = mid == 0? Integer.MIN_VALUE : arr1[mid-1] ; 
            int right1 = mid == arr1.length? Integer.MAX_VALUE : arr1[mid] ; 
            int left2 = mid2 == 0? Integer.MIN_VALUE : arr2[mid2-1] ; 
            int right2 = mid2 == arr2.length? Integer.MAX_VALUE : arr2[mid2] ;
            
            
            //now for valid partition left1 <= righ2 and and left2 <= righ1 ; 
            
            if( left2 <= right1 && left1 <= right2)
            {
                return (long)(Math.max(left1,left2)) ; 
            }
            else if( left2 > right1)
            {
                low = mid+1 ; 
            }
            else 
            high = mid-1 ;
        }
        
        
        return 0 ; 
    }
}