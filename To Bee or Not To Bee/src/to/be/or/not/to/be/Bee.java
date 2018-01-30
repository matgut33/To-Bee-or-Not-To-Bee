
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
    private Point3D[] pmoves = new Point3D[10000];
    
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
   
    public void addMove(Point3D a){
        pmoves[moves] = a;
        moves ++;
    }
    
    public boolean checkMove(Point3D m){
        for(int i = 0; i < moves; i++){
            if (pmoves[i].equals(m)){
                return false;
            }
        }
        return true;         
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
    
    public String toString() {
        return "(" + this.getX() + "," + this.getY() + "," + this.getZ() + ")";
    }
    
}
