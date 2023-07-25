/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
};
*/

class Solution {
    public Node construct(int[][] grid) {
        

         return helper( grid , 0 , grid.length-1 , 0 , grid[0].length-1) ; 
    }
    public Node helper(int grid[][] , int startR  , int endR , int startC , int endC)
    {

        boolean isZero = check( 0 , grid , startR  , endR , startC , endC) ; 


        if(isZero == true )
        {
            Node node = new Node(false , true , null , null  , null , null ) ; 

            return node ; 
        }
        boolean isOne = check( 1 , grid ,  startR  ,  endR ,  startC , endC ) ; 

        if(isOne == true )
        {
            Node node = new Node( true , true , null , null  , null , null ) ; 

            return node ; 
        }


        // above we checked , that is the all values in the grid , are same , 
        // if all values are same , then , we will do as we done above 
        // other wise we will divide it into four smaller parts
        

        // and we will do 4 recursion calls for 4 childrens ; 


        Node node = new Node(true , false) ; 


 // this step is very important , ie finding the middle vlaue of both rows and both 
 // columns ; 
        int middleR = startR + (endR- startR + 1)/2 - 1 ; 


        int middleC = startC + (endC-startC +1 )/2 -1 ; 



        node.topLeft = helper(grid , startR , middleR , startC , middleC) ; 

        node.topRight = helper(grid , startR , middleR , middleC+1 , endC) ; 

        node.bottomLeft = helper(grid , middleR+1 , endR , startC , middleC) ; 

        node.bottomRight = helper(grid , middleR+1 , endR  ,  middleC+1 , endC) ; 


        return node ; 


    }
    public boolean check(int value , int grid[][] ,   int startR  , int endR , int startC , int endC) 
    {
        for( int i = startR ; i <= endR ; i++)
        {
            for( int j = startC ; j <= endC ; j++)
            {
                if( grid[i][j] != value)
                return false ; 
            }
        }

        return true ; 
    }
}