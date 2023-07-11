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
    public boolean isBalanced(TreeNode root) {
        
        if( root == null)
        return true  ; 

        int depthleft = depth(root.left) ;

         if( depthleft == -1 )
        return false ; 

        int depthright = depth(root.right) ; 
        
        if( depthright == -1 )
        return false ;


        if( Math.abs(depthleft - depthright) > 1 )
        return false ; 

        return true ; 


    }

    public int depth( TreeNode root )
    {
        if( root == null)
        return 0 ; 
        int max = 0 ; 

        int depthleft = depth(root.left) ; 

        if( depthleft == -1 )
        return -1 ; 

        if( depthleft > max)
        max = depthleft ; 

        int depthright = depth(root.right) ; 

        if( depthright ==  -1)
        return -1 ; 

        if(depthright > max)
        max = depthright ; 


        if( Math.abs(depthleft - depthright) > 1 )
        return -1 ; 
        else
        return max+1 ; 


    }
}