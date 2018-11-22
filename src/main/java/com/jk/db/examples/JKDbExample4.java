/*
 * Copyright 2002-2016 Jalal Kiswani.
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
package com.jk.db.examples;

import java.util.List;
import java.util.Map;

import com.jk.db.dataaccess.orm.JKObjectDataAccess;
import com.jk.db.datasource.JKDataSourceFactory;
import com.jk.db.util.test.examples.entities.Department;
import com.jk.util.JK;
import com.jk.util.factory.JKFactory;

// TODO: Auto-generated Javadoc
/**
 * ORM Example.
 *
 * @author Jalal Kiswani Jul 2, 2016
 */
public class JKDbExample4 {
	static {
		JK.debug();
	}

	/** The Constant ID. */
	private static final int ID = 100;

	/** The orm. */
	static JKObjectDataAccess orm = JKFactory.instance(JKObjectDataAccess.class);

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		getList();
		insert();
		update();
		delete();
		getList();
		getListWithFilter();
		executeQuery();
	}

	/**
	 * Insert.
	 */
	private static void insert() {
		Department dep = new Department();
		dep.setId(ID);
		dep.setName("My Department");
		orm.insert(dep);
		JK.print("Insert : ", dep);
	}

	/**
	 * Update.
	 */
	private static void update() {
		Department dep = orm.find(Department.class, ID);
		JK.print("Found department :", dep);
		dep.setName("New Name");
		orm.update(dep);
		JK.print("Updated...");
	}

	/**
	 * Delete.
	 */
	private static void delete() {
		orm.delete( Department.class, ID);
		JK.print("Deleted succ...");
	}

	/**
	 * Gets the list.
	 *
	 * @return the list
	 */
	private static void getList() {
		List<Department> list = orm.getList(Department.class);
		JK.print("getList() : ", list);
	}

	/**
	 * Gets the list with filter.
	 *
	 * @return the list with filter
	 */
	private static void getListWithFilter() {
		Map<String, Object> paramters = JK.toMap("name", "Sales");
		List<Department> list = orm.getList(Department.class, paramters);
		JK.print("getListWithFilter() : ", list);
	}

	/**
	 * Execute query.
	 */
	private static void executeQuery() {
		List<Department> list = orm.executeQuery(Department.class, "SELECT d FROM Department d WHERE d.id>?1", 1);
		JK.print("executeQuery(): ", list);
	}

}
