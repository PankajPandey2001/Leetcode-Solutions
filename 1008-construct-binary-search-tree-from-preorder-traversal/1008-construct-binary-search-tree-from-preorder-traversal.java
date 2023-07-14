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
    public TreeNode bstFromPreorder(int[] preorder) {
         
       return  helper(preorder , 0 , preorder.length-1) ; 


    }
    public TreeNode helper(int preorder[], int start , int end)
    { 
        if( end < start)
        return null ; 
        
        TreeNode root = new TreeNode(preorder[start]) ; 

        if(start == end)
        return root ; 
        
        int index = end+1 ; 
        for( int i = start+1 ; i <= end ; i++)
        {
            if( preorder[i] > preorder[start])
            {
                index = i ; 
                break ; 
            }
        }

        if( index == end+1) // means ab sirf left mein aayga
        {
            root.left = helper(preorder , start+1 , end) ; 

            return root ; 
        }
       

        root.left = helper(preorder , start+1 , index-1) ;
        root.right = helper(preorder , index , end) ; 


        return root ; 

    }
}