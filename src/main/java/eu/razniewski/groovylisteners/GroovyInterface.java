/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.razniewski.groovylisteners;

import java.io.IOException;
import org.bukkit.event.Listener;
import org.codehaus.groovy.control.CompilationFailedException;

/**
 *
 * @author edge
 */
public interface GroovyInterface {
    public Listener compileAndGetInstance(String file) throws CompilationFailedException, IOException, InstantiationException, IllegalAccessException;
    
}
