
package to.be.or.not.to.be;

import javafx.geometry.Point3D;

/**
 * @author Henry Dench (c)
 * @author Matthew Gutkin
 * @author Eric Von Bevern
 */

public class Hive {
    private Point3D loc;
    boolean full;
    
    public Hive() {
        this(new Point3D(0,0,0),false);
    }
    
    public Hive(Point3D x, boolean f)
    {
       setFull(f);
       setLoc(x);
    }

    public Point3D getLoc() {
        return loc;
    }

    public void setLoc(Point3D loc) {
        this.loc = loc;
    }

    public boolean isFull() {
        return full;
    }

    public void setFull(boolean full) {
        this.full = full;
    }
    
    
}
