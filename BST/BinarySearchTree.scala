import scala.math._
object BinarySearchTree{
	trait Tree[+A]
	//definition of an empty node or leaf
	case object Leaf extends Tree[Nothing]
	//a node with value , left and right subtrees 
	case class Add[A](value: A, left: Tree[A], right: Tree[A]) extends Tree[A]

	// function that calculates the number of objects in the tree
	def numElems[A](tree: Tree[A]): Int = tree match {
    case Leaf => 0
    case Add(value,left,right) => 1 + numElems(left) + numElems(right)
    }
//function to calculate the maximum depth of the tree
 def maxDepth[A](tree: Tree[A]): Int = tree match {
    case Leaf => 0
    case Add(value,left,right) => 1 + (maxDepth(left) max maxDepth(right))
  }
  //Inorder travesal..left, root and right order traversal

  def inorder[A](tree : Tree[A]):List[A]= {
  tree match {
  	case Leaf =>List()
    case Add(value, left, right) =>inorder(left) ::: value :: inorder(right)
	  	}
	}
	//function that adds objects to the binary search tree. 
	def addElem[A](elem: A,  tree: Tree[A] )( implicit ordering: Ordering[A]): Tree[A] = tree match
  {
    case Leaf => Add( elem, Leaf, Leaf) 
    case Add(value, left, right) => 
      {
       if(ordering.gt(elem, value)) 
       		{
       		Add(value, left, addElem(elem, right))
       		}
       else if(ordering.lt(elem, value)) 
       		{
       		Add(value, addElem(elem, left), right)
       		}
       else
          
         Add(elem, left, right)
      }   
  }
  
//search for a particular object in ordered tree(Binary search tree)

  
def isThere[A](obj: A, tree: Tree[A])(implicit ordering: Ordering[A]): Boolean = tree match
  {
   //if leaf reached return false
    case Leaf => false 
 //else look at the different nodes
    case Add(value, left, right) => 
      {//if search object is less the root object go left 
       if(ordering.lt(obj, value) )
	       { 
	       	return isThere(obj,left)
	       }
	       //if search object is greater than root object go right
       else if(ordering.gt(obj, value)) 
       		{
       		//if search object is equal to root object return object
       	return isThere(obj,right)
            }
       else if(ordering.equiv(obj, value)) 
		       { println(obj+":Object found in the BST")
		       	return true
		       }
         else //for unsuccessful search
	         { 
	         	return false

	         }
       }
      }
  

	def main(args:Array[String]){

		println("===Algebraic Type Binary Search Demonstration:===")
		var tree1: Tree[Int] = Add(5,Add(2,Leaf,Leaf),Add(22,Add(7,Leaf,Add(8,Leaf,Add(9,Leaf,Leaf))),Leaf))
		var tree2: Tree[String] = Add("A",Add("B",Leaf,Leaf),Add("C",Add("D",Leaf,Add("F",Leaf,Add("G",Leaf,Leaf))),Leaf))
		    println("Integer Tree:"+tree1)
		    println("String Tree:"+tree2)
		    println("Tree1 Depth:"+maxDepth(tree1))
		    println("Tree1 # of object:"+numElems(tree1))
		    println("Adding an abject:")
		    tree1=addElem(6,tree1)
        tree1=addElem(5,tree1)
		    println("Modified Tree:"+tree1)
		    println("Tree Traversal in order:"+inorder(tree1))
		    println("Searching for an object:"+isThere(12,tree1))	
	}
}