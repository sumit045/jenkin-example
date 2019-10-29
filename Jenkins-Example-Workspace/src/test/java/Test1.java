import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Test1 {

	
	@Test
	public void test()
	{
		
		System.out.println("This is for testing");

		ExtentHtmlReporter reporter = new ExtentHtmlReporter("C:\\Users\\SumitKumar\\eclipse-workspace\\Sumit_Workspace\\jenkin-example\\Jenkins-Example-Workspace\\Reports\\HTMLReport.html");
		
		ExtentReports extentReport = new ExtentReports();
		extentReport.attachReporter(reporter);
		
		ExtentTest logger = extentReport.createTest("Testing");
		logger.log(Status.INFO, "Testing Report");
		
		extentReport.flush();
		
	}

}
