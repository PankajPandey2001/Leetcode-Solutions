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
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        
        HashMap<TreeNode,TreeNode> map = new HashMap<>() ; 

     List<Integer> list = new ArrayList<>() ;


        if(target == null)
        return list ; 

        if( k == 0)
        {
            list.add(target.val) ; 
            return list ; 
        }


        helper1(root , map , null) ; 
        add(target , list , k , map ) ;


        return list ; 
    }
    public void helper1(TreeNode root , HashMap<TreeNode,TreeNode> map , TreeNode parent )
    {
        if(root == null)
        return ; 

        map.put(root , parent) ; 
        
         helper1(root.left , map , root) ;
        
          helper1(root.right , map , root) ;

           
    }
    public void add(TreeNode target , List<Integer> list , int k, HashMap<TreeNode,TreeNode> map  )
    {
        if(target == null)
        return ; 

         downward(target.left , list , k-1) ; 
         downward(target.right , list, k-1) ; 

         if(map.get(target) != null)
         upward(map.get(target) , list , k-1 , target , map); 
        
    }
    public void downward(TreeNode root , List<Integer> list , int k)
    {
        if(root == null)
        return ; 

        if( k == 0)
        {
            list.add(root.val) ;
            return ; 
        }

        downward(root.left , list , k-1) ; 
        downward(root.right , list , k-1) ; 


    }
    public void upward(TreeNode root , List<Integer> list , int k , TreeNode child , HashMap<TreeNode,TreeNode> map )
    {
        if(root == null)
        return ; 


        if( k == 0)
        {
            list.add(root.val) ; 
            return ; 
        }


        if(root.left != child)
        {
            downward(root.left , list , k-1) ;
        }
        else if(root.right != null)
        {
            downward(root.right , list , k-1) ; 
        }



        if( map.get(root) != null)
        {
            upward(map.get(root) , list , k-1 , root , map) ;
        }
    }
}