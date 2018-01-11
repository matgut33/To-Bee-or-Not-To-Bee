
package to.be.or.not.to.be;

/**
 * @author Henry Dench (c)
 * @author Matthew Gutkin
 * @author Eric Von Bevern
 */

import javafx.geometry.Point3D;


public class Bee {
    private Point3D loc;
    
    public Bee()
    {
        Point3D x = new Point3D(0,0,0);
        setLoc(x);
    }
    
    public Bee(Point3D x)
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
