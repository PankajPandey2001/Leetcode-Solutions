/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Pair
{
    int minimum = Integer.MAX_VALUE ; 
    boolean isBST = true ; 
    int maximum = Integer.MIN_VALUE ; 

    int sum = 0 ; 

    public Pair()
    {
        minimum = Integer.MAX_VALUE ; 
        maximum = Integer.MIN_VALUE ; 
        sum = 0 ; 
    }
    public Pair( int min , int max, int value) 
    {
         minimum = min ; 
         maximum = max ;
         sum = value ; 
    }
}
class Solution {

    int answer = 0 ; 
    public int maxSumBST(TreeNode root) {
        
        answer = 0 ; 
         Pair temp = helper(root) ;
         return answer ; 
    }
    public Pair helper(TreeNode root)
    {
         
         if( root == null)
         {
             Pair temp = new Pair() ; 
             return temp ; 
         }


         Pair tempLeft = helper(root.left) ;  
         Pair tempright = helper(root.right) ; 

         if( tempLeft.isBST == false)
         return tempLeft ; 

          if( tempright.isBST == false)
          return tempright ; 

         // now check kya still bst h ya nhi ; 


         if( root.val >= tempright.minimum || root.val <= tempLeft.maximum)
         {
             Pair temp = new Pair() ; 
             temp.isBST = false ; 
             return temp ; 
         }

         int a = tempLeft.sum + tempright.sum + root.val ; 

         if( a > answer)
         answer = a ; 

         Pair newPair = new Pair(Math.min(tempLeft.minimum,root.val) , Math.max(tempright.maximum,root.val), a ) ;

         return newPair ; 
    }
}