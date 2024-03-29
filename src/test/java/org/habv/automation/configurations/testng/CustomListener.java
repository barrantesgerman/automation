package org.habv.automation.configurations.testng;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import org.habv.automation.configurations.selenium.TestCaseBase;

public class CustomListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult iTestResult) {
//        System.out.println("\t|-- Estamos en el metodo onTestStart");
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
//        System.out.println("\t|-- Estamos en el metodo onTestSuccess");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
//        System.out.println("\t|-- Estamos en el metodo onTestFailure");
        WebDriver driver = ((TestCaseBase) (iTestResult.getInstance())).getDriver();

        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File(String.format("./src/test/resources/screenshot-%s.png",
                    iTestResult.getMethod().getMethodName())));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
//        System.out.println("\t|-- Estamos en el metodo onTestSkipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
//        System.out.println("\t|-- Estamos en el metodo onTestFailedButWithinSuccessPercentage");
    }

    @Override
    public void onStart(ITestContext iTestContext) {
//        System.out.println("\t|-- Estamos en el metodo onStart");
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
//        System.out.println("\t|-- Estamos en el metodo onFinish");
    }
}
