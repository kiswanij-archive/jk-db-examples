package com.jk.util.examples;

import com.jk.cache.JKCacheFactory;
import com.jk.cache.JKCacheManager;
import com.jk.db.examples.beans.Employee;
import com.jk.util.JK;

public class CacheExample {
	public static void main(String[] args) {
		//Create instance of cacheManager
		JKCacheManager cacheManager = JKCacheFactory.getCacheManager();
		
		//create Employee object with the name emp
		Employee emp=Employee.create().id(1).name("Jalal").salary(1000);
		//define a key to be used for cache management
		String key = "firstEmployee";
		
		//cache the emp object with the key firstEmployee		
		cacheManager.cache(key, emp);
		
		//lookup the employee object by its key firstEmployee
		Employee employee = cacheManager.get(key,Employee.class);
		//print cached object
		JK.print(employee);
		
		//remove object from cache by key and class name 
		cacheManager.remove(key,Employee.class);
		
		//try to look up the object
		emp=cacheManager.get(key,Employee.class);
		//print the returned object which should be NULL, since it has been already removed
		JK.print(emp);
	}
}
