
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
        
        int total = 0;
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
        for(int h = 0; h < 15; h++){
            boolean done = false;
            while(done == false){
                Point3D[] pmoves = new Point3D[50];
                Point3D[] options = new Point3D[26];
                options[0] = new Point3D(Bees[h].getX() + 1, Bees[h].getY() + 1,Bees[h].getZ() + 1);
                options[1] = new Point3D(Bees[h].getX() + 1, Bees[h].getY() + 1,Bees[h].getZ() + 0);
                options[2] = new Point3D(Bees[h].getX() + 1, Bees[h].getY() + 1,Bees[h].getZ() - 1);
                options[3] = new Point3D(Bees[h].getX() + 1, Bees[h].getY() + 0,Bees[h].getZ() + 1);
                options[4] = new Point3D(Bees[h].getX() + 1, Bees[h].getY() + 0,Bees[h].getZ() + 0);
                options[5] = new Point3D(Bees[h].getX() + 1, Bees[h].getY() + 0,Bees[h].getZ() - 1);
                options[6] = new Point3D(Bees[h].getX() + 1, Bees[h].getY() - 1,Bees[h].getZ() + 1);
                options[7] = new Point3D(Bees[h].getX() + 1, Bees[h].getY() - 1,Bees[h].getZ() + 0);
                options[8] = new Point3D(Bees[h].getX() + 1, Bees[h].getY() - 1,Bees[h].getZ() - 1);
                options[9] = new Point3D(Bees[h].getX() + 0, Bees[h].getY() + 1,Bees[h].getZ() + 1);
                options[10] = new Point3D(Bees[h].getX() + 0, Bees[h].getY() + 1,Bees[h].getZ() + 0);
                options[11] = new Point3D(Bees[h].getX() + 0, Bees[h].getY() + 1,Bees[h].getZ() - 1);
                options[12] = new Point3D(Bees[h].getX() + 0, Bees[h].getY() + 0,Bees[h].getZ() + 1);
                options[13] = new Point3D(Bees[h].getX() + 0, Bees[h].getY() + 0,Bees[h].getZ() - 1);
                options[14] = new Point3D(Bees[h].getX() + 0, Bees[h].getY() - 1,Bees[h].getZ() + 1);
                options[15] = new Point3D(Bees[h].getX() + 0, Bees[h].getY() - 1,Bees[h].getZ() + 0);
                options[16] = new Point3D(Bees[h].getX() + 0, Bees[h].getY() - 1,Bees[h].getZ() - 1);
                options[17] = new Point3D(Bees[h].getX() - 1, Bees[h].getY() + 1,Bees[h].getZ() + 1);
                options[18] = new Point3D(Bees[h].getX() - 1, Bees[h].getY() + 1,Bees[h].getZ() + 0);
                options[19] = new Point3D(Bees[h].getX() - 1, Bees[h].getY() + 1,Bees[h].getZ() - 1);
                options[20] = new Point3D(Bees[h].getX() - 1, Bees[h].getY() + 0,Bees[h].getZ() + 1);
                options[21] = new Point3D(Bees[h].getX() - 1, Bees[h].getY() + 0,Bees[h].getZ() + 0);
                options[22] = new Point3D(Bees[h].getX() - 1, Bees[h].getY() + 0,Bees[h].getZ() - 1);
                options[23] = new Point3D(Bees[h].getX() - 1, Bees[h].getY() - 1,Bees[h].getZ() + 1);
                options[24] = new Point3D(Bees[h].getX() - 1, Bees[h].getY() - 1,Bees[h].getZ() + 0);
                options[25] = new Point3D(Bees[h].getX() - 1, Bees[h].getY() - 1,Bees[h].getZ() - 1);
                double d = 0;
                for(int i = 0; i < options.length; i++)
                {
                    for(int j = 1; j < (options.length - i); j++)
                    {
                        d = Hives[h].getDistance(options[j-1]) - Hives[h].getDistance(options[j]);
                            if (d > 0) 
                            {
                            Point3D tmp = options[j-1];
                            options[j-1] = options[j];
                            options[j] = tmp;
                            } 
                    }
                }

                for(int i = 0; i < options.length; i++)
                {
                    if (options[i].getX() > 0 && options[i].getY() > 0 && options[i].getZ() > 0 && options[i].getX() < cube.length && options[i].getY() < cube.length && options[i].getZ() < cube.length && Bees[h].checkMove(options[i]) == true){
                        if (cube[(int)options[i].getX()][(int)options[i].getY()][(int)options[i].getZ()].isEmpty() == true){
                        Point3D temp = options[i];
                        Bees[h].setLoc(temp);
                        Bees[h].addMove(options[i]);
                        System.out.println("Bee " + (h + 1) + " moved to " + options[i].getX() + "," + options[i].getY() + "," + options[i].getZ());
                        break;
                        }
                    }

                }

                if (Hives[h].getLoc().equals(Bees[h].getLoc())){
                    done = true;
                    System.out.println("Bee " + (h + 1) + " done in " + Bees[h].getMoves() + " moves.");
                    total += Bees[h].getMoves();
                }
            }
        }
        System.out.println("The total amount of moves is " + total + " moves");
    }
        
        
}