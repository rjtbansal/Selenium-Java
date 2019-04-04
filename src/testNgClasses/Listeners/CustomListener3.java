package testNgClasses.Listeners;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.annotations.Test;

public class CustomListener3 implements ISuiteListener{

	@Override
	public void onStart(ISuite suite) {
		// When <suite> tag starts
		System.out.println("onStart: before suite starts");
		
	}

	@Override
	public void onFinish(ISuite suite) {
		// When <suite> tag completes
		System.out.println("onFinish: after suite completes");
		
	}
  
	
}
