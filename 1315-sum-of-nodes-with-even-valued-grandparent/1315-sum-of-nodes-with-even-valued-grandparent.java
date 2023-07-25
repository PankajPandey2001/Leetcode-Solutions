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
    static int sum = 0 ; 

    public int sumEvenGrandparent(TreeNode root) {
        
        sum = 0 ; 

        HashMap<TreeNode , TreeNode > map = new HashMap<>() ; 


        fillParent(root , map , null) ;


        doSum(root , map) ; 

        return sum ;  


    }
    public void fillParent(TreeNode root , HashMap<TreeNode ,TreeNode > map , TreeNode parent)
    {
        if( root == null)
        return ; 

        map.put(root , parent) ; 

        fillParent(root.left , map , root) ; 
        fillParent(root.right , map , root) ; 
    }
    public void doSum(TreeNode root , HashMap<TreeNode ,TreeNode > map  )
    {
        if(root == null)
        return ; 

        if( map.get(root) != null && map.get(map.get(root)) != null  )
        {
            if( map.get(map.get(root)).val % 2 == 0)
            sum += root.val ; 
        }

        doSum(root.left , map) ; 
        doSum(root.right , map) ; 
    }
}