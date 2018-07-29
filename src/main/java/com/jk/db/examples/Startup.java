package com.jk.db.examples;

import com.jk.framework.application.ApplicationManager;
import com.jk.util.JK;

public class Startup {
	public static void main(String[] args) {
		JK.debug();
		JK.printBlock("1");
		ApplicationManager.getInstance().init();
		JK.printBlock("2");
		ApplicationManager.getInstance().start();
		JK.printBlock("3");
	}
}
