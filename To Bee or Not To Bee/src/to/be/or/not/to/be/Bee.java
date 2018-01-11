/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package to.be.or.not.to.be;
import javafx.geometry.Point3D;
/**
 *
 * @author evonbevern
 */

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
