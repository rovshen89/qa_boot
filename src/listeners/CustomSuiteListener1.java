package listeners;

import org.testng.ISuite;
import org.testng.ISuiteListener;

public class CustomSuiteListener1 implements ISuiteListener {
    @Override
    public void onStart(ISuite suite) {
        System.out.println("onFinish:" + suite.getName());
    }

    @Override
    public void onFinish(ISuite suite) {
        System.out.println("onStart:" + suite.getName());

    }
}
