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

    

    public int goodNodes(TreeNode root) {
        
        int count = 0 ; 

        count += helper(root , Integer.MIN_VALUE) ; 

        return count ; 
    }
    public int helper(TreeNode root , int maximum)
    {
        if(root == null)
        return 0 ;  

        int count = 0 ; 

        if( root.val >= maximum)
        {
            count++ ; 

            maximum = root.val ;
        }


        count += helper(root.left , maximum) ; 
        count += helper(root.right, maximum) ; 


        return count ; 
    }
}