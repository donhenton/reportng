/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.uncommons.reportng.sample;

import org.testng.ITest;
import org.testng.annotations.Listeners;

/**
 *
 * @author dhenton
 */
@Listeners({TestListener.class})
public class BaseTest implements ITest {

    @Override
    public String getTestName() {
         return this.getClass().getSimpleName();
    }
    
}
