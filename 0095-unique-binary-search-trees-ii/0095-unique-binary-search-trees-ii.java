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
    public List<TreeNode> generateTrees(int n) {
        
        return helper( 1 , n) ; 
    }
    public List<TreeNode>  helper( int start , int end)
    {

        

        List<TreeNode> curr = new ArrayList<>() ;


        if( start == end)
        {
            TreeNode temp = new TreeNode(start) ; 

            curr.add(temp) ; 
            return curr ; 
        }

        if( start > end)
        {
            TreeNode temp = null ; 
            curr.add(temp) ; 
            return curr ; 
        }
        
        for( int i =  start  ; i <= end  ; i++)
        {
             List<TreeNode> left = helper( start , i-1) ; 

             List<TreeNode> right = helper(i+1 , end ) ;


            for( int j = 0 ; j < left.size() ; j++)
            {
                

                 
                for( int k = 0 ; k < right.size() ; k++)
                {
                      TreeNode temp = new TreeNode(i) ; 

                      curr.add(temp) ; 


                      temp.left = left.get(j) ; 
                      temp.right = right.get(k) ; 
                }
            }
        }

        return curr ; 
    }
}