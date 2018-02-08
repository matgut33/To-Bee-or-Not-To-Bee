
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
    public static void main(String[] args) throws FileNotFoundException, IOException {
        //MATCH NUMBER TO WHICH SETUP TO USE
        int day = 1;
        
        int total = 0;
        DateFormat sdf = new SimpleDateFormat("MM-dd-yyyy  HH;mm;ss");
        Date date = new Date();
        String runDate = sdf.format(date);
        new File("Output/" + runDate + " SETUP " + day).mkdirs();
        DecimalFormat two = new DecimalFormat("#.##");
        File f = new File("beesetup" + day + ".txt");
        Scanner r = new Scanner(f);
        
        PrintWriter[] W = new PrintWriter[15];
        W[0] = new PrintWriter("Output/" + runDate + " SETUP " + day + "/Bee 1.txt", "UTF-8");
        W[1] = new PrintWriter("Output/" + runDate + " SETUP " + day + "/Bee 2.txt", "UTF-8");
        W[2] = new PrintWriter("Output/" + runDate + " SETUP " + day + "/Bee 3.txt", "UTF-8");
        W[3] = new PrintWriter("Output/" + runDate + " SETUP " + day + "/Bee 4.txt", "UTF-8");
        W[4] = new PrintWriter("Output/" + runDate + " SETUP " + day + "/Bee 5.txt", "UTF-8");
        W[5] = new PrintWriter("Output/" + runDate + " SETUP " + day + "/Bee 6.txt", "UTF-8");
        W[6] = new PrintWriter("Output/" + runDate + " SETUP " + day + "/Bee 7.txt", "UTF-8");
        W[7] = new PrintWriter("Output/" + runDate + " SETUP " + day + "/Bee 8.txt", "UTF-8");
        W[8] = new PrintWriter("Output/" + runDate + " SETUP " + day + "/Bee 9.txt", "UTF-8");
        W[9] = new PrintWriter("Output/" + runDate + " SETUP " + day + "/Bee 10.txt", "UTF-8");
        W[10] = new PrintWriter("Output/" + runDate + " SETUP " + day + "/Bee 11.txt", "UTF-8");
        W[11] = new PrintWriter("Output/" + runDate + " SETUP " + day + "/Bee 12.txt", "UTF-8");
        W[12] = new PrintWriter("Output/" + runDate + " SETUP " + day + "/Bee 13.txt", "UTF-8");
        W[13] = new PrintWriter("Output/" + runDate + " SETUP " + day + "/Bee 14.txt", "UTF-8");
        W[14] = new PrintWriter("Output/" + runDate + " SETUP " + day + "/Bee 15.txt", "UTF-8");
        PrintWriter WO = new PrintWriter("Output/" + runDate + " SETUP " + day + "/Overall.txt", "UTF-8");
        
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
                                
            Double closest = 9999999999999999999.0;
            int goingto = h;
            for(int hiveoptions = 0; hiveoptions < 15; hiveoptions ++)
            {
                if(Hives[hiveoptions].isFull() == false && Hives[hiveoptions].getDistance(Bees[h].getLoc()) < closest)
                {
                    closest = Hives[hiveoptions].getDistance(Bees[h].getLoc());
                    goingto = hiveoptions;
                }
            }
                
            
            
            boolean done = false;
            W[h].println("Bee " + (h + 1) + " started at point " + Bees[h].getX() + "," + Bees[h].getY() + "," + Bees[h].getZ());
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
                        d = Hives[goingto].getDistance(options[j-1]) - Hives[goingto].getDistance(options[j]);
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
                        W[h].println("Bee " + (h + 1) + " moved to " + (int)options[i].getX() + "," + (int)options[i].getY() + "," + (int)options[i].getZ());
                        break;
                        }

                if (Hives[goingto].getLoc().equals(Bees[h].getLoc())){
                    done = true;
                    Hives[goingto].setFull(true);
                    W[h].println("Bee " + (h + 1) + " done in " + Bees[h].getMoves() + " moves.");
                    WO.println("Bee " + (h + 1) + " done in " + Bees[h].getMoves() + " moves.");
                    total += Bees[h].getMoves();
                    W[h].close();
                }
            }
        }
        WO.println("The total amount of moves is " + total + " moves");
        WO.close();
    }
                    }

                }
      
    
}