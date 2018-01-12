
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
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        //MATCH NUMBER TO WHICH SETUP TO USE
        int z = 1;
        
        DateFormat sdf = new SimpleDateFormat("MM-dd-yyyy  HH;mm;ss");
        Date date = new Date();
        String runDate = sdf.format(date);
        new File("Output/" + runDate).mkdirs();
        File f = new File("beesetup" + z + ".txt");
        Scanner r = new Scanner(f);
    }

}
