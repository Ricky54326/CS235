package assign4;

/**
 * Title: ShapeCollection Class for CS 235 Assignment #4
 * Description: CS 235 Assignment #4 - ShapeCollection
 *             This class contains Shape objects.
 * @author Ricky Mutschlechner
 * @email riccardo.mutschlechner@my.uwrf.edu
 * @author Noah Muth
 * @email noah.muth@my.uwrf.edu
 * @date   December 13th, 2012
 * @version 1.0
 */


import java.awt.Graphics;
import java.io.Serializable;

import shapes.Drawable;
import shapes.Shape;

public class ShapeCollection implements Serializable{
	/**
	 * Data members and class invariants
	 */
	private static final long serialVersionUID = 1L;
	private static final int DEFAULT_INITIAL_SIZE = 10;
	private Shape[] store;
	private int size;
	private int startsize;

	public ShapeCollection() {
		store = new Shape[ DEFAULT_INITIAL_SIZE ];
		size  = 0;
		startsize = DEFAULT_INITIAL_SIZE;
	}

	public ShapeCollection(final int startsize) {
		store = new Shape[ startsize ];
		size  = 0;
		this.startsize = startsize;
	}

	public int getSize(){
		return size;
	}

	public Shape get( final int index ) {
		return store[index];
	}
	
	public void remove(final int index){
		store[index] = null;
	}
	
	public void set( final Shape s ){
		if(this.getSize() < this.getCapacity())
			store[size++] = s;
		else{
			System.err.println("ShapeCollection is full.");
			System.out.flush();
		}
	}

	public int getCapacity() {
		return store.length;
	}
	
	public boolean hasSpace(){
		return size < store.length;
	}
	
	public void clear(){
		this.store = new Shape[this.startsize];
		this.size = 0;
	}
	
	public void draw(Graphics g){
		for(Shape s : store){
			if(s != null)
				((Drawable)s).draw(g);
		}
	}
	
	
	/**
	 * sort - uses Selection sort to sort the shapes based on their areas. 
	 */
	public void sort(){
		int i, j, maxAreaIndex;
		for (j = 0; j < this.getSize() -1; j++) {
			maxAreaIndex = j;
			for(i = 0; i < this.getSize() -1; i++){
				if(this.store[i].area() > this.store[maxAreaIndex].area())
					maxAreaIndex = i;
			}
				if(maxAreaIndex != j){
					Shape temp = this.store[maxAreaIndex];
					this.store[maxAreaIndex] = this.store[j];
					this.store[j] = temp;
				}
		}
	}
	
}