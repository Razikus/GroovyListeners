/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.razniewski.groovylisteners;

import groovy.lang.GroovyClassLoader;
import java.io.File;
import java.io.IOException;
import org.bukkit.event.Listener;
import org.codehaus.groovy.control.CompilationFailedException;

/**
 *
 * @author edge
 */
public class GroovyListenerLoader implements GroovyInterface {

    @Override
    public Listener compileAndGetInstance(String file) throws CompilationFailedException, IOException, InstantiationException, IllegalAccessException {
        GroovyClassLoader loader = new GroovyClassLoader(GroovyListenersPlugin.class.getClassLoader());
        Class example = loader.parseClass(new File(file));
        Listener listener = (Listener) example.newInstance();
        return listener;
    }
    
}
