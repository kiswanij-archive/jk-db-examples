package com.jk.db.examples;

import com.jk.application.api.ApplicationManager;
import com.jk.util.JK;

public class Startup {
	public static void main(String[] args) {
		JK.debug();
		ApplicationManager instance = ApplicationManager.getInstance();
		instance.init();
		instance.start();
	}
}
