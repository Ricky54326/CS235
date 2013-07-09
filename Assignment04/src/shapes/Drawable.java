package shapes;

/** 
* Drawable - an interface that determines whether or not a Shape is Drawable to the screen.
* @author Ricky Mutschlechner
* @email riccardo.mutschlechner@my.uwrf.edu
* @author Noah Muth
* @email noah.muth@my.uwrf.edu
* @date   December 13th, 2012
* @version 1.0
*/
import java.awt.Graphics;

public interface Drawable {
	public abstract void draw( Graphics g);
}
