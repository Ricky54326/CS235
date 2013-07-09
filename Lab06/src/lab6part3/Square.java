package lab6part3;

public class Square extends Rectangle {
	//Instance Variables
	private int side;

	
	public Square(int side){
		this.side = side;
	}
	
	public int getSide(){
		return side;
	}

		  /**
		   * area:
		   * 
		   * Returns the area of this Rectangle.
		   */
		  public int area () {
		    return side * side;
		  }
		  
		  /**
		   * perimeter:
		   * 
		   * Returns the perimeter of this Rectangle.
		   */
		  public int perimeter () {
		    return 2*side + 2*side;
		  }
		  
		  public String toString(){
			  return "\nSide: " + side + "\nArea: " +area()+ "\nPerimeter: " +perimeter();
}
}
