/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.uncommons.reportng.sample;

import org.testng.Reporter;
import org.testng.annotations.Test;

/**
 *
 * @author dhenton
 */
public class ReporterTests extends BaseTest {
    
    /**
     * should see a link in the test report, needs escaping turned off
     * in the pom file
     */
    
    @Test
    public void testOutput()
    {
        Reporter.log("<a target='_blank' href='http://www.nytimes.com'>Ny Times in new window</a>");
    }
    
    
    
    
    
}
