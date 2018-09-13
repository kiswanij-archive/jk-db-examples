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
package com.jk.examples.db.dynamic;

import java.util.List;

import com.jk.db.dynamic.dataaccess.JKObjectDataAccess;
import com.jk.util.JK;
import com.jk.util.factory.JKFactory;

// TODO: Auto-generated Javadoc
/**
 * The Class DynamicDaoExample.
 */
public class DynamicDaoExample {
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		// Create data Access instance
		JKObjectDataAccess dataAccess = JKFactory.instance(JKObjectDataAccess.class);

		
		// Create Employee object to be inserted into the database
		Employee emp = Employee.create().name("Jalal Kiswani").salary(1000).email("Kiswani.Jalal@gmail.com");
		Employee emp2 = Employee.create().name("John Smith").salary(2000).email("John.Smith@xyz.com");
		Employee emp3 = Employee.create().name("Ata").salary(3000).email("Ata@xyz.com");

		
		// Insert new employee objects
		dataAccess.insert(emp);
		dataAccess.insert(emp2);
		dataAccess.insert(emp3);
		int lastId = emp.getId();
		
		JK.print("id of first created object :", lastId);

		// call Find method, and get the results in other instance
		// we set the id is 1 because I assume that you run this app for the first time,
		// however, this value
		// will keep incremented since the id field is auto increment in the database
		Employee instance2 = dataAccess.find(Employee.class, lastId);
		JK.print(instance2);

		
		// update the salary value , then save it to database
		instance2.setSalary(2000);
		dataAccess.update(instance2);

		//Get all records from database
		List<Employee> all = dataAccess.getAll(Employee.class);
		for (Employee employee : all) {
			JK.print(employee);
		}

	}
}
