package utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager implements ITestListener {
	public ExtentSparkReporter sparkReporter; // UI of the report.
	public ExtentReports extent; // populate common info on the report.
	public ExtentTest test; // creating test case entries in the report and update status of the test
							// methods.

	public void onStart(ITestContext context) {
		sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "//reports//myReport.html");
		sparkReporter.config().setDocumentTitle("Automation Report");
		sparkReporter.config().setReportName("Functional Testing");
		sparkReporter.config().setTheme(Theme.DARK);

		extent = new ExtentReports();
		extent.attachReporter(sparkReporter); // connecting the UI with the Test report.

		extent.setSystemInfo("Computer Name", "localhost"); // stores the value in key- value pair.
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("Tester Name", "Kunj Maheshwari");
		extent.setSystemInfo("OS", "Windows");
		extent.setSystemInfo("Browser Name", "Chrome");
	}

	public void onTestSuccess(ITestResult result) {
		test = extent.createTest(result.getName()); // creates a new entry in the report.
		test.log(Status.PASS, "Test Case Passed is: " + result.getName());
	}

	public void onTestFailure(ITestResult result) {
		test = extent.createTest(result.getName());
		test.log(Status.FAIL, "Test Case Failed is: " + result.getName());
		test.log(Status.FAIL, "Test Case Failed Caused: " + result.getThrowable());
	}

	public void onTestSkipped(ITestResult result) {
		test = extent.createTest(result.getName());
		test.log(Status.SKIP, "Test Case skipped: " + result.getName());
	}

	public void onFinish(ITestContext context) {
		extent.flush();
	}
}