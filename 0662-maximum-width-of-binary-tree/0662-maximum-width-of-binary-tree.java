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
    public int widthOfBinaryTree(TreeNode root) {
        
        // isme thoda bhot reference vertical order se le sakte hain ; 
        
        HashMap<TreeNode,Integer> map  = new HashMap<>() ; 


        int answer = 1 ; 


        map.put(root,1) ; 

        Queue<TreeNode> q = new LinkedList<>() ; 

        q.add(root) ; 
        q.add(null) ; 
            
         int left = 1 ; 
         int right = 1 ; 

        while(q.size() != 1)
        {
              TreeNode temp = q.remove() ; 
        
              if(temp == null)
              {
                  q.add(temp) ; 
                  
                  System.out.println("left= " + left + "right+= " + right) ; 
                  if(right - left + 1 > answer)
                  answer = right-left + 1 ; 


                  left = map.get(q.peek()) ; 
              }
              else
              {
                  right = map.get(temp) ; 

                  if(temp.left != null)
                  {
                      q.add(temp.left) ; 
                      map.put(temp.left , map.get(temp)*2) ;
                  }


                  if(temp.right != null)
                  {
                      q.add(temp.right) ; 
                      map.put(temp.right , map.get(temp)*2+1) ;
                  }
              }
        }



                if(right - left +1 > answer)
                  answer = right-left + 1 ; 



                  return answer ; 
    }
}