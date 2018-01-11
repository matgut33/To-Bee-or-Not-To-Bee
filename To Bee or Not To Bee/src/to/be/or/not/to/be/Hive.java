
package to.be.or.not.to.be;

/**
 * @author Henry Dench (c)
 * @author Matthew Gutkin
 * @author Eric Von Bevern
 */

import javafx.geometry.Point3D;

public class Hive {
    private Point3D loc;
    boolean full;
    
    public Hive() {
        Point3D x = new Point3D(0,0,0);
        setLoc(x);
        setFull(false);
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
