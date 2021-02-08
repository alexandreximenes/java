/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gui;

/**
 *
 * @author alexandrelerario
 */

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.naming.Context.INITIAL_CONTEXT_FACTORY;
import static javax.naming.Context.PROVIDER_URL;
import javax.naming.InitialContext;
import javax.naming.NamingException;


public class CallEJB {
     public int fat_orb(int v) {
        
        Properties props = new Properties();
        props.setProperty("java.naming.factory.initial", "com.sun.enterprise.naming.SerialInitContextFactory");
        props.setProperty("java.naming.factory.url.pkgs","com.sun.enterprise.naming");
        props.setProperty("java.naming.factory.state","com.sun.corba.ee.impl.presentation.rmi.JNDIStateFactoryImpl");
        props.setProperty("org.omg.CORBA.ORBInitialHost", "localhost");
        props.setProperty("org.omg.CORBA.ORBInitialPort", "3700");
        props.setProperty("com.sun.corba.ee.transport.ORBWaitForResponseTimeout","5000");
        props.setProperty("com.sun.corba.ee.transport.ORBTCPConnectTimeouts","100:500:100:500");
        props.setProperty("com.sun.corba.ee.transport.ORBTCPTimeouts","500:2000:50:1000");

        InitialContext ejbRemoteContext;
        try {
            ejbRemoteContext = new InitialContext(props);
        } catch (NamingException ex) {
            return -1;
        }

        br.rems.ICalculadora beanRemote;
        try {
            beanRemote = (br.rems.ICalculadora) ejbRemoteContext.lookup("java:global/Pratica3-1.0-SNAPSHOT/EJBCalculadora");
            int x = beanRemote.fatorial(v);
            return x;
        } catch (NamingException ex) {
            return -2;
        }
    }
        
     
     public int fat_http(int v) {
        Properties environment = new Properties();
        environment.put(INITIAL_CONTEXT_FACTORY, "fish.payara.ejb.rest.client.RemoteEJBContextFactory");
        environment.put(PROVIDER_URL, "http://localhost:8080/ejb-invoker");

        InitialContext ejbRemoteContext;
        try {
            ejbRemoteContext = new InitialContext(environment);
        } catch (NamingException ex) {      
            return -1;
        }

        br.rems.ICalculadora beanRemote;
        try {
            beanRemote = (br.rems.ICalculadora) ejbRemoteContext.lookup("java:global/Pratica3-1.0-SNAPSHOT/EJBCalculadora");
            int x = beanRemote.fatorial(v);
            return x;
        } catch (NamingException ex) {          
            return -2;
        }

    }
     
}
