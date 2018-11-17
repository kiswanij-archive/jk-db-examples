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

import com.jk.db.datasource.JKDataSourceFactory;
import com.jk.db.dynamic.dataaccess.JKObjectDataAccess;
import com.jk.util.JK;
import com.jk.util.factory.JKFactory;

// TODO: Auto-generated Javadoc
/**
 * The Class DynamicDaoExample.
 */
public class DynamicDaoExample {
	static {
		JKDataSourceFactory.getDataAccessService().dropTable("employee");
	}
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		// Create data Access instance
		JKObjectDataAccess dataAccess = JKFactory.instance(JKObjectDataAccess.class);
		
		// Create Employee objects to be inserted into the database
		Employee emp = Employee.create().name("Jalal Kiswani").salary(1000.0).email("Kiswani.Jalal@gmail.com");
		Employee emp2 = Employee.create().name("John Smith").salary(2000.0).email("John.Smith@xyz.com");
		Employee emp3 = Employee.create().name("Ata").salary(3000.0).email("Ata@xyz.com");

		
		// Create three records
		dataAccess.insert(emp);
		dataAccess.insert(emp2);
		dataAccess.insert(emp3);
		int lastId = emp.getId();
		
		JK.printBlock("Id of the first created object :", lastId);
		
		//find
		Employee instance2 = dataAccess.find(Employee.class, lastId);
		JK.print("Find employee with Id: ",lastId);
		JK.print(instance2);
		JK.line();
		
		// Update
		instance2.setSalary(2000.0);		
		dataAccess.update(instance2);
		JK.print("Update employee with id : ",lastId+" salary to be : 2000");
		JK.line();
		
		//find by example
		Employee filter=Employee.create().salary(2000.0);
		JK.print("Employees with 2000 salary:");
		List<Employee> employeesWith2000Salary= dataAccess.findByExample(filter);
		for (Employee employee : employeesWith2000Salary) {
			JK.print(employee);
		}
		JK.line();
		
		//get all records
		JK.print("Get all employees from database");
		List<Employee> all = dataAccess.getAll(Employee.class);
		for (Employee employee : all) {
			JK.print(employee);
		}
		JK.line();
	}
}
