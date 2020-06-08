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


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.sql.rowset.CachedRowSet;

import com.jk.db.dataaccess.plain.JKDbIdValue;
import com.jk.db.dataaccess.plain.JKFinder;
import com.jk.db.dataaccess.plain.JKPlainDataAccess;
import com.jk.db.dataaccess.plain.JKUpdater;
import com.jk.db.datasource.JKDataSourceFactory;
import com.jk.db.examples.beans.Department;
import com.jk.util.JK;

// TODO: Auto-generated Javadoc
/**
 * Full Plain API exmaple.
 *
 * @author Jalal Kiswani Jul 2, 2016
 */
public class JKDBExample2 {
	static {
		// Un-comment the below line to enable debugging
		// JK.debug();
	}
	
	/** The data access. */
	static JKPlainDataAccess dataAccess = JKDataSourceFactory.getPlainDataAccess();

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {

		executeQueryAsCachedRowSet();
		executeQueryAsIdValue();
		executeUpdate();
		execute();
		exeuteSingleOutputQuery();
		getNextId();
		getRowsCount();
		executeQueryAsString();
		executeQueryAsList();
		findRecord();
		getSystemDate();
		getList();
		executeQueryAsArray();
		executeQueryAsObjectList();
		executeQueryAsSingleObject();
	}

	/**
	 * Execute query as single object.
	 */
	public static void executeQueryAsSingleObject() {
		Department dep = dataAccess.executeQueryAsSingleObject(Department.class, "SELECT * FROM hr_departments WHERE dep_id=?", 3);
		JK.printBlock(dep);
	}

	/**
	 * Execute query as object list.
	 */
	public static void executeQueryAsObjectList() {
		List<Department> list = dataAccess.executeQueryAsObjectList(Department.class, "SELECT * FROM hr_departments WHERE dep_id<>?", 3);
		JK.printBlock(list);
	}

	/**
	 * Execute query as array.
	 */
	public static void executeQueryAsArray() {
		Object[] list = dataAccess.executeQueryAsArray("SELECT * FROM hr_departments WHERE dep_id<?", 4);
		JK.printBlock(list);
	}

	/**
	 * Gets the system date.
	 *
	 * @return the system date
	 */
	public static void getSystemDate() {
		Date systemDate = dataAccess.getSystemDate();
		JK.print("System date:", systemDate);
	}

	/**
	 * Execute query as list.
	 */
	public static void executeQueryAsList() {
		List<List<Object>> list = dataAccess.executeQueryAsList("SELECT * FROM hr_departments WHERE dep_id>?", 1);
		JK.printBlock(list);
	}

	/**
	 * Execute query as string.
	 */
	public static void executeQueryAsString() {
		String result = dataAccess.executeQueryAsString("SELECT * FROM hr_departments WHERE dep_id>?", ",", "\n", 1);
		JK.printBlock("String results : \n", result);
	}

	/**
	 * Gets the rows count.
	 *
	 * @return the rows count
	 */
	public static void getRowsCount() {
		int rowsCount = dataAccess.getRowsCount("SELECT dep_name FROM hr_departments WHERE 1=?", 1);
		JK.printBlock("Rows count:", rowsCount);
	}

	/**
	 * Gets the next id.
	 *
	 * @return the next id
	 */
	public static void getNextId() {
		Long nextId = dataAccess.getNextId("hr_departments", "dep_id");
		JK.print("Next id:", nextId);
	}

	/**
	 * Exeute single output query.
	 */
	public static void exeuteSingleOutputQuery() {
		Object name = dataAccess.exeuteSingleOutputQuery("SELECT dep_name FROM hr_departments WHERE dep_id=?", 2);
		JK.print("Result of exeuteSingleOutputQuery : ", name);
	}

	/**
	 * Execute.
	 */
	public static void execute() {
		dataAccess.execute("UPDATE hr_departments SET dep_name=? WHERE dep_id=?", "I.T.2", 1);
		JK.print("Updated succ using simple execute..");
	}

	/**
	 * Execute query as id value.
	 */
	public static void executeQueryAsIdValue() {
		List<JKDbIdValue> list = dataAccess.executeQueryAsIdValue("SELECT * FROM hr_departments WHERE dep_id>?", 0);
		for (JKDbIdValue idValue : list) {
			JK.print(idValue);
		}
	}

	/**
	 * Execute query as cached row set.
	 */
	public static void executeQueryAsCachedRowSet() {
		CachedRowSet rs = dataAccess.executeQueryAsCachedRowSet("SELECT * FROM hr_departments where 1=?", 1);
		JK.print(rs);
	}

	/**
	 * Execute update.
	 */
	// Complex Tables and Quries
	public static void executeUpdate() {
		dataAccess.executeUpdate(new JKUpdater() {

			@Override
			public void setParamters(PreparedStatement ps) throws SQLException {
				int counter = 1;
				ps.setString(counter++, "IT-1");
				ps.setInt(counter++, 1);
			}

			@Override
			public String getQuery() {
				return "UPDATE hr_departments SET dep_name=? WHERE dep_id=?";
			}
		});
		JK.print("Updated succ using updater..");
	}

	/**
	 * Gets the list.
	 *
	 * @return the list
	 */
	public static void getList() {
		List<Department> d = dataAccess.getList(new JKFinder() {

			@Override
			public void setParamters(PreparedStatement ps) throws SQLException {
				ps.setInt(1, 2);
			}

			@Override
			public Department populate(ResultSet rs) throws SQLException {
				Department d = new Department();
				d.setId(rs.getInt("dep_id"));
				d.setName(rs.getString("dep_name"));
				return d;
			}

			@Override
			public String getQuery() {
				return "SELECT * FROM hr_departments WHERE dep_id>?";
			}
		});
		JK.line();
		for (Department department : d) {
			JK.print(department);
		}
		JK.line();
	}

	/**
	 * Find record.
	 */
	public static void findRecord() {
		final int id = 3;
		Department d = dataAccess.findRecord(new JKFinder() {

			@Override
			public void setParamters(PreparedStatement ps) throws SQLException {
				ps.setInt(1, id);
			}

			@Override
			public Department populate(ResultSet rs) throws SQLException {
				Department d = new Department();
				d.setId(rs.getInt("dep_id"));
				d.setName(rs.getString("dep_name"));
				return d;
			}

			@Override
			public String getQuery() {
				return "SELECT * FROM hr_departments WHERE dep_id=?";
			}
		}, "hr_departments", id);
		JK.printBlock("Department : ", d);
	}

}
