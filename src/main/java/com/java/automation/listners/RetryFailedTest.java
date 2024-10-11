package com.java.automation.listners;

import com.java.automation.constants.FrameworkConstants;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryFailedTest implements IRetryAnalyzer {

    private int retryCount = 0;
    private static final int maxRetryCount = FrameworkConstants.MAXRETRYCOUNT;

    @Override
    public boolean retry(ITestResult result) {
        if (retryCount < maxRetryCount) {
            retryCount++;
            return true;
        }
        return false;
    }
}
