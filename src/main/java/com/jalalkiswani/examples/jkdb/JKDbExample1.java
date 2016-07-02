package com.jalalkiswani.examples.jkdb;

import java.util.List;

import com.jalalkiswani.examples.beans.Employee;
import com.jk.db.dataaccess.plain.JKPlainDataAccess;
import com.jk.db.datasource.JKDataSourceFactory;
import com.jk.util.JK;

/**
 * Test plain CRUD Operations
 * 
 * @author Jalal Kiswani Jul 2, 2016
 */
public class JKDbExample1 {
	static final int EMP_ID = 1050;
	static JKPlainDataAccess plainDataAccess = JKDataSourceFactory.getPlainDataAccess();

	public static void main(String[] args) {
		clearEmployeesTable();
		getAllEmployeeRecords();
		insertEmployeeRecord();
		getAllEmployeeRecords();
		updateEmployeeRecord();
		getAllEmployeeRecords();
		deleteEmployeeRecord();
		getAllEmployeeRecords();
	}

	/**
	 * 
	 */
	private static void clearEmployeesTable() {
		plainDataAccess.execute("DELETE FROM hr_employees");
		JK.print("Employees table cleared succ...");
	}

	/**
	 * 
	 */
	private static void getAllEmployeeRecords() {
		// get all employees with salary more than 10
		List<Employee> list = plainDataAccess.executeQueryAsObjectList(Employee.class, "id,name,salary",
				"SELECT emp_id,emp_name,emp_salary FROM hr_employees WHERE emp_salary>?", 100);
		if (list.size() == 0) {
			JK.print("NO employees found..");
			return;
		}
		for (Employee employee : list) {
			JK.print(employee);
		}
	}

	/**
	 * 
	 */
	private static void insertEmployeeRecord() {
		plainDataAccess.execute("INSERT INTO hr_employees (emp_id,dep_id,emp_name,emp_salary) VALUES(?,?,?,?)", EMP_ID, 1, "Jalal", 1000);
		JK.print("Record Added Success");
	}

	/**
	 * 
	 */
	private static void updateEmployeeRecord() {
		plainDataAccess.execute("UPDATE hr_employees SET emp_salary=? WHERE emp_id=?", 2222, EMP_ID);
		JK.print("Updated succ...");
	}

	/**
	 * 
	 */
	private static void deleteEmployeeRecord() {
		plainDataAccess.execute("DELETE FROM hr_employees WHERE emp_id=?", EMP_ID);
		JK.print("Deleted succ...");
	}
}
