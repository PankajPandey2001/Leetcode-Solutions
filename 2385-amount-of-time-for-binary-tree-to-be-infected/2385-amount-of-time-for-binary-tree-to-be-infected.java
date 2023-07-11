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
    public int amountOfTime(TreeNode root, int start) {
        
         HashMap<TreeNode,TreeNode> map = new HashMap<>() ; 


       TreeNode target =  helper1(root , map , null , start) ;  // to put parent of eveyr node , as its value ; 

        System.out.println(target.val) ;
       if(target == null)
        return 0 ; 

        // so that upward bhi traverse kar sake ; 


        int option1 = downward(target.left ) ; 
        int option2 = downward(target.right ) ; 

        int option3 = Integer.MIN_VALUE  ; 

         
        if(map.get(target) != null)
         option3 = upward(map.get(target) , target , map) ;


         return Math.max(option1 , Math.max(option2 , option3)) + 1 ; 


        
    }
     public TreeNode helper1(TreeNode root , HashMap<TreeNode,TreeNode> map , TreeNode parent,int start )
    {
        if(root == null)
        return null ; 

        map.put(root , parent) ;

         
        
         TreeNode temp1 = helper1(root.left , map , root , start) ;
        
         TreeNode temp2 =  helper1(root.right , map , root, start) ;
           
           if(temp1 != null)
           return temp1 ; 

           if(temp2 != null)
           return temp2 ; 

         if(root.val == start )
         return root ;


         return null ;  

           
    }
    public int downward(TreeNode root )
    {
        if(root == null)
        return -1 ; 

        

       int a =  downward(root.left ) ; 
       int b =  downward(root.right ) ; 


       return Math.max(a,b) + 1 ; 


    }
    public int upward(TreeNode root , TreeNode child , HashMap<TreeNode,TreeNode> map )
    {
        if(root == null)
        return -1 ; 


      
        int a = Integer.MIN_VALUE ; 
        int b = Integer.MIN_VALUE ; 

        if(root.left != child)
        {
            a = downward(root.left ) ;
        }
        else if(root.right != child)
        {
            a = downward(root.right ) ; 
        }



        if( map.get(root) != null)
        {
            b = upward(map.get(root) , root , map) ;
        }



        return Math.max(a,b) + 1 ; 
    }
}