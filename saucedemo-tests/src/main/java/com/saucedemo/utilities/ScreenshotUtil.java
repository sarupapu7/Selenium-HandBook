package com.saucedemo.utilities;

import org.openqa.selenium.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Utility to capture and save screenshots.
 */
public class ScreenshotUtil {

    public static String captureScreenshot(WebDriver driver, String testName) {
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String fileName = testName + "_" + timestamp + ".png";

        // folder under project root
        String folderPath = System.getProperty("user.dir") + File.separator + "screenshots";
        File directory = new File(folderPath);
        if (!directory.exists()) {
            directory.mkdirs();
        }

        // Take screenshot
        TakesScreenshot ts = (TakesScreenshot) driver;
        File srcFile = ts.getScreenshotAs(OutputType.FILE);
        File destFile = new File(folderPath + File.separator + fileName);

        try {
            Files.copy(srcFile.toPath(), destFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return destFile.getAbsolutePath();  // so caller can log it
    }
}
