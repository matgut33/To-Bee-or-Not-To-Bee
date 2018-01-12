
package to.be.or.not.to.be;

/**
 * @author Henry Dench (c)
 * @author Matthew Gutkin
 * @author Eric Von Bevern
 */

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
        dimx = Integer.parseInt(si.substring(0, 2));
        dimy = Integer.parseInt(si.substring(3, 5));
        dimz = Integer.parseInt(si.substring(6, 8));
        Box size[][][] = new Box[dimx][dimy][dimz];
        return size;
    }

}
