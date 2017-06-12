import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Created by Ben on 6/7/2017.
 */
public class RCallerInterfaceTest {

    @Test
    public void testAvg(){
        double[] arr1 = new double[]{5, 10, 15, 20};
        //RCallerInterface kenny = new RCallerInterface();
        assertEquals(12.5, RCallerInterface.avgTest(arr1), 0);
    }

    @Test
    public void testCor(){
        double[] arra1 = new double[]{5, 10, 15, 20};
        double[] arra2 = new double[]{10, 25, 34, 70};
        //RCallerInterface kenny = new RCallerInterface();
        for (double aV : RCallerInterface.testCor(arra1, arra2)) {
               System.out.println(aV);
            }
        //assertArrayEquals(,kenny.testCor(arra1, arra2));
    }

    @Test
    public void testMatrixAvg(){
        String[] names = new String[]{"Zack", "Kevin", "Dajuan"};
        //each array is a test #. Within each array, each student has test score in it.
        double[][] scores = new double[][]{{75.7, 92.5, 81.0}, {56.9, 95.8, 89.2}, {100.0, 69.6, 82.3}};
        //RCallerInterface kenny = new RCallerInterface();
        assertEquals("Kevin", RCallerInterface.gradingTest(names, scores));

    }




}