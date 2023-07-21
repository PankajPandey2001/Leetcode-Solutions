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
    public List<Double> averageOfLevels(TreeNode root) {
        
        List<Double> answer = new ArrayList<>() ; 

        Queue<TreeNode> q = new LinkedList<>() ; 
       q.add(root) ; 
       q.add(null) ; 

       long sum = 0 ; 
       long count = 0 ; 

       while(q.size() != 1)
       {
           TreeNode temp = q.remove() ;


           if(temp == null)
           {
               q.add(temp) ; 

               double avg = (double)sum / (double)count ; 

               answer.add(avg) ; 

               sum = 0 ; 
               count = 0 ; 

               continue ; 
           }


           sum += temp.val ; 

           count++ ; 

           if( temp.left != null)
           q.add(temp.left) ; 

           if(temp.right != null)
           q.add(temp.right) ; 


           
       }


        double avg = (double)sum / (double)count ; 
          answer.add(avg) ; 

          return answer ; 


        
    }
}