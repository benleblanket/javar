import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Created by Ben on 6/7/2017.
 */
public class RCallerInterfaceTest {

    //@Test
   // public void testAvg(){
     //   double[] arr1 = new double[]{5, 10, 15, 20};
       // RCallerInterface kenny = new RCallerInterface();
        //assertEquals(12.5, kenny.testAvg(arr1);
    //}
    @Test
    public void testCor(){
        double[] arra1 = new double[]{5, 10, 15, 20};
        double[] arra2 = new double[]{10, 25, 34, 70};
        RCallerInterface kenny = new RCallerInterface();
        for (double aV : kenny.testCor(arra1, arra2)) {
               System.out.println(aV);
            }
        //assertArrayEquals(,kenny.testCor(arra1, arra2));
    }


}