
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
        boolean done = false;
        for(int i = 0; done == false; i++){
            boolean left = false, right = false, up = false, down = false, forward = false, back = false, com = false;
            int wantedX = Bees[0].getX(), wantedY = Bees[0].getY(), wantedZ = Bees[0].getZ();
            if (Bees[0].getX() > Hives[0].getX()) left = true;
            if (Bees[0].getX() < Hives[0].getX()) right = true;
            if (Bees[0].getY() > Hives[0].getY()) down = true;
            if (Bees[0].getY() < Hives[0].getY()) up = true;
            if (Bees[0].getZ() > Hives[0].getZ()) back = true;
            if (Bees[0].getZ() < Hives[0].getZ()) forward = true;
            if (left == true) wantedX --;
            if (right == true) wantedX ++;
            if (down == true) wantedY --;
            if (up == true) wantedY ++;
            if (back == true) wantedZ --;
            if (forward == true) wantedZ ++;
            cube[Bees[0].getX()][Bees[0].getY()][Bees[0].getZ()].setBee(false);
            System.out.println(wantedX + " " + wantedY + " " + wantedZ);
            //First Box (Best move)
            if (cube[wantedX][wantedY][wantedZ].isEmpty() == true){
                System.out.println("Move Good");
                Point3D temp = new Point3D(wantedX,wantedY,wantedZ);
                Bees[0].setLoc(temp);
                Bees[0].addMove();
                if(Bees[0].getX() == Hives[0].getX() && Bees[0].getY() == Hives[0].getY() && Bees[0].getZ() == Hives[0].getZ()) done = true;
                com = true;
            }
            //Second Box
            if (com == false && cube[Bees[0].getX()][wantedY][wantedZ].isEmpty() == true){
                System.out.println("Move Good");
                Point3D temp = new Point3D(Bees[0].getX(),wantedY,wantedZ);
                Bees[0].setLoc(temp);
                Bees[0].addMove();
                if(Bees[0].getX() == Hives[0].getX() && Bees[0].getY() == Hives[0].getY() && Bees[0].getZ() == Hives[0].getZ()) done = true;
                com = true;
            }
            //Third Box
            if (com == false && cube[wantedX][Bees[0].getY()][wantedZ].isEmpty() == true){
                System.out.println("Move Good");
                Point3D temp = new Point3D(wantedX,Bees[0].getY(),wantedZ);
                Bees[0].setLoc(temp);
                Bees[0].addMove();
                if(Bees[0].getX() == Hives[0].getX() && Bees[0].getY() == Hives[0].getY() && Bees[0].getZ() == Hives[0].getZ()) done = true;
                com = true;
            }
            //Fourth Box
            if (com == false && cube[wantedX][wantedY][Bees[0].getZ()].isEmpty() == true){
                System.out.println("Move Good");
                Point3D temp = new Point3D(wantedX,wantedY,Bees[0].getZ());
                Bees[0].setLoc(temp);
                Bees[0].addMove();
                if(Bees[0].getX() == Hives[0].getX() && Bees[0].getY() == Hives[0].getY() && Bees[0].getZ() == Hives[0].getZ()) done = true;
                com = true;
            }
            
        }
    }
        
}