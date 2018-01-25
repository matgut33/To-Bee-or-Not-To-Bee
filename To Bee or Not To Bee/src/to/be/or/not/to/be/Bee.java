
package to.be.or.not.to.be;

import javafx.geometry.Point3D;

/**
 * @author Henry Dench (c)
 * @author Matthew Gutkin
 * @author Eric Von Bevern
 */

public class Bee {
    private Point3D loc;
    private int moves;
    
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

    public int getMoves() {
        return moves;
    }

    public void setMoves(int moves) {
        this.moves = moves;
    }
    
    public int getX() {
        return (int)loc.getX();
    }
    
    public int getY() {
        return (int)loc.getY();
    }
    
    public int getZ() {
        return (int)loc.getZ();
    }
}
