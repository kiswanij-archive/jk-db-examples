package com.jalalkiswani.examples.jkdb;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.sql.rowset.CachedRowSet;

import com.jalalkiswani.examples.beans.Department;
import com.jk.db.dataaccess.plain.JKDbIdValue;
import com.jk.db.dataaccess.plain.JKFinder;
import com.jk.db.dataaccess.plain.JKPlainDataAccess;
import com.jk.db.dataaccess.plain.JKUpdater;
import com.jk.db.datasource.JKDataSourceFactory;
import com.jk.util.JK;

/**
 * Full Plain API exmaple
 * 
 * @author Jalal Kiswani Jul 2, 2016
 */
public class JKDBExample2 {
	static {
		// Un-comment the below line to enable debugging
		// JK.debug();
	}
	static JKPlainDataAccess dataAccess = JKDataSourceFactory.getPlainDataAccess();

	public static void main(String[] args) throws SQLException {

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

	private static void executeQueryAsSingleObject() {
		Department dep = dataAccess.executeQueryAsSingleObject(Department.class, "SELECT * FROM hr_departments WHERE dep_id=?", 3);
		JK.printBlock(dep);
	}

	private static void executeQueryAsObjectList() {
		List<Department> list = dataAccess.executeQueryAsObjectList(Department.class, "SELECT * FROM hr_departments WHERE dep_id<>?", 3);
		JK.printBlock(list);
	}

	private static void executeQueryAsArray() {
		Object[] list = dataAccess.executeQueryAsArray("SELECT * FROM hr_departments WHERE dep_id<?", 4);
		JK.printBlock(list);
	}

	private static void getSystemDate() {
		Date systemDate = dataAccess.getSystemDate();
		JK.print("System date:", systemDate);
	}

	private static void executeQueryAsList() {
		List<List<Object>> list = dataAccess.executeQueryAsList("SELECT * FROM hr_departments WHERE dep_id>?", 1);
		JK.printBlock(list);
	}

	private static void executeQueryAsString() {
		String result = dataAccess.executeQueryAsString("SELECT * FROM hr_departments WHERE dep_id>?", ",", "\n", 1);
		JK.printBlock("String results : \n", result);
	}

	private static void getRowsCount() {
		int rowsCount = dataAccess.getRowsCount("SELECT dep_name FROM hr_departments WHERE 1=?", 1);
		JK.printBlock("Rows count:", rowsCount);
	}

	private static void getNextId() {
		Long nextId = dataAccess.getNextId("hr_departments", "dep_id");
		JK.print("Next id:", nextId);
	}

	private static void exeuteSingleOutputQuery() {
		Object name = dataAccess.exeuteSingleOutputQuery("SELECT dep_name FROM hr_departments WHERE dep_id=?", 2);
		JK.print("Result of exeuteSingleOutputQuery : ", name);
	}

	private static void execute() {
		dataAccess.execute("UPDATE hr_departments SET dep_name=? WHERE dep_id=?", "I.T.2", 1);
		JK.print("Updated succ using simple execute..");
	}

	private static void executeQueryAsIdValue() {
		List<JKDbIdValue> list = dataAccess.executeQueryAsIdValue("SELECT * FROM hr_departments WHERE dep_id>?", 0);
		for (JKDbIdValue idValue : list) {
			JK.print(idValue);
		}
	}

	private static void executeQueryAsCachedRowSet() {
		CachedRowSet rs = dataAccess.executeQueryAsCachedRowSet("SELECT * FROM hr_departments where 1=?", 1);
		JK.print(rs);
	}

	// Complex Tables and Quries
	private static void executeUpdate() {
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

	private static void getList() {
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

	private static void findRecord() {
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
