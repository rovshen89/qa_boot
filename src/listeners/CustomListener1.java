package listeners;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

public class CustomListener1 implements IInvokedMethodListener {

    public void beforeInvocation(IInvokedMethod method, ITestResult result){
        System.out.println("before invocation: " + result.getTestClass().getName() +
                "==>" + method.getTestMethod().getMethodName());
    }

    public void afterInvocation(IInvokedMethod method, ITestResult result){
        System.out.println("before invocation: " + result.getTestClass().getName() +
                "==>" + method.getTestMethod().getMethodName() +
                "==>" + result.isSuccess());
    }
}
