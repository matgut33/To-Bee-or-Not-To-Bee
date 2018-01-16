
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
<<<<<<< HEAD
        int dimx, dimy = 0, dimz = 0;
        dimx = Integer.parseInt(si.substring(0, si.indexOf(",")));
        String siz = (si.substring(si.indexOf(",") + 1));
        System.out.println(siz);
        dimy = Integer.parseInt(siz.substring(0, siz.indexOf(",")));
        dimz = Integer.parseInt(siz.substring(siz.indexOf(",") + 1));
        int size[][][] = new int[dimx][4][9];
        System.out.println(dimx + " " + dimy + " " + dimz);
        
=======
        int dimx, dimy, dimz;
        dimx = Integer.parseInt(si.substring(0, si.indexOf(",") - 1));
        si.substring(si.indexOf("," + 1));
        dimy = Integer.parseInt(si.substring(0, si.indexOf(",") - 1));
        si.substring(si.indexOf("," + 1));
        dimz = Integer.parseInt(si.substring(0, si.indexOf(",") - 1));
        Box size[][][] = new Box[dimx][dimy][dimz];
        return size;
>>>>>>> 03e5d6bfca6ab52b335ab93540edb8ffffc933af
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

}
