import com.github.rcaller.rstuff.RCaller;
import com.github.rcaller.rstuff.RCode;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Ben on 6/7/2017.
 */
public class RCallerInterface {

    public static void callRCodeDemo(){
        try {
            RCaller rCaller = RCaller.create();
            RCode code = RCode.create();

            double[] x = new double[]{1, 2, 3, 4, 5};
            double[] y = new double[]{5, 7, 6, 10, 20};
            code.addDoubleArray("x", x);
            code.addDoubleArray("y", y);
            code.addRCode("ols<-lm(y~x)");
            code.addRCode("a<-ols$residuals");

            double[] tt = new double[100];
            for (int i = 0; i < tt.length; i++) {
                tt[i] = Math.random();
            }
            code.addDoubleArray("tt", tt);
            File f = code.startPlot();
            code.addRCode("pie(tt)");
            code.endPlot();

            rCaller.setRCode(code);
            rCaller.runAndReturnResult("ols");

            System.out.println("Names : " + rCaller.getParser().getNames());
            code.showPlot(f);
            double[] v = rCaller.getParser().getAsDoubleArray("fitted_values");
            for (double aV : v) {
                System.out.println(aV);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        callRCodeDemo();
    }
    }

