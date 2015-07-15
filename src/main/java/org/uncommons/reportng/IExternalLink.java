/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.uncommons.reportng;

/**
 *
 * @author dhenton
 */
public interface IExternalLink {
    
    /**
     * the implementing class must be fully responsible for rendering
     * the complete text of the link .
     * eg. <a href="blah" _target="_blank">Get a job</a>
     * @return 
     */
    public String renderLinkText();
}
