package lab6part3;

/**
 * Title: Rectangle class for CSIS 235 Lab #6
 * Description: CS 235 Lab #6 - Rectangle
 *  This class represents a rectangle with integer dimensions.
 *
 * @author Ricky Mutschlechner and Tim Olmstead
 * @email  riccardo.mutschlechner@my.uwrf.edu and timothy.olmstead@my.uwrf.edu
 * @date   10/17/2012
 */


public class Rectangle {
  
  // Private data members:
  
  private int length;
  private int width;
  
  // Constructors:
  
  /**
   * Constructor:
   * 
   * Create a new Rectangle with the specified length and width.
   * Length and width must be non-negative.
   */
  public Rectangle (int length, int width) {
    this.length = length;
    this.width = width;
  }
  
  /*
   * Default constructor for a rectangle, automatically makes it 10x20 if unspecified.
   */
  public Rectangle(){
	  length = 10;
	  width = 20;
  }
  
  // Queries:
  
  /**
   * length:
   * 
   * Returns the length of this Rectangle.
   */
  public int length () {
    return length;
  }
  
  /**
   * width:
   * 
   * Returns the width of this Rectangle.
   */
  public int width () {
    return width;
  }
    
  /**
   * area:
   * 
   * Returns the area of this Rectangle.
   */
  public int area () {
    return length * width;
  }
  
  /**
   * perimeter:
   * 
   * Returns the perimeter of this Rectangle.
   */
  public int perimeter () {
    return 2*length + 2*width;
  }
  
  public String toString(){
	  return "Length: " +length+ "\nWidth: " +width+ "\nArea: " +area()+ "\nPerimeter: " +perimeter();
  }
  
}