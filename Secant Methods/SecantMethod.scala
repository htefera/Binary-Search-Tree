
  object SecantMethod{
 // A function that compares two Double numbers and returns True or false
  def comp(x:Double,y:Double):Boolean={
    if(x>y) true 
    else false
  }
   // definition of a sample function x2-8.0 for testing purpose
  def fx(x:Double):Double=
  {
    val result:Double=x*x-8.0  
    result
  }
  
  // function to compute root of a function according to secant method formula
  def findRoot(x0:Double, x1:Double, fn:Double => Double):Double =
    {
      // secant formula calculating the roort of the first value
      val y1=fn(x1)
      val y0=fn(x0)
      val dx=x1-x0
      val dy=y1-y0
      return x1-(y1*dx)/dy
    }
  
  // function to generate stream of Xn based on Secant formula given above
  def secantStream(x0:Double, x1:Double, fn:Double => Double):Stream[Double] =
  {
      //generating successive rootsusing x0 and x1 as starting point
      lazy val streamroots:Stream[Double]=findRoot(x0,x1,fn) #:: secantStream(x1, findRoot(x0,x1,fn),fn)
       
      return streamroots
  }
    
  // main secant function to solve for any given function f 
  def secantMethod(x0:Double, x1:Double, fn:Double => Double, ep:Double):Double =
  {
      var XnS = secantStream(x0, x1, fn)  //starting stream
      var XnPlus1 = XnS.head      //assign head of the stream to XnPlus1  
      XnS = XnS.tail             //update the original stream   
      var Xn = XnS.head           //assign head of new stream to Xn 
      XnS = XnS.tail                //again update stream
      var dif = Math.abs(Xn - XnPlus1) //differnce Xn-XnPluse1 
      var err = ep*Math.abs(Xn)      //find the abs of Xn
      //looping till(Xn-XnPlus1)<ep*Xn
      while(comp(dif,err)) //while condition is true do..
      { // swap the value of XnPlus1 and Xn till the result converges
        XnPlus1 = Xn        
        Xn = XnS.head            
        XnS = XnS.tail      
        dif = Math.abs(Xn - XnPlus1)     
        err = ep*Math.abs(Xn)         
      }                  
      return Xn // return result
  }
      
  def main(args: Array[String]) 
    {
        println("Secant Method Testing")
        println("Xn:"+secantMethod(0,10,fx,0.00001))
        println("Xn:"+secantMethod(2,10,fx,0.00001))
        println("Xn:"+secantMethod(1,10,fx,0.00001))
      
        
    }
  
}