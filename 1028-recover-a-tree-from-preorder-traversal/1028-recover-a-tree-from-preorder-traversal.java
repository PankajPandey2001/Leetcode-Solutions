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
    public TreeNode recoverFromPreorder(String traversal) {
        
        // TreeNode array[] = new TreeNode[]      , size nhi pta phle se therefore list
        // use karni padhegi  ; 

        if( traversal.length() == 0)
        return null ; 


        List<TreeNode> list = new ArrayList<>() ; 
         
         String temp = "" ; 

          int i = 0 ; 

         for(  i = 0 ; i < traversal.length(); i++)
         {
              if( traversal.charAt(i) < '0' || traversal.charAt(i) > '9')
              {
                  break ; 
              }
              else
              continue ; 
         }

        
         temp = traversal.substring(0 , i) ; 


         int data = Integer.parseInt(temp) ; 

         TreeNode root = new TreeNode(data) ; 

         list.add(root) ; 

         helper(traversal , i ,  list) ; 


         return root ; 
    } 
    public void helper(String traversal , int index , List<TreeNode> list)
    {
         if( index >= traversal.length())
         return ; 

        int count = 0 ; 

        while( index < traversal.length() && traversal.charAt(index) == '-')
        {
            count++ ; 
            index++ ; 
        }
        
        int tempIndex = index ; 

         while( index < traversal.length() && traversal.charAt(index) != '-')
        {
            
            index++ ; 
        }


        int data = Integer.parseInt(traversal.substring(tempIndex , index)) ; 

        TreeNode parent = list.get(count-1) ; 

        TreeNode curr = new TreeNode(data) ; 

        if( parent.left == null)
        {
            parent.left = curr ; 
        }
        else
        parent.right = curr  ; 

      // ye condition bhot jaruri hai , matlab ki agar , ek particular level par naye node// ko visit kar diya hai , toh ab agar usse kam level ka node aayga toh wo isnode ka children hoga
      // basically ek bar particualr elvel ka naya node visit kara toh usko hi consider karenge
      
        if( list.size() > count)
        {
            list.add(count , curr) ; 
        }
        else
        list.add(curr) ; 

        helper( traversal , index , list) ; 

    }
}