/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.uncommons.reportng.external.links;

import org.uncommons.reportng.IExternalLink;

/**
 *
 * @author dhenton
 */
public class ExternalLinkTester implements IExternalLink {

    @Override
    public String renderLinkText() {
         return "<a href=\"http://www.google.com\">Google</a>";
    }
    
}
