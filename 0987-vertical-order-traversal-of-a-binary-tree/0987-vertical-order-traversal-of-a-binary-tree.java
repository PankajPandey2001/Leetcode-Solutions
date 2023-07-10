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

    static int minimum = 0 ; 
    static int maximum = 0 ; 
    static int maxRow = 0 ; 

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        
         HashMap<Integer,HashMap<Integer,ArrayList<Integer>>> map = new HashMap<>() ; 

        minimum = 0 ; 
        maximum = 0 ; 
        maxRow = 0 ; 
         helper( root , 0 , 0 , map) ; 

         List<List<Integer>> list = new ArrayList<>() ; 

         for( int column = minimum ; column <= maximum ; column++)
         {
             HashMap<Integer,ArrayList<Integer>> temp = map.get(column) ; 
             
             List<Integer> answer = new ArrayList<>() ; 

             for( int row = 0 ; row <= maxRow ; row++)
             {
                 if(temp.containsKey(row) == false)
                 continue ; 

                 ArrayList<Integer> temporary  = temp.get(row) ; 

                 Collections.sort(temporary) ; 

                 for( int k = 0 ; k < temporary.size() ; k++)
                 {
                      answer.add(temporary.get(k)) ; 
                 }
             }


             list.add(answer) ;
         }

         return list ;
    } 
    public void helper(TreeNode root, int row , int column , HashMap<Integer,HashMap<Integer,ArrayList<Integer>>> map )
    {

        if(root == null)
        return ; 
        
        if( column < minimum)
        minimum = column ; 

        if( column > maximum)
        maximum = column ; 

        if( row > maxRow )
        {
            maxRow = row ; 
        }

        if(map.containsKey(column) )
        {
            HashMap<Integer,ArrayList<Integer>> temp = map.get(column) ; 

            if( temp.containsKey(row))
            {
                ArrayList<Integer> list =temp.get(row) ; 
                list.add(root.val) ;
            }
            else
            {
                ArrayList<Integer> list = new ArrayList<>() ; 
                list.add(root.val) ;
                temp.put(row , list) ; 
            }
        }
        else
        {
             HashMap<Integer,ArrayList<Integer>> temp = new HashMap<>(); 
              ArrayList<Integer> list = new ArrayList<>() ; 
                list.add(root.val) ;
                temp.put(row , list) ;
            map.put(column , temp) ; 

        }



        helper(root.left , row+1 , column-1 , map) ; 
        helper(root.right , row+1, column+1 , map) ; 
    }
}