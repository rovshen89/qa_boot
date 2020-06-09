package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;

public class CustomITestListener1 implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("onTestStart="+result.getName());
    }
    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("onTestSuccess="+result.getName());
    }
    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("onTestFailure="+result.getName());
    }
    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("onTestSkipped="+result.getName());
    }
    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println("onTestFailedButWithinSuccessPercentage="+result.getName());
    }
    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        System.out.println("onTestFailedWithTimeout="+result.getName());
    }
    @Override
    public void onStart(ITestContext context) {
        System.out.println("onStart="+context.getName());
        ITestNGMethod methods[] = context.getAllTestMethods();
        for(ITestNGMethod method: methods) {
            System.out.println(method.getMethodName());
        }
    }
    @Override
    public void onFinish(ITestContext context) {
        System.out.println("onFinish="+context.getName());
    }
}
