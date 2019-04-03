package testNgClasses.Listeners;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;
import org.testng.annotations.Test;

//IInvokedMethodListener is invoked before and after method by Testng
public class CustomListener1 implements IInvokedMethodListener {
  @Test
  public void f() {
  }

@Override
public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
	//before every method in the test class
	System.out.println("beforeInvocation: " + testResult.getTestClass().getName() + "=> " + method.getTestMethod().getMethodName());
	
}

@Override
public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
	// after every method in the test class
	System.out.println("afterInvocation: " + testResult.getTestClass().getName() + " => " + method.getTestMethod().getMethodName());
	
}

}
