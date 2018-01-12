
package to.be.or.not.to.be;

import javafx.geometry.Point3D;

/**
 * @author Matthew Gutkin
 *
 */

public class Box {
    private Point3D loc;
    boolean blocked;
    
    public Box()
    {
        Point3D x = new Point3D(0,0,0);
        setLoc(x);
    }
    
    public Box(Point3D x)
    {
       setLoc(x);
    }
    
    public Point3D getLoc() {
        return loc;
    }

    public void setLoc(Point3D loc) {
        this.loc = loc;
    }
    
    
}