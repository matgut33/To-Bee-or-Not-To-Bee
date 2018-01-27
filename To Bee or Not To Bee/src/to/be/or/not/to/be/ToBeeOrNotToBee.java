
package to.be.or.not.to.be;

/**
 * @author Henry Dench (c)
 * @author Matthew Gutkin
 * @author Eric Von Bevern
 */

import javafx.geometry.Point3D;
import java.util.Scanner;
import java.io.IOException;
import java.io.File;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.FileNotFoundException;

public class ToBeeOrNotToBee {

    /**
     * @param args String[]
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        //MATCH NUMBER TO WHICH SETUP TO USE
        int day = 1;
        
        DateFormat sdf = new SimpleDateFormat("MM-dd-yyyy  HH;mm;ss");
        Date date = new Date();
        String runDate = sdf.format(date);
        new File("Output/" + runDate).mkdirs();
        DecimalFormat two = new DecimalFormat("#.##");
        File f = new File("beesetup" + day + ".txt");
        Scanner r = new Scanner(f);
        day = r.nextInt();
        r.nextLine();
        String si = r.nextLine();
        int dimx, dimy, dimz;
        dimx = Integer.parseInt(si.substring(0, si.indexOf(",")));
        si.substring(si.indexOf(","));
        dimy = Integer.parseInt(si.substring(0, si.indexOf(",")));
        si.substring(si.indexOf(","));
        dimz = Integer.parseInt(si.substring(0, si.indexOf(",")));
        Box cube[][][] = new Box[dimx][dimy][dimz];
        dimx = Integer.parseInt(si.substring(0, si.indexOf(",")));
        si.substring(si.indexOf(",") + 1);
        dimy = Integer.parseInt(si.substring(0, si.indexOf(",")));
        si.substring(si.indexOf(",") + 1);
        dimz = Integer.parseInt(si.substring(0, si.indexOf(",")));
        Box size[][][] = new Box[dimx][dimy][dimz];
        for(int x = 0; x < dimx; x++){
            for(int y = 0; y < dimy; y++){
                for (int z = 0; z < dimz; z++){
                    Point3D temp = new Point3D(x,y,z);
                    cube[x][y][z] = new Box(temp);
                }
            }
        }
        Hive[] Hives = new Hive[15];
        for(int i = 0; i < 15; i++){
            String hi = r.nextLine();
            dimx = Integer.parseInt(hi.substring(0, hi.indexOf(",")));
            hi = hi.substring(hi.indexOf(",") + 1);
            dimy = Integer.parseInt(hi.substring(0, hi.indexOf(",")));
            hi = hi.substring(hi.indexOf(",") + 1);
            hi.trim();
            dimz = Integer.parseInt(hi);
            cube[dimx][dimy][dimz].setHive(true);
            Point3D temp = new Point3D(dimx,dimy,dimz);
            Hives[i] = new Hive(temp);
        }
        Bee[] Bees = new Bee[15];
        for(int i = 0; i < 15; i++){
            String be = r.nextLine();
            dimx = Integer.parseInt(be.substring(0, be.indexOf(",")));
            be = be.substring(be.indexOf(",") + 1);
            dimy = Integer.parseInt(be.substring(0, be.indexOf(",")));
            be = be.substring(be.indexOf(",") + 1);
            dimz = Integer.parseInt(be);
            Point3D htemp = new Point3D (dimx, dimy, dimz);
            cube[dimx][dimy][dimz].setBee(true);
            Bee temp = new Bee(htemp);
            Bees[i] = temp; 
        }
        int obs = Integer.parseInt(r.nextLine());
        for(int i = 0; i < obs; i++){
            String ob = r.nextLine();
            dimx = Integer.parseInt(ob.substring(0, ob.indexOf(",")));
            ob = ob.substring(ob.indexOf(",") + 1);
            dimy = Integer.parseInt(ob.substring(0, ob.indexOf(",")));
            ob = ob.substring(ob.indexOf(",") + 1);
            dimz = Integer.parseInt(ob);
            cube[dimx][dimy][dimz].setBlocked(true);
        }
        
        //Algorithm Try
        //Bee 1
       
        int totalmoves = 0;
        for(int i = 0; i < 15; i++){
            boolean done = false;
            for(int k = 0; done == false; k++){
            boolean left = false, right = false, up = false, down = false, forward = false, back = false, com = false;
            int wantedX = Bees[i].getX(), wantedY = Bees[i].getY(), wantedZ = Bees[i].getZ();
            if (Bees[i].getX() > Hives[i].getX()) left = true;
            if (Bees[i].getX() < Hives[i].getX()) right = true;
            if (Bees[i].getY() > Hives[i].getY()) down = true;
            if (Bees[i].getY() < Hives[i].getY()) up = true;
            if (Bees[i].getZ() > Hives[i].getZ()) back = true;
            if (Bees[i].getZ() < Hives[i].getZ()) forward = true;
            if (left == true) wantedX --;
            if (right == true) wantedX ++;
            if (down == true) wantedY --;
            if (up == true) wantedY ++;
            if (back == true) wantedZ --;
            if (forward == true) wantedZ ++;
            cube[Bees[i].getX()][Bees[i].getY()][Bees[i].getZ()].setBee(false);
            //System.out.println(wantedX + " " + wantedY + " " + wantedZ);
            //First Box (Best move) - Moves in X & Y & Z if wanted
            if (cube[wantedX][wantedY][wantedZ].isEmpty() == true && cube[wantedX][wantedY][wantedZ] != cube[Bees[i].getX()][Bees[i].getY()][Bees[i].getZ()]){
                Point3D temp = new Point3D(wantedX,wantedY,wantedZ);
                Bees[i].setLoc(temp);
                Bees[i].addMove();
                if(Bees[i].getX() == Hives[i].getX() && Bees[i].getY() == Hives[i].getY() && Bees[i].getZ() == Hives[i].getZ()) done = true;
                com = true;
            }
            //Second Box - Moves Y & Z if wanted
            if (com == false && cube[Bees[i].getX()][wantedY][wantedZ].isEmpty() == true && cube[Bees[i].getX()][wantedY][wantedZ] != cube[Bees[i].getX()][Bees[i].getY()][Bees[i].getZ()]){
                Point3D temp = new Point3D(Bees[i].getX(),wantedY,wantedZ);
                Bees[i].setLoc(temp);
                Bees[i].addMove();
                if(Bees[i].getX() == Hives[i].getX() && Bees[i].getY() == Hives[i].getY() && Bees[i].getZ() == Hives[i].getZ()) done = true;
                com = true;
            }
            //Third Box - Moves X & Z Direction if wanted
            if (com == false && cube[wantedX][Bees[i].getY()][wantedZ].isEmpty() == true && cube[wantedX][Bees[i].getY()][wantedZ] != cube[Bees[i].getX()][Bees[i].getY()][Bees[i].getZ()]){
                Point3D temp = new Point3D(wantedX,Bees[i].getY(),wantedZ);
                Bees[i].setLoc(temp);
                Bees[i].addMove();
                if(Bees[i].getX() == Hives[i].getX() && Bees[i].getY() == Hives[i].getY() && Bees[i].getZ() == Hives[i].getZ()) done = true;
                com = true;
            }
            //Fourth Box - Moves X & Y dimension if wanted
            if (com == false && cube[wantedX][wantedY][Bees[i].getZ()].isEmpty() == true && cube[wantedX][wantedY][Bees[i].getZ()] != cube[Bees[i].getX()][Bees[i].getY()][Bees[i].getZ()]){
                Point3D temp = new Point3D(wantedX,wantedY,Bees[i].getZ());
                Bees[i].setLoc(temp);
                Bees[i].addMove();
                if(Bees[i].getX() == Hives[i].getX() && Bees[i].getY() == Hives[i].getY() && Bees[i].getZ() == Hives[i].getZ()) done = true;
                com = true;
            }
            //Fifth Box - Only moves in the Z direction if wanted
            if (com == false && cube[Bees[i].getX()][Bees[i].getY()][wantedZ].isEmpty() == true && cube[Bees[i].getX()][Bees[i].getY()][wantedZ] != cube[Bees[i].getX()][Bees[i].getY()][Bees[i].getZ()]){
                Point3D temp = new Point3D(Bees[i].getX(),wantedY,wantedZ);
                Bees[i].setLoc(temp);
                Bees[i].addMove();
                if(Bees[i].getX() == Hives[i].getX() && Bees[i].getY() == Hives[i].getY() && Bees[i].getZ() == Hives[i].getZ()) done = true;
                com = true;
            }
            //Sixth Box - Only moves in the Y direction if wanted
            if (com == false && cube[Bees[i].getX()][wantedY][Bees[i].getZ()].isEmpty() == true && cube[Bees[i].getX()][wantedY][Bees[i].getZ()] != cube[Bees[i].getX()][Bees[i].getY()][Bees[i].getZ()]){
                Point3D temp = new Point3D(Bees[i].getX(),wantedY,wantedZ);
                Bees[i].setLoc(temp);
                Bees[i].addMove();
                if(Bees[i].getX() == Hives[i].getX() && Bees[i].getY() == Hives[i].getY() && Bees[i].getZ() == Hives[i].getZ()) done = true;
                com = true;
            }
            //Seventh Box - Only moves in the X direction if wanted
            if (com == false && cube[wantedX][Bees[i].getY()][Bees[i].getZ()].isEmpty() == true && cube[wantedX][Bees[i].getY()][Bees[i].getZ()] != cube[Bees[i].getX()][Bees[i].getY()][Bees[i].getZ()]){
                Point3D temp = new Point3D(Bees[i].getX(),wantedY,wantedZ);
                Bees[i].setLoc(temp);
                Bees[i].addMove();
                if(Bees[i].getX() == Hives[i].getX() && Bees[i].getY() == Hives[i].getY() && Bees[i].getZ() == Hives[i].getZ()) done = true;
                com = true;
            }
            if (com == false) {
                if(cube[Bees[i].getX()][Bees[i].getY() + 1][Bees[i].getZ()].isEmpty() == true){
                    Point3D temp = new Point3D(Bees[i].getX() + 1, Bees[i].getY() + 1, Bees[i].getZ() + 1);
                    System.out.println("First spot:" + Bees[i].toString());
                    Bees[i].setLoc(temp);
                    System.out.println("Move spot:" + Bees[i].toString());
                    Bees[i].addMove();
                    com = true;
                } else if (cube[Bees[i].getX() - 1][Bees[i].getY() - 1][Bees[i].getZ() - 1].isEmpty() == true){
                    Point3D temp = new Point3D(Bees[i].getX() - 1, Bees[i].getY() - 1, Bees[i].getZ() - 1);
                    System.out.println("First spot:" + Bees[i].toString());
                    Bees[i].setLoc(temp);
                    System.out.println("Moving spot:" + Bees[i].toString());
                    Bees[i].addMove();
                    com = true;
                } else {
                    System.out.println("Bee " + (i + 1));
                    System.out.println("Move " + (k + 1));
                    System.out.println("Current spot:" + Bees[i].toString());
                    break;
                }
            }
            if(Bees[i].getX() == Hives[i].getX() && Bees[i].getY() == Hives[i].getY() && Bees[i].getZ() == Hives[i].getZ()) done = true;
            cube[Bees[i].getX()][Bees[i].getY()][Bees[i].getZ()].setBee(true);
            if (done == true) {
                Bees[i].setMoves(k + 1);
                totalmoves += (k + 1);
                System.out.println(totalmoves);
                Hives[i].setFull(true);
            }
           
        }
        }
        
    }
        
}