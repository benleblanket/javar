import com.github.rcaller.rstuff.*;
import com.github.rcaller.util.Globals;

/**
 * Created by Ben on 6/9/2017.
 */
public class CSVandR {


    public static double rowTest(){
        RCaller rCaller;
        if(Globals.isWindows() == false) {
            RCallerOptions options = RCallerOptions.create("/usr/local/Cellar/r/3.4.0_1/bin/Rscript", Globals.R_current, FailurePolicy.RETRY_5, Long.MAX_VALUE, 100, RProcessStartUpOptions.create());
            rCaller = RCaller.create(options);
        }else {
            rCaller  = RCaller.create();
        }
        RCode code = RCode.create();
        code.addInt("points", 0);
        code.addInt("max", 181);
        code.addDouble("grade", 0);
        /** Reading csvfile through hardcoded filepath
         *  Read from directory path and filename as variable works too
         */

        code.addRCode("example.df <- read.csv(file='/Users/bleblanc2/IdeaProjects/javar/src/DataCSVExample.csv', header=TRUE, sep=',')");
        code.addRCode("for(i in 3:11){ " +
            "points <- points + example.df[[i]][2]" +
                    "}");
        code.addRCode("grade <- points/max");
        rCaller.setRCode(code);
        rCaller.runAndReturnResult("grade");
        double[] results = rCaller.getParser().getAsDoubleArray("grade");
        return results[0];
    }

    public static double columnTest(){
        RCaller rCaller;
        if(Globals.isWindows() == false) {
            RCallerOptions options = RCallerOptions.create("/usr/local/Cellar/r/3.4.0_1/bin/Rscript", Globals.R_current, FailurePolicy.RETRY_5, Long.MAX_VALUE, 100, RProcessStartUpOptions.create());
            rCaller = RCaller.create(options);
        }else {
            rCaller  = RCaller.create();
        }
        RCode code = RCode.create();
        code.addDouble("classAvg", 0.0);
        code.addRCode("example.df <- read.csv(file='/Users/bleblanc2/IdeaProjects/javar/src/DataCSVExample.csv', header=TRUE, sep=',')");
        code.addRCode("classAvg <- mean(example.df$FinalExam)");
        rCaller.setRCode(code);
        rCaller.runAndReturnResult("classAvg");
        double[] results = rCaller.getParser().getAsDoubleArray("classAvg");
        return results[0];
    }

}
