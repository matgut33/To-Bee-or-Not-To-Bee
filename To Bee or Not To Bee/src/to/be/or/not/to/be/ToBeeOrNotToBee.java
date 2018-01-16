
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
      
        Box cube[][][] = getSize(r);
        
        
    }
    
    public static Box[][][] getSize(Scanner r) {
        r.nextLine();
        String si = r.nextLine();
        int dimx, dimy, dimz;
        dimx = Integer.parseInt(si.substring(0, si.indexOf(",") - 1));
        si.substring(si.indexOf("," + 1));
        dimy = Integer.parseInt(si.substring(0, si.indexOf(",") - 1));
        si.substring(si.indexOf("," + 1));
        dimz = Integer.parseInt(si.substring(0, si.indexOf(",") - 1));
        Box size[][][] = new Box[dimx][dimy][dimz];
        return size;
    }
    
    public static Hive[] setHive(Scanner r) {
        r.nextLine();
        r.nextLine();
        Hive[] h = new Hive[15];
        for(int i = 0; i < 15; i++){
            String hi = r.nextLine();
            int dimx, dimy, dimz;
            dimx = Integer.parseInt(hi.substring(0, hi.indexOf(",") - 1));
            hi.substring(hi.indexOf("," + 1));
            dimy = Integer.parseInt(hi.substring(0, hi.indexOf(",") - 1));
            hi.substring(hi.indexOf("," + 1));
            dimz = Integer.parseInt(hi.substring(0, hi.indexOf(",") - 1));
            Point3D htemp = new Point3D (dimx, dimy, dimz);
            Hive temp = new Hive(htemp, false);
            h[i] = temp;
        }
        return h;
    }
    
    public static Bee[] setBee(Scanner r) {
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
    
    public static void setObs(Scanner r) {
        for(int i = 0; i < 33; i++){
            r.nextLine();
        }
        Box[] b = new Box[15];
        for(int i = 0; i < 15; i++){
            String ob = r.nextLine();
            int dimx, dimy, dimz;
            dimx = Integer.parseInt(ob.substring(0, ob.indexOf(",") - 1));
            ob.substring(ob.indexOf("," + 1));
            dimy = Integer.parseInt(ob.substring(0, be.indexOf(",") - 1));
            ob.substring(ob.indexOf("," + 1));
            dimz = Integer.parseInt(be.substring(0, be.indexOf(",") - 1));
            Point3D htemp = new Point3D (dimx, dimy, dimz);
            Bee temp = new Bee(htemp);
            o[i] = temp;
        }
        return b;
    }

    
}
