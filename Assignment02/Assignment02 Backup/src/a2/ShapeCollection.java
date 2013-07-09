package a2;

/**
 * <p>Title: ShapeCollection Class</p>
 * <p>Description: CS 235 Assignment #2 - ShapeCollection - an array or "Collection" of Shape objects of different types </p>
 * @author Ricky Mutschlechner
 * @role   Primary Coordinator, secondary Recorder
 * @email  riccardo.mutschlechner@my.uwrf.edu
 * @author Tim Olmstead
 * @role   Primary Recorder
 * @email  timothy.olmstead@my.uwrf.edu
 * @author Hao Chen
 * @role   Secondary recorder, Primary Checker
 * @email  hao.chen@my.uwrf.edu
 * @date   November 1st 2012
 */

public class ShapeCollection {
	private static final int DEFAULT_INITIAL_SIZE = 10;
	private Shape[] store;
	private int size;

	//constructors
	public ShapeCollection() {
		store = new Shape[ DEFAULT_INITIAL_SIZE ];
		size  = 0;
	}

	public ShapeCollection(int size) {
		store = new Shape[ size ];
		size  = 0;
	}

	/**
	* <p>getSize</p>
	* <p>Description: get the size of the shape</p>
	* @require none
	* @ensure none
	*
	*/
	public int getSize(){
		return size;
	}

	/**
	* <p>get</p>
	* <p>Description: This method computes ...</p>
	* @param int index - used to pass the value of shape
	* @require none 
	* @ensure none
	*
	*/
	public Shape get( int index ) {
		return store[index];
	}
	
	/**
	* <p>set</p>
	* <p>Description: This method computes to add the Shape s into the Collection of Shapes.</p>
	* @param Shape s - the Shape we are adding to the array
	* @require none
	* @ensure size < DEFAULT_INITIAL_SIZE : will not try to access an out of bounds element of the Collection
	*
	*/
	public void set( Shape s ){
		if(size < DEFAULT_INITIAL_SIZE)
			store[size++] = s;
		else
			System.err.println("The collection is full. Shape was not added.");
	}
}