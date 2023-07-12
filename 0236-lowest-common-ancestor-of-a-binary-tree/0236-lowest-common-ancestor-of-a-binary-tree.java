/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    static TreeNode answer = null ; 

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        answer = null ; 

        boolean temp = find( root , p , q ) ; 

        

        return answer ; 


    }
    public boolean find( TreeNode root , TreeNode p , TreeNode q ) 
    {

        if( root == null)
        return false ; 

         boolean Left = find(root.left , p , q ) ; 
         boolean Right = find(root.right , p , q ) ; 

         if( Left == true && Right == true)
         {
             answer = root ; 
             return true ; 
         }

         if( root == p || root == q )
         {
             if( Left == true || Right == true)
             {
                 answer = root ; 
             }

             return true ; 
         }


         if( Left == true || Right == true )
         {
             return true ; 
         }

         return false ; 
        
    }
}