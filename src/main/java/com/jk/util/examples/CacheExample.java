/*
 * Copyright 2002-2018 Jalal Kiswani. 
 * E-mail: Kiswani.Jalal@Gmail.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.jk.util.examples;

import com.jk.db.examples.beans.Employee;
import com.jk.util.JK;
import com.jk.util.cache.JKCacheFactory;
import com.jk.util.cache.JKCacheManager;

// TODO: Auto-generated Javadoc
/**
 * The Class CacheExample.
 */
public class CacheExample {
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
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
