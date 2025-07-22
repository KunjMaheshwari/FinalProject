package utilities;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShot {
	public static void takeElementScreenshot(WebDriver driver, String filePath) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;

		// Capture the screenshot as a temporary file
		File srcFile = ts.getScreenshotAs(OutputType.FILE);

		// Ensure target directory exists
		Path targetPath = Paths.get(filePath);
		Files.createDirectories(targetPath.getParent());

		// Copy temp file to the final destination
		Files.copy(srcFile.toPath(), targetPath);
	}
}