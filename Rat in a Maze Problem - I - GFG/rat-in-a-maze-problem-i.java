//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
class Rat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<String> res = obj.findPath(a, n);
            Collections.sort(res);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++)
                    System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}

// } Driver Code Ends


// User function Template for Java

// m is the given matrix and n is the order of matrix

class Solution {
    public static ArrayList<String> findPath(int[][] m, int n) {
        // Your code here
        
        ArrayList<String> answer = new ArrayList<>() ;
        
        StringBuilder str = new StringBuilder() ;
        
        helper( 0 , 0 , m , n , str , answer) ; 
        
        return answer ; 
        
        
        
    }
    public static void helper( int row , int column , int m[][] , int length , StringBuilder str , ArrayList<String> answer)
    {
     
         if( row < 0 || row >= length || column < 0 || column >= length)
          return ; 
    
    
    
           if( m[row][column] == 0 )
          return  ; 
          
           if( row == length-1 && column == length-1)
           {
               answer.add(str. toString()) ; 
               return ;
           }
           
           
           
          
          
          
          m[row][column] = 0 ; // 1 se 0 kar diya taaki dubara isme na aa sake , backtrack karte 
          // wakt dubara 1 kar denge ; 
          
          
          str.append('D') ;
          
          helper(row+1, column , m , length , str , answer) ; 
          
          str.deleteCharAt(str.length()-1) ; 
          
           str.append('U') ;
          
          helper(row-1, column , m , length , str , answer) ; 
          
          str.deleteCharAt(str.length()-1) ; 
          
           str.append('L') ;
          
          helper(row, column-1 , m , length , str , answer) ; 
          
          str.deleteCharAt(str.length()-1) ; 
          
          
           str.append('R') ;
          
          helper(row, column+1 , m , length , str , answer) ; 
          
          str.deleteCharAt(str.length()-1) ;
          
          
          m[row][column] = 1 ; 
          return ; 
    }
}