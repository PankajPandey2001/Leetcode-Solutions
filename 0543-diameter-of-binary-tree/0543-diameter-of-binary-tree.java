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
class Solution {

    static int answer = Integer.MIN_VALUE ; 

    public int diameterOfBinaryTree(TreeNode root) {
         
         answer = Integer.MIN_VALUE ; 


         if(root == null)
         return 0 ; 

         if(root.left == null &&  root.right == null)
         return 0 ; 


         int distance = helper(root) ; 


         return answer ; 
    } 
    public int helper(TreeNode root)
    {

        if(root == null)
        return 0 ; 

         int left = helper(root.left) ; 
         int right = helper(root.right) ;
       
         if( left + right > answer)
         answer = left+right ; 


         return Math.max(left,right)+1 ; 
    }
}