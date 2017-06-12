import org.junit.Test;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.text.DecimalFormat;

import static org.junit.Assert.*;

/**
 * Created by Ben on 6/9/2017.
 */
public class CSVandRTest {

    @Test
    public void testRow(){
        double expectedGrade = (145.0/181.0);
        //Note on delta: R rounds to the 15 decimals which may cause problems in equals.
        //In this case, Java has 16 decimals and R rounds the final digit to 15 decimals
        assertEquals(expectedGrade, CSVandR.rowTest(), 0.01);
    }

    @Test
    public void testColumn(){
        double expectedAvg = (1861.5/25.0);
        assertEquals(expectedAvg, CSVandR.columnTest(), 0.0);
    }
}
