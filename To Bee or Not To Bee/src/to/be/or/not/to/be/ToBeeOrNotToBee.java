
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
            hi.substring(hi.indexOf(","));
            dimy = Integer.parseInt(hi.substring(0, hi.indexOf(",")));
            hi.substring(hi.indexOf(","));
            dimz = Integer.parseInt(hi.substring(0, hi.indexOf(",")));
            cube[dimx][dimy][dimz].setHive(true);
            Point3D temp = new Point3D(dimx,dimy,dimz);
            Hives[i] = new Hive(temp);
        }
        Bee[] Bees = new Bee[15];
        for(int i = 0; i < 15; i++){
            String be = r.nextLine();
            dimx = Integer.parseInt(be.substring(0, be.indexOf(",")));
            be.substring(be.indexOf(","));
            dimy = Integer.parseInt(be.substring(0, be.indexOf(",")));
            be.substring(be.indexOf(","));
            dimz = Integer.parseInt(be.substring(0, be.indexOf(",")));
            Point3D htemp = new Point3D (dimx, dimy, dimz);
            cube[dimx][dimy][dimz].setBee(true);
            Bee temp = new Bee(htemp);
            Bees[i] = temp; 
        }
        int obs = Integer.parseInt(r.nextLine());
        for(int i = 0; i < obs; i++){
            String ob = r.nextLine();
            dimx = Integer.parseInt(ob.substring(0, ob.indexOf(",")));
            ob.substring(ob.indexOf(",") + 1);
            dimy = Integer.parseInt(ob.substring(0, ob.indexOf(",")));
            ob.substring(ob.indexOf(",") + 1);
            dimz = Integer.parseInt(ob.substring(0, ob.indexOf(",")));
            cube[dimx][dimy][dimz].setBlocked(true);
        }
        
        //Algorithm Try
        //Bee 1
        boolean left = false, right = false, up = false, down = false, forward = false, back = false;
        int wantedX = Bees[0].getX(), wantedY = Bees[0].getY(), wantedZ = Bees[0].getZ();
        int moves[] = new int[15];
        if (Bees[0].getX() > Hives[0].getX()) left = true;
        if (Bees[0].getX() < Hives[0].getX()) right = true;
        if (Bees[0].getY() > Hives[0].getY()) down = true;
        if (Bees[0].getY() < Hives[0].getY()) up = true;
        if (Bees[0].getZ() > Hives[0].getZ()) back = true;
        if (Bees[0].getZ() < Hives[0].getZ()) forward = true;
        if (left = true) wantedX -= 1;
        if (right = true) wantedX += 1;
        if (down = true) wantedY -= 1;
        if (up = true) wantedY += 1;
        if (back = true) wantedZ -= 1;
        if (forward = true) wantedZ += 1;
        if (cube[wantedX][wantedY][wantedZ].isFull() == false){
            Point3D temp = new Point3D(wantedX, wantedY, wantedZ);
            Bees[0] = new Bee(temp);
            moves[0] += 1;
        } else {
            wantedX = Bees[0].getX();
            if (cube[wantedX][wantedY][wantedZ].isFull() == false)
        }
    }
  

    
}
