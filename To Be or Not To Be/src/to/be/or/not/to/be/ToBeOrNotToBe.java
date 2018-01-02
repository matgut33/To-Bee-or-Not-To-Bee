
package to.be.or.not.to.be;

/**
 * @author Matthew Gutkin
 *
 */

import java.util.Scanner;
import java.io.IOException;
import java.io.File;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ToBeOrNotToBe {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd  HH;mm;ss");
        Date date = new Date();
        String runDate = sdf.format(date);
        new File("Output/" + runDate).mkdirs();
        
    }

}
