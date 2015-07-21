/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.uncommons.reportng.sample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;

/**
 *
 * @author dhenton
 */
public class TestListener extends TestListenerAdapter {

    private Logger LOG = LoggerFactory.getLogger(TestListener.class);

    @Override
    public void onStart(ITestContext testContext) {
        super.onStart(testContext);
        if (testContext.getAllTestMethods().length > 0) {
            LOG.info(testContext.getAllTestMethods()[0]
                    .getRealClass().getSimpleName() + " start");
        }
    }

    @Override
    public void onTestStart(ITestResult result) {
        super.onTestStart(result);
        Reporter.setCurrentTestResult(result);
    }

    @Override
    public void onConfigurationSuccess(ITestResult itr) {
        super.onConfigurationSuccess(itr);
    }

    @Override
    public void onConfigurationFailure(ITestResult itr) {
        super.onConfigurationFailure(itr);
    }

    @Override
    public void onFinish(ITestContext testContext) {
        super.onFinish(testContext);
        if (testContext.getAllTestMethods().length > 0) {
            LOG.info(testContext.getAllTestMethods()[0]
                    .getRealClass().getSimpleName() + " finish");
        }
    }

    @Override
    public void onTestFailure(ITestResult result) {
        super.onTestFailure(result);

        LOG.info("test " + result.getTestName() + "-->"
                + result.getMethod().getMethodName() + " failed ");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        super.onTestSuccess(result);
        LOG.info("test " + result.getTestName() + "-->"
                + result.getMethod().getMethodName() + " succeeded ");
    }

}
