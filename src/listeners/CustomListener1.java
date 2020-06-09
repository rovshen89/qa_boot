package listeners;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class CustomListener1 implements IInvokedMethodListener {

    public void beforeInvocation(IInvokedMethod method, ITestResult result){
        System.out.println("before invocation: " + result.getTestClass().getName() +
                "==>" + method.getTestMethod().getMethodName());
        Reporter.log("before invocation: " + result.getTestClass().getName() +
                "==>" + method.getTestMethod().getMethodName(), true);

    }

    public void afterInvocation(IInvokedMethod method, ITestResult result){
        System.out.println("before invocation: " + result.getTestClass().getName() +
                "==>" + method.getTestMethod().getMethodName() +
                "==>" + result.isSuccess());
        Reporter.log("before invocation: " + result.getTestClass().getName() +
                "==>" + method.getTestMethod().getMethodName() +
                "==>" + result.isSuccess(), true);

    }
}
