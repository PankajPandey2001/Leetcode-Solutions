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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        
        List<Integer> answer1 = new ArrayList<>() ;
        List<Integer> answer2 = new ArrayList<>() ;
        
        helper(root1 , answer1) ; 
        helper(root2 , answer2) ; 
        
        
        if(answer1.size() != answer2.size()) 
            return false ; 
        
        
        for( int i = 0 ; i < answer1.size() ; i++)
        {
            if(answer1.get(i) != answer2.get(i))
                return false ; 
        }
        
        
        return true ; 
    }
    public void helper(TreeNode root , List<Integer> list)
    {
        if(root == null)
            return ; 
        
        if( root.left == null && root.right == null)
        {
            list.add(root.val) ; 
            return ; 
        }
        
        
        helper(root.left , list) ; 
        helper(root.right , list) ;
    }
}
