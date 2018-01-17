
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
        int z = 1;
        
        DateFormat sdf = new SimpleDateFormat("MM-dd-yyyy  HH;mm;ss");
        Date date = new Date();
        String runDate = sdf.format(date);
        new File("Output/" + runDate).mkdirs();
        DecimalFormat two = new DecimalFormat("#.##");
        File f = new File("beesetup" + z + ".txt");
        Scanner r = new Scanner(f);
        int day = r.nextInt();
        Box cube[][][] = setBoxes(r); 
        
        
    }
    
    public static Box[][][] setBoxes(Scanner r) {
        r.nextLine();
        String si = r.nextLine();
        int dimx, dimy, dimz;
        dimx = Integer.parseInt(si.substring(0, si.indexOf(",") - 1));
        si.substring(si.indexOf(",") + 1);
        dimy = Integer.parseInt(si.substring(0, si.indexOf(",") - 1));
        si.substring(si.indexOf(",") + 1);
        dimz = Integer.parseInt(si.substring(0, si.indexOf(",") - 1));
        Box size[][][] = new Box[dimx][dimy][dimz];
        for(int x = 0; x < dimx; x++){
            for(int y = 0; y < dimy; y++){
                for (int z = 0; z < dimz; z++){
                    Point3D temp = new Point3D(x,y,z);
                    size[x][y][z] = new Box(temp);
                }
            }
        }
        Box a[][][] = setHive(r,size);
        Bee bee[] = makeBees(r);
        return a;
    }
    
    
    public static Box[][][] setHive(Scanner r, Box[][][] t) {
        r.nextLine();
        r.nextLine();
        
        for(int i = 0; i < 15; i++){
            String hi = r.nextLine();
            int dimx, dimy, dimz;
            dimx = Integer.parseInt(hi.substring(0, hi.indexOf(",") - 1));
            hi.substring(hi.indexOf("," + 1));
            dimy = Integer.parseInt(hi.substring(0, hi.indexOf(",") - 1));
            hi.substring(hi.indexOf("," + 1));
            dimz = Integer.parseInt(hi.substring(0, hi.indexOf(",") - 1));
            t[dimx][dimy][dimz].setHive(true);
        }
        Box[][][] d = setBees(r, t);
        return d;
    }
    
    public static Bee[] makeBees(Scanner r) {
        for(int i = 0; i < 18; i++){
            r.nextLine();
        }
        Bee[] b = new Bee[15];
        for(int i = 0; i < 15; i++){
            String be = r.nextLine();
            int dimx, dimy, dimz;
            dimx = Integer.parseInt(be.substring(0, be.indexOf(",") - 1));
            be.substring(be.indexOf("," + 1));
            dimy = Integer.parseInt(be.substring(0, be.indexOf(",") - 1));
            be.substring(be.indexOf("," + 1));
            dimz = Integer.parseInt(be.substring(0, be.indexOf(",") - 1));
            Point3D htemp = new Point3D (dimx, dimy, dimz);
            Bee temp = new Bee(htemp);
            b[i] = temp;
            
        }
        return b;
    }
    
    public static Box[][][] setBees(Scanner r, Box[][][] input) {
        for(int i = 0; i < 15; i++){
            String be = r.nextLine();
            int dimx, dimy, dimz;
            dimx = Integer.parseInt(be.substring(0, be.indexOf(",") - 1));
            be.substring(be.indexOf("," + 1));
            dimy = Integer.parseInt(be.substring(0, be.indexOf(",") - 1));
            be.substring(be.indexOf("," + 1));
            dimz = Integer.parseInt(be.substring(0, be.indexOf(",") - 1));
            input[dimx][dimy][dimz].setBee(true);
        }
        Box[][][] output = setObs(r, input);
        return output;
    }
    
    public static Box[][][] setObs(Scanner r, Box[][][] t) {
        int obs = Integer.parseInt(r.nextLine());
        for(int i = 0; i < obs; i++){
            String ob = r.nextLine();
            int dimx, dimy, dimz;
            dimx = Integer.parseInt(ob.substring(0, ob.indexOf(",") - 1));
            ob.substring(ob.indexOf("," + 1));
            dimy = Integer.parseInt(ob.substring(0, ob.indexOf(",") - 1));
            ob.substring(ob.indexOf("," + 1));
            dimz = Integer.parseInt(ob.substring(0, ob.indexOf(",") - 1));
            t[dimx][dimy][dimz].setBlocked(true);
        }
        return t;
    }

    
}
