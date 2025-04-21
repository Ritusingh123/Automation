package SeleniumFramework.Resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportNG {
	static ExtentReports extent;
	
	public static ExtentReports getReportObject() {	
		if (extent == null) {
		//ExtendReport, Extend spark report
		String path=System.getProperty("user.dir")+"//extentReprots//index.html";
		ExtentSparkReporter exp=new ExtentSparkReporter(path);
		exp.config().setReportName("Web Automation Results");
		exp.config().setDocumentTitle("Test Results");
		
		 extent=new ExtentReports();
		extent.attachReporter(exp);
		extent.setSystemInfo("Tester", "Ritu Singh");
		}
		//extent.createTest(path);
		return extent;
		
	}
}
