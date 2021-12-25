### 1. Binary-Search-Tree Implementation
The problem is decompposed intothe following set of functions:-

* **addElem**: add an object to binary search tree based on its magnitude
* **isThere**: searches for a particular object in ordered tree
* **numElems**: counts the number of objects in the binary search tree excluding the empty
nodes using concept of scala recursion
* **maxDepth**: finds the height of the tree/depth of the tree recursively
* **Inorder**: traverse the tree in left, root and right fashion and display the result using a list

### 2. Secant Method Implementation

Secant method is a recursive method for finding the root for the polynomials by successive approximations. 

To solve the problem I decompoased into the following methods

* **comp(Double,Double)**:Double: Compares two double numbers and later i used this when
inside the secantMethod function
* **fx(Double)**: definition of a sample function x2-8.0 for testing purpose and used on both
secantMethod and secantStream methods
* **findRoot(Double,Double,fx)**:function to compute root of a function according to secant
method formula . This function calculates only one root value which is the x2 from x0 and
* **secantStream(Double,Double, Double=>Double)**:Stream[Double]: Function that computes a
stream for a given input
* **secantMethod(Double,Double,Double=>Double,ep)**: a function that computes the successive
stream values till the convergence of the function is satisfied.




### Resources
1. [Introduction to Programming and Problem-Solving Using Scala](https://www.routledge.com/Introduction-to-Programming-and-Problem-Solving-Using-Scala/Lewis-Lacher/p/book/9781498730952)
2. [Binary Search Tree](https://www.programiz.com/dsa/binary-search-tree)
