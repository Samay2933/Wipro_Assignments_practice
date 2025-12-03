package com.dependencyinjection;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


//import com.dependencyinjection.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	// you have to first connect or call spring container
		
    			AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
    			
    			// ask the container or spring to get the delegate bean  or object
    			Delegate delegate = context.getBean(Delegate.class);
    			
    			delegate.notifyUser();
    			context.close();
    }
}