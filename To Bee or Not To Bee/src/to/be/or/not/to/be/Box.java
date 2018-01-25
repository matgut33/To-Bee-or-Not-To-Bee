
package to.be.or.not.to.be;

import javafx.geometry.Point3D;

/**
 * @author Matthew Gutkin
 *
 */

public class Box {
    private Point3D loc;
    boolean blocked;
    boolean hive;
    boolean bee;
    
    
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

    public boolean isBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    public boolean isHive() {
        return hive;
    }

    public void setHive(boolean hive) {
        this.hive = hive;
    }

    public boolean isBee() {
        return bee;
    }

    public void setBee(boolean bee) {
        this.bee = bee;
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
    
    public boolean isFull(){
        if (blocked == true || bee == true) return true;
        return false;
        
    }
}