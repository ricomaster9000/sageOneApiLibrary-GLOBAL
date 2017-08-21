package testPackage;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;


public class TestRunner {

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(TestVersion2.class);

        System.out.println(result.getFailureCount() + " tests failed out a total of " + result.getRunCount());

        for(Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
    }

}
