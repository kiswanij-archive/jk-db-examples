package com.jk.db.examples;

import java.util.List;
import java.util.Map;

import com.jk.db.dataaccess.orm.JKOrmDataAccess;
import com.jk.db.datasource.JKDataSourceFactory;
import com.jk.db.examples.entities.Department;
import com.jk.util.JK;

/**
 * ORM Example
 * 
 * @author Jalal Kiswani Jul 2, 2016
 */
public class JKDbExample4 {
	static {
		JK.debug();
	}
	private static final int ID = 100;
	static JKOrmDataAccess orm = JKDataSourceFactory.getOrmDataAccess();

	public static void main(String[] args) {
		getList();
		insert();
		update();
		delete();
		getList();
		getListWithFilter();
		executeQuery();
	}

	private static void insert() {
		Department dep = new Department();
		dep.setId(ID);
		dep.setName("My Department");
		orm.insert(dep);
		JK.print("Insert : ", dep);
	}

	private static void update() {
		Department dep = orm.find(Department.class, ID);
		JK.print("Found department :", dep);
		dep.setName("New Name");
		orm.update(dep);
		JK.print("Updated...");
	}

	private static void delete() {
		orm.delete(ID, Department.class);
		JK.print("Deleted succ...");
	}

	private static void getList() {
		List<Department> list = orm.getList(Department.class);
		JK.print("getList() : ", list);
	}

	private static void getListWithFilter() {
		Map<String, Object> paramters = JK.toMap("name", "Sales");
		List<Department> list = orm.getList(Department.class, paramters);
		JK.print("getListWithFilter() : ", list);
	}

	private static void executeQuery() {
		List<Department> list = orm.executeQuery(Department.class, "SELECT d FROM Department d WHERE d.id>?1", 1);
		JK.print("executeQuery(): ", list);
	}

}
