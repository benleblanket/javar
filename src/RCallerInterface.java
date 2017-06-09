import com.github.rcaller.rstuff.*;
import com.github.rcaller.util.Globals;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Ben on 6/7/2017.
 */
public class RCallerInterface {

    //example code that makes a pie graph
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

    public double[] testCor(double[] arr1, double[] arr2){
        RCaller rCaller;
        if(Globals.isWindows() == false) {
            RCallerOptions options = RCallerOptions.create("/usr/local/Cellar/r/3.4.0_1/bin/Rscript", Globals.R_current, FailurePolicy.RETRY_5, Long.MAX_VALUE, 100, RProcessStartUpOptions.create());
            rCaller = RCaller.create(options);
        }else {
            rCaller  = RCaller.create();
        }
        RCode code = RCode.create();
        code.addDoubleArray("x", arr1);
        code.addDoubleArray("y", arr2);
        code.addRCode("cor<-lm(y~x)");
        code.addRCode("b<-cor$residuals");
        rCaller.setRCode(code);
        rCaller.runAndReturnResult("cor");
        double[] residuals = rCaller.getParser().getAsDoubleArray("fitted_values");
        //for (double aV : residuals) {
         //   System.out.println(aV);
        //}
        return residuals;
    }

    public double avgTest(double[] arr){
        RCaller rCaller = RCaller.create();
        RCode code = RCode.create();
        code.addDoubleArray("x", arr);
        code.addRCode("a<-mean(x)");
        rCaller.setRCode(code);
        rCaller.runAndReturnResult("a");
        double[] avg = rCaller.getParser().getAsDoubleArray("a");

        return (avg[0]);
    }

    public String gradingTest(String[] names, double[][] scores){
        RCaller rCaller = RCaller.create();
        RCode code = RCode.create();
        code.addStringArray("students", names);
        code.addDoubleMatrix("scores", scores);
        double[] averages = new double[3];
        code.addDoubleArray("averages", averages);
        code.addRCode("for(i in 1:3){ " +
                "averages[i]<-mean(scores[i]) " +
                "}");
        rCaller.setRCode(code);
        rCaller.runAndReturnResult("averages");
        double[] results = rCaller.getParser().getAsDoubleArray("averages");
        int high = 1;
        for(int i = 0; i < results.length; i++){
            if(averages[i] > averages[high]){
                high = i;
            }
        }
        return names[high];
    }


    public static void main(String[] args) {

        double[] arra1 = new double[]{5, 10, 15, 20};
        double[] arra2 = new double[]{10, 25, 34, 70};
        //double[] arra3 = testCor(arra1, arra2);

        //testAvg(arra1);

    }
}

