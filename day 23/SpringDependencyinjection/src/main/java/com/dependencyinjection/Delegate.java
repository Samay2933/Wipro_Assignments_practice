package com.dependencyinjection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Delegate{

	// Here delegate depends upon interface only
  private final Allocator allocator; // depends on abstraction //required dependecy i.e. alocator + final 
  //allocator : reference 
	
  // dependency injection will be done by Spring but how by adding an annotation @Autowired
  @Autowired
  public Delegate(Allocator allocator) { 
	  //in the constructor injection
	  //spring will creates Manager and spring will call the constructor of Delegate and injects Manager
	  //object is ready and fully valid to use, here there is no chance of null dependency
	  //here 
		super();
		this.allocator = allocator;
	  };
  
  
  
public void notifyUser()
{
//manager.taskAllocation("Niti");
	
	allocator.taskAllocation("Niti");

}

}